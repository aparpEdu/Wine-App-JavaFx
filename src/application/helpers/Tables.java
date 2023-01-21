package application.helpers;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Tables {

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
	public static void removeTable(GridPane grid) {
		StorageUI.checkAvailability(vbox1, grid);
	}
	

}
