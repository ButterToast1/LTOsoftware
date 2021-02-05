package ph.edu.dlsu.lbycpa2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    boolean f1, f2, f3, f4, f5;

    @FXML
    public void clearTextFields()  {
        fNameTextField.clear();
        mNameTextField.clear();
        lNameTextField.clear();
        addressTextField.clear();
        telTextField.clear();
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

        File file = new File("C:\\Users\\Asus\\IdeaProjects\\LTOsoftware\\src\\assets\\renewalDetails");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        f1 = fNameTextField.getText().trim().isEmpty();
        f2 = mNameTextField.getText().trim().isEmpty();
        f3 = lNameTextField.getText().trim().isEmpty();
        f4 = addressTextField.getText().trim().isEmpty();
        f5 = telTextField.getText().trim().isEmpty();

        if (!f1 && !f2 && !f3 && !f4 && !f5) {
            name = fNameTextField.getText() + mNameTextField.getText() + lNameTextField.getText() + " ";
            address = addressTextField.getText() + " ";
            cellphoneNum = telTextField.getText() + " ";

            pw.print(name);
            pw.print(address);
            pw.print(cellphoneNum);
            pw.close();

            window.setScene(tableViewScene);
            window.show();
        }


        else {
            statusLabel.setText("One of the fields is missing.");
        }

    }

}
