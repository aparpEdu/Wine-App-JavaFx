package application.helpers.alerts;

import enums.Variety;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class InfoAlerts {

	public InfoAlerts() {
		// TODO Auto-generated constructor stub
	}
	public static void editSuccessfull(String text) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.setContentText("User "+text+" was successfully edited");
		alert.showAndWait();
	}
	public static void userRemovalSuccess(String t) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.setContentText("User "+t+" was successfully removed");
		alert.showAndWait();
	}
	
	public static void accountCreatedSuccess(String text) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.setContentText("User "+text+" was successfully created!");
		alert.showAndWait();
	}
	public static void logInSuccessfull(Button btn) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("You have logged in successfully!");
		alert.initOwner(btn.getScene().getWindow());
		alert.showAndWait();
	}
	public static void wip() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("BOOM RADIATOR");
		alert.setHeaderText(null);
		alert.setContentText("WORK IN PROGRESS SEE YOU NEXT PATCH!");
		alert.showAndWait();
	}
	public static void bottleInsertSuccess(ComboBox<String> cb) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.setContentText("bottle: "+cb.getSelectionModel().getSelectedItem().toString()+" was successfully stored");
		alert.showAndWait();
	}
	public static void grapeInsertSuccess(ComboBox<Variety> varietyCB ) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.setContentText("grape: "+varietyCB.getSelectionModel().getSelectedItem().toString()+" was successfully stored");
		alert.showAndWait();
	}
	

}
