package application;

import Storage.StorageUI;
import enums.Roles;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Buttons {
	public static void backButton(GridPane grid,final Stage stage,final LoggedForm loggedForm,int x,int y ) {
		 Button back = new Button("Back");
		 back.setPrefSize(80, 40);
		 back.setOnAction(new EventHandler<ActionEvent>() {

	 		@Override
	 		public void handle(ActionEvent e) {
	 			stage.close();
	 			
	 			loggedForm.formLoad(new Stage());
	 		}
	 	});
		 grid.add(back, x, y);
	}
	public static void adminButton(GridPane grid,final LoggedForm loggedForm ) {
		 Button adminButton = new Button("User Management");
		 adminButton.setPrefSize(160, 80);
		 StorageUI.buttonVisibility(Roles.ADMIN.name(), adminButton); 
		 
		 adminButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					
					AdminForm af = new AdminForm();
					af.formLoad(new Stage());
					loggedForm.closeStage();
				}
			});
		 grid.add(adminButton, 50, 50);
		 
	}
	public static void addUserButton() {
		
	}
	public static void searchUserButton() {
		
	}
	public static void removeserButton() {
	
	}
	
	
	
}
