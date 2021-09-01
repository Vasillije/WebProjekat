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
import model.Entity;
import model.User;
import model.Order;

/**
 * Servlet implementation class ShipperOrderDisplayServlet
 */
@WebServlet("/shipperOrderDisplay")
public class ShipperOrderDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShipperOrderDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		ArrayList<Entity> ordersWaiting = new ArrayList<Entity>();
		for(Entity ent: user.getOrdersShipper()) {
			if(((Order)ent).getStatus() == OrderStatus.WAITING) {
				ordersWaiting.add(ent);
			}
		}
		
		request.setAttribute("orders", ordersWaiting);
		RequestDispatcher disp = request.getRequestDispatcher("/shipperOrderDisplay.jsp");
    	disp.forward(request, response);
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
