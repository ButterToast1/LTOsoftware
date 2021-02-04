package ph.edu.dlsu.lbycpa2;

import javafx.animation.TranslateTransition;
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
import javafx.util.Duration;

import java.util.Stack;
import javax.swing.*;


public class paymentController {

        public Label total;
        //public ListView list_items;
        @FXML private ListView <String> list_items,cartList;
        @FXML private TextField showPrice;
        ObservableList <String> paymentList,newcartlist;

        @FXML
        private void initialize() {
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
                int totalPrice = 1;
                String item = showPrice.getText();
                list_items.getItems().addAll(item);
                //int -> string -> label

        }

        public void removeItems(ActionEvent event) {
                int index = list_items.getSelectionModel().getSelectedIndex();
                if (index >= 0) {
                        list_items.getItems().remove(index);
                }
        }

        public void checkout(ActionEvent event) throws IOException{
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
                Scene mainMenuScene = new Scene(tableViewParent);

                //This line gets the Stage information
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(mainMenuScene);
                window.show();
        }

        public void paymentSort(ActionEvent event) throws IOException{
                list.sort(String.CASE_INSENSITIVE_ORDER);
        }

        public void paymentSort2(ActionEvent event) throws IOException{
                list.sort(String.CASE_INSENSITIVE_ORDER.reversed());
        }
        @FXML
        ObservableList <String> list = FXCollections.observableArrayList("License Renewal Fee");

        //"Registration Fee", "License Application","Late Fee","Illegal Parking","Beating the Red Light"
        /*

        List&lt;Movie&gt; movies = Arrays.asList(
        new Movie("Lord of the rings", 8.8, true),
        new Movie("Back to the future", 8.5, false),
        new Movie("Carlito's way", 7.9, true),
        new Movie("Pulp fiction", 8.9, false));
        movies.sort(Comparator.comparing(Movie::getStarred).reversed().thenComparing(Comparator.comparing(Movie::getRating) .reversed()));
        movies.forEach(System.out::println);*/

        //New listarray
        /*"Driving w/o License",3000,
        "No Seatbelt",1000,
        "Driving under the Influence",5000,
        "Careless Driving",1000,
        "Driving w/o Registration",10000,
        "Illegally Modified Car",5000,
        "Running a Right-Hand Car",50000,
        "Missing Car Parts",5000,
        "Illegal Plate",5000,
        "Smoke Belching",6000*/
}
