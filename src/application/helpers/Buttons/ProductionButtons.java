package application.helpers.Buttons;

import java.util.Optional;

import application.forms.StorageForm;
import application.helpers.StorageUI;
import application.helpers.Tables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
				VBox vbox = new VBox();
				produceWine(grid, x, y);
			}
		});
		hbox.getChildren().add(addWine);
	}
	public static void produceWine(final GridPane grid, final int x, final int y) {
		
		VBox vbox = new VBox();
		Button produceWine = new Button("Produce");
		produceWine.setPrefSize(120, 60);
		produceWine.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to produce with selected varieties?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
					
					Tables.wineVarietyPickerTable(grid, x-1, y+5);
				    StorageUI.checkAvailability(vbox, grid);
				} 
	    		
	    		
			}
		});
		vbox.getChildren().add(produceWine);
		vbox1 = vbox;
		grid.add(vbox, x, y+5);
	}
}
