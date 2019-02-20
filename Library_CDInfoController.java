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
public class Library_CDInfoController implements Initializable {

    @FXML public Text cdIDField;
    @FXML public Text cdTitleField;
    @FXML public Text cdArtistField;
    @FXML public Text cdTracksField;
    @FXML public Text cdProdField;
    @FXML public Text cdPriceField;
    @FXML public Text cdSectionField;
    @FXML public Text cdStatusField;
    
    @FXML public Button returnBtn;
    @FXML public Button editBtn;
    
    private Scene cdMenuScene;  //scene for cd menu
    private Scene cdEditScene;  //scene for edit cd
    
    public void setUpScene(Scene scene0, Scene scene1) {
        cdMenuScene = scene0;
        cdEditScene = scene1;
    }
    
    public void handleReturnBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cdMenuScene);
        stage.show();
    }
    public void handleEditBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cdEditScene);
        stage.show();
    }
    
    public void setTextFields(String cdID, String cdTitle, String cdArtist, String cdTracks, String cdProducer, String cdPrice, String cdSection, String cdStatus){
        cdIDField.setText(cdID);
        cdTitleField.setText(cdTitle);
        cdArtistField.setText(cdArtist);
        cdTracksField.setText(cdTracks);
        cdProdField.setText(cdProducer);
        cdPriceField.setText(cdPrice);
        cdSectionField.setText(cdSection);
        cdStatusField.setText(cdStatus);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
