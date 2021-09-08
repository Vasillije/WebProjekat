package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Enums.OrderStatus;

public class Order extends Entity{

	//private ArrayList<Artical> aritcls;
	private Restorant restorant;
	private double cena;
	private String buyer;
	private LocalDate date;
	private User userCustomer;
	private User userShipper;
	private int brListe;		
	private OrderStatus status;
	

	
	
	
	public Order(int id , ArrayList<Artical> articls , Restorant restorant , double cena , String buyer , LocalDate date , User userCustomer ,User userShipper,
			int brListe, OrderStatus status) {
		super(id);
		//this.aritcls = articls;
		this.restorant = restorant;
		this.cena = cena;
		this.buyer = buyer;
		this.date = date;
		this.userCustomer = userCustomer;
		this.userShipper = userShipper;
		this.brListe = brListe;
		this.status = status;
		
	}
	public Order(int id ,  Restorant restorant , double cena , String buyer , LocalDate date ,  User userCustomer ,User userShipper, int brListe,OrderStatus status) {
		super(id);
		this.status = status;
		this.restorant = restorant;
		this.cena = cena;
		this.buyer = buyer;
		this.date = date;
		this.userCustomer = userCustomer;
		this.userShipper = userShipper;
		this.brListe = brListe;
	}

	@Override
	public String exportString() {
		String s = "" + id + "|";
		s += restorant.getId() + "|" + cena + "|" + buyer + "|" ;
		s += DateConverse.convertLocalDateToString(date);
		s += "|" + userCustomer.getId() + "|";
		s += (userShipper == null) ? "" : userShipper.getId()  ;
		s += "|" + brListe + "|" + status.ordinal();
		return s;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public User getUserCustomer() {
		return userCustomer;
	}
	public void setUserCustomer(User userCustomer) {
		this.userCustomer = userCustomer;
	}
	public User getUserShipper() {
		return userShipper;
	}
	public void setUserShipper(User userShipper) {
		this.userShipper = userShipper;
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
