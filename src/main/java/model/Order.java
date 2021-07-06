package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Enums.OrderStatus;

public class Order extends Entity{

	private ArrayList<Artical> aritcls;
	private Restorant restorant;
	private double cena;
	private String buyer;
	private LocalDate date;
	private User user;
	private int brListe;		//lista kojoj pripada u USER 
	private OrderStatus status;
	

	
	
	
	public Order(int id , ArrayList<Artical> articls , Restorant restorant , double cena , String buyer , LocalDate date , User user , int brListe) {
		super(id);
		this.aritcls = articls;
		this.restorant = restorant;
		this.cena = cena;
		this.buyer = buyer;
		this.date = date;
		this.user = user;
		this.brListe = brListe;
		
	}
	public Order(int id ,  Restorant restorant , double cena , String buyer , LocalDate date , User user , int brListe) {
		super(id);
		this.restorant = restorant;
		this.cena = cena;
		this.buyer = buyer;
		this.date = date;
		this.user = user;
		this.brListe = brListe;
	}

	@Override
	public String exportString() {
		String s = "" + id + "|";
		s += restorant.getId() + "|" + cena + "|" + buyer + "|" ;
		s += DateConverse.convertLocalDateToString(date);
		s += "|" + user.id + "|" + brListe ;
		return s;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public ArrayList<Artical> getAritcls() {
		return aritcls;
	}

	public void setAritcls(ArrayList<Artical> aritcls) {
		this.aritcls = aritcls;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getBrListe() {
		return brListe;
	}

	public void setBrListe(int brListe) {
		this.brListe = brListe;
	}

	
	
	public Restorant getRestorant() {
		return restorant;
	}
	public void setRestorant(Restorant restorant) {
		this.restorant = restorant;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	
	
	
}
