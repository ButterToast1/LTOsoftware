package ph.edu.dlsu.lbycpa2;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    public TextField name;
    public TextField password;
    public Label statusLabel;

    @FXML
    public VBox vbox;
    public Parent fxml;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 20);
        try{
            fxml = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
            vbox.getChildren().removeAll();
            vbox.getChildren().setAll(fxml);

        }catch(IOException ex){

        }
        t.play();
        t.setOnFinished((e) -> {

        });
    }

    @FXML
    private void open_signIn(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) -> {
            try{
                System.out.println("test");
                fxml = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);


            }catch(IOException ex){
                ex.printStackTrace();

            }
        });


    }


    @FXML
    private void open_SignUp(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(0);
        t.play();
        t.setOnFinished((e) -> {
            try{
                fxml = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);

            }catch(IOException ex){


            }
        });
    }


}
