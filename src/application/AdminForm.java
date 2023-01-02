package application;

import Storage.StorageUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminForm {

	
	public void formLoad(final Stage thirdStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(25, 25, 25, 25));
		HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        Tables.userTable(grid);
		LoggedForm f = new LoggedForm();
		StorageUI.profileSettings(grid, thirdStage);
		Buttons.backButton(grid, thirdStage, f, 0, 4);
		StorageUI.userManagement(hbox, grid, 6, 0);
		 Scene scene = new Scene(grid, 1150, 600);
		thirdStage.setScene(scene);
		thirdStage.show();
	}
	

}
