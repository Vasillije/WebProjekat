package dao;

import java.util.ArrayList;

import model.AppContext;
import model.Entity;
import model.Order;

public class OrderDao extends dao<Order>{

	public Order findById(int id) {
		for(Entity o : AppContext.getAplicationContext().getOrders()) {
			if(o.getId() == id) {
				return (Order)o;
			}
		}
		return null;
	}
	
	public ArrayList<Entity> findByRestorantId(int id){
		ArrayList<Entity> orders = new ArrayList<Entity>();
		for(Entity o : AppContext.getAplicationContext().getOrders()) {
			Order order = (Order)o;
			if(order.getRestorant().getId() == id) {
				orders.add(o);
			}
		}
		return orders;
	}
	
}
