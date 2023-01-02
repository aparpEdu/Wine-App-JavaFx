package application;

import javax.swing.JOptionPane;

import Storage.StorageUI;
import Users.Account;
import enums.Roles;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sqlconnection.LoginChecker;

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
		Scene scene = new Scene(grid, 800, 400);
		secondStage.setScene(scene);
		secondStage.show();
		
		

	}
	public void closeStage() {
        stage.close();
    }
	

	
}
