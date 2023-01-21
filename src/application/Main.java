package application;
	
import application.forms.LoginForm;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		LoginForm login=new LoginForm();
		login.formLoad(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
