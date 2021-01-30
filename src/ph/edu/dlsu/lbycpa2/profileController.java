package ph.edu.dlsu.lbycpa2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;

public class profileController {

    public TextField pictureLabel;
    public Label name;
    public Label address;
    public Label id;
    public Label statusLabel;
    public ImageView pictureView;

    @FXML
    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Scene mainMenuScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(mainMenuScene);
        window.show();
    }

    public void changePicture(ActionEvent event) {
        if (!pictureLabel.getText().trim().isEmpty()) {
            pictureView.setImage(new Image("file:/C:/Users/User/IdeaProjects/LTOsoftware/src/assets/" + pictureLabel.getText()));
            statusLabel.setText("picture changed to " + pictureLabel.getText());
        }
        statusLabel.setVisible(true);

        if (pictureLabel.getText() == "jian.jpg") {
            name.setText("Jian Daniel T. Lasam");
            address.setText("Cagayan, Philippines");
            id.setText("11946342");
        }

    }
}
