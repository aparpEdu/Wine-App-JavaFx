package Grape;

import enums.Color;
import enums.Variety;


public class Grape {
	private Color grapeColor;
	private int winePerKg;
	private Variety grapeVariety;	
	public Grape(Color grapeColor, Variety grapeVariety) {
		
		this.grapeColor = grapeColor;
		//this.winePerKg = winePerKg;
		this.grapeVariety = grapeVariety;
	}
	public Color getGrapeColor() {
		return grapeColor;
	}
	public void setGrapeColor(Color grapeColor) {
		this.grapeColor = grapeColor;
	}
	public int getWinePerKg() {
		return winePerKg;
	}
	public void setWinePerKg(int winePerKg) {
		this.winePerKg = winePerKg;
	}
	public Variety getGrapeVariety() {
		return grapeVariety;
	}
	public void setGrapeVariety(Variety grapeVariety) {
		this.grapeVariety = grapeVariety;
	}
	
	
	
	
	

}
