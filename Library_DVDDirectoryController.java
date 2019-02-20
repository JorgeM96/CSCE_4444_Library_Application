/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_mgmt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_DVDDirectoryController implements Initializable {

    ObservableList List = FXCollections.observableArrayList();
    @FXML public ChoiceBox<String> dvdSearchBox;
    @FXML public TextField dvdSearchField;
    @FXML public Text errText;
    @FXML public Button submitBtn;
    @FXML public Button cancelBtn;
    private Scene dvdMenuScene; //scene for dvd menu
    private Scene dvdInfoScene; //scene for dvd info
    private Library_DVDInfoController dvdInfoController;

    
    public void setUpScene(Scene scene0, Scene scene1, Library_DVDInfoController controller0) {
        dvdMenuScene = scene0;
        dvdInfoScene = scene1;
        dvdInfoController = controller0;
    }
    
    public void handleCancelBtn(ActionEvent event) throws IOException {
        dvdSearchField.clear();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(dvdMenuScene);
        stage.show();
    }
    public void handleSubmitBtn(ActionEvent event) throws IOException {
        String dvdSearch = dvdSearchBox.getValue();
        String search = dvdSearchField.getText();
       
        if(!dvdSearch.isEmpty() && !search.isEmpty())
        {
            // Search DVD
            String url = "https://www.pyware.com/api/library/dvds/search/";
            String postData = "&itemSearch="+dvdSearch+"&searchData="+search;
            String serverResponse = Library_Mgmt.sendResponse(url,postData);
            
            if(serverResponse.contains("false"))
            {
                errText.setVisible(true);
                dvdSearchBox.setValue(null);
                dvdSearchField.clear();
            }
            else
            {
                errText.setVisible(false);
                dvdSearchBox.setValue(null);
                dvdSearchField.clear();
                String[] arrServerR = serverResponse.split(";");
                if(arrServerR[0].contains("success"))   //Display information received from database to textfields in next scene
                {
                    //edward put code here!
                    dvdInfoController.setTextFields(arrServerR[1], arrServerR[2], arrServerR[3], arrServerR[4], arrServerR[5], arrServerR[6], arrServerR[7], arrServerR[8]);

                    
                    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(dvdInfoScene);
                    stage.show();
                }
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadChoiceBox();
    }    
    public void loadChoiceBox() {
        List.removeAll(List);
        String dvdID = "DVD ID";
        String dvdTitle = "DVD Title";
        List.addAll(dvdID,dvdTitle);
        dvdSearchBox.getItems().addAll(List);
    }
}
