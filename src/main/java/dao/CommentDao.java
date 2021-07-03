package dao;

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
	

}
