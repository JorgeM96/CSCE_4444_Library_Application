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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_AddBookController implements Initializable {
    
    @FXML public TextField bookTitleField;
    @FXML public TextField bookGenreField;
    @FXML public TextField bookAuthorField;
    @FXML public TextField bookPubField;
    @FXML public TextField bookPriceField;
    @FXML public TextField libSectionField;
    @FXML public Button bookSubmitBtn;
    @FXML public Button cancelBtn;
    private Scene scene9;  //scene for book menu
    
    public void setReturnBMScene(Scene scene) {
        scene9 = scene;
    }
    public void handleSubmitBtn(ActionEvent event) throws IOException {
        String bookTitle = bookTitleField.getText();
        String bookGenre = bookGenreField.getText();
        String bookAuthor = bookAuthorField.getText();
        String bookPublisher = bookPubField.getText();
        String bookPrice = bookPriceField.getText();
        String libSection = libSectionField.getText();
        
        bookTitleField.clear();
        bookGenreField.clear();
        bookAuthorField.clear();
        bookPubField.clear();
        bookPriceField.clear();
        libSectionField.clear();
        
        if(!bookTitle.isEmpty() && !bookGenre.isEmpty() && !bookAuthor.isEmpty() && !bookPublisher.isEmpty() && !bookPrice.isEmpty() && !libSection.isEmpty())
        {
            
            String url = "https://www.pyware.com/api/library/books/add/";
            String postData = "&title="+bookTitle+"&genre="+bookGenre+"&author="+bookAuthor
            +"&publisher="+bookPublisher+"&price="+bookPrice+"&section="+libSection;
            String serverResponse = Library_Mgmt.sendResponse(url,postData);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene9);
            stage.show();
        }
    }
    public void handleCancelBtn(ActionEvent event) throws IOException {
        bookTitleField.clear();
        bookGenreField.clear();
        bookAuthorField.clear();
        bookPubField.clear();
        bookPriceField.clear();
        libSectionField.clear();
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene9);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
