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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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
public class Library_PatronDirectoryController implements Initializable {

    ObservableList List = FXCollections.observableArrayList();
    @FXML private ChoiceBox<String> searchType;
    @FXML private TextField searchField;
    @FXML public Button submitBtn;
    @FXML public Button cancelBtn;
    @FXML public Text errText;
    private Scene scene3;  //will hold menu scene
    private Scene scene8;  //will hold patron info scene
    private Library_PatronInfoController PatronInfoController; // Controller to the Patron Information Scene
    
    public void setMenuScene(Scene scene) {
        scene3 = scene;
    }
    public void setInfoScene(Scene scene, Library_PatronInfoController controller) {
       scene8 = scene;
       PatronInfoController = controller;
    }
    public void handleCancelBtn(ActionEvent event) throws IOException {
        searchField.clear();
        searchType.setValue(null);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene3);
        stage.show();
    }
    
    public void handleSubmitBtn(ActionEvent event) throws IOException {
        String userSearch = searchType.getValue();
        String search = searchField.getText();
        
        System.out.println(userSearch);
           FXMLLoader InfoPane = new FXMLLoader(getClass().getResource("Library_PatronInfo.fxml"));
           Parent tempNode = InfoPane.load();
           Library_PatronInfoController controller = InfoPane.getController();
           //controller.setSearchValues(userSearch,search);
           //controller.setFields(searchField.getText());
        
        if(!userSearch.isEmpty() && !search.isEmpty())
        {
            String url = "https://www.pyware.com/api/library/users/search/";
            String postData = "&userSearch="+userSearch+"&searchData="+search;
            String serverResponse = Library_Mgmt.sendResponse(url,postData);
            if(serverResponse.contains("false"))
            {
                errText.setVisible(true);
                searchType.setValue(null);
                searchField.clear();
                
            }
            else
            {
                errText.setVisible(false);
                searchType.setValue(null);
                searchField.clear();
                String[] arrServerR = serverResponse.split(";");
                if(arrServerR[0].contains("success")) //Display information received from database to textfields in next scene
                {
                    PatronInfoController.setFields(arrServerR[1], arrServerR[2], arrServerR[3], arrServerR[4], arrServerR[5], arrServerR[6]);
                    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(scene8);
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
        String searchID = "PatronID";
        String searchEmail = "Patron Email";
        List.addAll(searchID,searchEmail);
        searchType.getItems().addAll(List);
    }
    
}
