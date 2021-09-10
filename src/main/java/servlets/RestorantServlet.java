package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Enums.Pol;
import Enums.RestorantStatus;
import Enums.RestorantType;
import dao.UserDao;
import model.Adress;
import model.AppContext;
import model.DateConverse;
import model.Entity;
import model.Location;
import model.Restorant;
import model.User;

/**
 * Servlet implementation class RestorantServlet
 */
@WebServlet("/createRestorant")
public class RestorantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestorantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Entity> users = new UserDao().findUserManager();
//		for(Entity e:users) {
//			System.out.println(((User)e).getName());
//		}

		request.setAttribute("managers", users);

		RequestDispatcher disp = request.getRequestDispatcher("/createRestorant.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("restorantName");
		String type = request.getParameter("restorantType");
		System.out.println(type);
		RestorantType type1 = RestorantType.valueOf(type);

		String gLenght = request.getParameter("restorantgLenght");
		String gWidth = request.getParameter("restorantgWidth");

		String restorantStreetName = request.getParameter("restorantStreetName");
		String restorantStreetNumber = request.getParameter("restorantStreetNumber");
		String restorantPlace = request.getParameter("restorantPlace");
		String restorantZipCode = request.getParameter("restorantZipCode");

		int idAdress = AppContext.getAplicationContext().GenerateID(AppContext.getAplicationContext().getAdresses());
		int idLocation = AppContext.getAplicationContext().GenerateID(AppContext.getAplicationContext().getLocations());
		int idRestorant = AppContext.getAplicationContext()
				.GenerateID(AppContext.getAplicationContext().getRestorants());

		int restorantStreetNumber1 = Integer.parseInt(restorantStreetNumber);

		Adress adress = new Adress(idAdress, restorantStreetName, restorantStreetNumber1, restorantPlace,
				restorantZipCode);

		Double gLenght1 = Double.parseDouble(gLenght);
		Double gWidth1 = Double.parseDouble(gWidth);
		Location location = new Location(idLocation, gLenght1, gWidth1, adress);

		String logo = request.getParameter("logo");

//		Part filePart = request.getPart("fileLogo");
//		String fileName = Paths.get(filePart.getName()).getFileName().toString();
//		InputStream fileContent = filePart.getInputStream();
//
//		System.out.println("|" + fileName + "|" + fileContent);

//    	File file = 
//    			try(OutputStream outputStream = new FileOutputStream(file)){
//    			    IOUtils.copy(fileContent, outputStream);
//    			} catch (FileNotFoundException e) {
//    			    // handle exception here
//    			} catch (IOException e) {
//    			    // handle exception here
//    			}
//    	

		Restorant resorant = new Restorant(idRestorant, name, type1, RestorantStatus.CLOSE, location, null);

		AppContext.getAplicationContext().getAdresses().add(adress);
		AppContext.getAplicationContext().getLocations().add(location);
		AppContext.getAplicationContext().getRestorants().add(resorant);
		AppContext.getAplicationContext().save();

		if (request.getParameter("manager").equals("-1")) {

			request.setAttribute("restID", resorant.getId());

			RequestDispatcher disp = request.getRequestDispatcher("/registrationMenager.jsp");
			disp.forward(request, response);

			return;
		}

		String value = request.getParameter("restorantManager");
		int userManagerId = Integer.parseInt(value);
		UserDao userDao = new UserDao();
		User userManager = userDao.findById(userManagerId);
		userManager.setRestorantMnagaer(resorant);
		RequestDispatcher disp = request.getRequestDispatcher("/index.jsp");
		disp.forward(request, response);
	}

}
