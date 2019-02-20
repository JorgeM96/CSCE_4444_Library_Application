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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_CDMenuController implements Initializable {

   @FXML public Button addCDBtn;
   @FXML public Button cdDirectoryBtn;
   @FXML public Button returnBtn;
   private Scene scene3; //scene for menu
   private Scene scene19; //scene for add cd
   private Scene scene20; //scene for cd directory
   
   public void setMenuFromCDScene(Scene scene) {
       scene3 = scene;
   }
   public void setCDDirectoryScene(Scene scene) {
       scene20 = scene;
   }
   public void setAddCDScene(Scene scene) {
       scene19 = scene;
   }
   public void handleReturnBtn(ActionEvent event) throws IOException {
       Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       stage.setScene(scene3);
       stage.show();
   }
   public void handleAddCD(ActionEvent event) throws IOException {
       Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       stage.setScene(scene19);
       stage.show();
   }
   public void handleCDDirectory(ActionEvent event) throws IOException {
       Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       stage.setScene(scene20);
       stage.show();
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
