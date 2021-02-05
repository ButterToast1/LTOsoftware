package ph.edu.dlsu.lbycpa2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class mainMenuController {


    @FXML
    public void changeScreenButtontoProfile(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("profile.fxml"));
        Scene profileScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(profileScene);
        window.show();


    }

    public void changeScreenButtontoRegistration(ActionEvent event) throws IOException {
        Parent tableViewParent2 = FXMLLoader.load(getClass().getResource("application.fxml"));
        Scene registrationScene = new Scene(tableViewParent2);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(registrationScene);
        window.show();
    }

    public void changeScreenButtontoPayment(ActionEvent event) throws IOException {
        Parent tableViewParent3 = FXMLLoader.load(getClass().getResource("payment.fxml"));
        Scene paymentScene = new Scene(tableViewParent3);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(paymentScene);
        window.show();
    }

    public void exit(ActionEvent event) throws IOException{
        System.exit(0);
    }
}
