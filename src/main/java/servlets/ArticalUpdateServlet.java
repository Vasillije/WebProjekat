package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticalDao;
import model.Artical;

/**
 * Servlet implementation class ArticalUpdateServlet
 */
@WebServlet("/articalUpdate")
public class ArticalUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticalUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int idArtical = Integer.parseInt(id);
		ArticalDao dao = new ArticalDao();
		
		Artical art = dao.findById(idArtical);
		if(art == null) {
			System.out.println("nema taj ID klas----> ArticalUpdateServlet   greskaa!!!");
			return;
		}
		request.setAttribute("artical", art);
		
		RequestDispatcher disp = request.getRequestDispatcher("/articalUpdate.jsp");
    	disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
