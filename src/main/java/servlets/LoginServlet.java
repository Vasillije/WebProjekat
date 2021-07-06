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

import dao.UserDao;
import model.User;

/***
 * Servlet zadužen za login. Èita podatke o korisniku iz zahteva i dodaje ga u sesiju ako su kredencijali ispravni.
 * @author Lazar
 *
 */
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
    /***
     * Preusmerava korisnika na login stranicu.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
    	disp.forward(request, response);
    }
    
    /***
     * Prihvata korisnièko ime i lozinku iz forme i pokušava da uloguje korisnika. 
     * Pri neuspešnom loginu preusmerava korisnika nazad na login stranicu, sa porukom greške.
     */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("username");
    	String pass = request.getParameter("password");
    	
    	UserDao userDao = new UserDao();
    	User user = userDao.findUserByUserPassword(username, pass);
    	if(user == null) {	
    		request.setAttribute("error", "Username and password are not OK");
    		RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
        	disp.forward(request, response);
        	return;
    	}
    	HttpSession session = request.getSession();
        session.setAttribute("user", user);
        
       // User u = (User)session.getAttribute("user"); // ovako uzimamo trenuntnog usera sa sesije
        
        RequestDispatcher disp = request.getRequestDispatcher("/home");
    	disp.forward(request, response);
    	
	}
}