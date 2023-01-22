package Grape;

import enums.Color;
import enums.Variety;

public class VarietyProperty {

	 private Variety variety;
	    private boolean picked;
	    private Color color;

	    public VarietyProperty(Variety variety,Color color) {
	        this.variety = variety;
	        this.setColor(color);
	    }

	    public Variety getVariety() {
	        return variety;
	    }

	    public boolean isPicked() {
	        return picked;
	    }

	    public void setPicked(boolean picked) {
	        this.picked = picked;
	    }

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}
}
