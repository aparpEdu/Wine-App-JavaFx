package application.forms;

import java.sql.SQLException;

import Storage.StorageFiller;
import application.helpers.StorageUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoggedForm {
	
	 
    
	private Stage stage;

	public void formLoad(final Stage secondStage) throws SQLException {
		this.stage = secondStage;
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
		StorageUI.setIcon(secondStage);
		secondStage.setScene(scene);
		secondStage.show();
		
		loadResources();
		

	}
	public void closeStage() {
        stage.close();
    }
	private void loadResources() throws SQLException
	{
		StorageFiller s=new StorageFiller();
		s.fillGrape();
		s.fillBottle();
	}
	

	
}
