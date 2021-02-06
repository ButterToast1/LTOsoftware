package ph.edu.dlsu.lbycpa2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class mainMenuController {

    private Scanner x;
    public String condition;

    public TextField email;
    public TextField prof;
    public TextField fName;
    public TextField mName;
    public TextField lName;
    public TextField gender;
    public TextField dateOfBirth;
    public TextField weight;
    public TextField height;
    public TextField province;
    public TextField licenseNum;
    public TextField expDate;
    public TextField bloodType;
    public TextField eyeColor;
    public TextField restrictions;
    public TextField condOfBody;




    @FXML
    public void changeScreenButtontoProfile(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("profile.fxml"));
        Scene profileScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();


        Parent signUpParent = FXMLLoader.load(getClass().getResource("signUpFields.fxml"));
        Scene signUpScene = new Scene(signUpParent);

        //This line gets the Stage information
        Stage signUpWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        try {
            x = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\conditions"));
        }
        catch (Exception e) {
            System.out.println("could not find file");
        }

        while(x.hasNext()) {
            condition = x.next();
        }

        System.out.println(condition);
        if (condition.equals("true")) {

            signUpWindow.setScene(signUpScene);
            signUpWindow.show();

        }
        else {
            window.setScene(profileScene);
            window.show();
        }
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

    public void exit(ActionEvent event){
        System.exit(0);
    }

    public void print(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("profile.fxml"));
        Scene profileScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();


        File file = new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\bioData");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.print(email.getText());
        pw.print(" ");
        pw.print(prof.getText());
        pw.print(" ");
        pw.print(fName.getText());
        pw.print(" ");
        pw.print(mName.getText());
        pw.print(" ");
        pw.print(lName.getText());
        pw.print(" ");
        pw.print(gender.getText());
        pw.print(" ");
        pw.print(dateOfBirth.getText());
        pw.print(" ");
        pw.print(weight.getText());
        pw.print(" ");
        pw.print(height.getText());
        pw.print(" ");
        pw.print(province.getText());
        pw.print(" ");
        pw.print(licenseNum.getText());
        pw.print(" ");
        pw.print(expDate.getText());
        pw.print(" ");
        pw.print(bloodType.getText());
        pw.print(" ");
        pw.print(eyeColor.getText());
        pw.print(" ");
        pw.print(restrictions.getText());
        pw.print(" ");
        pw.print(condOfBody.getText());

        pw.close();

        window.setScene(profileScene);
        window.show();
    }


}
