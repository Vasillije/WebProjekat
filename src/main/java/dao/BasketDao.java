package dao;

import model.AppContext;
import model.Basket;
import model.Entity;

public class BasketDao extends dao<Basket>{
	
	public Basket findById(int id) {
		for(Entity b : AppContext.getAplicationContext().getBaskets()) {
			if(b.getId() == id) {
				return (Basket)b;
				
				
			}
		}
		return null;
	}
	

}
