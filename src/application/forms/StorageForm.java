package application.forms;

import application.helpers.Buttons;
import application.helpers.StorageUI;
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
        grid.setHgap(3);
		grid.setVgap(2);
		grid.setPadding(new Insets(25, 25, 25, 25));
		HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        //Tables.userTable(grid);
        LoggedForm f = new LoggedForm();
		StorageUI.profileSettings(grid, fourthStage,f);
		StorageUI.storageManagement(hbox, grid, 4, 0);
		Scene scene = new Scene(grid, 1180, 600);
		fourthStage.setScene(scene);
		fourthStage.show();
	}

}
