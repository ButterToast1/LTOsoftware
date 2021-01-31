package ph.edu.dlsu.lbycpa2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.event.ActionEvent;


public class paymentController {


        //public ListView list_items;

        ObservableList<String> paymentList;


        @FXML
        private void initialize() {
                paymentList = FXCollections.observableArrayList();
                list_items.setItems(list);

                //paymentList.add("Registration Fee");
                //paymentList.add("License Application");
                //paymentList.add("License Renewal");
                //paymentList.add("Late Fee");
        }

        public void poptomainMenu(ActionEvent event) throws IOException {
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);

                //This line gets the Stage information
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(tableViewScene);
                window.show();
        }

        public void addItems(ActionEvent event) {
        }
        @FXML
        ListView <String> list_items;
        ObservableList <String> list = FXCollections.observableArrayList("License Renewal","Registration Fee", "License Application","Late Fee");


}
