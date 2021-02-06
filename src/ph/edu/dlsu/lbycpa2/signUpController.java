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

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class signUpController {

    public TextField nameTextField;
    public TextField emailTextField;
    public TextField passwordTextField;
    public Label statusLabel;

    public String fullName;
    public String email;
    public String password;
    private Scanner x;

    public int n;

    @FXML
    public void push(ActionEvent event) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene mainMenuScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        File file = new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\conditions");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        openFile();
        writeFile();
        readFile();
        closeFile();

        if (emailTextField.getText().equals(email) && passwordTextField.getText().equals(password)){
            pw.println("true");
            pw.close();

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
            //y = new Formatter("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\accounts");
        }
        catch (Exception e) {
            System.out.println("could not find file");
        }
    }

    public void writeFile() throws IOException {
        System.out.println("TEST");

        File file = new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\accounts");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        email = emailTextField.getText() + " ";
        password = passwordTextField.getText() + " ";
        fullName = nameTextField.getText();


        pw.print(email);
        pw.print(password);
        pw.println(fullName);

        pw.close();
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

        }

    }



    public void closeFile() {
        x.close();
    }





}
