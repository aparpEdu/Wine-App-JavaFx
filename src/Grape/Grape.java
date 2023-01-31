package Grape;


public class Grape {
	
	private String grapeColor;
	private float winePerKg;
	private String grapeVariety;	
	private float grapeKg;
	private int id;
	public Grape(String grapeColor,String grapeVariety,float winePerKg,float grapeKg) {
		
		this.grapeColor = grapeColor;
		this.winePerKg = winePerKg;
		this.grapeVariety = grapeVariety;
		this.grapeKg=grapeKg;
	}
	
	
	public float getWinePerKg() {
		return winePerKg;
	}
	public void setWinePerKg(float winePerKg) {
		this.winePerKg = winePerKg;
	}
	public float getGrapeKg() {
		return grapeKg;
	}
	public void setGrapeKg(float grapeKg) {
		this.grapeKg = grapeKg;
	}
	
	public String getGrapeColor() {
		return grapeColor;
	}


	public void setGrapeColor(String grapeColor) {
		this.grapeColor = grapeColor;
	}


	public String getGrapeVariety() {
		return grapeVariety;
	}


	public void setGrapeVariety(String grapeVariety) {
		this.grapeVariety = grapeVariety;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	

}
