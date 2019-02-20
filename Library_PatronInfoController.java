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
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_PatronInfoController implements Initializable {

    @FXML public Text userIDField;
    @FXML public Text nameField;
    @FXML public Text addressField;
    @FXML public Text emailField;
    @FXML public Text phoneField;
    @FXML public Text userTypeField;
    @FXML public Button editBtn;
    @FXML public Button finesBtn;
    @FXML public Button returnBtn;
    
    String patronIDMain;
    
    private Scene menuScene;  //scene for menu
    private Scene editPatronScene;  //scene for edit
    private Scene finesScene;  //scene for fines
    private Library_EditPatronController editPatronController;
    
    private String userSearch;
    private String search;
    
    public void setUpScene(Scene scene0, Scene scene1, Scene scene2, Library_EditPatronController controller0){
        menuScene = scene0;
        editPatronScene = scene1;
        finesScene = scene2;
        editPatronController = controller0;
    }
    
    public void setMenuScene(Scene scene) {
        menuScene = scene;
    }
    public void setEditScene(Scene scene) {
        editPatronScene = scene;
    }
    public void setFinesScene(Scene scene) {
        finesScene = scene;
    }
    public void setFields(String userID, String userType, String name, String address, String email, String phone) {
        patronIDMain = userID;
        userIDField.setText(userID);
        userTypeField.setText(userType);
        nameField.setText(name);
        addressField.setText(address);
        emailField.setText(email);
        phoneField.setText(phone);
    }
    public void handleEditBtn(ActionEvent event) throws IOException {
        System.out.println(patronIDMain);
            System.out.print("\\");
            System.out.print("\\");
            String url = "https://www.pyware.com/api/library/users/search/";
            String postData = "&userSearch=PatronID&searchData="+patronIDMain;
            String serverResponse = Library_Mgmt.sendResponse(url,postData);

        //Check that response is success
        String[] arrServerR = serverResponse.split(";");
        
        if(arrServerR[0].contains("success"))
        {
            String[] name = arrServerR[3].split(" ");
            editPatronController.setFields(name[0], name[1], arrServerR[4], arrServerR[5], arrServerR[6], arrServerR[1]);

            
            
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(editPatronScene);
            stage.show();
        }
    }
    public void handleFinesBtn(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(finesScene);
        stage.show();
    }
    public void handleReturnBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(menuScene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
