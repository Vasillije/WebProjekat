package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Enums.Pol;
import Enums.Role;
import dao.UserDao;
import model.AppContext;
import model.DateConverse;
import model.User;

/**
 * Servlet implementation class UserDisplayServlet
 */
@WebServlet("/userDisplayServlet")
public class UserDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		User user = (User)session.getAttribute("user");
//		request.setAttribute("dateBirdth",  user.getBirdth());
		RequestDispatcher disp = request.getRequestDispatcher("/userDisplay.jsp");
    	disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
    	String pass = request.getParameter("password");
    	
    	UserDao userDao = new UserDao();
    	User user = userDao.findUserByUserPassword(username, pass);
    	if(user != null) {	
    		request.setAttribute("error", "Username and password already exists!!!!!!!!!!!!!!!!");
    		RequestDispatcher disp = request.getRequestDispatcher("/userDisplay.jsp");
        	disp.forward(request, response);
        	return;
    	}
    	
    	HttpSession session = request.getSession();
    	user = (User)session.getAttribute("user");
    	
    	if(user == null) {
    		RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
        	disp.forward(request, response);
        	return;
    	}
    	
    	String name = request.getParameter("name");
    	String surname = request.getParameter("surname");
    	String sex = request.getParameter("gender");
    	String dateS = request.getParameter("dateBirth");
    	
    	user.setUsername(username);
    	user.setPassword(pass);
    	user.setName(name);
    	user.setSurname(surname);
    	user.setSex(sex == "MALE" ? Pol.MALE : Pol.FEMALE);
    	
    	LocalDate dateLD = DateConverse.convertStringToLocalDate(dateS);
    	user.setBirdth(dateLD);
    	
        AppContext.getAplicationContext().save();
          
        RequestDispatcher disp = request.getRequestDispatcher("/index.jsp");
    	disp.forward(request, response);
	}

}
