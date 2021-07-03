package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Enums.Pol;
import dao.UserDao;
import model.AppContext;
import model.DateConverse;
import model.Restorant;
import model.User;
import dao.RestorantDao;

import javax.servlet.annotation.WebServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;


@WebServlet("/registrationMenager")
public class RegistrationMenagerServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
    
    public RegistrationMenagerServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher disp = request.getRequestDispatcher("/registrationMenager.jsp");
    	disp.forward(request, response);
    }
    
   
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    
    	
    	String username = request.getParameter("username");
    	String pass = request.getParameter("password");
    	User user;
    	
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
    	
    	String restID = request.getParameter("restID");
    	int restIDint = Integer.parseInt(restID);
    	RestorantDao dao = new RestorantDao();
    	Restorant r = dao.findById(restIDint);
    	user.setRestorantMnagaer(r);
    	
    	AppContext.getAplicationContext().getUsers().add(user);
        AppContext.getAplicationContext().save();
        
        
        RequestDispatcher disp = request.getRequestDispatcher("/HomeServlet");
    	disp.forward(request, response);
	}
}
