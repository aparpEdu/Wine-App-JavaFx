package application.forms;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

import Grape.Grape;
import Storage.Storage;
import Wine.Bottle;
import application.helpers.StorageUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sqlconnection.helpers.ResourceLoader;
import sqlconnection.helpers.StorageChecker;

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
		
		ResourceLoader.loadResources();
		ArrayList<Bottle> bottleList = Storage.getInstance().getBottles();
		TreeMap<Integer, Grape> grapeList = Storage.getInstance().getGrapes();
		StorageChecker.criticalMinimum(bottleList);
		StorageChecker.criticalMinimumGrapes(grapeList);
		

	}
	

	public void closeStage() {
        stage.close();
    }
	
	

	
}
