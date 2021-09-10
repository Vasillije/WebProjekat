package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Enums.OrderStatus;
import dao.ArticalDao;
import model.AppContext;
import model.Artical;
import model.Basket;
import model.BasketHelpInfo;
import model.Order;
import model.OrderArtical;
import model.User;


@WebServlet("/basketServlet")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BasketServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Basket basket = getBasket(session);
		double ukupnaCena = 0;
		
		
		ArrayList<BasketHelpInfo> baskets = new ArrayList<BasketHelpInfo>();
		ArticalDao articalDao = new ArticalDao();
		
		
		Iterator it = basket.getBoughtArticls().entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        BasketHelpInfo basketHelpInfo = new BasketHelpInfo( articalDao.findById((Integer)pair.getKey()), (Double)pair.getValue());
	        baskets.add(basketHelpInfo); 
	        ukupnaCena += basketHelpInfo.getPrice();
	    }
	    basket.setPrice(ukupnaCena);
		
		request.setAttribute("basket", baskets);
		request.setAttribute("ukupna", ukupnaCena);
		
		//System.out.println(basket.getBoughtArticls());
		RequestDispatcher disp = request.getRequestDispatcher("/basket.jsp");
    	disp.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Basket basket = getBasket(session);
		session.setAttribute("basket", null);
		session.setAttribute("ukupna", 0);
		if(session.getAttribute("user") == null) {
			RequestDispatcher disp = request.getRequestDispatcher("/home");		//treba postaviti neki ispis (korpa je prazna)
			disp.forward(request, response);
	    	return;
		}
		if(basket == null) {
			RequestDispatcher disp = request.getRequestDispatcher("/home");		//treba postaviti neki ispis (korpa je prazna)
	    	disp.forward(request, response);
	    	return;
		}
		int id = AppContext.getAplicationContext().GenerateID(AppContext.getAplicationContext().getOrders());
		User user = basket.getUser();
		LocalDate dateNow = LocalDate.now();
		String userName ;
		if(user == null) {
			userName = "";
			RequestDispatcher disp = request.getRequestDispatcher("/index.jsp");
	    	disp.forward(request, response);
	    	return;
		}else {
			userName = user.getName() + " " + user.getSurname();
		}
		if(basket.getRestorant() == null) {
			System.out.println("basket is not valid !!!!!!!!!!");
			RequestDispatcher disp = request.getRequestDispatcher("/index.jsp");
	    	disp.forward(request, response);
			return ;
		}
		Order order = new Order(id, basket.getRestorant(), basket.getPrice(), userName, dateNow, user, null, 1000, OrderStatus.PROCESSING);
		user.setPointsCustomer((int)(user.getPointsCustomer() + order.getCena()/1000*133));
		AppContext.getAplicationContext().getOrders().add(order);
		
		ArticalDao articalDao = new ArticalDao();
		
		Iterator it = basket.getBoughtArticls().entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        int idOrderArtical = AppContext.getAplicationContext().GenerateID(AppContext.getAplicationContext().getOrderArticls());
	        Artical artical = articalDao.findById((Integer)pair.getKey());
	        OrderArtical orderArtical = new OrderArtical(idOrderArtical, order, artical, (Double)pair.getValue()); 
	        AppContext.getAplicationContext().getOrderArticls().add(orderArtical);

	    }
		
	    AppContext.getAplicationContext().save();
	    RequestDispatcher disp = request.getRequestDispatcher("/index.jsp");
    	disp.forward(request, response);
		
	}
	
	
	protected Basket getBasket(HttpSession session ) {
		Basket basket = (Basket)session.getAttribute("basket");
        if(basket == null) {
        	basket = new Basket(AppContext.getAplicationContext().GenerateID(AppContext.getAplicationContext().getBaskets()));
    		
            User user = (User)session.getAttribute("user");
    		
    		basket.setUser(user);
    		basket.setBoughtArticls(new HashMap<Integer, Double>());
        }
		return basket;
		
	}

}
