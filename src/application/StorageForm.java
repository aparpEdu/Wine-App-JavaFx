package application;

import Storage.StorageUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StorageForm {

	public void formLoad(final Stage fourthStage) {
		GridPane grid = new GridPane();
        
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(25, 25, 25, 25));
		HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        //Tables.userTable(grid);
		LoggedForm f = new LoggedForm();
		StorageUI.profileSettings(grid, fourthStage);
		Buttons.backButton(grid, fourthStage, f, 0, 4);
		Scene scene = new Scene(grid, 1150, 800);
		fourthStage.setScene(scene);
		fourthStage.show();
	}

}
