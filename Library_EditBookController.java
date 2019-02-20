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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_EditBookController implements Initializable {

    @FXML public Button saveBtn;
    @FXML public Button cancelBtn;
    @FXML public Button removeBtn;
    @FXML public TextField editBookTF;
    @FXML public TextField editBookGF;
    @FXML public TextField editBookAF;
    @FXML public TextField editBookPubF;
    @FXML public TextField editBookPF;
    @FXML public TextField editBookLSF;
    private Scene scene17;  //scene for book info
    private Scene scene18;  //scene for remove book
    
    public void setCancelBScene(Scene scene) {
        scene17 = scene;
    }
    public void setRemoveBookScene(Scene scene) {
        scene18 = scene;
    }
    public void handleSaveBtn(ActionEvent event) {
        String editBookTitle = editBookTF.getText();
        String editBookGenre = editBookGF.getText();
        String editBookAuthor = editBookAF.getText();
        String editBookPublisher = editBookPubF.getText();
        String editBookPrice = editBookPF.getText();
        String editBookLSection = editBookLSF.getText();
        
        editBookTF.clear();
        editBookGF.clear();
        editBookAF.clear();
        editBookPubF.clear();
        editBookPF.clear();
        editBookLSF.clear();
        
        if(!editBookTitle.isEmpty() && !editBookGenre.isEmpty() && !editBookAuthor.isEmpty() && !editBookPublisher.isEmpty() && !editBookPrice.isEmpty() && !editBookLSection.isEmpty())
        {
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene17);
            stage.show();
        }
    }
    public void handleCancelBtn(ActionEvent event) {
        editBookTF.clear();
        editBookGF.clear();
        editBookAF.clear();
        editBookPubF.clear();
        editBookPF.clear();
        editBookLSF.clear();
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene17);
        stage.show();
    }
    public void handleRemoveBtn(ActionEvent event) {
        editBookTF.clear();
        editBookGF.clear();
        editBookAF.clear();
        editBookPubF.clear();
        editBookPF.clear();
        editBookLSF.clear();
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene18);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
