package model;

import java.util.ArrayList;

import Enums.RestorantStatus;
import Enums.RestorantType;

public class Restorant extends Entity{
	private String name;
	private RestorantType type;
	private RestorantStatus status;
	private Location location;
	private String logoPath;
	private ArrayList<Artical> articals;
	
	public Restorant(int id , String name , RestorantType type , RestorantStatus status , Location location , String logoPath) {
		super(id);
		this.name = name;
		this.type = type;
		this.status = status;
		this.location = location;
		this.logoPath = logoPath;
	}
	
	
	
	@Override
	public String exportString() {
		
		String s = id +"|" + name + "|" + type.ordinal() + "|" + status.ordinal() + "|" + location.getId() + "|" + logoPath ;
		
		return s;
		
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RestorantType getType() {
		return type;
	}
	public void setType(RestorantType type) {
		this.type = type;
	}
	public RestorantStatus getstatus() {
		return status;
	}
	public void setstatus(RestorantStatus status) {
		this.status = status;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	
	public ArrayList<Artical> getArticals() {
		return articals;
	}
	public void setArticals(ArrayList<Artical> articals) {
		this.articals = articals;
	}
	
	
	
}
