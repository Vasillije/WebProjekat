package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestorantDao;
import model.Restorant;

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
		System.out.println("BOPBIPBAP");
		if(id == null) {
			System.out.println("nes geknulo");
			return;
		}
		int idRest = Integer.parseInt(id);
		System.out.println(idRest);
		RestorantDao dao = new RestorantDao();
		Restorant restorant = dao.findById(idRest);
		request.setAttribute("restorant", restorant);
		
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
