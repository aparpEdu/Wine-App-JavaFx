package application;



import javax.swing.JOptionPane;

import Users.Account;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sqlconnection.LoginChecker;

public class LoggedForm {
	
public LoggedForm() {}

public void formLoad()
{
	 final Stage secondStage=new Stage();
	GridPane grid = new GridPane();
	grid.setAlignment(Pos.TOP_LEFT);
	grid.setHgap(5);
	grid.setVgap(1);
	grid.setPadding(new Insets(25, 25, 25, 25));
	Label welcomeLabel = new Label("Welcome,");
	//Label label = new Label(Account.getInstance().getUsername());
	Label label2 = new Label("Role: " + Account.getInstance().getRole());
	Text username = new Text(Account.getInstance().getUsername());
	
	//label2.setTextFill(Color.RED);
	label2.setFont(new Font("Ariel",20));
	//welcomeLabel.setTextFill(Color.RED);
	welcomeLabel.setFont(new Font("Ariel",20));
	//label.setFont(new Font("Ariel",20));
	 Font font = Font.font("Ariel", FontWeight.BOLD, 20);
	 username.setFont(font);
	//label.setTextFill(Color.RED);
	Button button = new Button("Log out");
	button.setPrefSize(80, 40);
	button.setOnAction(new EventHandler<ActionEvent>() {
    	 
         @Override
         public void handle(ActionEvent e) {
         Account.resetInstance();
         secondStage.close();
         JOptionPane.showMessageDialog(null, "See you next time!");
         LoginForm f = new LoginForm();
         f.formLoad(new Stage());
         }
             }
     );
    
	
	grid.add(label2, 0, 3);
	grid.add(welcomeLabel, 0, 0);
	grid.add(username, 0, 1);
	grid.add(button, 0, 4);
	Scene scene = new Scene(grid, 800, 800);
	secondStage.setScene(scene);
	
	secondStage.show();
	

	
	
	
	}
}
