package model;

public class OrderArtical extends Entity{
	private Order order;
	private Artical artical;
	private double amount;
	
	public OrderArtical(int id) {
		super(id);
	}
	public OrderArtical(int id, Order order, Artical artical, double amount) {
		super(id);
		this.order = order;
		this.artical = artical;
		this.amount = amount;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
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
	@Override
	public String exportString() {
		return id + "|" + order.getId() + "|" + artical.getId() + "|" + amount;
	}
}
