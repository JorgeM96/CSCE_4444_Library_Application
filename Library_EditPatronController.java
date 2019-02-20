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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_EditPatronController implements Initializable {
    
    @FXML public TextField editFNField;
    @FXML public TextField editLNField;
    @FXML public TextField editAField;
    @FXML public TextField editEField;
    @FXML public TextField editPNField;
    @FXML public Label patronID;
    @FXML public Button saveBtn;
    @FXML public Button cancelBtn;
    @FXML public Button removeBtn;
    private Scene patronInfoScene;
    private Scene removeScene;  //setup scene for remove confirm
    
    public void setUpScene(Scene scene0, Scene scene1){
        removeScene = scene0;
        patronInfoScene = scene1;
    }
    
    public void handleSaveBtn(ActionEvent event) throws IOException {
        String firstNEdit = editFNField.getText();
        String lastNEdit = editLNField.getText();
        String addressEdit = editAField.getText();
        String emailEdit = editEField.getText();
        String phoneEdit = editPNField.getText();
        editFNField.clear();
        editLNField.clear();
        editAField.clear();
        editEField.clear();
        editPNField.clear();
        if(!firstNEdit.isEmpty() && !lastNEdit.isEmpty() && !addressEdit.isEmpty() && !emailEdit.isEmpty() && !phoneEdit.isEmpty())
        {
         //   +"&userID="+
            
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(patronInfoScene);
            stage.show();
        }
        
    }
    public void handleCancelBtn(ActionEvent event) throws IOException {
        editFNField.clear();
        editLNField.clear();
        editAField.clear();
        editEField.clear();
        editPNField.clear();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(patronInfoScene);
        stage.show();
    }
    public void handleRemoveBtn(ActionEvent event) throws IOException {
        editFNField.clear();
        editLNField.clear();
        editAField.clear();
        editEField.clear();
        editPNField.clear();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(removeScene);
        stage.show();
    }
    
    public void setFields(String firstName, String lastName, String address, String email, String phoneNumber, String id) {
        editFNField.setText(firstName);
        editLNField.setText(lastName);
        editAField.setText(address);
        editEField.setText(email);
        editPNField.setText(phoneNumber);
        patronID.setText(id);
    }    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
