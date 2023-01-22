package application.helpers.Buttons;

import java.util.Arrays;

import application.forms.AdminForm;
import application.forms.LoggedForm;
import application.forms.StorageForm;
import application.forms.WineProductionForm;
import application.helpers.StorageUI;
import application.helpers.Tables;
import enums.BottleSize;
import enums.Color;
import enums.Roles;
import enums.Variety;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Buttons {
	private static VBox vbox1 = null;
//	static HBox hboxA = null;

	public static void backButton(GridPane grid, final Stage stage, final LoggedForm loggedForm, int x, int y) {
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

	public static void adminButton(HBox hbox, GridPane grid, final LoggedForm loggedForm) {
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

	

	


	

	

	

	
	
	
	
	

}
