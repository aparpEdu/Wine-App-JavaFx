package application.helpers.Buttons;

import java.util.Optional;

import application.forms.StorageForm;
import application.helpers.StorageUI;
import application.helpers.Tables;
import enums.BottleSize;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductionButtons {
	private static VBox vbox1 = null;

	public ProductionButtons() {
		// TODO Auto-generated constructor stub
	}

	public static void addWine(HBox hbox, final GridPane grid, final int x, final int y) {
		Button addWine = new Button("Produce Wine");
		addWine.setPrefSize(120, 60);
		addWine.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				Tables.wineVarietyPickerTable(grid, x - 1, y + 5);
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
				if (result.get() == ButtonType.OK) {
					StorageUI.checkAvailability(vbox1, grid);
					Tables.removeTable(grid);
					fillBottlesButton(grid, y, y);
				}

			}
		});
		vbox.getChildren().add(produceWine);
		vbox1 = vbox;
		grid.add(vbox, x, y + 5);
	}

	public static void evaluateGrapesButton(HBox hbox, final GridPane grid, final int x, final int y) {
		Button evaluateGrapesButton = new Button("Evaluate Grapes");
		evaluateGrapesButton.setPrefSize(120, 60);
		evaluateGrapesButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);
				Tables.grapeEvaluationTable(grid, x - 1, y + 5);
				evaluateButton(grid, x, y);

			}
		});
		hbox.getChildren().add(evaluateGrapesButton);
	}

	public static void evaluateButton(final GridPane grid, final int x, final int y) {

		VBox vbox = new VBox();
		Button evaluateButton = new Button("Evaluate");
		evaluateButton.setPrefSize(120, 60);
		evaluateButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to evaluate with selected amounts?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {

					Tables.grapeEvaluationTable(grid, x - 1, y + 5);

				}

			}
		});
		vbox.getChildren().add(evaluateButton);
		vbox1 = vbox;
		grid.add(vbox, x, y + 5);
	}

	public static void fillBottlesButton(final GridPane grid, final int x, final int y) {
		ComboBox<String> sizeCB = new ComboBox<String>();
		ObservableList<String> options = FXCollections.observableArrayList(
				BottleSize.LARGE.toString().concat(BottleSize.LARGE.getSize()),
				BottleSize.MEDIUM.toString().concat(BottleSize.MEDIUM.getSize()),
				BottleSize.SMALL.toString().concat(BottleSize.SMALL.getSize()),
				BottleSize.TINY.toString().concat(BottleSize.TINY.getSize())

		);
		Label quantityLabel = new Label("Quantity: ");
		quantityLabel.setPrefWidth(100);
		TextField fillQuantity = new TextField();
		fillQuantity.setPrefWidth(105);
		fillQuantity.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("^-?\\d*\\.?\\d*")) {
		        	fillQuantity.setText(oldValue);
		        }
		    }
		});
		sizeCB.setItems(options);
		sizeCB.getSelectionModel().selectFirst();
		Button optimal = new Button("Optimal");
		optimal.setPrefSize(100, 0);
		optimal.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// optimalniq method za zapulvane

			}
		});
		Label sizeLabel = new Label("Size: ");
		sizeLabel.setPrefWidth(100);
//		Label numberOfBottles = new Label("Bottle quantity: ");
//		numberOfBottles.setPrefWidth(100);
		Button fillBottlesButton = new Button("Fill");
		fillBottlesButton.setPrefSize(80, 30);
		fillBottlesButton.setOnAction(new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent e) {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to fill bottle with selected amount?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					StorageUI.checkAvailability(vbox1, grid);
				//produceWine(grid, x, y);
					
				}

			}
		});
		HBox quantityBox = new HBox();
		quantityBox.getChildren().addAll(quantityLabel,fillQuantity,optimal);
		quantityBox.setSpacing(5);
		HBox sizeBox = new HBox();
		sizeBox.getChildren().addAll(sizeLabel,sizeCB);
		HBox fillBox = new HBox();
		fillBox.getChildren().add(fillBottlesButton);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(quantityBox,sizeBox,fillBox);
		vbox.setSpacing(8);
		vbox1 = vbox;
		grid.add(vbox, x+5, y + 5);
	}

}
