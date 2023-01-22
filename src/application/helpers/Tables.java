package application.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Grape.GrapeVariety;
import Grape.VarietyProperty;
import enums.Color;
import enums.Variety;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import properties.PickedVariety;
import javafx.beans.property.Property;

public class Tables {
	//private static Map<Variety, CheckBox> checkboxMap;
 private static VBox vbox1 = null;
	public Tables() {
		
	}
	public static void userTable(GridPane grid) {
		StorageUI.checkAvailability(vbox1, grid);
		TableView table = new TableView();
        TableColumn id = new TableColumn("id");
        TableColumn username = new TableColumn("username");
        TableColumn pass = new TableColumn("pass");
        TableColumn role = new TableColumn("Role");
        table.getColumns().addAll(id, username, pass,role);
        table.setPrefSize(750, 300);
        VBox vbox = new VBox();
       
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(0, 0, 0, 160));
        vbox.setPrefSize(750, 1000);
        vbox.getChildren().addAll(table);
        grid.add(vbox, 5,5);
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
        grid.add(vbox, 5,5);
        vbox1 = vbox;
	}
	public static void storageInfoTable(GridPane grid,int x,int y) {
		StorageUI.checkAvailability(vbox1, grid);
		TableView table = new TableView();
        TableColumn bottleSize = new TableColumn("Bottle Size");
        TableColumn bottleQuantity = new TableColumn("Quantity");
        TableColumn bottleDate = new TableColumn("Date");
        table.getColumns().addAll(bottleSize,bottleQuantity,bottleDate);
        table.setPrefSize(600, 600);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(0, 40, 0, 100));
        vbox.setPrefSize(620, 600);
        vbox.getChildren().addAll(table);
        grid.add(vbox, x,y);
        vbox1 = vbox;
	}
	public static void storedGrapesTable(GridPane grid,int x,int y) {
		StorageUI.checkAvailability(vbox1, grid);
		TableView table = new TableView();
        TableColumn grapeVariety = new TableColumn("Variety");
        TableColumn kg = new TableColumn("KG");
        TableColumn color = new TableColumn("Color");
        TableColumn grapeDate = new TableColumn("Date");
        table.getColumns().addAll(grapeVariety,color,kg,grapeDate);
        table.setPrefSize(800, 600);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(0, 0, 0, 100));
        vbox.setPrefSize(720, 700);
        vbox.getChildren().addAll(table);
        grid.add(vbox, x,y);
        vbox1 = vbox;
	}
	public static void wineVarietyPickerTable(GridPane grid,int x,int y) {
		StorageUI.checkAvailability(vbox1, grid);
		TableView<VarietyProperty> table = new TableView<VarietyProperty>();
       
  
        TableColumn kg = new TableColumn("Quantity");
        TableColumn color = new TableColumn("Color");
        ArrayList<VarietyProperty> myClassList = new ArrayList<>();
       
        for (Variety variety : Variety.values()) {
            Color colors;
            if (variety == Variety.Cabernet || variety == Variety.Merlot || variety == Variety.Barbera || variety == Variety.Molinara || variety == Variety.Tannat || variety == Variety.Tannat || variety == Variety.Sangiovese || variety == Variety.Marselan || variety == Variety.Pinotage || variety == Variety.Cinsaut) {
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
//        TableColumn<VarietyProperty, Boolean> grapePicker = new TableColumn<>("Pick");
//        grapePicker.setCellValueFactory(new PropertyValueFactory<>("picked"));
//        grapePicker.setCellFactory(CheckBoxTableCell.forTableColumn(grapePicker));
//        grapePicker.setEditable(true);
//        grapePicker.setOnEditCommit(event -> {
//        	VarietyProperty item = event.getRowValue();
//            item.setPicked(event.getNewValue());
//        });
//        TableColumn<VarietyProperty, Boolean> grapePicker = new TableColumn<>("Pick");
//        grapePicker.setCellValueFactory(new PropertyValueFactory<>("picked"));
//        grapePicker.setCellFactory(column -> {
//            return new TableCell<VarietyProperty, Boolean>() {
//                private final CheckBox checkBox = new CheckBox();
//
//                {
//                    checkBox.setOnAction(event -> {
//                        VarietyProperty item = getTableView().getItems().get(getIndex());
//                        item.setPicked(checkBox.isSelected());
//                        
//                    });
//                   
//                }
//
//                @Override
//                protected void updateItem(Boolean item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (empty || item == null) {
//                        setGraphic(null);
//                    } else {
//                        setGraphic(checkBox);
//                        checkBox.setSelected(item);
//                    }
//                    
//                }
//            };
//        });
        Map<VarietyProperty, CheckBox> checkboxMap = new HashMap<>();
        TableColumn<VarietyProperty, Boolean> grapePicker = new TableColumn<>("Pick");
        grapePicker.setCellValueFactory(new PropertyValueFactory<>("picked"));
        grapePicker.setCellFactory(column -> {
            return new TableCell<VarietyProperty, Boolean>() {
                private final CheckBox checkBox = new CheckBox();

                {
                    checkBox.setOnAction(event -> {
                        VarietyProperty item = getTableView().getItems().get(getIndex());
                        item.setPicked(checkBox.isSelected());
                        
                        if(checkBox.isSelected()){
                            if(item.getColor() == Color.WHITE){
                            	for (VarietyProperty variety : myClassList) {
                                    if (variety.getColor() == Color.RED) {
                                        // Get the checkbox corresponding to this variety
                                        CheckBox checkbox = checkboxMap.get(variety);
                                        // Disable the checkbox
                                        checkbox.setDisable(true);
                                    }
                                }
                            }else if(item.getColor() == Color.RED){
                            	for (VarietyProperty variety : myClassList) {
                                    if (variety.getColor() == Color.WHITE) {
                                        // Get the checkbox corresponding to this variety
                                        CheckBox checkbox = checkboxMap.get(variety);
                                        // Disable the checkbox
                                        checkbox.setDisable(true);
                                    }
                                }
                            }
                            
                        }
                        else {
                            if (item.getColor() == Color.WHITE) {
                                for (VarietyProperty variety : myClassList) {
                                    if (variety.getColor() == Color.RED) {
                                        // Get the checkbox corresponding to this variety
                                        CheckBox checkbox = checkboxMap.get(variety);
                                        // Enable the checkbox
                                        checkbox.setDisable(false);
                                    }
                                }
                            } else if (item.getColor() == Color.RED) {
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
        
//        grapePicker.setCellFactory(column -> {
//            return new TableCell<VarietyProperty, Boolean>() {
//                private final CheckBox checkBox = new CheckBox();
//
//                {
//                    checkBox.setOnAction(event -> {
//                        VarietyProperty item = getTableView().getItems().get(getIndex());
//                        item.setPicked(checkBox.isSelected());
//
//                        Color selectedColor = item.getVariety().getColor();
//                        for (VarietyProperty varietyProperty : table.getItems()) {
//                            if (varietyProperty.getVariety().getColor() != selectedColor) {
//                                TableRow<VarietyProperty> row = table.getRow(varietyProperty);
//                                CheckBox checkBox = (CheckBox) row.getChildren().get(0);
//                                checkBox.setDisable(checkBox.isSelected());
//                            }
//                        }
//                    });
//                }
//
//                @Override
//                protected void updateItem(Boolean item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (empty || item == null) {
//                        setGraphic(null);
//                    } else {
//                        setGraphic(checkBox);
//                        checkBox.setSelected(item);
//                    }
//                }
//            };
//        });
        TableColumn<VarietyProperty, Color> grapeColor = new TableColumn<>("Color");
        grapeColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        table.setItems(FXCollections.observableArrayList(myClassList));
        table.getColumns().addAll(grapeVariety,grapeColor,grapePicker,kg);
        table.setPrefSize(800, 600);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(0, 0, 0, 240));
        vbox.setPrefSize(720, 700);
        vbox.getChildren().addAll(table);
        grid.add(vbox, x,y);
        vbox1 = vbox;
	}
	
	public static void removeTable(GridPane grid) {
		StorageUI.checkAvailability(vbox1, grid);
	}
	

}
        
