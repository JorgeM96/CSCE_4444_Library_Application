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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_PatronFeesController implements Initializable {

    @FXML public TextField fineField;
    @FXML public TextField addFineField;
    @FXML public TextField removeFineField;
    @FXML public Button submitBtn;
    @FXML public Button returnBtn;
    private Scene scene8;  //scene for directory
    
    public void setDirectoryScene(Scene scene) {
        scene8 = scene;
    }
    public void handleSubmitBtn(ActionEvent event) throws IOException {
        String addFine = addFineField.getText();
        String removeFine = removeFineField.getText();
        addFineField.clear();
        removeFineField.clear();
        if(!addFine.isEmpty() && !removeFine.isEmpty())
        {
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene8);
            stage.show();
        }
        
    }
    public void handleReturnBtn(ActionEvent event) throws IOException {
        addFineField.clear();
        removeFineField.clear();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene8);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
