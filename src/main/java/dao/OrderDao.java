package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import Enums.OrderStatus;
import Enums.RestorantStatus;
import Enums.RestorantType;
import model.AppContext;
import model.DateConverse;
import model.Entity;
import model.Order;
import model.Restorant;

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
	public ArrayList<Order> selectWaitingOrder(ArrayList<Order> orders){
		ArrayList<Order> waitingOrders = new ArrayList<Order>();
		for(Order entity : orders) {
			if((entity).getStatus() == OrderStatus.WAITING ) {
				waitingOrders.add(entity);
			}
		}
		return waitingOrders;
	}
	
	public ArrayList<Entity> findOrderByUserCustomerId(int id){
		ArrayList<Entity> orders = new ArrayList<Entity>();
		for(Entity entity : AppContext.getAplicationContext().getOrders()) {
			if( ((Order)entity).getUserCustomer().getId() == id) {
				orders.add(entity);
			}
		}
		return orders;
	}
	
	public ArrayList<Order> findOrderByUserShipperId(int id){
		ArrayList<Order> orders = new ArrayList<Order>();
		for(Entity entity : AppContext.getAplicationContext().getOrders()) {
			if(((Order)entity).getUserShipper().getId() == id) {
				orders.add((Order)entity);
			}
		}
		return orders;
	}
	
	
	public ArrayList<Entity> searchByParam(ArrayList<Entity> orders, String searchingBy , String searchingForFrom, String searchingForTo) {
		ArrayList<Entity> retVal = new ArrayList<Entity>();
		if(searchingBy.equals("restName")) {
			for(Entity e : orders) {
				Order order = (Order)e;
				if(order.getRestorant().getName().toLowerCase().contains(searchingForFrom)) {
					retVal.add(e);
				}
				
			}
			
		}else if(searchingBy.equals("orderPrice")) {
			for(Entity e : orders) {
				Order order = (Order)e;
				if(order.getCena() > Double.parseDouble(searchingForFrom) && order.getCena() < Double.parseDouble(searchingForTo)) {
					retVal.add(e);
				}
				
			}
			
		}else if(searchingBy.equals("orderDate")) {
			for(Entity e : orders) {
				Order order = (Order)e;
				if(order.getDate().equals(DateConverse.convertStringToLocalDate(searchingForFrom))) {
					retVal.add(e);
				}
				
			}
			
		}
		return retVal;
		
	}
	
	public void restorantTypeFilter(ArrayList<Entity> allOrders, String restType) {
		RestorantType restTypeE = RestorantType.valueOf(restType);
		
		Iterator<Entity> iter = allOrders.iterator();
		while(iter.hasNext()) {
			Order r = (Order)iter.next();
			if(r.getRestorant().getType() != restTypeE) {
				iter.remove();
				
			}
		}
		
	}
	
	
	public void orderStatusFilter(ArrayList<Entity> allOrders, String type) {
		OrderStatus orderStat = OrderStatus.valueOf(type);
		
		Iterator<Entity> iter = allOrders.iterator();
		while(iter.hasNext()) {
			Order r = (Order)iter.next();
			if(r.getStatus() != orderStat) {
				iter.remove();
				
			}
		}
		
		
	}
	
	
	
	
	
	
public void sortByParam(ArrayList<Entity> orders , String sortCrit , String order) {
	
		
		if(sortCrit.equals("restName")) {
			if(order.equals("growing")) {
				Collections.sort(orders, new Comparator<Entity>(){
				    public int compare(Entity s1, Entity s2) {
				        return ((Order)s1).getRestorant().getName().compareToIgnoreCase(((Order)s2).getRestorant().getName());
				    }
				});
			}else {
				Collections.sort(orders, new Comparator<Entity>(){
				    public int compare(Entity s1, Entity s2) {
				        return ((Order)s2).getRestorant().getName().compareToIgnoreCase(((Order)s1).getRestorant().getName());
				    }
				});
			}
		}else if(sortCrit.equals("orderPrice")) {
			if(order.equals("growing")) {
				Collections.sort(orders, new Comparator<Entity>(){
				    public int compare(Entity s1, Entity s2) {
				    	return (int)(((Order)s1).getCena() - ((Order)s2).getCena());
				    }
				});
			}else {
				Collections.sort(orders, new Comparator<Entity>(){
				    public int compare(Entity s1, Entity s2) {
				    	return (int)(((Order)s2).getCena() - ((Order)s1).getCena());
				    }
				});
			}	
					
		}else if(sortCrit.equals("restDate")) {
			if(order.equals("growing")) {
				Collections.sort(orders, new Comparator<Entity>(){
				    public int compare(Entity s1, Entity s2) {
				    	return ((Order)s1).getDate().compareTo(((Order)s2).getDate());
				    }
				});
			}else {
				Collections.sort(orders, new Comparator<Entity>(){
				    public int compare(Entity s1, Entity s2) {
				    	
				    	return ((Order)s2).getDate().compareTo(((Order)s1).getDate());
				    }
				});
			}	
		}
			
	}
	
	
	
}
