package servlets;

import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Enums.Pol;
import dao.UserDao;
import model.AppContext;
import model.DateConverse;
import model.User;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public RegistrationServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	
    	RequestDispatcher disp = request.getRequestDispatcher("/registration.jsp");
    	disp.forward(request, response);
    }
    
   
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("username");
    	String pass = request.getParameter("password");
    	
    	UserDao userDao = new UserDao();
    	User user = userDao.findUserByUserPassword(username, pass);
    	if(user != null) {	
    		request.setAttribute("error", "Username and password already exists!!!!!!!!!!!!!!!!");
    		RequestDispatcher disp = request.getRequestDispatcher("/registration.jsp");
        	disp.forward(request, response);
        	return;
    	}
    	int id = AppContext.getAplicationContext().GenerateID(AppContext.getAplicationContext().getUsers());
    	user = new User(id);
    	
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
    	
    	HttpSession session = request.getSession();
        session.setAttribute("user", user);
    	
    	AppContext.getAplicationContext().getUsers().add(user);
        AppContext.getAplicationContext().save();
        
       // User u = (User)session.getAttribute("user"); // ovako uzimamo trenuntnog usera sa sesije
        
        RequestDispatcher disp = request.getRequestDispatcher("/HomeServlet");
    	disp.forward(request, response);
	}
}
