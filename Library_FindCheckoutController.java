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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_FindCheckoutController implements Initializable {

    @FXML public TextField checkoutIDField;
    @FXML public TextField userIDField;
    @FXML public TextField itemIDField;
    @FXML public TextField checkoutDField;
    @FXML public TextField dueDateField;
    @FXML public Text checkoutIDText;
    @FXML public Text userIDText;
    @FXML public Text itemIDText;
    @FXML public Text errText;
    @FXML public Text checkoutDateText;
    @FXML public Text dueDateText;
    @FXML public Button cancelBtn;
    @FXML public Button submitBtn;
    @FXML public Button returnBtn;
    private Scene scene3;   //scene for admin menu
    
    public void setAdminMenuScene(Scene scene) {
        scene3 = scene;
    }
    public void handleCancelBtn(ActionEvent event) throws IOException {
        checkoutIDField.clear();
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene3);
        stage.show();
    }
    public void handleSubmitBtn(ActionEvent event) throws IOException {
        String checkoutID = checkoutIDField.getText();
        checkoutIDField.clear();
        
        if(!checkoutID.isEmpty())
        {
            String url = "https://www.pyware.com/api/library/checkout/search/";
            String postData = "&checkoutID="+checkoutID;
            String serverResponse = Library_Mgmt.sendResponse(url,postData);
            if(serverResponse.contains("false"))
            {
                errText.setVisible(true);
            }
            else
            {
                errText.setVisible(false);
                checkoutIDField.setVisible(false);
                checkoutIDText.setVisible(false);
                cancelBtn.setVisible(false);
                submitBtn.setVisible(false);
            
                userIDField.setVisible(true);
                itemIDField.setVisible(true);
                checkoutDField.setVisible(true);
                dueDateField.setVisible(true);
                checkoutDateText.setVisible(true);
                dueDateText.setVisible(true);
                userIDText.setVisible(true);
                itemIDText.setVisible(true);
                returnBtn.setVisible(true);
                String[] arrServerR = serverResponse.split(";");
                if(arrServerR[0].contains("success"))  //Display information received from database to textfields in next scene
                {
                    userIDField.setText(arrServerR[1]);
                    itemIDField.setText(arrServerR[2]);
                    checkoutDField.setText(arrServerR[3]);
                    dueDateField.setText(arrServerR[4]);
                }
            }
        }
    }
    public void handleReturnBtn(ActionEvent event) throws IOException {
        userIDField.clear();
        itemIDField.clear();
        checkoutDField.clear();
        dueDateField.clear();
        
        checkoutIDField.setVisible(true);
        checkoutIDText.setVisible(true);
        cancelBtn.setVisible(true);
        submitBtn.setVisible(true);
            
        userIDField.setVisible(false);
        itemIDField.setVisible(false);
        checkoutDField.setVisible(false);
        dueDateField.setVisible(false);
        checkoutDateText.setVisible(false);
        dueDateText.setVisible(false);
        userIDText.setVisible(false);
        itemIDText.setVisible(false);
        returnBtn.setVisible(false);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene3);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
