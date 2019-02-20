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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_SearchController implements Initializable {

    @FXML public Label itemType;
    @FXML public Label itemID;
    @FXML public Label itemTitle;
    @FXML public Label itemProp1;
    @FXML public Label itemProp2;
    @FXML public Label itemProp3;
    @FXML public Label itemPrice;
    @FXML public Label itemSection;
    @FXML public TextField itemIDField;
    @FXML public TextField itemTitleField;
    @FXML public TextField itemProp1Field;
    @FXML public TextField itemProp2Field;
    @FXML public TextField itemProp3Field;
    @FXML public TextField itemPriceField;
    @FXML public TextField itemSectionField;
    @FXML public Button returnBtn;
    private Scene scene1;  //scene for library home
    
    public void setHomeScene(Scene scene) {
        scene1 = scene;
    }
    public void handleReturnBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene1);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemIDField.setText("Cant touch this dudududududu");
    }   
    
}
