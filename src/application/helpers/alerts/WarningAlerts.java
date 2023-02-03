package application.helpers.alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class WarningAlerts {

	public WarningAlerts() {
	}
	public static void valuesWarning() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("ERROR");
		alert.setHeaderText(null);
		alert.setContentText("Some values were not set!");
		alert.showAndWait();
	}
	public static void usernameWarning() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("ERROR");
		alert.setHeaderText(null);
		alert.setContentText("username was  not set!");
		alert.showAndWait();
	}
	public static void userCreationWarning() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("ERROR");
		alert.setHeaderText(null);
		alert.setContentText("username and/or password were not set!");
		alert.showAndWait();
	}
	public static void logInWarning(Button btn) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("ERROR");
		alert.setHeaderText(null);
		alert.setContentText("Wrong credential, try again!");
		alert.initOwner(btn.getScene().getWindow());
		alert.showAndWait();
	}
	public static void dateWarning() {
		 Alert alert = new Alert(Alert.AlertType.WARNING);
 		alert.setTitle("ERROR");
 		alert.setHeaderText(null);
 		alert.setContentText("DATES WERE NOT INSERTED");
 		alert.showAndWait();
	}
	public static void kgWarning() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("ERROR");
		alert.setHeaderText(null);
		alert.setContentText("Kilograms were not set!");
		alert.showAndWait();
	}
	public static void bottleMinimumWarning(String msg) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Warning Dialog");
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}
	public static void grapeMinimumWarning(String msg) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Warning Dialog");
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}
	public static void largeMargin() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Warning Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Your kilograms needed exceeds the remaining amount!");
		alert.showAndWait();
	}
	public static void notEnoughBottles() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Warning Dialog");
		alert.setHeaderText(null);
		alert.setContentText("There are no bottles left with this size");
		alert.showAndWait();
	}

}
