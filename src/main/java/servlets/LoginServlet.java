package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Enums.Role;
import dao.UserDao;
import model.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
    	disp.forward(request, response);
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("username");
    	String pass = request.getParameter("password");
    	
    	UserDao userDao = new UserDao();
    	User user = userDao.findUserByUserPassword(username, pass);
    	request.setAttribute("CUSTOMER", Role.CUSTOMER);
    	request.setAttribute("ADMINISTRATOR", Role.ADMINISTRATOR);
    	request.setAttribute("SHIPPER", Role.SHIPPER);
    	request.setAttribute("MANAGER", Role.MANAGER);
    	
    	if(user == null) {	
    		request.setAttribute("error", "Username and password are not OK");
    		RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
        	disp.forward(request, response);
        	return;
    	}
    	HttpSession session = request.getSession();
        session.setAttribute("user", user);
        
       // User u = (User)session.getAttribute("user"); // ovako uzimamo trenuntnog usera sa sesije
        
        RequestDispatcher disp = request.getRequestDispatcher("/index.jsp");
    	disp.forward(request, response);
    	
	}
}