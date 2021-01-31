package ph.edu.dlsu.lbycpa2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.awt.*;
import java.io.IOException;
import javafx.event.ActionEvent;

import javax.swing.*;


public class paymentController {


        //public ListView list_items;
        @FXML private ListView <String> list_items,cartList;
        @FXML private TextField showPrice;

        ObservableList <String> paymentList,newcartlist;

        @FXML
        private void initialize() {
                Label total;
                paymentList = FXCollections.observableArrayList();
                newcartlist = FXCollections.observableArrayList();
                list_items.setItems(list);
                cartList.setItems(newcartlist);
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
                String item = showPrice.getText();
                cartList.getItems().addAll(item);
                int totalPrice = 0;
                int index2 = list_items.getSelectionModel().getSelectedIndex();
                if (index2 == 0){
                        totalPrice += 200;
                }
                else if (index2 == 1){
                        totalPrice += 300;
                }
                else if (index2 == 2){
                        totalPrice += 350;
                }
                else{
                        totalPrice += 400;
                }

        }

        public void removeItems(ActionEvent event) {
                int index = cartList.getSelectionModel().getSelectedIndex();
                if (index >= 0) {
                        cartList.getItems().remove(index);
                }
        }
        @FXML
        ObservableList <String> list = FXCollections.observableArrayList("License Renewal","Registration Fee", "License Application","Late Fee");


}
