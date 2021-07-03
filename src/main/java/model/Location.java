package model;

public class Location extends Entity{
	private double gLenght;
	private double gWidth; 
	private Adress adress;
	
	public Location(int id , double gLenght , double gWidth , Adress adress) {
		super(id);
		this.gLenght = gLenght;
		this.gWidth = gWidth;
		this.adress = adress;
	}
	
	@Override
	public String exportString() {
		return id + "|"+ gLenght + "|" + gWidth + "|" + adress.getId();
	}
	
	
	public double getgLenght() {
		return gLenght;
	}
	public void setgLenght(double gLenght) {
		this.gLenght = gLenght;
	}
	public double getgWidth() {
		return gWidth;
	}
	public void setgWidth(double gWidth) {
		this.gWidth = gWidth;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
}
