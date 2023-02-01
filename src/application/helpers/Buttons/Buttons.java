package application.helpers.Buttons;

import java.sql.SQLException;

import application.forms.AdminForm;
import application.forms.LoggedForm;
import application.forms.StorageForm;
import application.forms.WineProductionForm;
import application.helpers.StorageUI;
import enums.Roles;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sqlconnection.LoginChecker;

public class Buttons {
//	private static VBox vbox1 = null;
//	static HBox hboxA = null;

	public static void backButton(GridPane grid, final Stage stage, final LoggedForm loggedForm, int x, int y) {
		Button back = new Button("Back");
		back.setPrefSize(80, 40);
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				stage.close();

				try {
					loggedForm.formLoad(new Stage());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		grid.add(back, x, y);
	}

	public static void adminButton(HBox hbox, GridPane grid, final LoggedForm loggedForm) {
		Button adminButton = new Button("User Management");
		adminButton.setPrefSize(160, 80);
		StorageUI.buttonVisibility(Roles.ADMIN.name(), adminButton);

		adminButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				AdminForm af = new AdminForm();
				try {
					af.formLoad(new Stage());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				loggedForm.closeStage();
			}
		});
		hbox.getChildren().add(adminButton);

	}

	public static void hostButton(HBox hbox, final GridPane grid, final LoggedForm loggedForm) {
		Button hostButton = new Button("Storage Management");
		hostButton.setPrefSize(170, 80);
		StorageUI.buttonVisibility(Roles.HOST.name(), hostButton);

		hostButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				StorageForm sf = new StorageForm();
				sf.formLoad(new Stage());
				loggedForm.closeStage();
			}
		});
		hbox.getChildren().add(hostButton);

	}

	public static void wineProdButton(HBox hbox, final GridPane grid, final LoggedForm loggedForm) {
		Button wineProdButton = new Button("Wine Production");
		wineProdButton.setPrefSize(160, 80);
		StorageUI.buttonVisibility(Roles.WINEPRODUCER.name(), wineProdButton);

		wineProdButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				WineProductionForm wf = new WineProductionForm();
				wf.formLoad(new Stage());
				loggedForm.closeStage();
			}
		});
		hbox.getChildren().add(wineProdButton);

	}
	public static void logInButton(HBox hbox,TextField field,PasswordField field2,GridPane grid,Stage stage) {
		Button btn = new Button("Log in");
		
		
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		hbox.getChildren().add(btn);
		grid.add(hbox, 1, 4);
		final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
            	LoginChecker lc=new LoginChecker();
            	if(lc.check(field.getText(), field2.getText()))
            	{
            		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            		alert.setTitle("Information Dialog");
            		alert.setHeaderText(null);
            		alert.setContentText("You have logged in successfully!");
            		alert.initOwner(btn.getScene().getWindow());
            		alert.showAndWait();
            		LoggedForm f = new LoggedForm();
            		try {
						f.formLoad(new Stage());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		stage.close();
            	}
            	else
            	{
            		Alert alert = new Alert(Alert.AlertType.INFORMATION);
            		alert.setTitle("Information Dialog");
            		alert.setHeaderText(null);
            		alert.setContentText("Wrong credential, try again!");
            		alert.initOwner(btn.getScene().getWindow());
            		alert.showAndWait();
            	
            		
            		
            		
            	}
            }
            
        }
        );
	}

	

	


	

	

	

	
	
	
	
	

}
