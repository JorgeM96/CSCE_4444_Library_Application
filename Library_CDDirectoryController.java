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
public class Library_CDDirectoryController implements Initializable {

    ObservableList List = FXCollections.observableArrayList();
    @FXML public ChoiceBox<String> cdSearchBox;
    @FXML public TextField cdSearchField;
    @FXML public Text errText;
    @FXML public Button submitBtn;
    @FXML public Button cancelBtn;
    
    private Scene cdMenuScene; //scene for cd menu
    private Scene cdInfoScene; //scene for cd info
    private Library_CDInfoController cdInfoController;
    
    public void setUpScene(Scene scene0, Scene scene1, Library_CDInfoController controller0) {
        cdMenuScene = scene0;
        cdInfoScene = scene1;
        cdInfoController = controller0;
    }

    public void handleCancelBtn(ActionEvent event) throws IOException {
        cdSearchField.clear();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cdMenuScene);
        stage.show();
    }
    public void handleSubmitBtn(ActionEvent event) throws IOException {
        String cdSearch = cdSearchBox.getValue();
        String search = cdSearchField.getText();
       
        if(!cdSearch.isEmpty() && !search.isEmpty())
        {   
            // Search CD
            String url = "https://www.pyware.com/api/library/cds/search/";
            String postData = "&itemSearch="+cdSearch+"&searchData="+search;
            String serverResponse = Library_Mgmt.sendResponse(url,postData);
            
            if(serverResponse.contains("false"))
            {
                errText.setVisible(true);
                cdSearchBox.setValue(null);
                cdSearchField.clear();
            }
            else
            {    
                errText.setVisible(false);
                cdSearchBox.setValue(null);
                cdSearchField.clear();
                String[] arrServerR = serverResponse.split(";");
                if(arrServerR[0].contains("success")) //Display information received from database to textfields in next scene
                {
                    System.out.println(arrServerR);
                    //Edward put code here!
                    cdInfoController.setTextFields(arrServerR[1], arrServerR[2], arrServerR[3], arrServerR[4], arrServerR[5], arrServerR[6], arrServerR[7], arrServerR[8]);
                    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(cdInfoScene);
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
        String cdID = "CD ID";
        String cdTitle = "CD Title";
        List.addAll(cdID,cdTitle);
        cdSearchBox.getItems().addAll(List);
    }
    
}
