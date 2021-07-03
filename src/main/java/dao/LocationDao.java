package dao;



import model.AppContext;
import model.Entity;
import model.Location;

public class LocationDao extends dao<Location>{
	
	
	public Location findById(int id) {
		for(Entity l : AppContext.getAplicationContext().getLocations()) {
			if(l.getId() == id) {
				return (Location)l;
				
				
			}
		}
		return null;
	}

}
