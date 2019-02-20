/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_mgmt;

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
public class Library_RemoveDVDController implements Initializable {

    @FXML Button removeBtn;
    @FXML Button cancelBtn;
    private Scene scene27;  //scene for edit dvd
    
    public void setEditDVDScene(Scene scene) {
        scene27 = scene;
    }
    public void handleRemoveBtn(ActionEvent event) {
        
    }
    public void handleCancelBtn(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene27);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
