package application.helpers;

import application.forms.AdminForm;
import application.forms.LoggedForm;
import application.forms.StorageForm;
import application.forms.WineProductionForm;
import enums.BottleSize;
import enums.Roles;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Buttons {
	static VBox vbox1 = null;
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
				TextField pass = new TextField();
				pass.setPrefSize(100, 0);
				TextField role = new TextField();
				role.setPrefSize(100, 0);
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
				rb1.requestFocus();
				rb2.setToggleGroup(group);
				rb3.setToggleGroup(group);
				Button search = new Button("Search");
				Label label = new Label("Input: ");
				TextField t = new TextField();
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
				vbox.getChildren().add(rb3);
				vbox.getChildren().add(hbox2);
				vbox.getChildren().add(search);
				grid.add(vbox, x, y + 5);
				vbox1 = vbox;

			}
		});

		hbox.getChildren().add(searchButton);

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
				TextField t = new TextField();
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
				TextField id = new TextField();
				TextField username = new TextField();
				TextField pass = new TextField();
				TextField role = new TextField();
				id.setPrefSize(100, 0);
				username.setPrefSize(100, 0);
				pass.setPrefSize(100, 0);
				role.setPrefSize(100, 0);
				HBox hbox2 = new HBox();
				HBox hbox3 = new HBox();
				HBox hbox4 = new HBox();
				HBox hbox5 = new HBox();
				hbox2.setSpacing(5);
				hbox3.setSpacing(5);
				hbox4.setSpacing(5);
				hbox5.setSpacing(5);
				hbox2.getChildren().add(label);
				hbox2.getChildren().add(id);
				hbox3.getChildren().add(label2);
				hbox3.getChildren().add(username);
				hbox4.getChildren().add(label3);
				hbox4.getChildren().add(pass);
				hbox5.getChildren().add(label4);
				hbox5.getChildren().add(role);
				VBox vbox = new VBox();
				vbox.setPadding(new Insets(0, 120, 0, 120));
				vbox.setSpacing(5);
				vbox.getChildren().add(hbox2);
				vbox.getChildren().add(hbox3);
				vbox.getChildren().add(hbox4);
				vbox.getChildren().add(hbox5);
				vbox.getChildren().add(edit);
				vbox1 = vbox;
				grid.add(vbox, x, y + 5);
			}
		});
		hbox.getChildren().add(editButton);
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
				TextField t = new TextField();
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

	public static void addGrape(HBox hbox, final GridPane grid, final int x, final int y) {
		Button addGrape = new Button("Store Grape");
		addGrape.setPrefSize(120, 60);

		hbox.getChildren().add(addGrape);
	}

	public static void addWine(HBox hbox, final GridPane grid, final int x, final int y) {
		Button addWine = new Button("Produce Wine");
		addWine.setPrefSize(120, 60);

		hbox.getChildren().add(addWine);
	}

	public static void addBottle(HBox hbox, final GridPane grid, final int x, final int y) {
		Button addBottle = new Button("Store Bottle");
		addBottle.setPrefSize(120, 60);
		addBottle.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);

				ComboBox cb = new ComboBox();
			
				Button check = new Button("Store");
				Label userLabel = new Label("Size: ");
				userLabel.setPrefSize(100, 0);
				ObservableList<String> options = 
					    FXCollections.observableArrayList(
					    	BottleSize.LARGE.toString().concat(BottleSize.LARGE.getSize()),
					    	BottleSize.MEDIUM.toString().concat(BottleSize.MEDIUM.getSize()),
					    	BottleSize.SMALL.toString().concat(BottleSize.SMALL.getSize()),
					    	BottleSize.TINY.toString().concat(BottleSize.TINY.getSize())
					    	
					    );
				cb.setItems(options);
				cb.getSelectionModel().selectFirst();
				TextField t = new TextField();
				t.setPrefSize(100, 0);
				HBox hbox2 = new HBox();
				
				hbox2.setSpacing(5);
			
				hbox2.getChildren().add(userLabel);
				hbox2.getChildren().add(cb);
				VBox vbox = new VBox();
				vbox.setPadding(new Insets(0, 120, 0, 120));
				vbox.setSpacing(5);
				vbox.getChildren().add(hbox2);
				
				vbox.getChildren().add(check);
				grid.add(vbox, x, y + 5);
				vbox1 = vbox;

			}
		});

		hbox.getChildren().add(addBottle);
	}

	public static void addBottledWine(HBox hbox, final GridPane grid, final int x, final int y) {
		Button addBottledWine = new Button("Fill bottle");
		addBottledWine.setPrefSize(120, 60);

		hbox.getChildren().add(addBottledWine);
	}

	public static void removeFromStorage(HBox hbox, final GridPane grid, final int x, final int y) {
		Button removeFromStorage = new Button("Remove item");
		removeFromStorage.setPrefSize(120, 60);

		hbox.getChildren().add(removeFromStorage);
	}
	public static void checkBottles(HBox hbox, final GridPane grid, final int x, final int y) {
		Button checkBottles = new Button("Bottles info");
		checkBottles.setPrefSize(120, 60);
		checkBottles.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				StorageUI.checkAvailability(vbox1, grid);
				Tables.storageInfoTable(grid);
				ToggleGroup rads = new ToggleGroup();
				//RadioButton empty

			}
		});
		hbox.getChildren().add(checkBottles);
		
	}

}
