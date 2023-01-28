package application.helpers.Buttons;

import java.sql.SQLException;

import application.helpers.StorageUI;
import application.helpers.Tables;
import controlers.GrapeController;
import enums.BottleSize;
import enums.Color;
import enums.Variety;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StorageButtons {
	private static VBox vbox1 = null;
	public StorageButtons() {
		// TODO Auto-generated constructor stub
	}

	public static void addBottle(HBox hbox, final GridPane grid, final int x, final int y) {
		Button addBottle = new Button("Store Bottle");
		addBottle.setPrefSize(120, 60);
		addBottle.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);
				//Tables.removeTable(grid);

				ComboBox cb = new ComboBox();
			    cb.setPrefWidth(155);
			    Spinner<Integer> quantity = new Spinner<Integer>(1,99,1);
				Button check = new Button("Store");
				Label userLabel = new Label("Size: ");
				Label quantityLabel = new Label("Quantity: ");
				quantityLabel.setPrefWidth(70);
				userLabel.setPrefWidth(65);
				ObservableList<String> options = 
					    FXCollections.observableArrayList(
					    	BottleSize.LARGE.toString().concat(BottleSize.LARGE.getSize()),
					    	BottleSize.MEDIUM.toString().concat(BottleSize.MEDIUM.getSize()),
					    	BottleSize.SMALL.toString().concat(BottleSize.SMALL.getSize()),
					    	BottleSize.TINY.toString().concat(BottleSize.TINY.getSize())
					    	
					    );
				cb.setItems(options);
				cb.getSelectionModel().selectFirst();
				TextField t = new TextField();
				t.setPrefSize(100, 0);
				HBox hbox2 = new HBox();
				HBox hbox3 = new HBox();
				hbox3.getChildren().addAll(quantityLabel,quantity);
				
				hbox2.setSpacing(5);
			
				hbox2.getChildren().add(userLabel);
				hbox2.getChildren().add(cb);
				VBox vbox = new VBox();
				//vbox.setPadding(new Insets(0, 120, 0, 120));
				vbox.setSpacing(5);
				vbox.getChildren().add(hbox2);
				vbox.getChildren().add(hbox3);
				vbox.getChildren().add(check);
				vbox1 = vbox;
				grid.add(vbox, x, y + 5);
				

			}
		});

		hbox.getChildren().add(addBottle);
	}
	public static void checkProduction(HBox hbox, final GridPane grid, final int x, final int y) {
		Button checkProduction = new Button("Search Wine");
		checkProduction.setPrefSize(120, 60);
		checkProduction.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);
				ToggleGroup tg = new ToggleGroup();
				RadioButton byVariety = new RadioButton("By Variety");
				RadioButton everyVariety = new RadioButton("All Wine");
				RadioButton byColor = new RadioButton("By color");
				RadioButton byBottle = new RadioButton("By bottle");
				everyVariety.setToggleGroup(tg);
				everyVariety.setUserData("var");
				byColor.setUserData("color");
				byBottle.setToggleGroup(tg);
				byBottle.setUserData("bottle");
				byColor.setToggleGroup(tg);
				byVariety.setUserData("no");
				byVariety.setToggleGroup(tg);
				tg.selectToggle(everyVariety);
				ComboBox<Variety> varietyCB = new ComboBox<Variety>();
				varietyCB.setItems(FXCollections.observableArrayList(Variety.values()));
				varietyCB.getSelectionModel().selectFirst();
				ComboBox<Color> colorCB = new ComboBox<Color>();
				colorCB.setItems(FXCollections.observableArrayList(Color.values()));
				colorCB.getSelectionModel().selectFirst();
				ComboBox<String> sizeCB = new ComboBox<String>();
				ObservableList<String> options = 
					    FXCollections.observableArrayList(
					    	BottleSize.LARGE.toString().concat(BottleSize.LARGE.getSize()),
					    	BottleSize.MEDIUM.toString().concat(BottleSize.MEDIUM.getSize()),
					    	BottleSize.SMALL.toString().concat(BottleSize.SMALL.getSize()),
					    	BottleSize.TINY.toString().concat(BottleSize.TINY.getSize())
					    	
					    );
				sizeCB.setItems(options);
				sizeCB.getSelectionModel().selectFirst();
				Button searchGrapeButton = new Button("Search");
				VBox vbox = new VBox();
				HBox choice = new HBox();
				choice.getChildren().addAll(byVariety,byColor,byBottle);
				choice.setSpacing(50);
				HBox varietyHbox =  new HBox();
				varietyHbox.setSpacing(30);
				DatePicker dayOne = new DatePicker();
				DatePicker dayTwo = new DatePicker();
				HBox date = new HBox();
				HBox dateLabels = new HBox();
				Label firstDateLabel = new Label("From:");
				Label secondDateLabel = new Label("To:");
				date.setSpacing(10);
				dateLabels.setSpacing(160);
				dateLabels.getChildren().addAll(firstDateLabel,secondDateLabel);
				date.getChildren().addAll(dayOne,dayTwo);
				if (tg.getSelectedToggle() != null) {
					if (tg.getSelectedToggle().getUserData().toString().equals("var")) {
						varietyCB.setDisable(true);
						colorCB.setDisable(true);
						sizeCB.setDisable(true);
						
					} else if (tg.getSelectedToggle().getUserData().toString().compareToIgnoreCase("no") == 0) {
						varietyCB.setDisable(false);
					}
					
				}
				tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
				    public void changed(ObservableValue<? extends Toggle> ov,
				        Toggle old_toggle, Toggle new_toggle) {
				            if (tg.getSelectedToggle() != null) {
				            	if (tg.getSelectedToggle().getUserData().toString().compareToIgnoreCase("no") == 0) {
				            		varietyCB.setDisable(false);
				            		colorCB.setDisable(true);
				            		sizeCB.setDisable(true);
								}
				            	else if (tg.getSelectedToggle().getUserData().toString().compareToIgnoreCase("var") == 0) {
				            		varietyCB.setDisable(true);
				            		colorCB.setDisable(true);
				            		sizeCB.setDisable(true);
				            	}
				            	else if (tg.getSelectedToggle().getUserData().toString().compareToIgnoreCase("color") == 0) {
				            		varietyCB.setDisable(true);
				            		sizeCB.setDisable(true);
				            		colorCB.setDisable(false);
				            	}
				            	else if (tg.getSelectedToggle().getUserData().toString().compareToIgnoreCase("bottle") == 0) {
				            		varietyCB.setDisable(true);
				            		colorCB.setDisable(true);
				            		sizeCB.setDisable(false);
				            	}
				            }                
				        }
				});
				searchGrapeButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						
						Tables.storedGrapesTable(grid, x-1, y+5);
					}
				});
				varietyHbox.getChildren().addAll(varietyCB,colorCB,sizeCB);
				vbox.getChildren().addAll(everyVariety,choice,varietyHbox,dateLabels,date,searchGrapeButton);
				vbox.setSpacing(5);
				vbox1 = vbox;
				grid.add(vbox, x, y+5);
			}
		});
		hbox.getChildren().add(checkProduction);
		
	}
	public static void checkGrapes(HBox hbox, final GridPane grid, final int x, final int y) {
		Button checkGrapes = new Button("Search Grapes");
		checkGrapes.setPrefSize(120, 60);
		checkGrapes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);
				ToggleGroup tg = new ToggleGroup();
				RadioButton byVariety = new RadioButton("By Variety");
				RadioButton everyVariety = new RadioButton("All Grapes");
				RadioButton byColor = new RadioButton("By color");
				everyVariety.setToggleGroup(tg);
				everyVariety.setUserData("var");
				byColor.setUserData("color");
				byColor.setToggleGroup(tg);
				byVariety.setUserData("no");
				byVariety.setToggleGroup(tg);
				tg.selectToggle(everyVariety);
				Label grapreVarietyLabel = new Label("Variety: ");
				ComboBox<Variety> varietyCB = new ComboBox<Variety>();
				varietyCB.setItems(FXCollections.observableArrayList(Variety.values()));
				varietyCB.getSelectionModel().selectFirst();
				ComboBox<Color> colorCB = new ComboBox<Color>();
				colorCB.setItems(FXCollections.observableArrayList(Color.values()));
				colorCB.getSelectionModel().selectFirst();
				Button searchGrapeButton = new Button("Search");
				VBox vbox = new VBox();
				HBox choice = new HBox();
				choice.getChildren().addAll(byVariety,byColor);
				choice.setSpacing(50);
				HBox varietyHbox =  new HBox();
				varietyHbox.setSpacing(30);
				DatePicker dayOne = new DatePicker();
				DatePicker dayTwo = new DatePicker();
				HBox date = new HBox();
				HBox dateLabels = new HBox();
				Label firstDateLabel = new Label("From:");
				Label secondDateLabel = new Label("To:");
				date.setSpacing(10);
				dateLabels.setSpacing(160);
				dateLabels.getChildren().addAll(firstDateLabel,secondDateLabel);
				date.getChildren().addAll(dayOne,dayTwo);
				grapreVarietyLabel.setPrefWidth(100);
				if (tg.getSelectedToggle() != null) {
					if (tg.getSelectedToggle().getUserData().toString().equals("var")) {
						varietyCB.setDisable(true);
						colorCB.setDisable(true);
						
					} else if (tg.getSelectedToggle().getUserData().toString().compareToIgnoreCase("no") == 0) {
						varietyCB.setDisable(false);
					}
					
				}
				tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
				    public void changed(ObservableValue<? extends Toggle> ov,
				        Toggle old_toggle, Toggle new_toggle) {
				            if (tg.getSelectedToggle() != null) {
				            	if (tg.getSelectedToggle().getUserData().toString().compareToIgnoreCase("no") == 0) {
				            		varietyCB.setDisable(false);
				            		colorCB.setDisable(true);
								}
				            	else if (tg.getSelectedToggle().getUserData().toString().compareToIgnoreCase("var") == 0) {
				            		varietyCB.setDisable(true);
				            		colorCB.setDisable(true);
				            	}
				            	else if (tg.getSelectedToggle().getUserData().toString().compareToIgnoreCase("color") == 0) {
				            		varietyCB.setDisable(true);
				            		colorCB.setDisable(false);
				            	}
				            }                
				        }
				});
				searchGrapeButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						
						Tables.storedGrapesTable(grid, x-1, y+5);
					}
				});
				varietyHbox.getChildren().addAll(varietyCB,colorCB);
				vbox.getChildren().addAll(everyVariety,choice,varietyHbox,dateLabels,date,searchGrapeButton);
				vbox.setSpacing(5);
				vbox1 = vbox;
				grid.add(vbox, x, y+5);
			}
		});
		hbox.getChildren().add(checkGrapes);
		
	}
	public static void storeGrape(HBox hbox, final GridPane grid, final int x, final int y) {
		Button storeGrape = new Button("Store Grape");
		storeGrape.setPrefSize(120, 60);
		storeGrape.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);
				Label grapreVarietyLabel = new Label("Variety: ");
				Label grapeKgLabel = new Label("Kilograms: ");
				ComboBox<Variety> varietyCB = new ComboBox<Variety>();
				varietyCB.setItems(FXCollections.observableArrayList(Variety.values()));
				varietyCB.getSelectionModel().selectFirst();
			TextField grapeKgField = new TextField();
			grapeKgField.setEditable(true);
			grapeKgField.textProperty().addListener(new ChangeListener<String>() {
			    @Override
			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
			        String newValue) {
			        if (!newValue.matches("^-?\\d*\\.?\\d*")) {
			            grapeKgField.setText(oldValue);
			        }
			    }
			});
			
			
				Button storeGrapeButton = new Button("Store");
				storeGrapeButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {

						GrapeController gc = new GrapeController();
						try {
							gc.storeGrapes(varietyCB.getSelectionModel().getSelectedItem(), Double.parseDouble(grapeKgField.getText()));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				VBox vbox = new VBox();
				HBox varietyHbox =  new HBox();
				HBox kgHbox =  new HBox();
				grapeKgField.setPrefWidth(105);
				grapreVarietyLabel.setPrefWidth(100);
				grapeKgLabel.setPrefWidth(100);
				varietyHbox.getChildren().addAll(grapreVarietyLabel,varietyCB);
				kgHbox.getChildren().addAll(grapeKgLabel,grapeKgField);
				vbox.getChildren().addAll(varietyHbox,kgHbox,storeGrapeButton);
				vbox.setSpacing(5);
				vbox1 = vbox;
				grid.add(vbox, x, y+5);
			}
		});
		hbox.getChildren().add(storeGrape);
		
	}
	public static void checkBottles(HBox hbox, final GridPane grid, final int x, final int y) {
		Button checkBottles = new Button("Search Bottles");
		checkBottles.setPrefSize(120, 60);
		checkBottles.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);
				ToggleGroup tg = new ToggleGroup();
				RadioButton bySize = new RadioButton("By Size");
				RadioButton everySize = new RadioButton("All Sizes");
				everySize.setToggleGroup(tg);
				everySize.setUserData("yes");
				bySize.setUserData("no");
				bySize.setToggleGroup(tg);
				tg.selectToggle(everySize);
				Label sizeLabel = new Label("Size: ");
				//sizeLabel.setPrefWidth(70);
				ComboBox<String> sizeCB = new ComboBox<String>();
				ObservableList<String> options = 
					    FXCollections.observableArrayList(
					    	BottleSize.LARGE.toString().concat(BottleSize.LARGE.getSize()),
					    	BottleSize.MEDIUM.toString().concat(BottleSize.MEDIUM.getSize()),
					    	BottleSize.SMALL.toString().concat(BottleSize.SMALL.getSize()),
					    	BottleSize.TINY.toString().concat(BottleSize.TINY.getSize())
					    	
					    );
				sizeCB.setItems(options);
				sizeCB.getSelectionModel().selectFirst();
				Button searchBottleButton = new Button("Search");
				VBox vbox = new VBox();
				HBox sizeHbox =  new HBox();
				DatePicker dayOne = new DatePicker();
				DatePicker dayTwo = new DatePicker();
				HBox date = new HBox();
				HBox dateLabels = new HBox();
				Label firstDateLabel = new Label("From:");
				Label secondDateLabel = new Label("To:");
				date.setSpacing(10);
				dateLabels.setSpacing(160);
				dateLabels.getChildren().addAll(firstDateLabel,secondDateLabel);
				date.getChildren().addAll(dayOne,dayTwo);
				sizeLabel.setPrefWidth(100);
				if (tg.getSelectedToggle() != null) {
					if (tg.getSelectedToggle().getUserData().toString().equals("yes")) {
						sizeHbox.setDisable(true);
						
					} else if (tg.getSelectedToggle().getUserData().toString().compareToIgnoreCase("no") == 0) {
						sizeHbox.setDisable(false);
					}
					
				}
				tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
				    public void changed(ObservableValue<? extends Toggle> ov,
				        Toggle old_toggle, Toggle new_toggle) {
				            if (tg.getSelectedToggle() != null) {
				            	if (tg.getSelectedToggle().getUserData().toString().compareToIgnoreCase("no") == 0) {
				            		sizeHbox.setDisable(false);
								}
				            	else if (tg.getSelectedToggle().getUserData().toString().compareToIgnoreCase("yes") == 0) {
				            		sizeHbox.setDisable(true);
				            	}
				            }                
				        }
				});
				searchBottleButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {

						Tables.storageInfoTable(grid, x-1, y+5);
					}
				});
				sizeHbox.getChildren().addAll(sizeLabel,sizeCB);
				vbox.getChildren().addAll(everySize,bySize,sizeHbox,dateLabels,date,searchBottleButton);
				vbox.setSpacing(5);
				vbox1 = vbox;
				grid.add(vbox, x, y+5);
			}
		});
		hbox.getChildren().add(checkBottles);
		
	}
}
