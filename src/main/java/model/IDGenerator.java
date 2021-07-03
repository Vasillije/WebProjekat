package model;

import java.util.ArrayList;

public abstract class IDGenerator<EntityT> {
	public abstract int genId(ArrayList<EntityT> arrayL);
	
}
