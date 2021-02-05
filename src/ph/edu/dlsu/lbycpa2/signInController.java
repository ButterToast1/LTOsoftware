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

    public TextField emailTextField;
    public TextField passwordTextField;
    public Label statusLabel;

    public String fullName;
    public String email;
    public String password;
    private Scanner x;

    @FXML
    public void push(ActionEvent event) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene mainMenuScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        openFile();
        readFile();
        closeFile();
        if (emailTextField.getText().equals(email) && passwordTextField.getText().equals(password)){
            window.setScene(mainMenuScene);
            window.show();
            System.out.println("variable emailTextField is: " + email + " while password is: "+ password);
        }

        else {
            statusLabel.setVisible(true);
            statusLabel.setText("Incorrect username or password.");
        }
    }

    public void openFile() {
        try {
            x = new Scanner(new File("C:\\Users\\Asus\\IdeaProjects\\LTOsoftware\\src\\assets\\accounts"));
        }
        catch (Exception e) {
            System.out.println("could not find file");
        }
    }

    public void readFile() {

        email = x.next();
        password = x.next();

        String firstName = x.next();
        String middleInitial = x.next();
        String lastName = x.next();
        fullName = firstName + middleInitial + lastName;

        while(x.hasNext() && !email.equals(emailTextField.getText())) {

            email = x.next();
            password = x.next();

            firstName = x.next();
            middleInitial = x.next();
            lastName = x.next();
            fullName = firstName + " " + middleInitial + " " + lastName;

            System.out.printf("%s %s %s\n", email, password, fullName);
        }

        System.out.println("success");
    }

    public void closeFile() {
        x.close();
    }
}
