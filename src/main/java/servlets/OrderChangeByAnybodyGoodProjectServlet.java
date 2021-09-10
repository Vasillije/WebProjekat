package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Enums.OrderStatus;
import Enums.Role;
import dao.OrderDao;
import model.AppContext;
import model.Order;
import model.User;

/**
 * Servlet implementation class OrderChangeByAnybodyGoodProjectServlet
 */
@WebServlet("/orderChangeByAnybodyGoodProjectServlet")
public class OrderChangeByAnybodyGoodProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderChangeByAnybodyGoodProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		OrderDao dao = new OrderDao();
		Order order = dao.findById(orderId);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("error", "SESSION EXPIRED SSS");
			RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
			disp.forward(request, response);
			return;
		}
		if(user.getRole() == Role.CUSTOMER) {
			if(order.getStatus() == OrderStatus.PROCESSING) {
				user.setPointsCustomer((int)(user.getPointsCustomer() - (order.getCena()/1000.00)*133*4));
				order.setStatus(OrderStatus.CANCELED);				
			}
		}else if(user.getRole() == Role.MANAGER) {
			if(order.getStatus() == OrderStatus.PROCESSING) {
				order.setStatus(OrderStatus.INPREPARATION);
			}else if(order.getStatus() == OrderStatus.INPREPARATION) {
				order.setStatus(OrderStatus.WAITING);
			}
		}else if(user.getRole() == Role.SHIPPER) {
			if(order.getStatus() == OrderStatus.WAITING) {
				order.setStatus(OrderStatus.INTRANSPORT);
			}else if(order.getStatus() == OrderStatus.INTRANSPORT) {
				order.setStatus(OrderStatus.DELIVERED);
			}
		}
		AppContext.getAplicationContext().save();
		RequestDispatcher disp = request.getRequestDispatcher("/OrderDisplayServlet");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
