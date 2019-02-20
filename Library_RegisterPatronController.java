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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_RegisterPatronController implements Initializable {
    public static String hed = "";
    
   @FXML public TextField userIDField;  //just added
   @FXML public Button returnBtn;  //just added
   @FXML public Text userIDText;  //just added
   
   @FXML public TextField patronFNField;
   @FXML public TextField patronLNField;
   @FXML public TextField patronSAField;
   @FXML public TextField patronEField;
   @FXML public TextField patronPNField;
   @FXML public TextField userF;
   @FXML public PasswordField passF;
   @FXML public Text userText;
   @FXML public Text passText;
   @FXML public Text userType;
   @FXML public Label firstN;
   @FXML public Label lastN;
   @FXML public Label SA;
   @FXML public Label Email;
   @FXML public Label PN;
   @FXML public Button userTP;
   @FXML public Button userTS;
   @FXML public Button finalRegBtn;
   @FXML public Button cancelBtn;
   private String userRegister;
   private Scene scene3;  //scene for menu
   private Scene scene10;  //Scene for confirm
   
   public void setReturnMenuS(Scene scene) {
       scene3 = scene;
   }
   public void setConfirmScene(Scene scene) {
       scene10 = scene;
   }
   
   public void enableFields(ActionEvent event) throws IOException {
           userF.setVisible(true);
           passF.setVisible(true);
           userText.setVisible(true);
           passText.setVisible(true);
           userRegister = "Staff";
   }
   public void disableFields(ActionEvent event) throws IOException {
           userF.setVisible(false);
           passF.setVisible(false);
           userText.setVisible(false);
           passText.setVisible(false);
           userRegister = "Patron";
   }
   public void HandleFinalRegister(ActionEvent event) throws IOException {
       
       String firstName = patronFNField.getText();
       String lastName = patronLNField.getText();
       String address = patronSAField.getText();
       String email = patronEField.getText();
       String phoneN = patronPNField.getText();
       String username = userF.getText();
       String password = passF.getText();
      
       patronFNField.clear();
       patronLNField.clear();
       patronSAField.clear();
       patronEField.clear();
       patronPNField.clear();
       userF.clear();
       passF.clear();
       if(!firstName.isEmpty() && !lastName.isEmpty() && !address.isEmpty() && !email.isEmpty() && !phoneN.isEmpty())
       {
           String url = "https://www.pyware.com/api/library/users/add/";
           String postData = "&username="+username+"&password="+password+"&firstName="+firstName+"&lastName="+lastName+"&address="+address+"&email="+email+"&phone="+phoneN+"&role="+userRegister;
           String serverResponse = Library_Mgmt.sendResponse(url, postData);
           //Check that response is success
           String[] arrServerR = serverResponse.split(";",2);

           
           if(serverResponse.contains("success"))
           {
              userIDText.setVisible(true);
              userIDField.setVisible(true);
              returnBtn.setVisible(true);
              patronFNField.setVisible(false);
              patronLNField.setVisible(false);
              patronSAField.setVisible(false);
              patronEField.setVisible(false);
              patronPNField.setVisible(false);
              
              userType.setVisible(false);
              firstN.setVisible(false);
              lastN.setVisible(false);
              SA.setVisible(false);
              Email.setVisible(false);
              PN.setVisible(false);
              
              userF.setVisible(false);
              passF.setVisible(false);
              userText.setVisible(false);
              passText.setVisible(false);
              userTP.setVisible(false);
              userTS.setVisible(false);
              finalRegBtn.setVisible(false);
              cancelBtn.setVisible(false);
              
              userIDField.setText(arrServerR[1]);
              
              
            //Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            //stage.setScene(scene10);
            //stage.show();
           }
           //else display try again stay same scene and clear values
       }
       /*Else put an error message telling them to re-enter correct information */
      
   }
   
   public void handleReturnBtn(ActionEvent event) throws IOException {
       userIDField.clear();
       userIDText.setVisible(false);
       userIDField.setVisible(false);
              returnBtn.setVisible(false);
              patronFNField.setVisible(true);
              patronLNField.setVisible(true);
              patronSAField.setVisible(true);
              patronEField.setVisible(true);
              patronPNField.setVisible(true);
              userType.setVisible(true);
              firstN.setVisible(true);
              lastN.setVisible(true);
              SA.setVisible(true);
              Email.setVisible(true);
              PN.setVisible(true);
              userF.setVisible(true);
              passF.setVisible(true);
              userText.setVisible(true);
              passText.setVisible(true);
              userTP.setVisible(true);
              userTS.setVisible(true);
              finalRegBtn.setVisible(true);
              cancelBtn.setVisible(true);
       Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       stage.setScene(scene3);
       stage.show();
       }
   public void handleCancelBtn(ActionEvent event) throws IOException {
       
       patronFNField.clear();
       patronLNField.clear();
       patronSAField.clear();
       patronEField.clear();
       patronPNField.clear();
       userF.clear();
       passF.clear();
       Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       stage.setScene(scene3);
       stage.show();
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
