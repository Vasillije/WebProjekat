package model;

import Enums.ArticalType;

public class Artical extends Entity{
	private String name;
	private int price;
	private double amount;
	private String opis;
	private String image;
	private Restorant restorant;
	private ArticalType type;
	private Order order;
	
	public Artical(int id) {
		super(id);
	}
	


	public Artical(int id,String name , int price , double amount , String opis , String image , ArticalType type , Restorant restorant , Order order) {
		super(id);
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.opis = opis;
		this.image = image;
		this.type = type;
		this.restorant = restorant;
		this.order = order;
	}
	
	@Override
	public String exportString() {
		String s = id  + "|" + name + "|" + price + "|" + amount + "|" + opis + "|" + image  + "|" + type.ordinal() + "|" ;
		s += ((restorant == null) ? "" : restorant.getId()) + "|";
		s += ((order == null) ? "" : order.getId()) + "|";
				
		return s;
	}
	
	public Order getOrder() {
		return order;
	}
	
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ArticalType getType() {
		return type;
	}
	public void setType(ArticalType type) {
		this.type = type;
	}
	public Restorant getRestorant() {
		return restorant;
	}
	public void setRestorant(Restorant restorant) {
		this.restorant = restorant;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
