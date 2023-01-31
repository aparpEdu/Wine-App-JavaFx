package application.forms;

import java.sql.SQLException;
import java.util.ArrayList;

import Storage.Storage;
import Storage.StorageFiller;
import Wine.Bottle;
import application.helpers.StorageUI;
import enums.BottleSize;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
		ArrayList<Bottle> bottleList = Storage.getInstance().getBottles();
		criticalMinimum(bottleList);
		

	}
	public void criticalMinimum(ArrayList<Bottle> bottles)
	{
		int sizeA=0;
		int sizeB=0;
		int sizeC=0;
		int sizeD=0;
		for(Bottle b:bottles)
		{
			if(b.getSize().equals(BottleSize.LARGE.toString().concat(BottleSize.LARGE.getSize())))
			{
				sizeA++;
			}
			if(b.getSize().equals(BottleSize.MEDIUM.toString().concat(BottleSize.MEDIUM.getSize())))
			{
				sizeB++;
			}
			if(b.getSize().equals(BottleSize.SMALL.toString().concat(BottleSize.SMALL.getSize())))
			{
				sizeC++;
			}
			if(b.getSize().equals(BottleSize.TINY.toString().concat(BottleSize.TINY.getSize())))
			{
				sizeD++;
			}
			if(sizeA<5||sizeB<5||sizeC<5||sizeD<5)
			{
				String msg="You are at critical minimum for:\n";
				StringBuilder sb=new StringBuilder(" ");
				if(sizeA<5)
				{
					sb.append("You are low for"+BottleSize.LARGE+ " Bottles\n");
				}
				if(sizeB<5)
				{
					sb.append("You are low for"+BottleSize.MEDIUM+ " Bottles \n");
				}
				if(sizeC<5)
				{
					sb.append("You are low for"+BottleSize.SMALL+ " Bottles \n");
				}
				if(sizeD<5)
				{
					sb.append("You are low for"+BottleSize.TINY+ " Bottles ");
				}
				msg+=sb.toString();
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText(null);
				alert.setContentText(msg);
				alert.showAndWait();
			}
			
		}
		
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
