package ph.edu.dlsu.lbycpa2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class applicationController2 {

    public TextField regionField;
    public TextField officeField;
    public Label statusLabel;

    public String region;
    public String office;

    boolean p1, p2;


    public void clearTextFields() {
        regionField.clear();
        officeField.clear();
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
        File file = new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\renewalDetails");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        p1 = regionField.getText().trim().isEmpty();
        p2 = officeField.getText().trim().isEmpty();

        if (!p1 && !p2) {
            region = regionField.getText() + " ";
            office = officeField.getText();

            System.out.printf("%s%s", region, office);
            pw.print(region);
            pw.print(office);

            pw.close();

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("finalMsg.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        }

        else {
            statusLabel.setText("One of the fields is missing.");
        }



    }
}
