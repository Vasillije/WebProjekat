package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketHelpInfoDao;
import model.Basket;
import model.BasketHelpInfo;

/**
 * Servlet implementation class BasketDeleteServlet
 */
@WebServlet("/basketDeleteServlet")
public class BasketDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idArtical");
		if(id == null) {
			System.out.println("nes geknulo");
			return;
		}
		BasketHelpInfoDao dao = new BasketHelpInfoDao();
		int idArtical = Integer.parseInt(id);
		
		HttpSession session = request.getSession();
		Basket basket = (Basket)session.getAttribute("basket");
		
		basket.getBoughtArticls().remove(idArtical);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
