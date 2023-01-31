package application.forms;

import application.helpers.StorageUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StorageForm {

	public void formLoad(final Stage fourthStage) {
		GridPane grid = new GridPane();
        
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(3);
		grid.setVgap(2);
		grid.setPadding(new Insets(25, 25, 25, 25));
        LoggedForm f = new LoggedForm();
		StorageUI.profileSettings(grid, fourthStage,f);
		StorageUI.storageManagement(grid, 6, 0);
		Scene scene = new Scene(grid, 1500, 600);
		StorageUI.setIcon(fourthStage);
		fourthStage.setScene(scene);
		fourthStage.show();
	}

}
