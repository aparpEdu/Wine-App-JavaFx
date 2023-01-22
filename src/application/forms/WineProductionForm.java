package application.forms;

import application.helpers.StorageUI;
import application.helpers.Tables;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WineProductionForm {

	public WineProductionForm() {

	}

public void formLoad(Stage fifthStage) {
	GridPane grid = new GridPane();
    
    grid.setAlignment(Pos.TOP_LEFT);
    grid.setHgap(3);
	grid.setVgap(2);
	grid.setPadding(new Insets(25, 25, 25, 25));
	Tables.wineVarietyPickerTable(grid, 5, 5);
    LoggedForm f = new LoggedForm();
	StorageUI.profileSettings(grid, fifthStage,f);
	StorageUI.wineManagement(grid, 6, 0);
	Scene scene = new Scene(grid, 1300, 600);
	StorageUI.setIcon(fifthStage);
	fifthStage.setScene(scene);
	fifthStage.show();
}
}
