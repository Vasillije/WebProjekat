package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Enums.Role;
import dao.ArticalDao;
import model.Restorant;
import model.User;

/**
 * Servlet implementation class ArticalDisplayServlet
 */
@WebServlet("/articalDisplay")
public class ArticalDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticalDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticalDao dao = new ArticalDao();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user ==  null) {
			RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
	    	disp.forward(request, response);
			return;	
		}
		Restorant rest = user.getRestorantMnagaer();
		
		if(user.getRole() != Role.MANAGER) {
			RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
	    	disp.forward(request, response);
			return;	
		}
		if(rest == null) {
			RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
	    	disp.forward(request, response);
			return;
		}
		request.setAttribute("articls", dao.findArticlsByRestorantId(rest.getId()));
		RequestDispatcher disp = request.getRequestDispatcher("/articalDisplay.jsp");
    	disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
