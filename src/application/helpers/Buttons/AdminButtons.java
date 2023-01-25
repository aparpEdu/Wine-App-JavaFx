package application.helpers.Buttons;

import application.helpers.NumberTextField;
import application.helpers.StorageUI;
import application.helpers.Tables;
import enums.Roles;
import enums.Variety;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AdminButtons extends Buttons {

	private static VBox vbox1 = null;
	private static HBox hbox1 = null;

	public AdminButtons() {
		// TODO Auto-generated constructor stub
	}

	public static void addStorageAccess(HBox hbox, final GridPane grid, final int x, final int y) {
		Button checkStorageButton = new Button("Add Storage Access");
		checkStorageButton.setPrefSize(150, 60);
		checkStorageButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);

				Button check = new Button("Add");
				Label userLabel = new Label("User ID: ");
				Label storageLabel = new Label("Storage ID: ");
				userLabel.setPrefSize(100, 0);
				storageLabel.setPrefSize(100, 0);
				TextField t = new TextField();
				t.setPrefSize(100, 0);
				TextField storageField = new TextField();
				storageField.setPrefSize(100, 0);
				HBox hbox2 = new HBox();
				HBox hbox3 = new HBox();
				hbox2.setSpacing(5);
				hbox3.setSpacing(5);
				hbox2.getChildren().add(userLabel);
				hbox2.getChildren().add(t);
				hbox3.getChildren().add(storageLabel);
				hbox3.getChildren().add(storageField);

				VBox vbox = new VBox();
				vbox.setPadding(new Insets(0, 120, 0, 120));
				vbox.setSpacing(5);

				vbox.getChildren().add(hbox2);
				vbox.getChildren().add(hbox3);
				vbox.getChildren().add(check);
				grid.add(vbox, x, y + 5);
				vbox1 = vbox;

			}
		});
		hbox.getChildren().add(checkStorageButton);

	}

	public static void checkStorageButton(HBox hbox, final GridPane grid, final int x, final int y) {
		Button checkStorageButton = new Button("Check Storage Access");
		checkStorageButton.setPrefSize(150, 60);
		checkStorageButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);

				final ToggleGroup group = new ToggleGroup();
				final RadioButton rb1 = new RadioButton("By Storage");
				rb1.setUserData("st");
				RadioButton rb2 = new RadioButton("By User");
				rb2.setUserData("User");

				rb1.setToggleGroup(group);
				rb2.setToggleGroup(group);

				group.selectToggle(rb1);
				rb1.requestFocus();

				final Button check = new Button("Check");
				Label label = new Label("ID: ");
				NumberTextField t = new NumberTextField();
				if (group.getSelectedToggle() != null) {
					if (group.getSelectedToggle().getUserData().toString().equals("st")) {
						check.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent e) {
								Tables.storageTable(grid);

							}
						});
					} else if (group.getSelectedToggle().getUserData().toString().compareToIgnoreCase("User") == 0) {
						check.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent e) {
								Tables.storageTable(grid);

							}
						});
					}
				}

				t.setPrefSize(100, 0);
				HBox hbox2 = new HBox();
				hbox2.setSpacing(5);
				hbox2.getChildren().add(label);
				hbox2.getChildren().add(t);
				VBox vbox = new VBox();
				vbox.setPadding(new Insets(0, 120, 0, 120));
				vbox.setSpacing(5);
				vbox.getChildren().add(rb1);
				vbox.getChildren().add(rb2);
				vbox.getChildren().add(hbox2);
				vbox.getChildren().add(check);
				grid.add(vbox, x, y + 5);
				vbox1 = vbox;

			}
		});
		hbox.getChildren().add(checkStorageButton);

	}

	public static void editButton(HBox hbox, final GridPane grid, final int x, final int y) {
		Button editButton = new Button("Edit User");
		editButton.setPrefSize(120, 60);
		editButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);
				Button edit = new Button("Edit");
				Label label = new Label("Input ID");
				Label label2 = new Label("Username: ");
				Label label3 = new Label("Password: ");
				Label label4 = new Label("Role: ");
				label.setPrefSize(100, 0);
				label2.setPrefSize(100, 0);
				label3.setPrefSize(100, 0);
				label4.setPrefSize(100, 0);
				NumberTextField id = new NumberTextField();
				TextField username = new TextField();
				PasswordField pass = new PasswordField();
				ComboBox<Roles> role = new ComboBox<Roles>();
				role.setItems(FXCollections.observableArrayList(Roles.values()));
				role.getSelectionModel().select(0);
				role.setPrefSize(170, 0);
				id.setPrefSize(100, 0);
				username.setPrefSize(100, 0);
				pass.setPrefSize(100, 0);
				HBox hbox2 = new HBox();
				HBox hbox3 = new HBox();
				HBox hbox4 = new HBox();
				HBox hbox5 = new HBox();
				hbox2.setSpacing(5);
				hbox3.setSpacing(5);
				hbox4.setSpacing(5);
				hbox5.setSpacing(5);
				hbox2.getChildren().addAll(label,id);
				hbox3.getChildren().addAll(label2,username);
				hbox4.getChildren().addAll(label3,pass);
				hbox5.getChildren().addAll(label4,role);
				VBox vbox = new VBox();
				vbox.setPadding(new Insets(0, 120, 0, 120));
				vbox.setSpacing(5);
				vbox.getChildren().addAll(hbox2,hbox3,hbox4,hbox5,edit);
				vbox1 = vbox;
				grid.add(vbox, x, y + 5);
			}
		});
		hbox.getChildren().add(editButton);
	}

	public static void refreshButton(HBox hbox, final GridPane grid, int x, int y) {
		Button refreshButton = new Button("Refresh");
		refreshButton.setPrefSize(120, 60);
		refreshButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);
				Tables.userTable(grid);

			}
		});
		hbox.getChildren().add(refreshButton);
	}

	public static void removeUserButton(HBox hbox, final GridPane grid, final int x, final int y) {
		Button removeButton = new Button("Remove User");
		removeButton.setPrefSize(140, 60);
		removeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);
				Button add = new Button("Remove");
				Label label = new Label("Input ID");
				label.setPrefSize(100, 0);
				NumberTextField t = new NumberTextField();
				t.setPrefSize(100, 0);
				HBox hbox2 = new HBox();
				hbox2.setSpacing(5);
				hbox2.getChildren().add(label);
				hbox2.getChildren().add(t);
				VBox vbox = new VBox();
				vbox.setPadding(new Insets(0, 120, 0, 120));
				vbox.setSpacing(5);
				vbox.getChildren().add(hbox2);
				vbox.getChildren().add(add);
				vbox1 = vbox;
				grid.add(vbox, x, y + 5);
			}
		});
		hbox.getChildren().add(removeButton);
	}

	public static void searchUserButton(HBox hbox, final GridPane grid, final int x, final int y) {
		final Button searchButton = new Button("Search User");
		searchButton.setPrefSize(140, 60);
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);
				final ToggleGroup group = new ToggleGroup();
				RadioButton rb1 = new RadioButton("By Role");
				RadioButton rb2 = new RadioButton("By Username");
				RadioButton rb3 = new RadioButton("By ID");
				rb1.setToggleGroup(group);
				rb1.setSelected(true);
				rb1.setUserData("role");
				rb1.requestFocus();
				rb2.setToggleGroup(group);
				rb2.setUserData("username");
				rb3.setToggleGroup(group);
				rb3.setUserData("id");
				Button search = new Button("Search");
				Label labelRole = new Label("Role: ");
				Label labelID = new Label("ID: ");
				Label labelUsername = new Label("Username: ");
				TextField t = new TextField();
				NumberTextField id = new NumberTextField();
				id.setPrefWidth(50);
				ComboBox<Roles> role = new ComboBox<Roles>();
				role.setItems(FXCollections.observableArrayList(Roles.values()));
				role.getSelectionModel().select(0);
				role.setPrefSize(150, 0);
				t.setPrefSize(100, 0);
				HBox userHbox = new HBox();
				userHbox.setSpacing(5);
				userHbox.getChildren().addAll(labelUsername, t);
				HBox IDHBox = new HBox();
				IDHBox.getChildren().addAll(labelID, id);
				HBox roleHBox = new HBox();
				roleHBox.getChildren().addAll(labelRole, role);
				VBox vbox = new VBox();
				vbox.setPadding(new Insets(0, 120, 0, 120));
				vbox.setSpacing(5);
				vbox.getChildren().addAll(rb1, rb2, rb3);
				HBox searchHBox = new HBox();
				searchHBox.getChildren().add(search);
				vbox.getChildren().add(roleHBox);
				hbox1 = roleHBox;
				vbox.getChildren().add(searchHBox);
				group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
					public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
						if (group.getSelectedToggle() != null) {
							if (group.getSelectedToggle().getUserData().toString().equalsIgnoreCase("role")) {
								StorageUI.checkAvailability(searchHBox, grid, vbox);
								StorageUI.checkAvailability(hbox1, grid, vbox);
								hbox1 = roleHBox;
								vbox.getChildren().addAll(hbox1, searchHBox);

							} else if (group.getSelectedToggle().getUserData().toString().equalsIgnoreCase("username")) {
								StorageUI.checkAvailability(searchHBox, grid, vbox);
								StorageUI.checkAvailability(hbox1, grid, vbox);
								hbox1 = userHbox;
								vbox.getChildren().addAll(hbox1, searchHBox);

							} else if (group.getSelectedToggle().getUserData().toString().equalsIgnoreCase("id")) {
								StorageUI.checkAvailability(searchHBox, grid, vbox);
								StorageUI.checkAvailability(hbox1, grid, vbox);
								hbox1 = IDHBox;
								vbox.getChildren().addAll(hbox1, searchHBox);

							}

						}
					}
				});

				grid.add(vbox, x, y + 5);
				vbox1 = vbox;

			}
		});

		hbox.getChildren().add(searchButton);

	}

	public static void addUserButton(HBox hbox, final GridPane grid, final int x, final int y) {
		Button addButton = new Button("Add User");
		addButton.setPrefSize(120, 60);
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);
				Button add = new Button("Add");
				Label label = new Label("Username: ");
				Label label2 = new Label("Password: ");
				Label label3 = new Label("Role: ");
				TextField username = new TextField();
				label.setPrefSize(100, 0);
				label2.setPrefSize(100, 0);
				label3.setPrefSize(100, 0);
				username.setPrefSize(100, 0);
				ComboBox<Roles> role = new ComboBox<Roles>();
				role.setItems(FXCollections.observableArrayList(Roles.values()));
				role.getSelectionModel().select(0);
				role.setPrefSize(100, 0);
				PasswordField pass = new PasswordField();
				pass.setPrefSize(100, 0);
				HBox hbox2 = new HBox();
				hbox2.setSpacing(5);
				hbox2.getChildren().add(label);
				hbox2.getChildren().add(username);
				HBox hbox3 = new HBox();
				hbox3.setSpacing(5);
				hbox3.getChildren().add(label2);
				hbox3.getChildren().add(pass);
				HBox hbox4 = new HBox();
				hbox4.setSpacing(5);
				hbox4.getChildren().add(label3);
				hbox4.getChildren().add(role);
				VBox vbox = new VBox();
				vbox.setPadding(new Insets(0, 120, 0, 120));
				vbox.setSpacing(5);
				vbox.getChildren().add(hbox2);
				vbox.getChildren().add(hbox3);
				vbox.getChildren().add(hbox4);
				vbox.getChildren().add(add);
				grid.add(vbox, x, y + 5);
				vbox1 = vbox;

			}
		});
		hbox.getChildren().add(addButton);

	}
}