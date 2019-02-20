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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.net.ssl.HttpsURLConnection;

/**
 * FXML Controller class
 *
 * @author Jorge Moreno
 *         Tate Mosier  */
public class Library_AdminLoginController implements Initializable {

    @FXML public Text errorText;
    @FXML public Button loginBtn;
    @FXML public Button cancelBtn;
    @FXML public TextField userField;
    @FXML public PasswordField passField;
    private Scene scene3;  //scene for admin menu
    private Scene scene1;  //scene for home 
    
    public void setMenuScene(Scene scene) {
        scene3 = scene;
    }
    public void setHomeScene(Scene scene) {
        scene1 = scene;
    }
    public void handleCancelBtn(ActionEvent event) throws IOException {
        userField.clear();
        passField.clear();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene1);
        stage.show();
    }
    public void handleLogin(ActionEvent event) throws IOException {
        String username = userField.getText();
        String password = passField.getText();
        userField.clear();
        passField.clear();
        
        if(!username.isEmpty() && !password.isEmpty())
        {
            String url = "https://www.pyware.com/api/library/users/login/";
            String postData = "&username="+username+"&password="+password;

            String serverResponse = Library_Mgmt.sendResponse(url, postData);
            if(!serverResponse.contains("success"))
            {
                errorText.setVisible(true);
            }
            else
            {
                FXMLLoader passUserPane = new FXMLLoader(getClass().getResource("Library_AdminMenu.fxml"));
                Parent nodePUP = passUserPane.load();
                Library_AdminMenuController controller = passUserPane.getController();
                controller.setUserLabel(username);
                
                errorText.setVisible(false);
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene3);
                stage.show();
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
