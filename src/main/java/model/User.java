package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Enums.Pol;
import Enums.Role;

public class User extends Entity{
	private String username;
	private String password;
	private String name;
	private String surname;
	private Pol sex;
	private LocalDate birdth;
	private Role role;
	private ArrayList<Order> ordersCustomer;
	private Basket basketCustomer; 
	private Restorant restorantMnagaer;
	private ArrayList<Order> ordersShipper;
	private int pointsCustomer;
	private CustomerType typeCustomer;
	
	public User(int id){
		super(id);
	}
	public User(int id , String username , String password , String name , String surname , Pol sex 
			, LocalDate birdth , Role role , Basket basketCustomer , Restorant restorantMnagaer ,
			int pointsCustomer , CustomerType typeCustomer){
		super(id);
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.birdth = birdth;
		this.role = role;
		this.basketCustomer = basketCustomer;
		this.restorantMnagaer = restorantMnagaer;
		this.pointsCustomer = pointsCustomer;
		this.typeCustomer = typeCustomer;
		
	}
	
	@Override
	public String exportString() {
		String s = id + "|" + username + "|" + password + "|" + name + "|" + surname + "|" + sex.ordinal() + "|" +
				birdth + "|";
		s += ((role==null) ? "" : role.ordinal()) + "|";
		s += ((basketCustomer==null) ? "" : basketCustomer.getId()) + "|";
		s += ((restorantMnagaer == null) ? "" : restorantMnagaer.getId()) + "|" ;
		s += pointsCustomer + "|";
		s += ((typeCustomer == null)? "" : typeCustomer.getId());		
		
		return s;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Pol getSex() {
		return sex;
	}
	public void setSex(Pol sex) {
		this.sex = sex;
	}
	public LocalDate getBirdth() {
		return birdth;
	}
	public void setBirdth(LocalDate birdth) {
		this.birdth = birdth;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public ArrayList<Order> getOrdersCustomer() {
		return ordersCustomer;
	}
	public void setOrdersCustomer(ArrayList<Order> ordersCustomer) {
		this.ordersCustomer = ordersCustomer;
	}
	public Basket getBasketCustomer() {
		return basketCustomer;
	}
	public void setBasketCustomer(Basket basketCustomer) {
		this.basketCustomer = basketCustomer;
	}
	public Restorant getRestorantMnagaer() {
		return restorantMnagaer;
	}
	public void setRestorantMnagaer(Restorant restorantMnagaer) {
		this.restorantMnagaer = restorantMnagaer;
	}
	public ArrayList<Order> getOrdersShipper() {
		return ordersShipper;
	}
	public void setOrdersShipper(ArrayList<Order> ordersShipper) {
		this.ordersShipper = ordersShipper;
	}
	public int getPointsCustomer() {
		return pointsCustomer;
	}
	public void setPointsCustomer(int pointsCustomer) {
		this.pointsCustomer = pointsCustomer;
	}
	public CustomerType getTypeCustomer() {
		return typeCustomer;
	}
	public void setTypeCustomer(CustomerType typeCustomer) {
		this.typeCustomer = typeCustomer;
	}
	
	
	
	
	
	
	
}	
