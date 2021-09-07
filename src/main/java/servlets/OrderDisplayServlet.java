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
import model.Entity;
import model.Order;
import model.Restorant;
import model.User;

/**
 * Servlet implementation class OrderDisplayServlet
 */
@WebServlet("/OrderDisplayServlet")
public class OrderDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public OrderDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		OrderDao dao = new OrderDao();
		RequestDispatcher disp = null;
		if(user == null) {
			request.setAttribute("error", "SESSION EXPIRED SSS");
    		 disp = request.getRequestDispatcher("/login.jsp");
        	disp.forward(request, response);
        	return;
		}else if(user.getRole() == Role.CUSTOMER) {
			request.setAttribute("orders", user.getOrdersCustomer());	
			 disp = request.getRequestDispatcher("/userOrderDisplay.jsp");
		}else if(user.getRole() == Role.SHIPPER) {		
			ArrayList<Entity> ordersWaiting = new ArrayList<Entity>();
			if(user.getOrdersShipper() == null) {
				request.setAttribute("error", "User has no orders");
	    		 disp = request.getRequestDispatcher("/shipperOrderDisplay.jsp");
	        	disp.forward(request, response);
	        	return;
			}
			for(Entity ent: user.getOrdersShipper()) {
				if(((Order)ent).getStatus() == OrderStatus.WAITING) {
					ordersWaiting.add(ent);
				}
			}
			
			request.setAttribute("orders", ordersWaiting);
			request.setAttribute("types", RestorantType.values());
			request.setAttribute("status", OrderStatus.values());
			 disp = request.getRequestDispatcher("/shipperOrderDisplay.jsp");
	    	disp.forward(request, response);
		}else if(user.getRole() == Role.MANAGER) {
			Restorant restorant = user.getRestorantMnagaer();
			if(restorant == null) {
				request.setAttribute("error", "is not menager error 404 not found mistake ");
	    		 disp = request.getRequestDispatcher("/managerOrderDisplay.jsp");
	        	disp.forward(request, response);
	        	return;
			}
			ArrayList<Entity> restOrders = dao.findByRestorantId(restorant.getId());
			request.setAttribute("orders",restOrders);
			request.setAttribute("types", RestorantType.values());
			request.setAttribute("status", OrderStatus.values());
			 disp = request.getRequestDispatcher("/managerOrderDisplay.jsp");
	    	disp.forward(request, response);
		}
		request.setAttribute("types", RestorantType.values());
		request.setAttribute("status", OrderStatus.values());
		disp.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
