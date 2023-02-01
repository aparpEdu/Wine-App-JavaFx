package application.forms;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import application.helpers.StorageUI;
import application.helpers.Buttons.Buttons;

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
			StorageUI.setIcon(primaryStage);
			HBox hbBtn = new HBox(10);
			Buttons.logInButton(hbBtn, userTextField, pwBox, grid, primaryStage);

	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
            	
          
		
	}
	

}
