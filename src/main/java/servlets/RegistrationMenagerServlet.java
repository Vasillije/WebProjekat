package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Enums.Pol;
import Enums.Role;
import dao.UserDao;
import model.AppContext;
import model.DateConverse;
import model.User;


import javax.servlet.http.HttpServlet;

@WebServlet("/registrationMenager")
public class RegistrationMenagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationMenagerServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("/registrationMenager.jsp");
		disp.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		UserDao userDao = new UserDao();
    	User user = userDao.findUserByUserPassword(username, pass);
		if(user != null) {	
    		request.setAttribute("error", "Username and password already exists!!!!!!!!!!!!!!!!");
    		RequestDispatcher disp = request.getRequestDispatcher("/registrationMenager.jsp");
        	disp.forward(request, response);
        	return;
    	}
		

		int id = AppContext.getAplicationContext().GenerateID(AppContext.getAplicationContext().getUsers());
		user = new User(id);

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String sex = request.getParameter("gender");
		String dateS = request.getParameter("dateBirth");
		String tip = request.getParameter("type");
		user.setRole(Role.valueOf(tip));

		user.setUsername(username);
		user.setPassword(pass);
		user.setName(name);
		user.setSurname(surname);
		user.setSex(sex == "MALE" ? Pol.MALE : Pol.FEMALE);

		LocalDate dateLD = DateConverse.convertStringToLocalDate(dateS);
		user.setBirdth(dateLD);

//    	String restID = request.getParameter("restID");
//    	int restIDint = Integer.parseInt(restID);
//    	RestorantDao dao = new RestorantDao();
//    	Restorant r = dao.findById(restIDint);
//    	user.setRestorantMnagaer(r);

		AppContext.getAplicationContext().getUsers().add(user);
		AppContext.getAplicationContext().save();
		request.setAttribute("CUSTOMER", Role.CUSTOMER);
    	request.setAttribute("ADMINISTRATOR", Role.ADMINISTRATOR);
    	request.setAttribute("SHIPPER", Role.SHIPPER);
    	request.setAttribute("MANAGER", Role.MANAGER);

		RequestDispatcher disp = request.getRequestDispatcher("/index.jsp");
		disp.forward(request, response);
	}
}
