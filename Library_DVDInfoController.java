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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_DVDInfoController implements Initializable {

    @FXML public Text dvdIDField;
    @FXML public Text dvdTitleField;
    @FXML public Text dvdProdField;
    @FXML public Text dvdRatingField;
    @FXML public Text dvdDurationField;
    @FXML public Text dvdPriceField;
    @FXML public Text dvdLSectionField;
    @FXML public Text dvdStatus;

    @FXML public Button returnBtn;
    @FXML public Button editBtn;
    private Scene dvdMenuScene;  //scene for dvd menu
    private Scene dvdEditScene;  //scene for edit dvd
    
    public void setUpScene(Scene scene0, Scene scene1) {
        dvdMenuScene = scene0;
        dvdEditScene = scene1;
    }
    
    public void setDVDMenuScene(Scene scene) {
        dvdMenuScene = scene;
    }
    public void setEditDVDScene(Scene scene) {
        dvdEditScene = scene;
    }
    public void handleReturnBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(dvdMenuScene);
        stage.show();
    }
    public void handleEditBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(dvdEditScene);
        stage.show();
    }
    
    public void setTextFields(String dvdID, String dvdTitle, String dvdProducer, String dvdRating, String dvdDuration, String dvdPrice, String dvdSection, String dvdStat){
        dvdIDField.setText(dvdID);
        dvdTitleField.setText(dvdTitle);
        dvdProdField.setText(dvdProducer);
        dvdRatingField.setText(dvdRating);
        dvdDurationField.setText(dvdDuration);
        dvdPriceField.setText(dvdPrice);
        dvdLSectionField.setText(dvdSection);
        dvdStatus.setText(dvdStat);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
