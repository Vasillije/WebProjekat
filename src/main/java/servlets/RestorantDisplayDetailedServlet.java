package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticalDao;
import dao.CommentDao;
import dao.RestorantDao;
import model.Entity;
import model.Restorant;
import model.Comment;

/**
 * Servlet implementation class RestorantDisplayDetailedServlet
 */
@WebServlet("/restorantDisplayDetailed")
public class RestorantDisplayDetailedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantDisplayDetailedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null) {
			System.out.println("nes geknulo");
			return;
		}
		int idRest = Integer.parseInt(id);
		System.out.println(idRest);
		RestorantDao dao = new RestorantDao();
		CommentDao commentDao = new CommentDao();
		ArticalDao articalDao = new ArticalDao();
		Restorant restorant = dao.findById(idRest);
		
		ArrayList<Entity> comments = commentDao.findByRestrantId(idRest);
		ArrayList<Entity> articls = articalDao.findArticlsByRestorantId(idRest);
		double rate = 0;
		
		for(Entity e: comments) {
			 rate += ((Comment)e).getGrade();
		}
		if(comments.size() != 0) {
			rate = rate/comments.size();			
		}
		
		
		request.setAttribute("restorant", restorant);
		request.setAttribute("comments", comments);
		request.setAttribute("articls", articls);
		request.setAttribute("rate", rate);
		
		RequestDispatcher disp = request.getRequestDispatcher("/restorantDisplayDetailed.jsp");
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
