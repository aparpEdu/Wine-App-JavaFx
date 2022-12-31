package Storage;

import javax.swing.JOptionPane;

import Users.Account;
import application.LoginForm;
import enums.Roles;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StorageUI {
public static void buttonVisibility(String string,Button button) {
	if(Account.getInstance().getRole().equalsIgnoreCase(string)) {
		button.setVisible(true);
	}else {
		button.setVisible(false);
	}
}
public static void profileSettings(GridPane grid,final Stage stage) {
	Button logOutVButton = new Button("Log out");
	Label welcomeLabel = new Label("Welcome,");
	Label roleLabel = new Label("Role: " + Account.getInstance().getRole());
	roleLabel.setFont(new Font("Ariel", 20));
	welcomeLabel.setFont(new Font("Ariel", 20));
	Text username = new Text(Account.getInstance().getUsername());
	Font font = Font.font("Ariel", FontWeight.BOLD, 20);
	username.setFont(font);
	logOutVButton.setPrefSize(80, 40);
	logOutVButton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent e) {
			Account.resetInstance();
			stage.close();
			JOptionPane.showMessageDialog(null, "See you next time!");
			LoginForm f = new LoginForm();
			f.formLoad(new Stage());
		}
	});
	grid.add(logOutVButton, 0, 3);
	grid.add(roleLabel, 0, 2);
	grid.add(welcomeLabel, 0, 0);
	grid.add(username, 0, 1);
}


}
