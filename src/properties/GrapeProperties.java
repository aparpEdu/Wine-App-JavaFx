package properties;

import javafx.scene.control.TextField;

public class GrapeProperties {
private String variety;
private String color;
private String kg;
private String wkg;
private String date;
private boolean picked;
private TextField winePerKGTextField;

	public String getVariety() {
	return variety;
}

public void setVariety(String variety) {
	this.variety = variety;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public String getKg() {
	return kg;
}

public void setKg(String kg) {
	this.kg = kg;
}

public String getWkg() {
	return wkg;
}

public void setWkg(String wkg) {
	this.wkg = wkg;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}



public TextField getWinePerKGTextField() {
	return winePerKGTextField;
}

public void setWinePerKGTextField(TextField winePerKGTextField) {
	this.winePerKGTextField = winePerKGTextField;
}

public boolean isPicked() {
	return picked;
}

public void setPicked(boolean picked) {
	this.picked = picked;
}

}
