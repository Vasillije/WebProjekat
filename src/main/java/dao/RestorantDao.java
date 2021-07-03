package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import model.AppContext;
import model.Entity;
import model.Restorant;
import Enums.RestorantStatus;
import Enums.RestorantType;


public class RestorantDao extends dao<Restorant>{
	
	public Restorant findById(int id) {
		for(Entity r : AppContext.getAplicationContext().getRestorants()) {
			if(r.getId() == id) {
				return (Restorant)r;
			}
		}
		return null;
	}
	private void swapElem(ArrayList<Entity> allRests , int i , int j) {
		//Collections.swap(allRests, i, j);
		Entity ref1 = allRests.get(i);
		Entity ref2 = allRests.get(j);
		
		allRests.set(i, ref2);
		allRests.set(j, ref1);
	}
	
	public ArrayList<Entity> getAllRestorants(){
		/*
		ArrayList<Entity> allRests = AppContext.getAplicationContext().getRestorants();
		int i = 0;
		int j = allRests.size() - 1;
		
		while(i < j) {
			if(((Restorant)allRests.get(i)).getstatus() == RestorantStatus.RADI ) {
				i++;
				continue;
			}
			
			if(((Restorant)allRests.get(j)).getstatus() == RestorantStatus.NERADI ) {
				j--;
				continue;
			}
			if(i != j) {
				swapElem(allRests , i , j);				
			}
		}
		
		
		return allRests;
		*/
		ArrayList<Entity> allRests = AppContext.getAplicationContext().getRestorants();
		Collections.sort(allRests, new Comparator<Entity>(){
		    public int compare(Entity s1, Entity s2) {
		        return ((Restorant)s2).getstatus().name().compareToIgnoreCase(((Restorant)s1).getstatus().name());
		    }
		});
		return allRests;
	}
	
	public void sortByParam(ArrayList<Entity> rest , String sortCrit , String order) {
	
		
		if(sortCrit.equals("restName")) {
			if(order.equals("growing")) {
				Collections.sort(rest, new Comparator<Entity>(){
				    public int compare(Entity s1, Entity s2) {
				        return ((Restorant)s1).getName().compareToIgnoreCase(((Restorant)s2).getName());
				    }
				});
			}else {
				Collections.sort(rest, new Comparator<Entity>(){
				    public int compare(Entity s1, Entity s2) {
				        return ((Restorant)s2).getName().compareToIgnoreCase(((Restorant)s1).getName());
				    }
				});
			}
		}else if(sortCrit.equals("restLocation")) {
			if(order.equals("growing")) {
				Collections.sort(rest, new Comparator<Entity>(){
				    public int compare(Entity s1, Entity s2) {
				        return ((Restorant)s1).getLocation().getAdress().getPlace().compareToIgnoreCase(((Restorant)s2).getLocation().getAdress().getPlace());
				    }
				});
			}else {
				Collections.sort(rest, new Comparator<Entity>(){
				    public int compare(Entity s1, Entity s2) {
				    	return ((Restorant)s2).getLocation().getAdress().getPlace().compareToIgnoreCase(((Restorant)s1).getLocation().getAdress().getPlace());
				    }
				});
			}	
					
		}else if(sortCrit.equals("restRate")) {
			if(order.equals("growing")) {
				Collections.sort(rest, new Comparator<Entity>(){
				    public int compare(Entity s1, Entity s2) {
				        //return ((Restorant)s1).getLocation().getAdress().getPlace().compareToIgnoreCase(((Restorant)s2).getLocation().getAdress().getPlace());
				    	return 0;
				    }
				});
			}else {
				Collections.sort(rest, new Comparator<Entity>(){
				    public int compare(Entity s1, Entity s2) {
				    	//return ((Restorant)s2).getLocation().getAdress().getPlace().compareToIgnoreCase(((Restorant)s1).getLocation().getAdress().getPlace());
				    	return 0;
				    }
				});
			}	
		}
			
	}
	
	public void restorantTypeFilter(ArrayList<Entity> allRest, String type) {
		RestorantType restType = RestorantType.valueOf(type);
		
		Iterator<Entity> iter = allRest.iterator();
		while(iter.hasNext()) {
			Restorant r = (Restorant)iter.next();
			if(r.getType() != restType) {
				iter.remove();
				
			}
		}
		
	}
	
	public void restorantStatusFilter(ArrayList<Entity> allRest, String type) {
		RestorantStatus restStat = RestorantStatus.valueOf(type);
		
		Iterator<Entity> iter = allRest.iterator();
		while(iter.hasNext()) {
			Restorant r = (Restorant)iter.next();
			if(r.getstatus() != restStat) {
				iter.remove();
				
			}
		}
		/*
		for(Entity rest : allRest) {
			Restorant r = (Restorant)rest;
			if(r.getstatus() != restStat) {
				allRest.remove(rest);
			}
		}*/
		
	}
	
	public ArrayList<Entity> searchByParam(ArrayList<Entity> restorants, String searchingBy , String searchingFor) {
		ArrayList<Entity> retVal = new ArrayList<Entity>();
		if(searchingBy.equals("restName")) {
			for(Entity e : restorants) {
				Restorant r = (Restorant)e;
				if(r.getName().toLowerCase().contains(searchingFor)) {
					retVal.add(e);
				}
				
			}
			
		}else if(searchingBy.equals("restType")) {
			for(Entity e : restorants) {
				Restorant r = (Restorant)e;
				/*if(r.getName().toLowerCase().contains(searchingFor)) {
					retVal.add(e);
				}*/
				
			}
			
		}else if(searchingBy.equals("restLocation")) {
			for(Entity e : restorants) {
				Restorant r = (Restorant)e;
				
				if(r.getLocation().getAdress().getPlace().contains(searchingFor)) {
					retVal.add(e);
				}
				
			}
			
		}else if(searchingBy.equals("restRate")) {
			for(Entity e : restorants) {
				/*if(r.getName().toLowerCase().contains(searchingFor)) {
				retVal.add(e);
			}*/
				
			}
			
		}
		return retVal;
		
	}
	
}
