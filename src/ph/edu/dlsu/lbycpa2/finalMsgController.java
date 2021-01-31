package ph.edu.dlsu.lbycpa2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;
import java.io.IOException;

public class finalMsgController {

    int n = 0;

    HashMap<String,LinkedList<String>> adjList = new HashMap<>();

    @FXML
    public void initialize() {
        applicationController object = new applicationController();
        applicationController2 object2 = new applicationController2();

        addEdge(object.name, object2.office);
        addEdge(object.address, object.name);

        if (!object.f5) {
            addEdge(object.cellphoneNum, object.name);
        }


    }

    void addEdge(String src, String dest)
    {
        if (!adjList.containsKey(src))
        {
            LinkedList<String> nodes = new LinkedList<>();
            nodes.add(dest);
            adjList.put(src, nodes);
            n++;
        }
        else
        {
            LinkedList<String> nodes = adjList.get(src);
            nodes.add(dest);
            adjList.put(src, nodes);
        }
    }

    Set getNodes()
    {
        return adjList.keySet();
    }



    public void popToNextApp(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }
}
