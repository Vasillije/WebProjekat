package dao;

import model.Adress;
import model.AppContext;
import model.Entity;

public class AdressDao extends dao<Adress>{

	public Adress findById(int id) {
		for(Entity a : AppContext.getAplicationContext().getAdresses()) {
			if(a.getId() == id) {
				return (Adress)a;
			}
		}
		return null;
	}
	
}
