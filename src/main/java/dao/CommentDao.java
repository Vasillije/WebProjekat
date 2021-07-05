package dao;

import java.util.ArrayList;

import model.AppContext;
import model.Comment;
import model.Entity;

public class CommentDao extends dao<Comment>{
	
	public Comment findById(int id) {
		for(Entity c : AppContext.getAplicationContext().getComments()) {
			if(c.getId() == id) {
				return (Comment)c;
			}
		}
		return null;
	}
	
	public ArrayList<Entity> findByRestrantId(int id){
		ArrayList<Entity> found = new ArrayList<Entity>();
		for(Entity c : AppContext.getAplicationContext().getComments()) {
			Comment com = (Comment)c;
			if(com.getRestorant().getId() == id) {
				found.add(c);
			}
		}
		return found;
	}

}
