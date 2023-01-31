package Storage;

import java.util.ArrayList;
import java.util.TreeMap;

import Grape.Grape;
import Wine.Bottle;
import Wine.Wine;


public class Storage {
	
	private ArrayList<Wine> storedWine;//Wine Ready to be Bottled
	private ArrayList<Bottle> bottles;//empty Bottles ready to filled
	private TreeMap<Integer,Grape> grapes;//Grapes ready to made to Wine
	private static Storage storageInstance = null;
	public ArrayList<Bottle> getBottles() {
		return bottles;
	}



	public void setBottles(ArrayList<Bottle> bottles) {
		this.bottles = bottles;
	}
	
	private Storage() {}
	
	
	
	
	
	public static Storage getInstance() {
		if(storageInstance == null) {
			storageInstance = new Storage();
		}
		return storageInstance;
	}
	
	public ArrayList<Wine> getStoredWine() {
		return storedWine;
	}
	public void setStoredWine(ArrayList<Wine> storedWine) {
		this.storedWine = storedWine;
	}
	
	public TreeMap<Integer,Grape> getGrapes() {
		return grapes;
	}
	public void setGrapes(TreeMap<Integer,Grape> grapes) {
		this.grapes = grapes;
	}
	
	

}
