package application.helpers;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Archive {

	public Archive() {
		// TODO Auto-generated constructor stub
	}
	public static void archive() {
		Image image = new Image("C:\\Users\\ShittyRestaurant\\eclipse-workspace\\WineProject\\ff.jpg");
		ImageView imageView = new ImageView();
		
		imageView.setImage(image);
		 imageView.setX(5);
	      imageView.setY(5);
	      imageView.setFitWidth(100);
	      imageView.setFitHeight(100);
	      imageView.setScaleX(5);
	      imageView.setScaleY(5);
	    //group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
////				if (group.getSelectedToggle() != null) {
////					if(group.getSelectedToggle().getUserData().toString().equals("st")) {
////						check.setOnAction(new EventHandler<ActionEvent>() {
////
////							@Override
////							public void handle(ActionEvent e) {
////								Tables.storageTable(grid);
////								
////								
////								
////							}
////						});
////					}
////					else if(group.getSelectedToggle().getUserData().toString().compareToIgnoreCase("User") == 0) {
////						check.setOnAction(new EventHandler<ActionEvent>() {
////
////							@Override
////							public void handle(ActionEvent e) {
////								Tables.storageTable(grid);
////								
////								
////							}
////						});
////					}
////				}
//			}
//
//		});
	}
//	public static void manageUsersButton(final HBox hbox, final GridPane grid, final int x, final int y) {
//	Button manageUsersButton = new Button("User Info");
//	manageUsersButton.setPrefSize(120, 60);
//	manageUsersButton.setOnAction(new EventHandler<ActionEvent>() {
//		@Override
//		public void handle(ActionEvent e) {
//			StorageUI.checkAvailability(hboxA, grid);
//			Buttons.addUserButton(hbox, grid, x, y);
//			Buttons.searchUserButton(hbox, grid, x, y);
//			Buttons.removeUserButton(hbox, grid, x, y);
//			Buttons.editButton(hbox, grid, x, y);
//			hboxA = hbox;
//
//		}
//	});
//	hboxA = hbox;
//	hbox.getChildren().add(manageUsersButton);
//	
//	
//
//}
//  TitledPane ff = new TitledPane();
//  ff.setContent(hbox);
	public static void removeFromStorage(HBox hbox, final GridPane grid, final int x, final int y) {
		Button removeFromStorage = new Button("Remove item");
		removeFromStorage.setPrefSize(120, 60);

		hbox.getChildren().add(removeFromStorage);
	}
}
