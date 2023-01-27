package application.helpers;

import javax.swing.JOptionPane;

import Users.Account;
import application.forms.LoggedForm;
import application.forms.LoginForm;
import application.helpers.Buttons.AdminButtons;
import application.helpers.Buttons.Buttons;
import application.helpers.Buttons.ProductionButtons;
import application.helpers.Buttons.StorageButtons;
import enums.Roles;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StorageUI {
public static void buttonVisibility(String string,Button button) {
	if(Account.getInstance().getRole().equalsIgnoreCase(string) || Account.getInstance().getRole().equalsIgnoreCase(Roles.ADMIN.name())) {
		button.setVisible(true);
	}else {
		button.setVisible(false);
	}
}
public static void profileSettings(GridPane grid,final Stage stage) {
	VBox vbox = new VBox(10);
	Button logOutVButton = new Button("Log out");
	Label welcomeLabel = new Label("Welcome,");
	Label roleLabel = new Label("Role: " + Account.getInstance().getRole());
	roleLabel.setFont(new Font("Ariel", 20));
	roleLabel.setPrefSize(441, 10);
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
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(null);
    		alert.setContentText("You have logged out successfully!");
    		alert.showAndWait();
			LoginForm f = new LoginForm();
			f.formLoad(new Stage());
		}
	});
	vbox.getChildren().add(welcomeLabel);
	vbox.getChildren().add(username);
	vbox.getChildren().add(roleLabel);
	vbox.getChildren().add(logOutVButton);
	vbox.setSpacing(1);
	grid.add(vbox, 0, 0);
}
public static void profileSettings(GridPane grid,final Stage stage,LoggedForm lf) {
	VBox vbox = new VBox(10);
	Button logOutVButton = new Button("Log out");
	Label welcomeLabel = new Label("Welcome,");
	Label roleLabel = new Label("Role: " + Account.getInstance().getRole());
	roleLabel.setFont(new Font("Ariel", 20));
	roleLabel.setPrefSize(441, 10);
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
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(null);
    		setIcon(stage);
    		alert.setContentText("You have logged out successfully!");
    		alert.initOwner(logOutVButton.getScene().getWindow());
    		alert.showAndWait();
			LoginForm f = new LoginForm();
			f.formLoad(new Stage());
		}
	});
	Buttons.backButton(grid, stage, lf, 0, 1);
	vbox.getChildren().add(welcomeLabel);
	vbox.getChildren().add(username);
	vbox.getChildren().add(roleLabel);
	vbox.getChildren().add(logOutVButton);
	vbox.setSpacing(1);
	grid.add(vbox, 0, 0);
}
public static void adminHub(GridPane grid,int x,int y) {
	HBox hbox = new HBox(10);
	HBox hbox2 = new HBox(10);
	AdminButtons.addUserButton(hbox, grid, x, y);
	AdminButtons.searchUserButton(hbox, grid, x, y);
	AdminButtons.checkStorageButton(hbox2, grid, x, y);
	AdminButtons.removeUserButton(hbox, grid, x, y);
	AdminButtons.refreshButton(hbox, grid, x, y);
	AdminButtons.editButton(hbox, grid, x, y);
	AdminButtons.addStorageAccess(hbox2, grid, x, y);
	hbox.setAlignment(Pos.TOP_RIGHT);
	TitledPane users = new TitledPane();
	users.setCollapsible(false);
	TitledPane storage = new TitledPane();
	storage.setCollapsible(false);
//	users.setPrefWidth(20);
//	users.setPrefHeight(20);
	//storage.setPrefHeight(40);
	storage.setPrefWidth(1);
	hbox2.setSpacing(30);
    hbox2.setPadding(new Insets(10,0,10,75));
	users.setText("User Info");
	storage.setText("Storage Info");
	users.setContent(hbox);
	storage.setContent(hbox2);
	grid.add(users, x, y);
	grid.add(storage, x-1, y);
	
}
public static void checkAvailability(VBox vbox,GridPane grid) {
	if(vbox != null) {
		ObservableList<Node> children = grid.getChildren();
		children.remove(vbox);
	}
}
public static void checkAvailability(HBox hbox,GridPane grid,VBox vbox) {
	if(hbox != null) {
		ObservableList<Node> vboxChildren = vbox.getChildren();
		vboxChildren.remove(hbox);
	}
}
public static void homePage(HBox hbox,GridPane grid,int x,int y,LoggedForm loggedForm) {
	Buttons.adminButton(hbox, grid, loggedForm);
	Buttons.wineProdButton(hbox, grid, loggedForm);
	Buttons.hostButton(hbox, grid, loggedForm);
	grid.add(hbox, x, y);
}

public static void storageManagement(GridPane grid,int x,int y) {
	HBox hbox2 = new HBox();
	HBox hbox = new HBox();
	BorderPane bp = new BorderPane();
	bp.setPadding(new Insets(0,25,0,25));
	StorageButtons.addBottle(hbox, grid, x, y);
	StorageButtons.storeGrape(hbox, grid, x, y);
	StorageButtons.checkGrapes(hbox2, grid, x, y);
	StorageButtons.checkProduction(hbox2, grid, x, y);
	//Buttons.removeFromStorage(hbox, grid, x, y);
	StorageButtons.checkBottles(hbox2, grid, x, y);
	TitledPane storageManagement = new TitledPane();
	TitledPane storageCheck = new TitledPane();
	storageManagement.setCollapsible(false);
	storageManagement.setPrefWidth(250);
	storageCheck.setMaxWidth(350);
	storageCheck.setCollapsible(false);
	storageManagement.setText("Storage Management");
	storageCheck.setText("Storage Info");
	storageManagement.setContent(hbox);
	storageCheck.setContent(hbox2);
	bp.setRight(storageCheck);
	bp.setLeft(storageManagement);
	grid.add(bp, x, y);
}
public static void setIcon(Stage stage) {
	stage.getIcons().add(new Image("C:\\\\Users\\\\ShittyRestaurant\\\\eclipse-workspace\\\\WineProject\\\\ff.jpg"));
}
public static void wineManagement(GridPane grid,int x,int y) {
	HBox hbox = new HBox();
	ProductionButtons.addWine(hbox, grid, x, y);
	ProductionButtons.evaluateGrapesButton(hbox, grid, x, y);
	BorderPane bp = new BorderPane();
	bp.setPadding(new Insets(0,25,0,25));
	TitledPane wineManagement = new TitledPane();
	wineManagement.setCollapsible(false);
	wineManagement.setText("Wine Production");
	wineManagement.setContent(hbox);
	wineManagement.setPrefWidth(480);
	wineManagement.setMaxWidth(480);
	bp.setRight(wineManagement);
	hbox.setPadding(new Insets(10,50,10,50));
	hbox.setSpacing(30);
	grid.add(bp, x, y);
}
public static void conditionChecker(String condition ) {
	if(condition.equalsIgnoreCase("")) {
		
	}
}
}
