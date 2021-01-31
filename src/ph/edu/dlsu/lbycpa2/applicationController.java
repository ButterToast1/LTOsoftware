package ph.edu.dlsu.lbycpa2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


import javafx.stage.Stage;


public class applicationController {


    public TextField fNameTextField;
    public TextField mNameTextField;
    public TextField lNameTextField;
    public TextField addressTextField;
    public TextField telTextField;
    public Label statusLabel;

    public String name;
    public String address;
    public String cellphoneNum;

    boolean f1, f3, f4;
    // Button clear, submit;
    // String name,address,tel,tin,nationality;

    @FXML
    public void clearTextFields()  {
        fNameTextField.clear();
        mNameTextField.clear();
        lNameTextField.clear();
        addressTextField.clear();
        telTextField.clear();
        //regionField.clear();
        //officeField.clear();
    }


    public void popToMainMenu(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
    public void popToNextApp(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("application2.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        f1 = fNameTextField.getText().trim().isEmpty();
        f3 = lNameTextField.getText().trim().isEmpty();
        f4 = addressTextField.getText().trim().isEmpty();



        if (!f1 && !f3 && !f4){
            window.setScene(tableViewScene);
            window.show();

            name = fNameTextField.getText() + " " + lNameTextField.getText();
            address = addressTextField.getText();
            // cellphoneNum = telTextField.getText();

        }

        else {
            statusLabel.setText("One of the fields is missing.");
        }

    }

}
