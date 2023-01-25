package properties;

import javafx.scene.control.TextField;

public class GrapeEvaluationProperty {
	private boolean picked;
	private TextField winePerKGTextField;

    public GrapeEvaluationProperty() {
        // existing constructor code
        this.winePerKGTextField = new TextField();
    }

    public TextField getWinePerKGTextField() {
        return winePerKGTextField;
    }

	public boolean isPicked() {
		return picked;
	}

	public void setPicked(boolean picked) {
		this.picked = picked;
	}

}
