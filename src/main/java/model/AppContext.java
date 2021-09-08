package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Enums.ArticalType;
import Enums.OrderStatus;
import Enums.Pol;
import Enums.RestorantStatus;
import Enums.RestorantType;
import Enums.Role;
import dao.AdressDao;
import dao.ArticalDao;
import dao.BasketDao;
import dao.CustomerTypeDao;
import dao.LocationDao;
import dao.OrderDao;
import dao.RestorantDao;
import dao.UserDao;

public class AppContext {

	private ArrayList<Entity> articals = new ArrayList<Entity>();
	private ArrayList<Entity> adresses = new ArrayList<Entity>();
	private ArrayList<Entity> baskets = new ArrayList<Entity>();
	private ArrayList<Entity> comments = new ArrayList<Entity>();
	private ArrayList<Entity> customertypes = new ArrayList<Entity>();
	private ArrayList<Entity> locations = new ArrayList<Entity>();
	private ArrayList<Entity> orders = new ArrayList<Entity>();
	private ArrayList<Entity> restorants = new ArrayList<Entity>();
	private ArrayList<Entity> users = new ArrayList<Entity>();
	private ArrayList<Entity> orderArticls = new ArrayList<Entity>();


	private String path = "C:\\VebBobBaza\\";
	private static AppContext aplicationContext;
	

	
	
	public ArrayList<Entity> getArticals() {
		return articals;
	}

	public void setArticals(ArrayList<Entity> articals) {
		this.articals = articals;
	}

	public ArrayList<Entity> getAdresses() {
		return adresses;
	}

	public void setAdresses(ArrayList<Entity> adresses) {
		this.adresses = adresses;
	}

	public ArrayList<Entity> getBaskets() {
		return baskets;
	}

	public void setBaskets(ArrayList<Entity> baskets) {
		this.baskets = baskets;
	}

