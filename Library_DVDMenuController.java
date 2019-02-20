/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_mgmt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_DVDMenuController implements Initializable {

    @FXML public Button returnBtn;
    @FXML public Button addDVDBtn;
    @FXML public Button dvdDirectoryBtn;
    private Scene scene3;   //set menu scene
    private Scene scene24;  //set scene for add dvd
    private Scene scene25;  //scene for dvd directory
    
    public void setMenuFromDVDScene(Scene scene) {
        scene3 = scene;
    }
    public void setAddDVDScene(Scene scene) {
        scene24 = scene;
    }
    public void setDVDDirectoryScene(Scene scene) {
        scene25 = scene;
    }
    public void handleReturnBtn(ActionEvent event) throws IOException {
       Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       stage.setScene(scene3);
       stage.show();
    }
    public void handleAddDVD(ActionEvent event) throws IOException {
       Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       stage.setScene(scene24);
       stage.show();
    }
    public void handleDVDDirectory(ActionEvent event) throws IOException {
       Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       stage.setScene(scene25);
       stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
