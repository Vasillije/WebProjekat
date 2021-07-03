package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestorantDao;
import model.AppContext;
import model.Entity;
import model.Restorant;
import Enums.RestorantType;
import Enums.RestorantStatus;


@WebServlet("/restorantDisplay")
public class RestorantDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RestorantDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RestorantDao dao = new RestorantDao();
    	request.setAttribute("restorants", dao.getAllRestorants());
    	request.setAttribute("types", RestorantType.values());
    	request.setAttribute("status", RestorantStatus.values());
    	
    	
    	RequestDispatcher disp = request.getRequestDispatcher("/restorantDisplay.jsp");
    	disp.forward(request, response);
	}
	private void finish(HttpServletRequest request, HttpServletResponse response , ArrayList<Entity> validRestorants) throws ServletException, IOException{
		request.setAttribute("restorants", validRestorants);
		RequestDispatcher disp = request.getRequestDispatcher("/filteringRestorant.jsp");
    	disp.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchingBy = request.getParameter("searchType");
		RestorantDao dao = new RestorantDao();
		
		String searchValue = request.getParameter("searchValue").toLowerCase();
		
		ArrayList<Entity> allRestorants = AppContext.getAplicationContext().getRestorants();
		ArrayList<Entity> validRestorants = dao.searchByParam(allRestorants, searchingBy, searchValue);
		
		String sortingCrit = request.getParameter("sortingCrit");
		String sortingOrder = request.getParameter("sortingOrder");
		String filteringType = request.getParameter("filteringType");
		String filteringStatus = request.getParameter("filteringOpen");
		
		if(!filteringType.equals("noFilter")) {
			dao.restorantTypeFilter(validRestorants, filteringType);
		}
		
		if(!filteringStatus.equals("noFilter")) {
			dao.restorantStatusFilter(validRestorants, filteringStatus);
		}
				
		if(!sortingCrit.equals("noSort")) {
			dao.sortByParam(validRestorants, sortingCrit, sortingOrder);
		}
		request.setAttribute("restorants", validRestorants);
		RequestDispatcher disp = request.getRequestDispatcher("/filteringRestorant.jsp");
    	disp.forward(request, response);
		
		
		
	}

}
