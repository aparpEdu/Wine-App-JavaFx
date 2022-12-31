package application;

import Storage.StorageUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminForm {

	
	public void formLoad(final Stage thirdStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(5);
		grid.setVgap(1);
		grid.setPadding(new Insets(25, 25, 25, 25));
        Tables.userTable(grid);
		LoggedForm f = new LoggedForm();
		Buttons.backButton(grid, thirdStage, f, 0, 4);
		StorageUI.profileSettings(grid, thirdStage);
		 Scene scene = new Scene(grid, 800, 800);
		thirdStage.setScene(scene);
		thirdStage.show();
	}
	

}
