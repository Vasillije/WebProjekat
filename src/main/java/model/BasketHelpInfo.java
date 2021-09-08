package model;

public class BasketHelpInfo {
	private Artical artical;
	private double amount;
	private double price;
	
	public BasketHelpInfo(Artical artical, double amount) {
		super();
		this.artical = artical;
		this.amount = amount;
		this.price = artical.getPrice()*amount;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Artical getArtical() {
		return artical;
	}
	public void setArtical(Artical artical) {
		this.artical = artical;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}	
