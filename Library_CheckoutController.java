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
public class Library_CheckoutController implements Initializable {

    @FXML public TextField userIDField;
    @FXML public TextField itemIDField;
    @FXML public TextField checkoutIDField;
    @FXML public Button submitBtn;
    @FXML public Button cancelBtn;
    @FXML public Button returnBtn;
    @FXML public Button bookBtn;
    @FXML public Button cdBtn;
    @FXML public Button dvdBtn;
    @FXML public Text confirmText;
    @FXML public Text userIDText;
    @FXML public Text itemIDText;
    @FXML public Text checkoutIDText;
    @FXML public Text errText;
    private Scene scene3;  //scene for admin menu
    public String itemType;
    
    public void setAdminMenuScene(Scene scene) {
        scene3 = scene;
    }
    public void handleBookBtn(ActionEvent event) throws IOException {
        itemType = "Book";
    }
    public void handleCDBtn(ActionEvent event) throws IOException {
        itemType = "CD";
    }
    public void handleDVDBtn(ActionEvent event) throws IOException {
        itemType = "DVD";
    }
    public void handleSubmitBtn(ActionEvent event) throws IOException {
        String userID = userIDField.getText();
        String itemID = itemIDField.getText();
        userIDField.clear();
        itemIDField.clear();
        
        if(!userID.isEmpty() && !itemID.isEmpty() && !itemType.isEmpty())
        {
            String url = "https://www.pyware.com/api/library/checkout/";
            String postData = "&userID="+userID+"&itemID="+itemID+"&itemType="+itemType;
            String serverResponse = Library_Mgmt.sendResponse(url,postData);
            String[] arrServerR = serverResponse.split(";");
            
            if(serverResponse.contains("success"))
            {
                userIDField.setVisible(false);
                itemIDField.setVisible(false);
                submitBtn.setVisible(false);
                cancelBtn.setVisible(false);
                userIDText.setVisible(false);
                itemIDText.setVisible(false);
                bookBtn.setVisible(false);
                cdBtn.setVisible(false);
                dvdBtn.setVisible(false);
                errText.setVisible(false);
            
                checkoutIDField.setVisible(true);
                returnBtn.setVisible(true);
                confirmText.setVisible(true);
                checkoutIDText.setVisible(true);
                
                checkoutIDField.setText(arrServerR[1]);
            }
            else
            {
                errText.setVisible(true);
            }
        }
        itemType = "";
    }
    public void handleCancelBtn(ActionEvent event) throws IOException {
        userIDField.clear();
        itemIDField.clear();
        itemType = "";
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene3);
        stage.show();
    }
    public void handleReturnBtn(ActionEvent event) throws IOException {
        checkoutIDField.clear();
        
        userIDField.setVisible(true);
        itemIDField.setVisible(true);
        submitBtn.setVisible(true);
        cancelBtn.setVisible(true);
        userIDText.setVisible(true);
        itemIDText.setVisible(true);
        bookBtn.setVisible(true);
        cdBtn.setVisible(true);
        dvdBtn.setVisible(true);
            
        checkoutIDField.setVisible(false);
        returnBtn.setVisible(false);
        confirmText.setVisible(false);
        checkoutIDText.setVisible(false);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene3);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
