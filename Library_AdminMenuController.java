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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moren
 */
public class Library_AdminMenuController implements Initializable {

    @FXML public Button regBtn;
    @FXML public Button directoryBtn;
    @FXML public Button bookBtn;
    @FXML public Button cdBtn;
    @FXML public Button dvdBtn;
    @FXML public Button checkoutBtn;
    @FXML public Button checkinBtn;
    @FXML public Button findCBtn;
    @FXML public Label userLabel;
    private String usernameLabel;  //username for label 
    private Scene homeS;  //scene for home 
    private Scene registerPS;  //scene for registering patron
    private Scene patronDS;  //scene for patron information
    private Scene booksMS;  //scene for books menu
    private Scene cdsMS;  //scene for cds menu
    private Scene dvdsMS;  //scene for dvds menu
    private Scene checkoutS;  //scene for checkout 
    private Scene checkinS;  //scene for checkin
    private Scene findcheckoutS;  //scene for finding checkout
    
    public void setHomeScene(Scene scene) {  //set value of homeS (home fxml scene)
        homeS = scene;
    }
    public void setRegisterPScene(Scene scene) {
        registerPS = scene;
    }
    public void setPatronDScene(Scene scene) {
        patronDS = scene;
    }
    public void setBooksScene(Scene scene) {
        booksMS = scene;
    }
    public void setCDsScene(Scene scene) {
        cdsMS = scene;
    }
    public void setDVDsScene(Scene scene) {
        dvdsMS = scene;
    }
    public void setCheckoutScene(Scene scene) {
        checkoutS = scene;
    }
    public void setCheckinScene(Scene scene) {
        checkinS = scene;
    }
    public void setFindCheckoutScene(Scene scene) {
        findcheckoutS = scene;
    }
   public void setUserLabel(String username) { //Not working
       usernameLabel = username;
       userLabel.setText(username);
   }    
    public void handleSignOut(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(homeS);  //use home fxml scene
        stage.show();
    }
    public void handlePRegister(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(registerPS);  //use home fxml scene
        stage.show();
    }
    
    public void handlePDirectory(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(patronDS);  //use home fxml scene
        stage.show();
    }
   
    public void handleBooks(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(booksMS);
        stage.show();
    }
    
    public void handleCDs(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cdsMS);
        stage.show();
    }
    
    public void handleDVDs(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(dvdsMS);
        stage.show();
    }
    
    public void handleCheckout(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(checkoutS);  //use checkout fxml scene
        stage.show();
    }
    
    public void handleCheckin(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(checkinS);  //use checkin fxml scene
        stage.show();
    }
    
    public void handleFCheckout(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(findcheckoutS);  //use findCheckout fxml scene
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
