package model;

public class Adress extends Entity{
	private String street;
	private int number;
	private String place;
	private String zipCode;
	
	public Adress(int id,String street , int number , String place ,String zipCode) {
		super(id);
		this.street = street;
		this.number = number;
		this.place = place;
		this.zipCode = zipCode;
		
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String exportString() {
		return id + "|" + street + "|" + number + "|" + place + "|" + zipCode ;
	}
	
}
