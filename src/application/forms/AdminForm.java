package application.forms;

import application.helpers.Buttons;
import application.helpers.StorageUI;
import application.helpers.Tables;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminForm {

	
	public void formLoad(final Stage thirdStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(3);
		grid.setVgap(2);
		grid.setPadding(new Insets(25, 25, 25, 25));
        Tables.userTable(grid);
        LoggedForm f = new LoggedForm();
		StorageUI.profileSettings(grid, thirdStage,f);
		StorageUI.adminHub(grid, 6, 0);
		Scene scene = new Scene(grid, 1180, 600);
		thirdStage.setScene(scene);
		thirdStage.show();
	}
	

}
