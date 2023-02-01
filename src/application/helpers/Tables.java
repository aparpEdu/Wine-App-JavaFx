package application.helpers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import controlers.AccountController;
import controlers.BottleController;
import controlers.GrapeController;
import controlers.WineController;
import enums.Color;
import enums.Variety;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import properties.BottleProperties;
import properties.GrapeProperties;
import properties.UserProperties;
import properties.VarietyProperty;
import properties.WineProperty;

public class Tables {
	// private static Map<Variety, CheckBox> checkboxMap;
	private static VBox vbox1 = null;
	private static int whiteCheckedCounter = 0;
	private static int redCheckedCounter = 0;
	private static boolean needed = false;

	public Tables() {

	}

	@SuppressWarnings("unchecked")
	public static void userTable(GridPane grid) throws SQLException {
		StorageUI.checkAvailability(vbox1, grid);
		TableView<UserProperties> table = new TableView<UserProperties>();
		TableColumn <UserProperties, String>username = new TableColumn<UserProperties, String>("username");
		TableColumn<UserProperties, String> pass = new TableColumn<UserProperties, String>("pass");
		TableColumn<UserProperties, String> role = new TableColumn<UserProperties, String>("Role");
		username.setCellValueFactory(new PropertyValueFactory<UserProperties, String>("username"));
		pass.setCellValueFactory(new PropertyValueFactory<UserProperties, String>("password"));
		role.setCellValueFactory(new PropertyValueFactory<UserProperties, String>("role"));
		AccountController ac = new AccountController();
		 ac.showAllUsers(table);
		table.getColumns().addAll(username, pass, role);
		table.setPrefSize(750, 300);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 0, 0, 160));
		vbox.setPrefSize(750, 1000);
		vbox.getChildren().addAll(table);
		grid.add(vbox, 5, 5);
		vbox1 = vbox;
		
		
	}
	@SuppressWarnings("unchecked")
	public static void userFinderTable(GridPane grid,String condition,String choice) throws SQLException {
		StorageUI.checkAvailability(vbox1, grid);
		TableView<UserProperties> table = new TableView<UserProperties>();
		TableColumn <UserProperties, String>username = new TableColumn<UserProperties, String>("username");
		TableColumn<UserProperties, String> pass = new TableColumn<UserProperties, String>("pass");
		TableColumn<UserProperties, String> role = new TableColumn<UserProperties, String>("Role");
		username.setCellValueFactory(new PropertyValueFactory<UserProperties, String>("username"));
		pass.setCellValueFactory(new PropertyValueFactory<UserProperties, String>("password"));
		role.setCellValueFactory(new PropertyValueFactory<UserProperties, String>("role"));
		AccountController ac = new AccountController();
		 ac.selectUser(table,condition,choice);
		 
		table.getColumns().addAll(username, pass, role);
		table.setPrefSize(750, 300);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 0, 0, 160));
		vbox.setPrefSize(750, 1000);
		vbox.getChildren().addAll(table);
		grid.add(vbox, 5, 5);
		vbox1 = vbox;
	}

	

	@SuppressWarnings("unchecked")
	public static void bottlesInfoTable(GridPane grid, int x, int y,String condition,String startDate,String endDate,String choice) throws SQLException {
		StorageUI.checkAvailability(vbox1, grid);
		TableView<BottleProperties> table = new TableView<BottleProperties>();
		TableColumn<BottleProperties, String> bottleSize = new TableColumn<BottleProperties, String>("Bottle Size");
		TableColumn<BottleProperties, String> bottleDate = new TableColumn<BottleProperties, String>("Date");
		bottleSize.setCellValueFactory(new PropertyValueFactory<BottleProperties, String>("Bottle_size"));
		
		bottleDate.setCellValueFactory(new PropertyValueFactory<BottleProperties, String>("date"));
		BottleController bc = new BottleController();
		if(choice.equalsIgnoreCase("all")) {
			bc.searchBottles(table,startDate,endDate);
			table.getColumns().addAll(bottleSize, bottleDate);
		}
		else if(choice.equalsIgnoreCase("specific")) {
			bc.searchSpecific(table,startDate,endDate,condition);
			table.getColumns().addAll(bottleSize, bottleDate);
		}
		
		table.setPrefSize(600, 600);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 40, 0, 100));
		vbox.setPrefSize(620, 600);
		vbox.getChildren().addAll(table);
		grid.add(vbox, x, y);
		vbox1 = vbox;
	}
	@SuppressWarnings("unchecked")
	public static void bottlesInfoTable(GridPane grid, int x, int y,String condition,String startDate,String endDate) throws SQLException {
		StorageUI.checkAvailability(vbox1, grid);
		TableView<BottleProperties> table = new TableView<BottleProperties>();
		TableColumn<BottleProperties, String> bottleSize = new TableColumn<BottleProperties, String>("Bottle Size");
		
		TableColumn<BottleProperties, String> bottleDate = new TableColumn<BottleProperties, String>("Date");
		bottleSize.setCellValueFactory(new PropertyValueFactory<BottleProperties, String>("Bottle_size"));
		
		bottleDate.setCellValueFactory(new PropertyValueFactory<BottleProperties, String>("date"));
		BottleController bc = new BottleController();
		
		
		
		
			bc.searchSpecific(table,startDate,endDate,condition);
			table.getColumns().addAll(bottleSize, bottleDate);
		
		
		table.setPrefSize(600, 600);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 40, 0, 100));
		vbox.setPrefSize(620, 600);
		vbox.getChildren().addAll(table);
		grid.add(vbox, x, y);
		vbox1 = vbox;
	}

	@SuppressWarnings("unchecked")
	public static void storedGrapesTable(GridPane grid, int x, int y,String startDate,String endDate,String condition,String choice) throws SQLException {
		StorageUI.checkAvailability(vbox1, grid);
		TableView<GrapeProperties> table = new TableView<GrapeProperties>();
		TableColumn<GrapeProperties,String> grapeVariety = new TableColumn<GrapeProperties, String>("Variety");
		TableColumn<GrapeProperties, String> kg = new TableColumn<GrapeProperties, String>("KG");
		TableColumn<GrapeProperties, String> color = new TableColumn<GrapeProperties, String>("Color");
		TableColumn<GrapeProperties, String> WKG = new TableColumn<GrapeProperties, String>("WKG");
		TableColumn<GrapeProperties, String> grapeDate = new TableColumn<GrapeProperties, String>("Date");
		grapeVariety.setCellValueFactory(new PropertyValueFactory<GrapeProperties, String>("variety"));
		kg.setCellValueFactory(new PropertyValueFactory<GrapeProperties, String>("kg"));
		color.setCellValueFactory(new PropertyValueFactory<GrapeProperties, String>("color"));
		WKG.setCellValueFactory(new PropertyValueFactory<GrapeProperties, String>("wkg"));
		grapeDate.setCellValueFactory(new PropertyValueFactory<GrapeProperties, String>("date"));
		GrapeController gp = new GrapeController();
		if(choice.equalsIgnoreCase("all")) {
		gp.searchGrapes(table, startDate, endDate);
		table.getColumns().addAll(grapeVariety, color, kg,WKG ,grapeDate);
		}
		else if(choice.equalsIgnoreCase("var")) {
			gp.searchByVariety(table, startDate, endDate, condition);
			table.getColumns().addAll(grapeVariety, color, kg,WKG ,grapeDate);
			}
		else if(choice.equalsIgnoreCase("color")) {
			gp.searchByColor(table, startDate, endDate, condition);
			table.getColumns().addAll(grapeVariety, color, kg,WKG ,grapeDate);
		}
		table.setPrefSize(800, 600);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 0, 0, 100));
		vbox.setPrefSize(720, 700);
		vbox.getChildren().addAll(table);
		grid.add(vbox, x, y);
		vbox1 = vbox;
	}
	@SuppressWarnings("unchecked")
	public static void grapeEvaluationTable(GridPane grid, int x, int y,String value) throws SQLException {
		StorageUI.checkAvailability(vbox1, grid);
		TableView<GrapeProperties> table = new TableView<GrapeProperties>();
		TableColumn<GrapeProperties, String> grapeVariety = new TableColumn<GrapeProperties,String >("Variety");
		TableColumn<GrapeProperties, String> kg = new TableColumn<GrapeProperties, String>("KG");
		TableColumn<GrapeProperties, String> color = new TableColumn<GrapeProperties, String>("Color");
		TableColumn<GrapeProperties, String> grapeDate = new TableColumn<GrapeProperties, String>("Date");
		grapeVariety.setCellValueFactory(new PropertyValueFactory<>("variety"));
		kg.setCellValueFactory(new PropertyValueFactory<>("kg"));
		color.setCellValueFactory(new PropertyValueFactory<>("color"));
		grapeDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		
		TableColumn<GrapeProperties, String> winePerKG = new TableColumn<>("WKG");
		winePerKG.setCellValueFactory(new PropertyValueFactory<>("wkg"));
		winePerKG.setEditable(true);
		Map<GrapeProperties, CheckBox> checkboxMap = new HashMap<>();
		ArrayList<GrapeProperties> selectedRows = new ArrayList<>();
		




		TableColumn<GrapeProperties, CheckBox> checkboxColumn = new TableColumn<>("Check");
		checkboxColumn.setCellValueFactory(data -> {
		    CheckBox checkBox = new CheckBox();
		    GrapeProperties grapeProperties = data.getValue();
		    checkboxMap.put(grapeProperties, checkBox);
		    return new SimpleObjectProperty<>(checkBox);
		});
		
		for (Map.Entry<GrapeProperties, CheckBox> entry : checkboxMap.entrySet()) {
		    GrapeProperties grapeProperties = entry.getKey();
		    CheckBox checkBox = entry.getValue();
		    checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
		        if (newValue) {
		            selectedRows.add(grapeProperties);
		            grapeProperties.setKgneeded(1f);
		        } else {
		            selectedRows.remove(grapeProperties);
		            grapeProperties.setKgneeded(0f);
		        }
		    });
		}
		GrapeController gc = new GrapeController();
	    gc.showAll(table);
		 
		
		
	
	
		
		//table.setItems(FXCollections.observableArrayList(Storage.getInstance().getGrapes()));
		table.getColumns().addAll(grapeVariety, color, kg, grapeDate,winePerKG,checkboxColumn);
		table.setPrefSize(900, 600);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 0, 0, 240));
		vbox.setPrefSize(900, 700);
		vbox.getChildren().addAll(table);
		grid.add(vbox, x, y);
		vbox1 = vbox;
	}
	@SuppressWarnings("unchecked")
	public static void grapeEvaluationTable2(GridPane grid, int x, int y,String value) throws SQLException {
		StorageUI.checkAvailability(vbox1, grid);
		TableView<GrapeProperties> table = new TableView<GrapeProperties>();
		TableColumn<GrapeProperties, String> grapeVariety = new TableColumn<GrapeProperties,String >("Variety");
		TableColumn<GrapeProperties, String> kg = new TableColumn<GrapeProperties, String>("KG");
		TableColumn<GrapeProperties, String> color = new TableColumn<GrapeProperties, String>("Color");
		TableColumn<GrapeProperties, String> grapeDate = new TableColumn<GrapeProperties, String>("Date");
		grapeVariety.setCellValueFactory(new PropertyValueFactory<>("variety"));
		kg.setCellValueFactory(new PropertyValueFactory<>("kg"));
		color.setCellValueFactory(new PropertyValueFactory<>("color"));
		grapeDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		Map<GrapeProperties, CheckBox> checkboxMap = new HashMap<>();
		TableColumn<GrapeProperties, String> winePerKG = new TableColumn<>("WKG");
		winePerKG.setCellValueFactory(new PropertyValueFactory<>("wkg"));
		winePerKG.setEditable(true);
		TableColumn<GrapeProperties, CheckBox> checkboxColumn = new TableColumn<>("Check");
		checkboxColumn.setCellValueFactory(data -> {
		    CheckBox checkBox = new CheckBox();
		    GrapeProperties grapeProperties = data.getValue();
		    checkboxMap.put(grapeProperties, checkBox);
		    return new SimpleObjectProperty<>(checkBox);
		});
		GrapeController gc = new GrapeController();
		gc.showAll(table);
		 
		
		
	
	
		
		//table.setItems(FXCollections.observableArrayList(Storage.getInstance().getGrapes()));
		table.getColumns().addAll(grapeVariety, color, kg, grapeDate,winePerKG);
		table.setPrefSize(900, 600);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 0, 0, 240));
		vbox.setPrefSize(900, 700);
		vbox.getChildren().addAll(table);
		grid.add(vbox, x, y);
		vbox1 = vbox;
	}
	

	@SuppressWarnings("unchecked")
	public static void wineVarietyPickerTable(GridPane grid, int x, int y) {
		StorageUI.checkAvailability(vbox1, grid);
		TableView<VarietyProperty> table = new TableView<VarietyProperty>();
		ArrayList<VarietyProperty> myClassList = new ArrayList<>();

		for (Variety variety : Variety.values()) {
			Color colors;
			if (variety == Variety.Cabernet || variety == Variety.Merlot || variety == Variety.Barbera
					|| variety == Variety.Molinara || variety == Variety.Tannat || variety == Variety.Tannat
					|| variety == Variety.Sangiovese || variety == Variety.Marselan || variety == Variety.Pinotage
					|| variety == Variety.Cinsaut) {
				colors = Color.RED;
			} else {
				colors = Color.WHITE;
			}
			myClassList.add(new VarietyProperty(variety, colors));
		}

		TableColumn<VarietyProperty, Variety> grapeVariety = new TableColumn<>("Variety");
		grapeVariety.setCellValueFactory(new PropertyValueFactory<>("variety"));
		grapeVariety.setCellFactory(c -> new TableCell<VarietyProperty, Variety>() {
			protected void updateItem(Variety item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText(null);
				} else {
					setText(item.toString());
				}
			}
		});

		Map<VarietyProperty, CheckBox> checkboxMap = new HashMap<>();
		TableColumn<VarietyProperty, Boolean> grapePicker = new TableColumn<>("Pick");
		grapePicker.setCellValueFactory(new PropertyValueFactory<>("picked"));
		ArrayList<VarietyProperty> selectedRows = new ArrayList<>();
		grapePicker.setCellFactory(column -> {
			return new TableCell<VarietyProperty, Boolean>() {
				private final CheckBox checkBox = new CheckBox();

				{
					checkBox.setOnAction(event -> {
//                    	checkBox.setOnAction((ActionEvent e) -> {
//                            textField.setDisable(!checkbox.isSelected());
//                        });
						VarietyProperty item = getTableView().getItems().get(getIndex());
						item.setPicked(checkBox.isSelected());

						if (checkBox.isSelected()) {
							selectedRows.add(item);
							if (item.getColor() == Color.WHITE) {
								for (VarietyProperty variety : myClassList) {
									if (variety.getColor() == Color.RED) {
									
										CheckBox checkbox = checkboxMap.get(variety);
									
										checkbox.setDisable(true);
									}
								}
								whiteCheckedCounter++;
							} else if (item.getColor() == Color.RED) {
								for (VarietyProperty variety : myClassList) {
									if (variety.getColor() == Color.WHITE) {
									
										CheckBox checkbox = checkboxMap.get(variety);
										
										checkbox.setDisable(true);
									}
								}
								redCheckedCounter++;
							}
						} else {
							selectedRows.remove(item);
							if (item.getColor() == Color.WHITE) {
								whiteCheckedCounter--;
								if (whiteCheckedCounter == 0) {
									for (VarietyProperty variety : myClassList) {
										if (variety.getColor() == Color.RED) {
											
											CheckBox checkbox = checkboxMap.get(variety);
											
											checkbox.setDisable(false);
										}
									}
								}
							} else if (item.getColor() == Color.RED) {
								redCheckedCounter--;
								if (redCheckedCounter == 0) {
									for (VarietyProperty variety : myClassList) {
										if (variety.getColor() == Color.WHITE) {
											
											CheckBox checkbox = checkboxMap.get(variety);
											
											checkbox.setDisable(false);
										}
									}
								}
							}
						}
					});
				}

				@Override
				protected void updateItem(Boolean item, boolean empty) {
					super.updateItem(item, empty);

					if (empty || item == null) {
						setGraphic(null);
					} else {
						setGraphic(checkBox);
						checkBox.setSelected(item);
						checkboxMap.put(getTableView().getItems().get(getIndex()), checkBox);
					}
				}
			};
		});

		TableColumn<VarietyProperty, Double> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		quantityColumn.setCellFactory(column -> {
		    return new TableCell<VarietyProperty, Double>() {
		        private final TextField textField = new TextField();

		        {
		            textField.setEditable(false);
		            textField.textProperty().addListener((obs, oldValue, newValue) -> {
		                if (!newValue.matches("^-?\\d*\\.?\\d*")) {
		                    textField.setText(newValue.replaceAll("[^\\d]", ""));
		                }
		            });
		        }

		        @Override
		        protected void updateItem(Double item, boolean empty) {
		            super.updateItem(item, empty);
		            if (empty || item == null) {
		                setGraphic(null);
		            } else {
		                setGraphic(textField);
		                textField.setText(Double.toString(item));
		                VarietyProperty variety = getTableView().getItems().get(getIndex());
		                CheckBox checkbox = checkboxMap.get(variety);
		                checkbox.selectedProperty().addListener((obs, oldValue, newValue) -> {
		                    textField.setEditable(newValue);
		                });
		            }
		        }
		    };
		});


		TableColumn<VarietyProperty, Color> grapeColor = new TableColumn<>("Color");
		grapeColor.setCellValueFactory(new PropertyValueFactory<>("color"));
		table.setItems(FXCollections.observableArrayList(myClassList));
		table.getColumns().addAll(grapeVariety, grapeColor, grapePicker, quantityColumn);
		table.setPrefSize(800, 600);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 0, 0, 240));
		vbox.setPrefSize(720, 700);
		vbox.getChildren().addAll(table);
		grid.add(vbox, x, y);
		vbox1 = vbox;
	}
	@SuppressWarnings("unchecked")
	public static void wineTable(GridPane grid, int x, int y,String startDate,String endDate,String condition,String choice) throws SQLException {
		
		StorageUI.checkAvailability(vbox1, grid);
		TableView<WineProperty> table = new TableView<WineProperty>();
		TableColumn<WineProperty,String> wineVariety = new TableColumn<WineProperty, String>("Variety");
		TableColumn<WineProperty, String> size = new TableColumn<WineProperty, String>("Bottle size");
		TableColumn<WineProperty, String> quantity = new TableColumn<WineProperty, String>("Quantity");
		TableColumn<WineProperty, String> wineDate = new TableColumn<WineProperty, String>("Date");
		TableColumn<WineProperty, String> filled = new TableColumn<WineProperty, String>("Filled");
		wineVariety.setCellValueFactory(new PropertyValueFactory<WineProperty, String>("variety"));
		size.setCellValueFactory(new PropertyValueFactory<WineProperty, String>("size"));
		quantity.setCellValueFactory(new PropertyValueFactory<WineProperty, String>("quantity"));
		wineDate.setCellValueFactory(new PropertyValueFactory<WineProperty, String>("date"));
		filled.setCellValueFactory(new PropertyValueFactory<WineProperty, String>("filled"));
		WineController wc = new WineController();
		if(choice.equalsIgnoreCase("all")) {
		wc.searchWine(table, startDate, endDate);
		table.getColumns().addAll(wineVariety,  size,quantity ,filled,wineDate);
		}
		else if(choice.equalsIgnoreCase("var")) {
			wc.searchByVariety(table, startDate, endDate, condition);
			table.getColumns().addAll(wineVariety,  size,quantity ,filled,wineDate);
		}
		else if(choice.equalsIgnoreCase("size")) {
			wc.searchBySize(table, startDate, endDate, condition);
			table.getColumns().addAll(wineVariety,  size,quantity ,filled,wineDate);
		}
		table.setPrefSize(800, 600);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 0, 0, 100));
		vbox.setPrefSize(800, 700);
		vbox.getChildren().addAll(table);
		grid.add(vbox, x, y);
		vbox1 = vbox;
	}

	public static void removeTable(GridPane grid) {
		StorageUI.checkAvailability(vbox1, grid);
	}

	public static boolean isNeeded() {
		return needed;
	}

	public static void setNeeded(boolean needed) {
		Tables.needed = needed;
	}

}
	