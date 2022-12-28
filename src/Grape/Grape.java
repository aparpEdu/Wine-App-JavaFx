package Grape;

import enums.Color;


public class Grape {
	private Color grapeColor;
	private int winePerKg;
	private String grapeVariety;	
	public Grape(Color grapeColor, String grapeVariety) {
		
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
	public String getGrapeVariety() {
		return grapeVariety;
	}
	public void setGrapeVariety(String grapeVariety) {
		this.grapeVariety = grapeVariety;
	}
	
	
	
	
	

}
