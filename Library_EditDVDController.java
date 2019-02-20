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
public class Library_EditDVDController implements Initializable {

    @FXML public TextField editDVDTitleF;
    @FXML public TextField editDVDProdF;
    @FXML public TextField editDVDRatingF;
    @FXML public TextField editDVDDurationF;
    @FXML public TextField editDVDPriceF;
    @FXML public TextField editDVDLSectionF;
    @FXML public Button saveBtn;
    @FXML public Button cancelBtn;
    @FXML public Button removeBtn;
    private Scene scene26;  //scene for dvd info
    private Scene scene28; //scene for remove dvd
    
    public void setDVDInfoScene(Scene scene) {
        scene26 = scene;
    }
    public void setRemoveDVDScene(Scene scene) {
        scene28 = scene;
    }
    public void handleCancelBtn(ActionEvent event) {
        editDVDTitleF.clear();
        editDVDProdF.clear();
        editDVDRatingF.clear();
        editDVDPriceF.clear();
        editDVDLSectionF.clear();
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene26);
        stage.show();
    }
    public void handleSaveBtn(ActionEvent event) {
        String editDVDTitle = editDVDTitleF.getText();
        String editDVDProducer = editDVDProdF.getText();
        String editDVDRating = editDVDRatingF.getText();
        String editDVDPrice = editDVDPriceF.getText();
        String editDVDLSection = editDVDLSectionF.getText();
        
        editDVDTitleF.clear();
        editDVDProdF.clear();
        editDVDRatingF.clear();
        editDVDPriceF.clear();
        editDVDLSectionF.clear();
        
        if(!editDVDTitle.isEmpty() && !editDVDProducer.isEmpty() && !editDVDRating.isEmpty() && !editDVDPrice.isEmpty() && !editDVDLSection.isEmpty())
        {
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene26);
            stage.show();
        }
    }
    public void handleRemoveBtn(ActionEvent event) {
        editDVDTitleF.clear();
        editDVDProdF.clear();
        editDVDRatingF.clear();
        editDVDPriceF.clear();
        editDVDLSectionF.clear();
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene28);
        stage.show(); 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
