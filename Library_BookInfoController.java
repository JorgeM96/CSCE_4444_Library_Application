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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_BookInfoController implements Initializable {

    @FXML public Text bookIDField;
    @FXML public Text bookTitleField;
    @FXML public Text bookGenreField;
    @FXML public Text bookAuthorField;
    @FXML public Text bookPubField;
    @FXML public Text bookPriceField;
    @FXML public Text bookSectionField;
    @FXML public Text bookStatus;

    @FXML public Button returnBtn;
    @FXML public Button editBtn;
    Scene bEditMenuScene;  //scene for edit book
    Scene bMenuScene; //scene for book menu
    
    public void setUpScene(Scene scene0, Scene scene1){
        bEditMenuScene = scene0;
        bMenuScene = scene1;
    }
    
    public void handleReturnBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(bMenuScene);
        stage.show();
    }
    public void handleEditBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(bEditMenuScene);
        stage.show();
    }
    public void setTextFields(String bID, String bTitle, String bGenre, String bAuthor, String bPublisher, String bPrice, String bSection, String bStatus){
        bookIDField.setText(bID);
        bookTitleField.setText(bTitle);
        bookGenreField.setText(bGenre);
        bookAuthorField.setText(bAuthor);
        bookPubField.setText(bPublisher);
        bookPriceField.setText(bPrice);
        bookSectionField.setText(bSection);   
        bookStatus.setText(bStatus);   
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
