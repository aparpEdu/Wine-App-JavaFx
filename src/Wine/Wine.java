package Wine;

import java.util.TreeMap;

import Grape.Grape;

public class Wine {
	private int wineQuantity;
	TreeMap<Integer,Grape> grapes=new TreeMap<Integer,Grape>();
	private int id;
	public Wine(TreeMap<Integer, Grape> grapes)
	{this.grapes=grapes;
		
	}
	
	public int getWineQuantity() {
		return wineQuantity;
	}
	public void setWineQuantity(int wineQuantity) {
		this.wineQuantity = wineQuantity;
	}
	public TreeMap<Integer, Grape> getGrapes() {
		return grapes;
	}
	public void setGrapes(TreeMap<Integer, Grape> grapes) {
		this.grapes = grapes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
