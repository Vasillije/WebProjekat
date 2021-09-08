package model;

import java.util.HashMap;

public class Basket extends Entity{
	private HashMap<Integer , Double> boughtArticls;
	private User user;
	private double price;
	private Restorant restorant;
	
	public Basket(int id){
		super(id);
	}
	
	public Basket(int id,HashMap<Integer , Double> map , User user , double price, Restorant restorant) {
		super(id);
		this.price = price;
		this.user = user;
		this.boughtArticls = map;
	}
	

	@Override
	public String exportString() {
		String s = "" + id + ";";
		
		for (Integer key : boughtArticls.keySet()) {
		    Double value = boughtArticls.get(key);
		    s += key + "," + value + ";";
		}
		
		//s += user.getId() + "|" + price;
		s += price + ";";
		s += restorant.getId();
		
		return s;
	}
	
	
	public HashMap<Integer, Double> getBoughtArticls() {
		return boughtArticls;
	}
	public void setBoughtArticls(HashMap<Integer, Double> boughtArticls) {
		this.boughtArticls = boughtArticls;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Restorant getRestorant() {
		return restorant;
	}
	
	public void setRestorant(Restorant restorant) {
		this.restorant = restorant;
	}
	
	
	
}
