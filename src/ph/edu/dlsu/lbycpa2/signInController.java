package ph.edu.dlsu.lbycpa2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class signInController {

    public TextField nameTextField;
    public TextField passwordTextField;
    public Label statusLabel;

    public String name1;
    public String password;
    private Scanner x;
    boolean breaker = false;

    @FXML
    public void push(ActionEvent event) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene mainMenuScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        openFile();
        readFile();
        closeFile();
        if (nameTextField.getText().equals(name1) && passwordTextField.getText().equals(password)){
            window.setScene(mainMenuScene);
            window.show();
        }

        else {
            statusLabel.setVisible(true);
            statusLabel.setText("Incorrect username or password.");
        }
    }

    public void openFile() {
        try {
            x = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\accounts"));
        }
        catch (Exception e) {
            System.out.println("could not find file");
        }
    }

    public void readFile() {
        int i;

        name1 = x.next();
        password = x.next();

        while(x.hasNext() && !name1.equals(nameTextField.getText())) {
            name1 = x.next();
            password = x.next();

            System.out.printf("%s %s\n", name1, password);
        }
        System.out.println("success");
    }

    public void closeFile() {
        x.close();
    }
}
