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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Jorge Moreno
           Tate Mosier   */

public class Library_HomeController implements Initializable {
    
    @FXML public Button adminLogin;
    @FXML public Button bookBtn;
    @FXML public Button dvdBtn;
    @FXML public Button cdBtn;
    @FXML public Button searchBtn;
    @FXML public TextField searchBar;
    private Scene scene2;  //scene for admin login
    private Scene scene32;  //scene for search
    
    public String itemSelected;  //holds which item button was pressed
    
    public void setLoginScene(Scene scene) { //setting the value of scene2 
        scene2 = scene;
    }
    public void setSearchScene(Scene scene) {
        scene32 = scene;
    }
    public void handleBookBtn(ActionEvent event) throws IOException {
        itemSelected = "Book";
    }
    public void handleDVDBtn(ActionEvent event) throws IOException {
        itemSelected = "DVD";
    }
    public void handleCDBtn(ActionEvent event) throws IOException {
        itemSelected = "CD";
    }
    public void handleSearchBtn(ActionEvent event) throws IOException {
        String searchTitle = searchBar.getText();
        searchBar.clear();
        if(!itemSelected.isEmpty() && !searchTitle.isEmpty())
        {
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene32); 
            stage.show(); 
        }
    }
    public void handleAdminLogin(ActionEvent event) throws IOException {  //Handling when a user clicks admin login
        //FXMLLoader secondPane = new FXMLLoader(getClass().getResource("Library_AdminLogin.fxml")); //creating a pane for adminlogin fxml
        //Parent node2 = secondPane.load();  //load the pane onto a parent node
        //Library_AdminLoginController controller1 = secondPane.getController(); //Creating a controller for adminlogin scene
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();  //get source for a stage
        stage.setScene(scene2);  //use scene2 for the scene
        stage.show();  //show the next scene
        
    }
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
