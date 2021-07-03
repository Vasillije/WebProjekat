package dao;

import java.util.ArrayList;

import model.AppContext;
import model.Artical;
import model.Entity;

public class ArticalDao extends dao<Artical>{
	
	public Artical findById(int id) {
		for(Entity a : AppContext.getAplicationContext().getArticals()) {
			if(a.getId() == id) {
				return (Artical)a;
				
				
			}
		}
		return null;
	}
	
	public ArrayList<Entity> findArticlsByRestorantId(int id){
		ArrayList<Entity> retVal = new ArrayList<Entity>();
		for(Entity e : AppContext.getAplicationContext().getArticals()) {
			Artical a = (Artical)e;
			if(a.getRestorant().getId() == id) {
				retVal.add(e);
			}
		}
		return retVal;
	}
	
	
}
