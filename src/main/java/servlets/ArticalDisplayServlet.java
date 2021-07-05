package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticalDao dao = new ArticalDao();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Restorant rest = user.getRestorantMnagaer();
		if(rest == null) {
			System.out.println("prazan restoran jer nije popunjeno jer nije gotovo to jos do sad al bice uskoro");
			return;
		}
		request.setAttribute("articls", dao.findArticlsByRestorantId(rest.getId()));
		RequestDispatcher disp = request.getRequestDispatcher("/articaltDisplay.jsp");
    	disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
