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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_BookDirectoryController implements Initializable {

    ObservableList List = FXCollections.observableArrayList();
    @FXML public ChoiceBox<String> bookSearchBox;
    @FXML public TextField bookSearchField;
    @FXML public Text errText;
    @FXML public Button submitBtn;
    @FXML public Button cancelBtn;
    
    private Scene bMenuScene;  //scene for book menu
    private Scene bInfoScene;  //scene for book info
    private Library_BookInfoController BookInfoController;  // Controller of the book information scene
    
    // Establishes connections to appropritate scenes and controller
    public void setUpScene(Scene scene0, Scene scene1, Library_BookInfoController controller0){
        bMenuScene = scene0;
        bInfoScene = scene1;
        BookInfoController = controller0;
    }

    public void handleCancelBtn(ActionEvent event) throws IOException {
        bookSearchField.clear();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(bMenuScene);
        stage.show();
    }
    public void handleSubmitBtn(ActionEvent event) throws IOException {
        String bookSearch = bookSearchBox.getValue();
        String search = bookSearchField.getText();
       
        if(!bookSearch.isEmpty() && !search.isEmpty()){
            // Search book
            String url = "https://www.pyware.com/api/library/books/search/";
            String postData = "&itemSearch="+bookSearch+"&searchData="+search;
            String serverResponse = Library_Mgmt.sendResponse(url,postData);
            
            if(serverResponse.contains("false")){
                errText.setVisible(true);
                bookSearchBox.setValue(null);
                bookSearchField.clear();
            }
            else{
                errText.setVisible(false);
                bookSearchBox.setValue(null);
                bookSearchField.clear();
                String[] arrServerR = serverResponse.split(";");
                if(arrServerR[0].contains("success")){ //Display information received from database to textfields in next scene
                    System.out.println(arrServerR);
                    BookInfoController.setTextFields(arrServerR[1], arrServerR[2], arrServerR[3], arrServerR[4], arrServerR[5], arrServerR[6], arrServerR[7], arrServerR[8]);
                    
                    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    stage.setScene(bInfoScene);
                    stage.show();
                }
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadChoiceBox();
    }
    
    public void loadChoiceBox() {
        List.removeAll(List);
        String bookID = "Book ID";
        String bookTitle = "Book Title";
        List.addAll(bookID,bookTitle);
        bookSearchBox.getItems().addAll(List);
    }
}
