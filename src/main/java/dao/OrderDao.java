package dao;

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
	
}
