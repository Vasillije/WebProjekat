package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Enums.OrderStatus;
import Enums.RestorantType;
import Enums.Role;
import dao.OrderDao;
import dao.RestorantDao;
import model.AppContext;
import model.Entity;
import model.Order;
import model.Restorant;
import model.User;

@WebServlet("/orderDisplay")
public class OrderDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderDisplayServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		OrderDao dao = new OrderDao();
		RequestDispatcher disp = null;
		if (user == null) {
			request.setAttribute("error", "SESSION EXPIRED SSS");
			disp = request.getRequestDispatcher("/login.jsp");
			disp.forward(request, response);
			return;
		} else if (user.getRole() == Role.CUSTOMER) {
			OrderDao orderDao = new OrderDao();
			request.setAttribute("orders", orderDao.findOrderByUserCustomerId(user.getId()));
			request.setAttribute("types", RestorantType.values());
			request.setAttribute("status", OrderStatus.values());
			disp = request.getRequestDispatcher("/orderDisplay.jsp");
			disp.forward(request, response);
		} else if (user.getRole() == Role.SHIPPER) {
			ArrayList<Order> ordersWaiting;
			ordersWaiting = dao.findOrderByUserShipperId(user.getId());
			ordersWaiting = dao.selectWaitingOrder(ordersWaiting);

			request.setAttribute("orders", ordersWaiting);
			request.setAttribute("types", RestorantType.values());
			request.setAttribute("status", OrderStatus.values());
			disp = request.getRequestDispatcher("/orderDisplay.jsp");
			disp.forward(request, response);
		} else if (user.getRole() == Role.MANAGER) {
			Restorant restorant = user.getRestorantMnagaer();
			if (restorant == null) {
				request.setAttribute("error", "is not menager error 404 not found mistake ");
				disp = request.getRequestDispatcher("/login.jsp");
				disp.forward(request, response);
				return;
			}
			ArrayList<Entity> restOrders = dao.findByRestorantId(restorant.getId());
			request.setAttribute("orders", restOrders);
			request.setAttribute("types", RestorantType.values());
			request.setAttribute("status", OrderStatus.values());
			disp = request.getRequestDispatcher("/orderDisplay.jsp");
			disp.forward(request, response);
		} else {
			disp = request.getRequestDispatcher("/login.jsp");
			disp.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchingBy = request.getParameter("searchType");
		OrderDao dao = new OrderDao();

		String searchValueFrom = request.getParameter("searchValueFrom").toLowerCase();
		String searchValueTo = request.getParameter("searchValueTo").toLowerCase();

		ArrayList<Entity> allOrders = AppContext.getAplicationContext().getOrders();
		ArrayList<Entity> validOrders = dao.searchByParam(allOrders, searchingBy, searchValueFrom, searchValueTo);

		String sortingCrit = request.getParameter("sortingCrit");
		String sortingOrder = request.getParameter("sortingOrder");
		String filteringType = request.getParameter("filteringRestorantType");
		String filteringStatus = request.getParameter("filteringOrderStatus");

		if (!filteringType.equals("noFilter")) {
			dao.restorantTypeFilter(validOrders, filteringType);
		}

		if (!filteringStatus.equals("noFilter")) {
			dao.orderStatusFilter(allOrders, filteringStatus);
		}

		if (!sortingCrit.equals("noSort")) {
			dao.sortByParam(validOrders, sortingCrit, sortingOrder);
		}
		request.setAttribute("orders", validOrders);
		RequestDispatcher disp = request.getRequestDispatcher("/sortedOrderDisplayGoodProgram.jsp");
		disp.forward(request, response);
	}

}
