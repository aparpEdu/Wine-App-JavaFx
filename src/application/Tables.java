package application;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Tables {

	public Tables() {
		
	}
	public static void userTable(GridPane grid) {
		TableView table = new TableView();

        TableColumn id = new TableColumn("id");
        TableColumn username = new TableColumn("username");
        TableColumn pass = new TableColumn("pass");
        TableColumn role = new TableColumn("Role");
        table.getColumns().addAll(id, username, pass,role);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(50, 0, 0, 200));
        vbox.getChildren().addAll(table);
        grid.add(vbox, 1, 5);
	}

}
