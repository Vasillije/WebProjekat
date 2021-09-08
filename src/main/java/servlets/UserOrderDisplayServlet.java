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
import Enums.RestorantType;
import model.User;

@WebServlet("/userOrderDisplay")
public class UserOrderDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserOrderDisplayServlet() {
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
		request.setAttribute("orders", user.getOrdersCustomer());
		request.setAttribute("types", RestorantType.values());
		request.setAttribute("status", OrderStatus.values());
		RequestDispatcher disp = request.getRequestDispatcher("/userOrderDisplay.jsp");
    	disp.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
