package application.helpers.Buttons;

import java.sql.SQLException;
import java.util.Optional;

import application.helpers.StorageUI;
import application.helpers.Tables;
import controlers.GrapeController;
import controlers.WineController;
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
				Tables.removeTable(grid);
				StorageUI.checkAvailability(vbox1, grid);
				try {
					Tables.grapeEvaluationTable(grid, x - 1, y + 5, null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					produceWine(grid, x, y);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		hbox.getChildren().add(addWine);
	}

	public static void produceWine(final GridPane grid, final int x, final int y) throws SQLException {

		VBox vbox = new VBox();
		Button produceWine = new Button("Produce");
		
		produceWine.setPrefSize(120, 60);
		GrapeController gc = new GrapeController();
		Label  winevar = new Label("New variety:");
		Label withKg = new Label("Find kg:");
		
		
		ComboBox<String> kgCB = new ComboBox<String>();
		try {
			gc.showKG(kgCB);
			kgCB.getSelectionModel().selectFirst();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Label withKg2 = new Label("Second kg:");
		
		ComboBox<String> kgCB2 = new ComboBox<String>();
		try {
			gc.showKG(kgCB2);
			kgCB.getSelectionModel().selectFirst();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		HBox kgboxa = new HBox();
		kgboxa.getChildren().addAll(withKg,kgCB,withKg2,kgCB2);
		TextField varField = new TextField();
		HBox varbox = new HBox();
		Label kgneeded1 = new Label("Kg for first option:");
		Label kgneeded2 = new Label("Kg for second option:");
		TextField kgneededfield1 = new TextField();
		kgneededfield1.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("^-?\\d*\\.?\\d*")) {
		        	kgneededfield1.setText(oldValue);
		        }
		    }
		});
		TextField kgneededfield2 = new TextField();
		kgneededfield2.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("^-?\\d*\\.?\\d*")) {
		        	kgneededfield2.setText(oldValue);
		        }
		    }
		});
		HBox kgneededbox = new HBox();
		
		ComboBox<String> wkgCB = new ComboBox<String>();
		gc.showWKG(wkgCB);
		ComboBox<String> wkgCB2 = new ComboBox<String>();
		gc.showWKG(wkgCB2);
		ComboBox<String> sizeCB = new ComboBox<String>();
		ObservableList<String> options = FXCollections.observableArrayList(
				BottleSize.LARGE.toString().concat(BottleSize.LARGE.getSize()),
				BottleSize.MEDIUM.toString().concat(BottleSize.MEDIUM.getSize()),
				BottleSize.SMALL.toString().concat(BottleSize.SMALL.getSize()),
				BottleSize.TINY.toString().concat(BottleSize.TINY.getSize())

		);
		Label quantityLabel = new Label("Fill bottle with: ");
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
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("BOOM RADIATOR");
        		alert.setHeaderText(null);
        		alert.setContentText("WORK IN PROGRESS SEE YOU NEXT PATCH!");
        		//alert.initOwner(btn.getScene().getWindow());
        		alert.showAndWait();

			}
		});
		Label sizeLabel = new Label("Size: ");
		sizeLabel.setPrefWidth(100);
