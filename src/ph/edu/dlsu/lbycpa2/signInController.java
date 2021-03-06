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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
            profileController profileName = new profileController();

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
            x = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\accounts"));
        }
        catch (Exception e) {
            System.out.println("could not find file");
        }
    }

    public String readFile() throws IOException{
        File file = new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\profile");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        File file2 = new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\conditions");
        FileWriter fw2 = new FileWriter(file2, true);
        PrintWriter pw2 = new PrintWriter(fw2);

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

        pw.println(email);
        pw.close();

        pw2.println("false");
        pw2.close();

        return email;
    }

    public void closeFile() {
        x.close();
    }
}
