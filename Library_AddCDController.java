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
public class Library_AddCDController implements Initializable {

    @FXML public TextField cdTitleField;
    @FXML public TextField cdArtistField;
    @FXML public TextField cdTracksField;
    @FXML public TextField cdProducerField;
    @FXML public TextField cdPriceField;
    @FXML public TextField cdLSectionField;
    @FXML public Button submitBtn;
    @FXML public Button cancelBtn;
    private Scene scene12;  //scene for cd menu
    
    public void setCDMScene(Scene scene) {
        scene12 = scene;
    }
    public void handleSubmitBtn(ActionEvent event) throws IOException {
        String cdTitle = cdTitleField.getText();
        String cdArtist = cdArtistField.getText();
        String cdTracks = cdTracksField.getText();
        String cdProducer = cdProducerField.getText();
        String cdPrice = cdPriceField.getText();
        String cdSection = cdLSectionField.getText();
        
        cdTitleField.clear();
        cdArtistField.clear();
        cdTracksField.clear();
        cdProducerField.clear();
        cdPriceField.clear();
        cdLSectionField.clear();
        
        if(!cdTitle.isEmpty() && !cdArtist.isEmpty() && !cdTracks.isEmpty() && !cdProducer.isEmpty() && !cdPrice.isEmpty() && !cdSection.isEmpty())
        {
            // Add CD
            String url = "https://www.pyware.com/api/library/cds/add/";
            String postData = "&title="+cdTitle+"&artist="+cdArtist+"&tracks="+cdTracks
            +"&producer="+cdProducer+"&price="+cdPrice+"&section="+cdSection;
            String serverResponse = Library_Mgmt.sendResponse(url,postData);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene12);
            stage.show();
        }
        
    }
    public void handleCancelBtn(ActionEvent event) throws IOException {
        cdTitleField.clear();
        cdArtistField.clear();
        cdTracksField.clear();
        cdProducerField.clear();
        cdPriceField.clear();
        cdLSectionField.clear();
        
       Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       stage.setScene(scene12);
       stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
