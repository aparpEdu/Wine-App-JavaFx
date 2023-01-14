package application.helpers;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Tables {

 private	static VBox vbox1;
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
        vbox1 = vbox;
        grid.add(vbox, 5,5);
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
        vbox.setPadding(new Insets(0, 165, 0, 100));
        vbox.setPrefSize(750, 1000);
        vbox.getChildren().addAll(table);
        vbox1 = vbox;
        grid.add(vbox, 5,5);
	}
	public static void storageInfoTable(GridPane grid) {
		StorageUI.checkAvailability(vbox1, grid);
		TableView table = new TableView();
        TableColumn bottleSize = new TableColumn("Bottle Size");
        table.getColumns().addAll(bottleSize);
        table.setPrefSize(750, 300);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(0, 165, 0, 100));
        vbox.setPrefSize(750, 1000);
        vbox.getChildren().addAll(table);
        vbox1 = vbox;
        grid.add(vbox, 5,5);
	}
	

}
