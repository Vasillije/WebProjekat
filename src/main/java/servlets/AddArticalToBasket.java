package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ArticalDao;
import dao.CommentDao;
import dao.RestorantDao;
import model.AppContext;
import model.Artical;
import model.Basket;
import model.Comment;
import model.Entity;
import model.Restorant;
import model.User;

/**
 * Servlet implementation class AddArticalToBasket
 */
@WebServlet("/addArticalToBasket")
public class AddArticalToBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticalToBasket() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idArtical");
		if(id == null) {
			System.out.println("nes geknulo");
			return;
		}
		int idArtical = Integer.parseInt(id);
		ArticalDao articalDao = new ArticalDao();
		Artical artical = articalDao.findById(idArtical);
		
		HttpSession session = request.getSession();
		Basket basket = getBasket(session);
		basket.setRestorant(artical.getRestorant());
		//System.out.println("[ " + request.getParameter("idArtical") + " , " + request.getParameter("amountOfArtical")  + "]");
		if (basket.getBoughtArticls().get(idArtical) == null) {
			if(request.getParameter("amountOfArtical").equals("")) {
				basket.getBoughtArticls().put(idArtical, 1.00);
			}else {
				basket.getBoughtArticls().put(idArtical, Double.parseDouble( request.getParameter("amountOfArtical")));
			}
		}else {
			if(request.getParameter("amountOfArtical").equals("")) {
				basket.getBoughtArticls().put(idArtical,  basket.getBoughtArticls().get(idArtical) + 1);
			}else {
				basket.getBoughtArticls().put(idArtical, basket.getBoughtArticls().get(idArtical) + Double.parseDouble( request.getParameter("amountOfArtical")));
			}
		}
		
		request.setAttribute("id", artical.getRestorant().getId());
		
    	
    	
    	
//    	int idRest = Integer.parseInt(id);
//		System.out.println(idRest);
//		RestorantDao dao = new RestorantDao();
//		CommentDao commentDao = new CommentDao();
//		ArticalDao articalDao = new ArticalDao();
//		Restorant restorant = dao.findById(idRest);
		
//		ArrayList<Entity> comments = commentDao.findByRestrantId(idRest);
		ArrayList<Entity> articls = articalDao.findArticlsByRestorantId(artical.getRestorant().getId());
		double rate = 0;
		
//		for(Entity e: comments) {
//			 rate += ((Comment)e).getGrade();
//		}
//		if(comments.size() != 0) {
//			rate = rate/comments.size();			
//		}
		
		
		request.setAttribute("restorant", artical.getRestorant());
//		request.setAttribute("comments", comments);
		request.setAttribute("articls", articls);
//		request.setAttribute("rate", rate);
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
	
	protected Basket getBasket(HttpSession session ) {
		Basket basket = (Basket)session.getAttribute("basket");
        if(basket == null) {
        	basket = new Basket(AppContext.getAplicationContext().GenerateID(AppContext.getAplicationContext().getBaskets()));
    		
           // User user = (User)session.getAttribute("user");
    		
    		//basket.setUser(user);
    		basket.setBoughtArticls(new HashMap<Integer, Double>());
    		session.setAttribute("basket", basket);
        }
        User user = (User)session.getAttribute("user");
		
		basket.setUser(user);
        
		return basket;
		
	}

}
