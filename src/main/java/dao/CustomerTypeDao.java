package dao;

import model.AppContext;
import model.CustomerType;
import model.Entity;


public class CustomerTypeDao extends dao<CustomerType>{
	
	public CustomerType findById(int id) {
		for(Entity ct : AppContext.getAplicationContext().getCustomertypes()) {
			if(ct.getId() == id) {
				return (CustomerType)ct;
			}
		}
		return null;
	}

}
