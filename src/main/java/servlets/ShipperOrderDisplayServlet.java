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
import model.Entity;
import model.User;
import model.Order;

/**
 * Servlet implementation class ShipperOrderDisplayServlet
 */
@WebServlet("/shipperOrderDisplay")
public class ShipperOrderDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ShipperOrderDisplayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null) {
			request.setAttribute("error", "SESSION EXPIRED SSS");
    		RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
        	disp.forward(request, response);
        	return;
		}
		
		ArrayList<Entity> ordersWaiting = new ArrayList<Entity>();
		if(user.getOrdersShipper() == null) {
			request.setAttribute("error", "User has no orders");
    		RequestDispatcher disp = request.getRequestDispatcher("/shipperOrderDisplay.jsp");
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
		RequestDispatcher disp = request.getRequestDispatcher("/shipperOrderDisplay.jsp");
    	disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
