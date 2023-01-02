package application;

import Storage.StorageUI;
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
    grid.setHgap(5);
	grid.setVgap(5);
	grid.setPadding(new Insets(25, 25, 25, 25));
	HBox hbox = new HBox(10);
    hbox.setAlignment(Pos.BOTTOM_RIGHT);
    //Tables.userTable(grid);
	LoggedForm f = new LoggedForm();
	StorageUI.profileSettings(grid, fifthStage);
	Buttons.backButton(grid, fifthStage, f, 0, 4);
	Scene scene = new Scene(grid, 1150, 800);
	fifthStage.setScene(scene);
	fifthStage.show();
}
}
