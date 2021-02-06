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
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class profileController extends signInController {

    public String signInEmail;
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
    public String profileEmail;

    public Label Label1;
    public Label Label2;
    public Label Label3;
    public Label Label4;
    public Label Label5;
    public Label Label6;
    public Label Label7;
    public Label Label8;
    public Label Label9;
    public Label Label10;
    public Label Label11;
    public Label Label12;
    public Label Label13;
    public Label Label14;
    public Label Label15;

    private Scanner y;
    private Scanner x;

    @FXML
    public void push(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Scene mainMenuScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(mainMenuScene);
        window.show();

    }

    public void changePicture(ActionEvent event) {
        if (!pictureLabel.getText().trim().isEmpty()) {
            pictureView.setImage(new Image("file:/C:/Users/User/IdeaProjects/LTOsoftware/src/assets/" + pictureLabel.getText()));
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

    @FXML
    public void initialize() throws IOException {
        try {
            y = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\bioData"));
        } catch (Exception e) {
            System.out.println("could not find file");
        }

        try {
            x = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\profile"));
        } catch (Exception e) {
            System.out.println("could not find file");
        }



        readFile();
    }

    @FXML
    public String readFile() throws IOException {
        File file = new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\profile");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        email = y.next();
        licenseType= y.next();
        String profilefirstName = y.next();
        String profilemiddleInitial = y.next();
        String profilelastName = y.next();
        Fullname = profilefirstName + profilemiddleInitial + profilelastName;
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

        Label1.setText(licenseType);
        Label2.setText(Fullname);
        Label3.setText(gender);
        Label4.setText(birth);
        Label5.setText(weight);
        Label6.setText(loc);
        Label7.setText(licenseNumber);
        Label8.setText(exp);
        Label9.setText(bloodType);
        Label10.setText(eyeColor);
        Label11.setText(restriction);
        Label12.setText(condition);
        Label13.setText(email);


        signInEmail = x.next();

        while(x.hasNext()) {

            signInEmail = x.next();
            System.out.println(signInEmail);
        }

        System.out.println("The signInEmail is: " + signInEmail);
            while(y.hasNext() && !email.equals(signInEmail)) {

                email = y.next();
                licenseType= y.next();
                profilefirstName = y.next();
                profilemiddleInitial = y.next();
                profilelastName = y.next();
                Fullname = profilefirstName + profilemiddleInitial + profilelastName;
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

                Label1.setText(licenseType);
                Label2.setText(Fullname);
                Label3.setText(gender);
                Label4.setText(birth);
                Label5.setText(weight);
                Label6.setText(loc);
                Label7.setText(licenseNumber);
                Label8.setText(exp);
                Label9.setText(bloodType);
                Label10.setText(eyeColor);
                Label11.setText(restriction);
                Label12.setText(condition);
                Label13.setText(email);
            }

        x.close();

        y.close();

        System.out.println("success");
        return profilefirstName;
    }

    public void closeFile() {
        y.close();
    }

    }
