package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Enums.ArticalType;
import Enums.Pol;
import dao.ArticalDao;
import dao.UserDao;
import model.AppContext;
import model.Artical;
import model.DateConverse;
import model.Entity;
import model.User;

/**
 * Servlet implementation class CreateArticalServlet
 */
@WebServlet("/createArtical")
public class CreateArticalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateArticalServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher disp = request.getRequestDispatcher("/createArtical.jsp");
    	disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		ArticalDao articalDao = new ArticalDao();
		Entity artical = articalDao.findByName(name);
		if(artical != null) {
			request.setAttribute("error", "Artical already exists!!!!!!!!!!!!!!!!");
    		RequestDispatcher disp = request.getRequestDispatcher("/createArtical.jsp");
        	disp.forward(request, response);
        	return;
		}
		String price = request.getParameter("price");
		String artType = request.getParameter("articalType");
		String image = request.getParameter("image");
		String description = request.getParameter("description");
		String amount = request.getParameter("amount");
		
		
		
	
    	int id = AppContext.getAplicationContext().GenerateID(AppContext.getAplicationContext().getArticals());
 
    	Artical articalA = new Artical(id);
    	articalA.setName(name);
    	articalA.setPrice(Integer.parseInt(price));
    	
    	ArticalType type = ArticalType.valueOf(artType);
    	articalA.setType(type);
    	articalA.setImage(image);
    	articalA.setOpis(description);
    	articalA.setAmount(Double.parseDouble(amount));
    	HttpSession session = request.getSession();
    	User user = (User)session.getAttribute("user");
    	articalA.setRestorant(user.getRestorantMnagaer());
    	
    	
    	AppContext.getAplicationContext().getArticals().add(articalA);
        AppContext.getAplicationContext().save();
        
        
        RequestDispatcher disp = request.getRequestDispatcher("/HomeServlet");
    	disp.forward(request, response);
	}

}
