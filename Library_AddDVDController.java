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
    public class Library_AddDVDController implements Initializable {

    @FXML public TextField dvdTitleField;
    @FXML public TextField dvdProdField;
    @FXML public TextField dvdRatingField;
    @FXML public TextField dvdDurationField;
    @FXML public TextField dvdPriceField;
    @FXML public TextField dvdLSectionField;
    @FXML public Button submitBtn;
    @FXML public Button cancelBtn;
    private Scene scene13; //scene for dvd menu
    
    public void setDVDMenuScene(Scene scene) {
        scene13 = scene;
    }
    public void handleSubmitBtn(ActionEvent event) throws IOException {
        String dvdTitle = dvdTitleField.getText();
        String dvdProducer = dvdProdField.getText();
        String dvdRating = dvdRatingField.getText();
        String dvdDuration = dvdDurationField.getText();
        String dvdPrice = dvdPriceField.getText();
        String dvdSection = dvdLSectionField.getText();
        
        dvdTitleField.clear();
        dvdProdField.clear();
        dvdRatingField.clear();
        dvdDurationField.clear();
        dvdPriceField.clear();
        dvdLSectionField.clear();
        
        if(!dvdTitle.isEmpty() && !dvdProducer.isEmpty() && !dvdRating.isEmpty() && !dvdDuration.isEmpty() && !dvdPrice.isEmpty() && !dvdSection.isEmpty())
        {
            // Add DVD
            String url = "https://www.pyware.com/api/library/dvds/add/";
            String postData = "&title="+dvdTitle+"&producer="+dvdProducer+"&rating="+dvdRating+"&duration="+dvdDuration+"&price="+dvdPrice+"&section="+dvdSection;
            String serverResponse = Library_Mgmt.sendResponse(url,postData);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene13);
            stage.show();
        }
    }
    public void handleCancelBtn(ActionEvent event) throws IOException {
        dvdTitleField.clear();
        dvdProdField.clear();
        dvdRatingField.clear();
        dvdDurationField.clear();
        dvdPriceField.clear();
        dvdLSectionField.clear();
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene13);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
