package dao;

import java.util.ArrayList;


import Enums.Role;
import model.AppContext;
import model.Entity;
import model.User;

public class UserDao extends dao<User>{
	
	public User findById(int id) {
		for(Entity user : AppContext.getAplicationContext().getUsers()) {
			if(user.getId() == id) {
				return (User)user;
			}
		}
		return null;
	}
	
	public User findUserByUserPassword(String user , String password) {
		for(Entity entity : AppContext.getAplicationContext().getUsers()) {
			User rUser = (User)entity;
			if(rUser.getUsername().equals(user) && rUser.getPassword().equals(password)) {
				return rUser;
			}
		}
		return null;
		
	}
	public ArrayList<Entity> findUserManager(){
		ArrayList<Entity> noManagers = new ArrayList<Entity>();
		for(Entity entity : AppContext.getAplicationContext().getUsers()) {
			User rUser = (User)entity;
			if(rUser.getRole() == Role.MANAGER && rUser.getRestorantMnagaer() == null) {
				noManagers.add(rUser);
			}
		}
		return noManagers;
	}

}
