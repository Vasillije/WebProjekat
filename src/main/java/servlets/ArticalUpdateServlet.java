package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Enums.ArticalType;
import dao.ArticalDao;
import model.Artical;

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
		request.setAttribute("types", ArticalType.values());
		
		RequestDispatcher disp = request.getRequestDispatcher("/articalUpdate.jsp");
    	disp.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("articalID");
		int idArt = Integer.parseInt(id);
		ArticalDao dao = new ArticalDao();
		Artical artical = dao.findById(idArt);
		artical.setName(request.getParameter("name"));
		artical.setPrice(Integer.parseInt(request.getParameter("price")));
		artical.setImage(request.getParameter("image"));
		artical.setOpis(request.getParameter("description"));
		artical.setAmount(Double.parseDouble(request.getParameter("amount")));
		
		RequestDispatcher disp = request.getRequestDispatcher("/HomeServlet");
    	disp.forward(request, response);
		
	}

}
