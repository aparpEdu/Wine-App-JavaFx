package Storage;

import java.util.ArrayList;

import Grape.Grape;
import Wine.Wine;
import Wine.WineBottle;

public class Storage {
	private ArrayList<WineBottle> storedBottles;//filled Bottles
	private ArrayList<Wine> storedWine;//Wine Ready to be Bottled
	private ArrayList<WineBottle> wine;//empty Bottles ready to filled
	private ArrayList<Grape> grapes;//Grapes ready to made to Wine
	public Storage(ArrayList<WineBottle> storedBottles, ArrayList<Wine> storedWine, ArrayList<WineBottle> wine,
			ArrayList<Grape> grapes) {
		
		this.storedBottles = storedBottles;
		this.storedWine = storedWine;
		this.wine = wine;
		this.grapes = grapes;
		fillArrays();
	}
	private void fillArrays()
	{
		
	}
	public ArrayList<WineBottle> getStoredBottles() {
		return storedBottles;
	}
	public void setStoredBottles(ArrayList<WineBottle> storedBottles) {
		this.storedBottles = storedBottles;
	}
	public ArrayList<Wine> getStoredWine() {
		return storedWine;
	}
	public void setStoredWine(ArrayList<Wine> storedWine) {
		this.storedWine = storedWine;
	}
	public ArrayList<WineBottle> getWine() {
		return wine;
	}
	public void setWine(ArrayList<WineBottle> wine) {
		this.wine = wine;
	}
	public ArrayList<Grape> getGrapes() {
		return grapes;
	}
	public void setGrapes(ArrayList<Grape> grapes) {
		this.grapes = grapes;
	}
	
	

}
