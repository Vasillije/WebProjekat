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
import dao.OrderDao;
import model.Entity;
import model.Restorant;
import model.User;

@WebServlet("/managerOrderDisplay")
public class ManagerOrderDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerOrderDisplayServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao dao = new OrderDao();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null) {
			request.setAttribute("error", "SESSION EXPIRED SSS");
    		RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
        	disp.forward(request, response);
        	return;
		}
		Restorant restorant = user.getRestorantMnagaer();
		if(restorant == null) {
			request.setAttribute("error", "is not menager error 404 not found mistake ");
    		RequestDispatcher disp = request.getRequestDispatcher("/managerOrderDisplay.jsp");
        	disp.forward(request, response);
        	return;
		}
		ArrayList<Entity> restOrders = dao.findByRestorantId(restorant.getId());
		request.setAttribute("orders",restOrders);
		request.setAttribute("types", RestorantType.values());
		request.setAttribute("status", OrderStatus.values());
		RequestDispatcher disp = request.getRequestDispatcher("/managerOrderDisplay.jsp");
    	disp.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
