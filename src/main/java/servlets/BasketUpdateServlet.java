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
import dao.BasketHelpInfoDao;
import model.AppContext;
import model.Artical;
import model.Basket;
import model.BasketHelpInfo;
import model.User;

/**
 * Servlet implementation class BasketUpdateServlet
 */
@WebServlet("/basketUpdateServlet")
public class BasketUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BasketUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("idArtical");
		if (id == null) {
			System.out.println("nes geknulo");
			return;
		}
		int idArtical = Integer.parseInt(id);
		ArticalDao articalDao = new ArticalDao();
		//Artical artical = articalDao.findById(idArtical);

		HttpSession session = request.getSession();
		Basket basket = (Basket) session.getAttribute("basket");
		if (basket == null) {
			System.out.println("prazna korpa Eror 4004");
			return;
		}

		if (basket.getBoughtArticls().get(idArtical) == null) {
			System.out.println("ne bi trebalo da se desi !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			return;
		} else {

			basket.getBoughtArticls().put(idArtical,  Double.parseDouble(request.getParameter("amountOfArtical")));
		}
		
		BasketHelpInfoDao dao = new BasketHelpInfoDao();
		
		double ukupna = 0;
		ArrayList<BasketHelpInfo> baskets = dao.getListOfBasketHelpInfo(basket);
		ukupna = dao.ukupnaCena(baskets);
		
	    basket.setPrice(ukupna);
		
		request.setAttribute("basket", baskets);
		System.out.println(ukupna);
		request.setAttribute("ukupna", ukupna);
		
		//System.out.println(basket.getBoughtArticls());
		RequestDispatcher disp = request.getRequestDispatcher("/basket.jsp");
    	disp.forward(request, response);
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
