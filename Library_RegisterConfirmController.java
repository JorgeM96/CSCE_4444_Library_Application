/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_mgmt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 */
public class Library_RegisterConfirmController implements Initializable {

    @FXML public TextField userIDField;
    @FXML public Button returnBtn;
    private Scene scene3;
    private String serverResponse;
    
    public void setMenuScene(Scene scene) {
        scene3 = scene;
    }
    public void setResponseValue(String response) {
        //serverResponse = response;
        //System.out.println(serverResponse);
       // userIDField.setText("test");
       // userIDTArea.setText("deez Nuts");
    }
    public void handleReturnBtn(ActionEvent event) throws IOException {
      //  userIDField.setText("test");
       // userIDTArea.setText("deez Nuts");
       // Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       // stage.setScene(scene3);
       // stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     // System.out.println("Hed is: "+Library_RegisterPatronController.hed);
     // userIDField.setText(Library_Mgmt.sendResponse("https://www.pyware.com/api/library/users/add/", "&malone="+Library_RegisterPatronController.hed));
      //loadTextField();
    }    
  //  public void loadTextField()
   // {
     //   System.out.println("HED is: "+Library_RegisterPatronController.hed);
     //   String test = Library_Mgmt.sendResponse("https://www.pyware.com/api/library/users/add/", "&malone="+Library_RegisterPatronController.hed);
     //   System.out.println("test is: "+test);
  //  }
    
}
