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
public class Library_BooksMenuController implements Initializable {

    @FXML public Button addBtn;
    @FXML public Button bDirectoryBtn;
    @FXML public Button returnBtn;
    private Scene scene3;  //scene for menu
    private Scene scene14; //scene for add book
    private Scene scene15; //scene for book directory
  
    public void setAddBookScene(Scene scene) {
        scene14 = scene;
    }
    public void setMenuFromBookScene(Scene scene) {
        scene3 = scene;
    }
    public void setBookDScene(Scene scene) {
        scene15 = scene;
    }
    public void handleAddBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene14);
        stage.show();
    }
    public void handleBDirectory(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene15);
        stage.show();
    }
    public void handleReturnBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene3);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
