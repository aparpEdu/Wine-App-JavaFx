package application.helpers.Buttons;

import application.forms.StorageForm;
import application.helpers.Tables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductionButtons {
	private static VBox vbox1 = null;
	public ProductionButtons() {
		// TODO Auto-generated constructor stub
	}
	public static void addBottledWine(HBox hbox, final GridPane grid, final int x, final int y) {
		Button addBottledWine = new Button("Fill bottle");
		addBottledWine.setPrefSize(120, 60);

		hbox.getChildren().add(addBottledWine);
	}
	public static void addWine(HBox hbox, final GridPane grid, final int x, final int y) {
		Button addWine = new Button("Produce Wine");
		addWine.setPrefSize(120, 60);
		addWine.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				Tables.wineVarietyPickerTable(grid, x-1, y+5);
			}
		});
		hbox.getChildren().add(addWine);
	}
}
