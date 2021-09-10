package model;

import Enums.Role;

public class CustomerType extends Entity{
	private String nameType;
	private double discount;
	private int points;
	
	public CustomerType(int id , String nameType , double discount , int points) {
		super(id);
		this.nameType = nameType;
		this.discount = discount;
		this.points = points;
	}
	
	@Override
	public String exportString() {
		
		return id + "|" + nameType + "|" + discount + "|" + points;
	}
	
	public String getNameType() {
		return nameType;
	}
	public void setNameType(String nameType) {
		this.nameType = nameType;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
