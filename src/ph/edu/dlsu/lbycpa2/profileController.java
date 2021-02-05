package ph.edu.dlsu.lbycpa2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class profileController {

    public TextField emailTextField;
    public TextField pictureLabel;
    public Label name;
    public Label address;
    public Label id;
    public Label statusLabel;
    public ImageView pictureView;
    public Label license;
    public String licenseType;
    public String gender;
    public String birth;
    public String weight;
    public String height;
    public String licenseNumber;
    public String bloodType;
    public String eyeColor;
    public String restriction;
    public String condition;
    public String Fullname;
    public String password;
    public String loc;
    public String exp;
    public String email;
    private Scanner y;

    @FXML
    public void push(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Scene mainMenuScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(mainMenuScene);
        window.show();

        openFile();
        readFile();
        closeFile();
    }

    public void changePicture(ActionEvent event) {
        if (!pictureLabel.getText().trim().isEmpty()) {
            pictureView.setImage(new Image("file:/C:/Users/Asus/IdeaProjects/LTOsoftware/src/assets/" + pictureLabel.getText()));
            statusLabel.setText("picture changed to " + pictureLabel.getText());
        }
        statusLabel.setVisible(true);

        loginController loginObject = new loginController();
        //name.setText(String.valueOf(loginObject.name));

        //if (pictureLabel.getText() == "jian.jpg") {
        //  name.setText("Jian Daniel T. Lasam");
        //  address.setText("Cagayan, Philippines");
        // id.setText("11946342");
        //}

    }

    public void openFile() {
        try {
            y = new Scanner(new File("C:\\Users\\Asus\\IdeaProjects\\LTOsoftware\\src\\assets\\bioData"));
        } catch (Exception e) {
            System.out.println("could not find file");
        }
    }
    public void readFile(){
        licenseType= y.next();
        String firstName = y.next();
        String middleInitial = y.next();
        String lastName = y.next();
        Fullname = firstName + middleInitial + lastName;
        gender=y.next();
        birth=y.next();
        weight=y.next();
        height=y.next();
        loc=y.next();
        licenseNumber=y.next();
        exp=y.next();
        bloodType=y.next();
        eyeColor=y.next();
        restriction=y.next();
        condition=y.next();

        while(y.hasNext() && !email.equals(emailTextField.getText())) {

            email = y.next();
            password = y.next();

            firstName = y.next();
            middleInitial = y.next();
            lastName = y.next();
            Fullname = firstName + " " + middleInitial + " " + lastName;

            System.out.printf("%s %s %s\n", licenseType, Fullname,gender);
        }

        System.out.println("success");
    }

    public void closeFile() {
        y.close();
    }

    }
