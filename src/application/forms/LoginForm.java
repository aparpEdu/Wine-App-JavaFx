package application.forms;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import sqlconnection.LoginChecker;

public class LoginForm {
	public LoginForm()
	{
		
	}
	public void formLoad(final Stage primaryStage)
	{
		try {
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Scene scene = new Scene(grid, 300, 275);
			primaryStage.setScene(scene);
			
			Text scenetitle = new Text("Wine Project");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			Label userName = new Label("User Name:");
			grid.add(userName, 0, 1);

			final TextField userTextField = new TextField();
			userTextField.setText("Leonellus");
			grid.add(userTextField, 1, 1);

			Label pw = new Label("Password:");
			grid.add(pw, 0, 2);

			final PasswordField pwBox = new PasswordField();
			pwBox.setText("pass123");
			grid.add(pwBox, 1, 2);
			
			Button btn = new Button("Log in");
			
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(btn);
			grid.add(hbBtn, 1, 4);
			final Text actiontarget = new Text();
	        grid.add(actiontarget, 1, 6);
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	            	LoginChecker lc=new LoginChecker();
	            	if(lc.check(userTextField.getText(), pwBox.getText()))
	            	{
	            		Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            		alert.setTitle("Information Dialog");
	            		alert.setHeaderText(null);
	            		alert.setContentText("You have logged in successfully!");
	            		alert.showAndWait();
	            		LoggedForm f = new LoggedForm();
	            		f.formLoad(new Stage());
	            		primaryStage.close();
	            	}
	            	else
	            	{
	            		JOptionPane.showMessageDialog(null, "Try Again");
	            		
	            		
	            		
	            	}
	            }
	            
	        }
	        );
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
            	
          
		
	}
	

}
