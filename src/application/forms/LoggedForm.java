package application.forms;

import application.helpers.StorageUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoggedForm {
	
	 
    
	private Stage stage;

	public void formLoad(final Stage secondStage) {
		this.stage = secondStage;
		secondStage.setTitle("close suka");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(5);
		grid.setVgap(1);
		grid.setPadding(new Insets(25, 25, 25, 25));
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		StorageUI.profileSettings(grid, secondStage);
		StorageUI.homePage(hbox, grid, 8, 5, this);
		Scene scene = new Scene(grid, 810, 400);
		secondStage.setScene(scene);
		secondStage.show();
		
		

	}
	public void closeStage() {
        stage.close();
    }
	

	
}