	public ArrayList<Entity> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Entity> comments) {
		this.comments = comments;
	}

	public ArrayList<Entity> getCustomertypes() {
		return customertypes;
	}

	public void setCustomertypes(ArrayList<Entity> customertypes) {
		this.customertypes = customertypes;
	}

	public ArrayList<Entity> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<Entity> locations) {
		this.locations = locations;
	}

	public ArrayList<Entity> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Entity> orders) {
		this.orders = orders;
	}

	public ArrayList<Entity> getRestorants() {
		return restorants;
	}

	public void setRestorants(ArrayList<Entity> restorants) {
		this.restorants = restorants;
	}

	public ArrayList<Entity> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Entity> users) {
		this.users = users;
	}
	
	public ArrayList<Entity> getOrderArticls() {
		return orderArticls;
	}

	public void setOrderArticls(ArrayList<Entity> orderArticls) {
		this.orderArticls = orderArticls;
	}


	public static AppContext getAplicationContext() {
		if(aplicationContext == null) {
			aplicationContext = new AppContext();
			aplicationContext.load();
		}
		return aplicationContext;
	}
	
	
	
	public void saveArticals() {
		if(articals == null) {
			return;
		}
		
		FileWriter fw;
		BufferedWriter writer;
		try {
			fw = new FileWriter(path + "articals.txt");
			
			
			writer = new BufferedWriter(fw);
			
			for(Entity e : articals) {
				writer.write(e.exportString());
				writer.newLine();
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	   // writer.write(str);
	    
	}
	
	
	public void saveAdresses() {
		if(adresses == null) {
			return;
		}
		
		FileWriter fw;
		BufferedWriter writer;
		try {
			fw = new FileWriter(path + "adresses.txt");
			
			
			writer = new BufferedWriter(fw);
			
			for(Entity e : adresses) {
				writer.write(e.exportString());
				writer.newLine();
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveBaskets() {
		if(baskets == null) {
			return;
		}
		
		FileWriter fw;
		BufferedWriter writer;
		try {
			fw = new FileWriter(path + "baskets.txt");
			
			
			writer = new BufferedWriter(fw);
			
			for(Entity e : baskets) {
				writer.write(e.exportString());
				writer.newLine();
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveComments() {
		if(comments == null) {
			return;
		}
		
		FileWriter fw;
		BufferedWriter writer;
		try {
			fw = new FileWriter(path + "comments.txt");
			
			
			writer = new BufferedWriter(fw);
			
			for(Entity e : comments) {
				writer.write(e.exportString());
				writer.newLine();
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveCustomerTypes() {
		if(customertypes == null) {
			return;
		}
		
		FileWriter fw;
		BufferedWriter writer;
		try {
			fw = new FileWriter(path + "customertypes.txt");
			
			
			writer = new BufferedWriter(fw);
			
			for(Entity e : customertypes) {
				writer.write(e.exportString());
				writer.newLine();
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveLocations() {
		if(locations == null) {
			return;
		}
		
		FileWriter fw;
		BufferedWriter writer;
		try {
			fw = new FileWriter(path + "locations.txt");
			
			
			writer = new BufferedWriter(fw);
			
			for(Entity e : locations) {
				writer.write(e.exportString());
				writer.newLine();
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void saveOrders() {
		if(orders == null) {
			return;
		}
		
		FileWriter fw;
		BufferedWriter writer;
		try {
			fw = new FileWriter(path + "orders.txt");
			
			
			writer = new BufferedWriter(fw);
			
			for(Entity e : orders) {
				writer.write(e.exportString());
				writer.newLine();
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveRestorants() {
		if(restorants == null) {
			return;
		}
		
		FileWriter fw;
		BufferedWriter writer;
		try {
			fw = new FileWriter(path + "restorants.txt");
			
			
			writer = new BufferedWriter(fw);
			
			for(Entity e : restorants) {
				writer.write(e.exportString());
				writer.newLine();
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveUsers() {
		if(users == null) {
			return;
		}
		//String path = System.getProperty("user.dir");
		
		
		FileWriter fw;
		BufferedWriter writer;
		try {
			fw = new FileWriter(path + "users.txt");
			
			
			
			writer = new BufferedWriter(fw);
			
			for(Entity e : users) {
				writer.write(e.exportString());
				writer.newLine();
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveOrderArticls() {
		if(orderArticls == null) {
			return;
		}
		
		
		FileWriter fw;
		BufferedWriter writer;
		try {
			fw = new FileWriter(path + "orderArticls.txt");
			
			
			
			writer = new BufferedWriter(fw);
			
			for(Entity e : orderArticls) {
				writer.write(e.exportString());
				writer.newLine();
			}
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	public void save() {
		saveArticals();
		saveAdresses();
		saveBaskets();
		saveComments();
		saveCustomerTypes();
		saveOrders();
		saveRestorants();
		saveUsers();
		saveLocations();
		saveOrderArticls();
	}
	
	public void load() {
		loadAdresses();
		loadCustomerTypes();
		loadLocations();
		loadRestorants();
		loadBaskets();
		loadUsers();
		loadComments();
		loadOrders();
		loadArticals();
	}
	
	public void loadOrderArticls() {
		String line;
		OrderDao orderDao = new OrderDao();
		ArticalDao articalDao = new ArticalDao();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "orderArticls.txt"));
			
			
			while((line = br.readLine()) != null) {		//id + "|" + street + "|" + number + "|" + place + "|" + zipCode ;
				String[] lineParts = line.split("\\|");
				int id = Integer.parseInt(lineParts[0]);
				int orderId = Integer.parseInt(lineParts[1]);
				int articalId = Integer.parseInt(lineParts[2]);
				double amount = Double.parseDouble(lineParts[3]);
				OrderArtical orderArtical = new OrderArtical(id, orderDao.findById(orderId), articalDao.findById(articalId), amount);
				orderArticls.add(orderArtical);
				
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadAdresses() {
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "adresses.txt"));
			
			
			while((line = br.readLine()) != null) {		//id + "|" + street + "|" + number + "|" + place + "|" + zipCode ;
				String[] lineParts = line.split("\\|");
				int id = Integer.parseInt(lineParts[0]);
				int number = Integer.parseInt(lineParts[2]);
				Adress adress = new Adress(id , lineParts[1] , number , lineParts[3] , lineParts[4]);
				adresses.add(adress);
				
			}
			
			
			br.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void loadCustomerTypes() {
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "customertypes.txt"));		// id + "|" + nameType + "|" + discount + "|" + points;
			while((line = br.readLine()) != null) {
				String[] lineParts = line.split("\\|");
				int id = Integer.parseInt(lineParts[0]);
				double discount = Double.parseDouble(lineParts[2]);
				int points = Integer.parseInt(lineParts[3]);
				
				CustomerType customertype = new CustomerType(id , lineParts[1] , discount , points);
				customertypes.add(customertype);
				
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void loadLocations() {
		String line;
		AdressDao dao = new AdressDao();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "locations.txt"));		//id + "|"+ gLenght + "|" + gWidth + "|" + adress.getId();
			while((line = br.readLine()) != null) {
				String[] lineParts = line.split("\\|");
				int id = Integer.parseInt(lineParts[0]);
				double gLenght = Double.parseDouble(lineParts[1]);
				double gWidth = Double.parseDouble(lineParts[2]);
				int idAdress = Integer.parseInt(lineParts[3]);
				Adress adr = dao.findById(idAdress);
				this.locations.add(new Location(id , gLenght , gWidth , adr));
				
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void loadRestorants() {
		String line;
		LocationDao dao = new LocationDao();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "restorants.txt"));	// id +"|" + name + "|" + type.ordinal() + "|" + status.ordinal() + "|" + location.getId() + "|" + logoPath ;
			while((line = br.readLine()) != null) {
				String[] lineParts = line.split("\\|");
				int id = Integer.parseInt(lineParts[0]);
				int enumRestType = Integer.parseInt(lineParts[2]);
				int enumRestStatus = Integer.parseInt(lineParts[3]);
				int idLocation = Integer.parseInt(lineParts[4]);
				
				RestorantType restType = null;
				for(RestorantType rt : RestorantType.values()) {
					if(rt.ordinal() == enumRestType) {
						restType = rt;
					}
				}
				
				RestorantStatus restStatus = null;
				for(RestorantStatus rt : RestorantStatus.values()) {
					if(rt.ordinal() == enumRestStatus) {
						restStatus = rt;
					}
				}
				Location l = dao.findById(idLocation);
				
				Restorant R = new Restorant(id , lineParts[1] , restType , restStatus , l , lineParts[5]);
				
				this.restorants.add(R);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void loadBaskets() {
		String line;
		RestorantDao dao = new RestorantDao();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "baskets.txt"));
			
			while((line = br.readLine()) != null) {			//(ArrayList<Artical> articls , Restorant restorant , double cena , String buyer , LocalDate date)
				String[] lineParts = line.split("\\;");
				int id = Integer.parseInt(lineParts[0]);
				HashMap<Integer , Double> boughtArticls = new HashMap<Integer , Double>();
				for(int i=1;i<lineParts.length - 2;i++) {
					String subLineP[] = lineParts[i].split("\\,");
					int idArtikal = Integer.parseInt(subLineP[0]);
					double d = Double.parseDouble(subLineP[1]);
					boughtArticls.put(idArtikal ,  d);
					
				}
				String restS = lineParts[lineParts.length - 2];
				int restId = Integer.parseInt(lineParts[lineParts.length - 1]);
				Restorant rest = dao.findById(restId);
				//String[] rest = restS.split("|");
				//int idRestorant = Integer.parseInt(rest[0]);
				double price = Double.parseDouble(restS);
				
				//orders.add(new Order(aritcls , resorant , price , rest[2] , ldate));
				this.baskets.add(new Basket(id ,boughtArticls , null , price, rest ));
				
				
			}
			
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadUsers() {
		String line;
		BasketDao basketDao = new BasketDao();
		RestorantDao restDao = new RestorantDao();
		CustomerTypeDao custTypeDao = new CustomerTypeDao();		
		/*String s = id + "|" + username + "|" + password + "|" + name + "|" + surname + "|" + sex.ordinal() + "|" + 
				birdth + "|" + role.ordinal() + "|" ;
		s += basketCustomer.getId() + "|" + restorantMnagaer.getId() + "|" ;
		s += pointsCustomer + "|" + typeCustomer.getId() ;	
		*/
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "users.txt"));
			
			while((line = br.readLine()) != null) {			
				String[] lineParts = line.split("\\|");
				int id = Integer.parseInt(lineParts[0]);
				int sexNum = Integer.parseInt(lineParts[5]);
				int roleNum = (lineParts[7].isEmpty()) ?-1 : Integer.parseInt(lineParts[7]);
				int basketCustId = (lineParts[8].isEmpty())? -1 : Integer.parseInt(lineParts[8]);
				int restManagerId = (lineParts[9].isEmpty())? -1 : Integer.parseInt(lineParts[9]);
				int pointsCustomer = Integer.parseInt(lineParts[10]);
				int typeCustomerId = -1;
				if(lineParts.length >= 12) {
					typeCustomerId = (lineParts[11] == "")? -1 : Integer.parseInt(lineParts[11]);
					
				}
				
				Basket basket = basketDao.findById(basketCustId);
				Restorant restorant = restDao.findById(restManagerId);
				CustomerType typeCustomer = custTypeDao.findById(typeCustomerId);
				
				Pol[] arrayPol = Pol.values();
				Pol valuePol = arrayPol[sexNum];
				
				Role valueRole;
				if(roleNum == -1) {
					valueRole = null;
				}else {
					Role[] arrayRole = Role.values();
					valueRole = arrayRole[roleNum];
					
				}
				LocalDate date = DateConverse.convertStringToLocalDate(lineParts[6]);
				
				
				User user = new User(id , lineParts[1], lineParts[2], lineParts[3], lineParts[4],valuePol ,date,valueRole, basket, restorant,pointsCustomer , typeCustomer);
				
				users.add(user);
				
			}
			
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void loadComments() {
		String line;
		
		UserDao daoUser = new UserDao();
		RestorantDao daoRest = new RestorantDao();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "comments.txt"));
			//return id + "|" + buyer.getId() + "|" + restorant.getId() + "|" + text + "|" + grade;
			while((line = br.readLine()) != null) {			
				String[] lineParts = line.split("\\|");
				int id = Integer.parseInt(lineParts[0]);
				int userId = Integer.parseInt(lineParts[1]);
				int restId = Integer.parseInt(lineParts[2]);
				String text = lineParts[3];
				int grade = Integer.parseInt(lineParts[4]);
				
				User user = daoUser.findById(userId);
				Restorant restorant = daoRest.findById(restId);
				
				Comment comment = new Comment(id , user , restorant , text , grade);
				comments.add(comment);
				
				
			}
			
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void loadOrders() {
		String line;
		
		UserDao daoUser = new UserDao();
		RestorantDao daoRest = new RestorantDao();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "orders.txt"));
			/*
			 * String s = "" + id;
		s += restorant.getId() + "|" + cena + "|" + buyer + "|" ;
		s += DateConverse.convertLocalDateToString(date);
		s += "|" + user.id + "|" + brListe
			 */
			while((line = br.readLine()) != null) {			
				String[] lineParts = line.split("\\|");
				int id = Integer.parseInt(lineParts[0]);
				int idRestorant = Integer.parseInt(lineParts[1]);
				double price = Double.parseDouble(lineParts[2]);
				String buyer = lineParts[3];
				LocalDate ldate= DateConverse.convertStringToLocalDate(lineParts[4]);
				int userCustomerId = Integer.parseInt(lineParts[5]);
				int userShipperId = -1;
				if(!lineParts[6].equals("")) {
					userShipperId = Integer.parseInt(lineParts[6]);
				}
				int brListe  = Integer.parseInt(lineParts[7]);
				int statusOrdinal = Integer.parseInt(lineParts[8]);
				
				OrderStatus[] statusi = OrderStatus.values();
				OrderStatus izFajla = statusi[statusOrdinal];
				
				User userCustomer = daoUser.findById(userCustomerId);
				User userShipper = daoUser.findById(userShipperId);
				
				
				Restorant restorant = daoRest.findById(idRestorant);
				
				Order ord = new Order(id , restorant , price , buyer , ldate ,userCustomer, userShipper, brListe, izFajla);
				
				orders.add(ord);
				
			}
			
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void loadArticals() {
		String line;
		RestorantDao dao = new RestorantDao();
		OrderDao daoOrd = new OrderDao();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "articals.txt"));
			
			while((line = br.readLine()) != null) {
				String[] lineParts = line.split("\\|");	//id  + "|" + name + "|" + price + "|" + amount + "|" + opis + "|" + image  + "|" + type.ordinal() + "|" + restorant.getId() + order.id;
				int id = Integer.parseInt(lineParts[0]);
				int price = Integer.parseInt(lineParts[2]);
				double amount = Double.parseDouble(lineParts[3]);
				int indexEnuma = Integer.parseInt(lineParts[6]);
				int idRestoran = Integer.parseInt(lineParts[7]);
				
				Restorant r = dao.findById(idRestoran);
				ArticalType articalT = null;
				for(ArticalType at : ArticalType.values()) {
					if(at.ordinal() == indexEnuma) {
						articalT = at;
					}
				}
				
				//Order order = daoOrd.findById(Integer.parseInt(lineParts[8]));
				Artical art = new Artical(id , lineParts[1] , price , amount , lineParts[4] , lineParts[5] ,articalT , r,  null);
				articals.add(art);
				
				
			}
			
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public int GenerateID(List<Entity> entities) {
		int id = 0;
		
		for(Entity entity: entities) {
			if(entity.getId() > id) 
			{
				id = entity.getId();
			}
		}
		return id + 1;
	}
	
	

	
	
	
	
	
}
