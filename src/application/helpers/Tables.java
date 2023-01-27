package application.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Grape.GrapeVariety;
import Users.Account;
import controlers.AccountController;
import enums.Color;
import enums.Variety;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import properties.GrapeEvaluationProperty;
import properties.PickedVariety;
import properties.UserProperties;
import properties.VarietyProperty;
import javafx.beans.property.Property;

public class Tables {
	// private static Map<Variety, CheckBox> checkboxMap;
	private static VBox vbox1 = null;
	private static int whiteCheckedCounter = 0;
	private static int redCheckedCounter = 0;

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

	public static void storageTable(GridPane grid) {
		StorageUI.checkAvailability(vbox1, grid);
		TableView table = new TableView();
		TableColumn id = new TableColumn("User id");
		TableColumn username = new TableColumn("Storage ID");
		table.getColumns().addAll(id, username);
		table.setPrefSize(750, 300);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 230, 0, 100));
		vbox.setPrefSize(750, 1000);
		vbox.getChildren().addAll(table);
		grid.add(vbox, 5, 5);
		vbox1 = vbox;
	}

	public static void storageInfoTable(GridPane grid, int x, int y) {
		StorageUI.checkAvailability(vbox1, grid);
		TableView table = new TableView();
		TableColumn bottleSize = new TableColumn("Bottle Size");
		TableColumn bottleQuantity = new TableColumn("Quantity");
		TableColumn bottleDate = new TableColumn("Date");
		table.getColumns().addAll(bottleSize, bottleQuantity, bottleDate);
		table.setPrefSize(600, 600);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 40, 0, 100));
		vbox.setPrefSize(620, 600);
		vbox.getChildren().addAll(table);
		grid.add(vbox, x, y);
		vbox1 = vbox;
	}

	public static void storedGrapesTable(GridPane grid, int x, int y) {
		StorageUI.checkAvailability(vbox1, grid);
		TableView table = new TableView();
		TableColumn grapeVariety = new TableColumn("Variety");
		TableColumn kg = new TableColumn("KG");
		TableColumn color = new TableColumn("Color");
		TableColumn grapeDate = new TableColumn("Date");
		table.getColumns().addAll(grapeVariety, color, kg, grapeDate);
		table.setPrefSize(800, 600);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 0, 0, 100));
		vbox.setPrefSize(720, 700);
		vbox.getChildren().addAll(table);
		grid.add(vbox, x, y);
		vbox1 = vbox;
	}
	public static void grapeEvaluationTable(GridPane grid, int x, int y) {
		StorageUI.checkAvailability(vbox1, grid);
		TableView table = new TableView();
		TableColumn grapeVariety = new TableColumn("Variety");
		TableColumn kg = new TableColumn("KG");
		TableColumn color = new TableColumn("Color");
		TableColumn grapeDate = new TableColumn("Date");
		
		
		Map<GrapeEvaluationProperty, CheckBox> checkboxMap = new HashMap<>();
		Map<GrapeEvaluationProperty, TextField> textfieldMap = new HashMap<>();
		TableColumn<GrapeEvaluationProperty, Double> winePerKG = new TableColumn<>("WKG");
		winePerKG.setCellValueFactory(new PropertyValueFactory<>("winePerKG"));
		winePerKG.setCellFactory(column -> {
		        return new TableCell<GrapeEvaluationProperty, Double>() {
		            private final TextField textField = new TextField();

		            {
		                textField.setEditable(false);
		                textField.textProperty().addListener((obs, oldValue, newValue) -> {
		                    if (!newValue.matches("\\d*")) {
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
		                    GrapeEvaluationProperty variety = getTableView().getItems().get(getIndex());
		                    textfieldMap.put(getTableView().getItems().get(getIndex()), textField);
		                    CheckBox checkbox = checkboxMap.get(variety);
		                    textField.setDisable(!checkbox.isSelected());
		                }
		            }
		        };
		    });
		TableColumn<GrapeEvaluationProperty, Boolean> pickColumn = new TableColumn<>("Pick");
		pickColumn.setCellValueFactory(new PropertyValueFactory<>("picked"));
		pickColumn.setCellFactory(column -> {
		    return new TableCell<GrapeEvaluationProperty, Boolean>() {
		        private final CheckBox checkBox = new CheckBox();

		        {
		            checkBox.setOnAction(event -> {
		            	GrapeEvaluationProperty item = getTableView().getItems().get(getIndex());
		                item.setPicked(checkBox.isSelected());

		                // Enable/disable the corresponding WinePerKG textfield
		                TextField winePerKGTextField = textfieldMap.get(getTableView().getItems().get(getIndex()));
		                winePerKGTextField.setDisable(!checkBox.isSelected());
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
						TextField winePerKGTextField = textfieldMap.get(getTableView().getItems().get(getIndex()));
					}
				}
			};
		});
		ArrayList<GrapeEvaluationProperty> myArrayList = new ArrayList<>();
		// populate the array list with data
		ObservableList<GrapeEvaluationProperty> myObservableList = FXCollections.observableArrayList(myArrayList);
		table.setItems(myObservableList);
		table.getColumns().addAll(grapeVariety, color, kg, grapeDate,pickColumn,winePerKG);
		table.setPrefSize(900, 600);
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(0, 0, 0, 240));
		vbox.setPrefSize(900, 700);
		vbox.getChildren().addAll(table);
		grid.add(vbox, x, y);
		vbox1 = vbox;
	}
	

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
							if (item.getColor() == Color.WHITE) {
								for (VarietyProperty variety : myClassList) {
									if (variety.getColor() == Color.RED) {
										// Get the checkbox corresponding to this variety
										CheckBox checkbox = checkboxMap.get(variety);
										// Disable the checkbox
										checkbox.setDisable(true);
									}
								}
								whiteCheckedCounter++;
							} else if (item.getColor() == Color.RED) {
								for (VarietyProperty variety : myClassList) {
									if (variety.getColor() == Color.WHITE) {
										// Get the checkbox corresponding to this variety
										CheckBox checkbox = checkboxMap.get(variety);
										// Disable the checkbox
										checkbox.setDisable(true);
									}
								}
								redCheckedCounter++;
							}
						} else {
							if (item.getColor() == Color.WHITE) {
								whiteCheckedCounter--;
								if (whiteCheckedCounter == 0) {
									for (VarietyProperty variety : myClassList) {
										if (variety.getColor() == Color.RED) {
											// Get the checkbox corresponding to this variety
											CheckBox checkbox = checkboxMap.get(variety);
											// Enable the checkbox
											checkbox.setDisable(false);
										}
									}
								}
							} else if (item.getColor() == Color.RED) {
								redCheckedCounter--;
								if (redCheckedCounter == 0) {
									for (VarietyProperty variety : myClassList) {
										if (variety.getColor() == Color.WHITE) {
											// Get the checkbox corresponding to this variety
											CheckBox checkbox = checkboxMap.get(variety);
											// Enable the checkbox
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

	public static void removeTable(GridPane grid) {
		StorageUI.checkAvailability(vbox1, grid);
	}

}