//		Label numberOfBottles = new Label("Bottle quantity: ");
//		numberOfBottles.setPrefWidth(100);
		
		
		
		
		HBox quantityBox = new HBox();
		HBox wkgBox = new HBox();
		Label wkgLabel = new Label("WKG: ");
		Label wkgLabel2 = new Label("WKG2:");
		varbox.getChildren().addAll(winevar,varField);
		varbox.setSpacing(5);
		wkgBox.getChildren().addAll(wkgLabel,wkgCB,wkgLabel2,wkgCB2);
		kgneededbox.getChildren().addAll(kgneeded1,kgneededfield1,kgneeded2,kgneededfield2);
		kgneededbox.setSpacing(5);
		wkgBox.setSpacing(5);
		quantityBox.getChildren().addAll(quantityLabel,fillQuantity,optimal);
		quantityBox.setSpacing(5);
		HBox sizeBox = new HBox();
		sizeBox.getChildren().addAll(sizeLabel,sizeCB);
	
	
		produceWine.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to produce with selected options?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					if(!kgneededfield1.getText().isBlank() && !kgneededfield2.getText().isBlank() &&!fillQuantity.getText().isBlank()&&!varField.getText().isBlank()) {
					StorageUI.checkAvailability(vbox1, grid);
					WineController wc = new WineController();
					wc.CreateWine(wkgCB.getSelectionModel().getSelectedItem().toString(), wkgCB2.getSelectionModel().getSelectedItem(), kgCB.getSelectionModel().getSelectedItem(), kgCB2.getSelectionModel().getSelectedItem(), sizeCB.getSelectionModel().getSelectedItem(), kgneededfield1.getText(),kgneededfield2.getText(),fillQuantity.getText(),varField.getText());
					StorageUI.checkAvailability(vbox1, grid);
					Tables.removeTable(grid);
					}
					else {
						Alert alerts = new Alert(Alert.AlertType.WARNING);
						alerts.setTitle("ERROR");
						alerts.setHeaderText(null);
						alerts.setContentText("Inputs were not set!");
	            		//alert.initOwner(btn.getScene().getWindow());
						alerts.showAndWait();
					}
					
				}

			}
		});
		vbox.getChildren().addAll(kgneededbox,quantityBox,sizeBox,wkgBox,kgboxa,varbox,produceWine);
		vbox.setSpacing(10);
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
				TextField evaluateField = new TextField();
				evaluateField.textProperty().addListener(new ChangeListener<String>() {
				    @Override
				    public void changed(ObservableValue<? extends String> observable, String oldValue, 
				        String newValue) {
				        if (!newValue.matches("^-?\\d*\\.?\\d*")) {
				        	evaluateField.setText(oldValue);
				        }
				    }
				});
				ComboBox<String> varCB = new ComboBox<String>();
				
				GrapeController gc = new GrapeController();
				try {
					gc.showVariety(varCB);
					varCB.getSelectionModel().selectFirst();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				ComboBox<String> kgCB = new ComboBox<String>();
				
				try {
					gc.showKG(kgCB);
					kgCB.getSelectionModel().selectFirst();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				HBox varietyBox = new HBox();
				
				HBox kgBox = new HBox();
				
				Label evaluateLabel = new Label("WKG:");
				Label varLabel = new Label("Variety:");
				
				Label kgLabel = new Label("KG:");
				
				VBox vbox = new VBox();
				HBox evaluateHBox = new HBox();
				evaluateHBox.setSpacing(5);
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

							try {
								if(!evaluateField.getText().isBlank() || !evaluateField.getText().isEmpty()) {
								gc.evaluateGrape(evaluateField.getText(), varCB.getSelectionModel().getSelectedItem().toString(), kgCB.getSelectionModel().getSelectedItem().toString());
								Tables.grapeEvaluationTable2(grid, x - 1, y + 5, evaluateField.getText());
								}
								else {
									Alert alerts = new Alert(Alert.AlertType.WARNING);
				            		alerts.setTitle("ERROR");
				            		alerts.setHeaderText(null);
				            		alerts.setContentText("Wine per kg was not set!");
				            		//alert.initOwner(btn.getScene().getWindow());
				            		alerts.showAndWait();
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}

					}
				});
				try {
					
					Tables.grapeEvaluationTable2(grid, x - 1, y + 5,evaluateField.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				varietyBox.setSpacing(5);
				
				kgBox.setSpacing(5);
				
				evaluateHBox.getChildren().addAll(evaluateLabel,evaluateField);
				varietyBox.getChildren().addAll(varLabel,varCB);
				
				kgBox.getChildren().addAll(kgLabel,kgCB);
				
				vbox.getChildren().addAll(varietyBox,kgBox,evaluateHBox,evaluateButton);
				vbox.setSpacing(10);
				vbox1 = vbox;
				grid.add(vbox, x, y + 5);
			}
		});
		hbox.getChildren().add(evaluateGrapesButton);
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
