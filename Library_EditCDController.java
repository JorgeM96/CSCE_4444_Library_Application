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
public class Library_EditCDController implements Initializable {

    @FXML public TextField editCDTitleF;
    @FXML public TextField editCDArtistF;
    @FXML public TextField editCDTracksF;
    @FXML public TextField editCDProdF;
    @FXML public TextField editCDPriceF;
    @FXML public TextField editCDSectionF;
    @FXML public Button saveBtn;
    @FXML public Button cancelBtn;
    @FXML public Button removeBtn;
    private Scene scene21;  //scene for cd info
    private Scene scene23;  //scene for remove cd
    
    public void setRemoveCDScene(Scene scene) {
        scene23 = scene;
    }
    public void setCDInfoScene(Scene scene) {
        scene21 = scene;
    }
    public void handleCancelBtn(ActionEvent event)  {
        editCDTitleF.clear();
        editCDArtistF.clear();
        editCDTracksF.clear();
        editCDProdF.clear();
        editCDPriceF.clear();
        editCDSectionF.clear();
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene21);
        stage.show();
    }
    public void handleSaveBtn(ActionEvent event) {
        String editCDTitle = editCDTitleF.getText();
        String editCDArtist = editCDArtistF.getText();
        String editCDTracks = editCDTracksF.getText();
        String editCDProd = editCDProdF.getText();
        String editCDPrice = editCDPriceF.getText();
        String editCDLSection = editCDSectionF.getText();
        
        editCDTitleF.clear();
        editCDArtistF.clear();
        editCDTracksF.clear();
        editCDProdF.clear();
        editCDPriceF.clear();
        editCDSectionF.clear();
        
        if(!editCDTitle.isEmpty() && !editCDArtist.isEmpty() && !editCDTracks.isEmpty() && !editCDProd.isEmpty() && !editCDPrice.isEmpty() && !editCDLSection.isEmpty())
        {
           Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
           stage.setScene(scene21);
           stage.show(); 
        }    
        
    }
    public void handleRemoveBtn(ActionEvent event) {
        editCDTitleF.clear();
        editCDArtistF.clear();
        editCDTracksF.clear();
        editCDProdF.clear();
        editCDPriceF.clear();
        editCDSectionF.clear();
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene23);
        stage.show(); 
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
