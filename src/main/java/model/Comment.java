package model;

public class Comment extends Entity{
	private User buyer;
	private Restorant restorant;
	private String text;
	private int grade;
	
	Comment(int id , User buyer , Restorant rest , String text , int grade){
		super(id);
		this.restorant = rest;
		this.text = text;
		this.grade = grade;	
	}
	@Override
	public String exportString() {	
		return id + "|" + buyer.getId() + "|" + restorant.getId() + "|" + text + "|" + grade;
	}
	
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	public Restorant getRestorant() {
		return restorant;
	}
	public void setRestorant(Restorant restorant) {
		this.restorant = restorant;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
