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
public class Library_CheckinController implements Initializable {

    @FXML public TextField checkoutIDField;
    @FXML public Text checkoutIDText;
    @FXML public Text checkinText;
    @FXML public Text errText;
    @FXML public Button submitBtn;
    @FXML public Button cancelBtn;
    @FXML public Button returnBtn;
    private Scene scene3;  //scene for admin menu
    
    public void setAdminMenuScene(Scene scene) {
        scene3 = scene;
    }
    public void handleSubmitBtn(ActionEvent event) throws IOException {
        String checkoutID = checkoutIDField.getText();
        checkoutIDField.clear();
        
        if(!checkoutID.isEmpty())
        {
            String url = "https://www.pyware.com/api/library/checkin/";
            String postData = "&checkoutID="+checkoutID;
            String serverResponse = Library_Mgmt.sendResponse(url,postData);
            String[] arrServerR = serverResponse.split(";");
            
            if(serverResponse.contains("success"))
            {
                checkoutIDField.setVisible(false);
                submitBtn.setVisible(false);
                cancelBtn.setVisible(false);
                checkoutIDText.setVisible(false);
                errText.setVisible(false);
            
                returnBtn.setVisible(true);
                checkinText.setVisible(true);
            }
            else
            {
                errText.setVisible(true);
            }
        }
    }
    public void handleCancelBtn(ActionEvent event) throws IOException {
        checkoutIDField.clear();
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene3);
        stage.show();
    }
    public void handleReturnBtn(ActionEvent event) throws IOException {
        checkoutIDField.setVisible(true);
        submitBtn.setVisible(true);
        cancelBtn.setVisible(true);
        checkoutIDText.setVisible(true);
            
        returnBtn.setVisible(false);
        checkinText.setVisible(false);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene3);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
