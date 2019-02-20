/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_mgmt;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Jorge Moreno
 *         Tate Mosier
 */
public class Library_Mgmt extends Application {
    
    public static String sendResponse(String url, String postData) {
    HttpsURLConnection conn = null;
    String libraryServerResponse = "";

    try {
    	//...setup connection
    	URL serverURL = new URL(url);
    	conn = (HttpsURLConnection) serverURL.openConnection();
    	conn.setDoOutput(true);
    	conn.setInstanceFollowRedirects(false);
    	conn.setRequestMethod("POST");
    	conn.setUseCaches(false);
    
    	//...write
    	DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
    	wr.write(postData.getBytes(StandardCharsets.UTF_8));
	  
    	//...get response
    	BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    	String line;
    	while ((line = reader.readLine()) != null)
    		libraryServerResponse +=line;

        System.out.println("\nLibrary Server Responded with: "+libraryServerResponse);
   	
    }catch(Exception e) {
    	e.printStackTrace();
    	// this occurs when no internet or url not found
    	System.out.println("Unable to connect with the Library Server: "+e.getMessage());
    	
    }finally {
    	//...cleanup
        if (conn!=null) conn.disconnect();
    }
    
    if(libraryServerResponse.isEmpty())
    	// this occurs when we have internet but missing php
    	System.out.println("No response from the Library Server.");
    
    return libraryServerResponse;
    }
    
    @Override
    public void start(Stage stage) throws IOException {
        
        /* -------- Creating/Initializing a scene for each fxml file -------- */
        FXMLLoader firstPane = new FXMLLoader(getClass().getResource("Library_Home.fxml"));
        Parent root = firstPane.load();
        Scene scene1 = new Scene(root,900,600);
        
        FXMLLoader secondPane = new FXMLLoader(getClass().getResource("Library_AdminLogin.fxml"));
        Parent node2 = secondPane.load();
        Scene scene2 = new Scene(node2,900,600);
        
        FXMLLoader thirdPane = new FXMLLoader(getClass().getResource("Library_AdminMenu.fxml"));
        Parent node3 = thirdPane.load();
        Scene scene3 = new Scene(node3,900,600);
        
        FXMLLoader fourthPane = new FXMLLoader(getClass().getResource("Library_RegisterPatron.fxml"));
        Parent node4 = fourthPane.load();
        Scene scene4 = new Scene(node4,900,600);
        
        FXMLLoader fifthPane = new FXMLLoader(getClass().getResource("Library_EditPatron.fxml"));
        Parent node5 = fifthPane.load();
        Scene scene5 = new Scene(node5,900,600); 
        
        FXMLLoader sixthPane = new FXMLLoader(getClass().getResource("Library_PatronDirectory.fxml"));
        Parent node6 = sixthPane.load();
        Scene scene6 = new Scene(node6,900,600);
        
        FXMLLoader seventhPane = new FXMLLoader(getClass().getResource("Library_PatronFees.fxml"));
        Parent node7 = seventhPane.load();
        Scene scene7 = new Scene(node7,900,600);
        
        FXMLLoader eighthPane = new FXMLLoader(getClass().getResource("Library_PatronInfo.fxml"));
        Parent node8 = eighthPane.load();
        Scene scene8 = new Scene(node8,900,600);
        
        FXMLLoader ninthPane = new FXMLLoader(getClass().getResource("Library_BooksMenu.fxml"));
        Parent node9 = ninthPane.load();
        Scene scene9 = new Scene(node9,900,600);
        
        FXMLLoader tenthPane = new FXMLLoader(getClass().getResource("Library_RegisterConfirm.fxml"));
        Parent node10 = tenthPane.load();
        Scene scene10 = new Scene(node10,600,400);
        
        FXMLLoader pane11 = new FXMLLoader(getClass().getResource("Library_RemoveConfirm.fxml"));
        Parent node11 = pane11.load();
        Scene scene11 = new Scene(node11,600,400);
        
        FXMLLoader pane12 = new FXMLLoader(getClass().getResource("Library_CDMenu.fxml"));
        Parent node12 = pane12.load();
        Scene scene12 = new Scene(node12,900,600);
        
        FXMLLoader pane13 = new FXMLLoader(getClass().getResource("Library_DVDMenu.fxml"));
        Parent node13 = pane13.load();
        Scene scene13 = new Scene(node13,900,600);
        
        FXMLLoader pane14 = new FXMLLoader(getClass().getResource("Library_AddBook.fxml"));
        Parent node14 = pane14.load();
        Scene scene14 = new Scene(node14,900,600);
        
        FXMLLoader pane15 = new FXMLLoader(getClass().getResource("Library_BookDirectory.fxml"));
        Parent node15 = pane15.load();
        Scene scene15 = new Scene(node15,900,600);
        
        FXMLLoader pane16 = new FXMLLoader(getClass().getResource("Library_EditBook.fxml"));
        Parent node16 = pane16.load();
        Scene scene16 = new Scene(node16,900,600);
        
        FXMLLoader pane17 = new FXMLLoader(getClass().getResource("Library_BookInfo.fxml"));
        Parent node17 = pane17.load();
        Scene scene17 = new Scene(node17,900,600);
        
        FXMLLoader pane18 = new FXMLLoader(getClass().getResource("Library_RemoveBook.fxml"));
        Parent node18 = pane18.load();
        Scene scene18 = new Scene(node18,600,400);
        
        FXMLLoader pane19 = new FXMLLoader(getClass().getResource("Library_AddCD.fxml"));
        Parent node19 = pane19.load();
        Scene scene19 = new Scene(node19,900,600);
        
        FXMLLoader pane20 = new FXMLLoader(getClass().getResource("Library_CDDirectory.fxml"));
        Parent node20 = pane20.load();
        Scene scene20 = new Scene(node20,900,600);
        
        FXMLLoader pane21 = new FXMLLoader(getClass().getResource("Library_CDInfo.fxml"));
        Parent node21 = pane21.load();
        Scene scene21 = new Scene(node21,900,600);
        
        FXMLLoader pane22 = new FXMLLoader(getClass().getResource("Library_EditCD.fxml"));
        Parent node22 = pane22.load();
        Scene scene22 = new Scene(node22,900,600);
        
        FXMLLoader pane23 = new FXMLLoader(getClass().getResource("Library_RemoveCD.fxml"));
        Parent node23 = pane23.load();
        Scene scene23 = new Scene(node23,600,400);
        
        FXMLLoader pane24 = new FXMLLoader(getClass().getResource("Library_AddDVD.fxml"));
        Parent node24 = pane24.load();
        Scene scene24 = new Scene(node24,900,600);
        
        FXMLLoader pane25 = new FXMLLoader(getClass().getResource("Library_DVDDirectory.fxml"));
        Parent node25 = pane25.load();
        Scene scene25 = new Scene(node25,900,600);
        
        FXMLLoader pane26 = new FXMLLoader(getClass().getResource("Library_DVDInfo.fxml"));
        Parent node26 = pane26.load();
        Scene scene26 = new Scene(node26,900,600);
        
        FXMLLoader pane27 = new FXMLLoader(getClass().getResource("Library_EditDVD.fxml"));
        Parent node27 = pane27.load();
        Scene scene27 = new Scene(node27,900,600);
        
        FXMLLoader pane28 = new FXMLLoader(getClass().getResource("Library_RemoveDVD.fxml"));
        Parent node28 = pane28.load();
        Scene scene28 = new Scene(node28,600,400);
        
        FXMLLoader pane29 = new FXMLLoader(getClass().getResource("Library_Checkout.fxml"));
        Parent node29 = pane29.load();
        Scene scene29 = new Scene(node29,900,600);
        
        FXMLLoader pane30 = new FXMLLoader(getClass().getResource("Library_Checkin.fxml"));
        Parent node30 = pane30.load();
        Scene scene30 = new Scene(node30,900,600);
        
        FXMLLoader pane31 = new FXMLLoader(getClass().getResource("Library_FindCheckout.fxml"));
        Parent node31 = pane31.load();
        Scene scene31 = new Scene(node31,900,600);
        
        FXMLLoader pane32 = new FXMLLoader(getClass().getResource("Library_Search.fxml"));
        Parent node32 = pane32.load();
        Scene scene32 = new Scene(node32,900,600);
        
        /* -------- A controller must have the scene they want to switch to passed as a variable to reference to ------------ */
        
        Library_HomeController firstPaneC = (Library_HomeController) firstPane.getController();
        Library_HomeController searchPaneC = (Library_HomeController) firstPane.getController();
        Library_AdminLoginController secondPaneC = (Library_AdminLoginController) secondPane.getController();
        Library_AdminMenuController returnMenuPaneC = (Library_AdminMenuController) thirdPane.getController();
        Library_AdminMenuController registerPPaneC = (Library_AdminMenuController) thirdPane.getController();
        Library_AdminMenuController patronDPaneC = (Library_AdminMenuController) thirdPane.getController();
        Library_RegisterPatronController returnMenuPaneC2 = (Library_RegisterPatronController) fourthPane.getController();
        Library_RegisterPatronController menuPaneC = (Library_RegisterPatronController) fourthPane.getController();
        Library_PatronDirectoryController returnMenuPaneC3 = (Library_PatronDirectoryController) sixthPane.getController();
        
            Library_PatronInfoController patronInfoController = (Library_PatronInfoController) eighthPane.getController();

        Library_PatronDirectoryController patronInfoPaneC = (Library_PatronDirectoryController) sixthPane.getController();
        Library_AdminMenuController booksMenuPaneC = (Library_AdminMenuController) thirdPane.getController();
        Library_AdminLoginController returnHomePaneC = (Library_AdminLoginController) secondPane.getController();
        
            Library_EditPatronController editPatronController = (Library_EditPatronController) fifthPane.getController();
            
        Library_PatronFeesController patronFinePaneC = (Library_PatronFeesController) seventhPane.getController();
        Library_RegisterConfirmController confirmPaneC = (Library_RegisterConfirmController) tenthPane.getController();
        Library_RemoveConfirmController returnEditPaneC = (Library_RemoveConfirmController) pane11.getController();
        Library_BooksMenuController bookReturnMenuC = (Library_BooksMenuController) ninthPane.getController();
        Library_CDMenuController cdReturnMenuC = (Library_CDMenuController) pane12.getController();
        Library_DVDMenuController dvdReturnMenuC = (Library_DVDMenuController) pane13.getController();
        Library_AdminMenuController cdsMenuPaneC = (Library_AdminMenuController) thirdPane.getController();
        Library_AdminMenuController dvdsMenuPaneC = (Library_AdminMenuController) thirdPane.getController();
        Library_BooksMenuController addBookPaneC = (Library_BooksMenuController) ninthPane.getController();
        Library_AddBookController returnBookMenuC = (Library_AddBookController) pane14.getController();
        Library_BooksMenuController bookDirectoryPaneC = (Library_BooksMenuController) ninthPane.getController();
            
            Library_BookDirectoryController bDirectoryController = (Library_BookDirectoryController) pane15.getController();
            Library_BookInfoController bInfoController = (Library_BookInfoController) pane17.getController();
            
        Library_EditBookController cancelButtonC = (Library_EditBookController) pane16.getController();
        Library_EditBookController removeBookC = (Library_EditBookController) pane16.getController();
        Library_RemoveBookController returnEditBookC = (Library_RemoveBookController) pane18.getController();
        Library_CDMenuController addCDPaneC = (Library_CDMenuController) pane12.getController();
        Library_CDMenuController cdDirectoryPaneC = (Library_CDMenuController) pane12.getController();
        Library_AddCDController returnCDSceneC = (Library_AddCDController) pane19.getController();
        
            Library_CDDirectoryController cdDirectoryController = (Library_CDDirectoryController) pane20.getController();
            Library_CDInfoController cdInfoController = (Library_CDInfoController) pane21.getController();
        
        Library_EditCDController returnCDInfoC = (Library_EditCDController) pane22.getController();
        Library_EditCDController removeCDPaneC = (Library_EditCDController) pane22.getController();
        Library_RemoveCDController returnEditCDC = (Library_RemoveCDController) pane23.getController();
        Library_DVDMenuController addDVDPaneC = (Library_DVDMenuController) pane13.getController();
        Library_AddDVDController returnDVDMenuC = (Library_AddDVDController) pane24.getController();
        Library_DVDMenuController dvdDirectoryPaneC = (Library_DVDMenuController) pane13.getController();
        
            Library_DVDDirectoryController dvdDirectoryController = (Library_DVDDirectoryController) pane25.getController();
            Library_DVDInfoController dvdInfoController = (Library_DVDInfoController) pane26.getController();
        
        Library_EditDVDController returnDVDInfoC = (Library_EditDVDController) pane27.getController();
        Library_EditDVDController removeDVDPaneC = (Library_EditDVDController) pane27.getController();
        Library_RemoveDVDController returnEditDVDC = (Library_RemoveDVDController) pane28.getController();
        Library_CheckoutController returnAdminMenu = (Library_CheckoutController) pane29.getController();
        Library_AdminMenuController checkoutPaneC = (Library_AdminMenuController) thirdPane.getController();
        Library_AdminMenuController checkinPaneC = (Library_AdminMenuController) thirdPane.getController();
        Library_CheckinController returnAdminMenu2 = (Library_CheckinController) pane30.getController();
        Library_AdminMenuController findCheckoutC = (Library_AdminMenuController) thirdPane.getController();
        Library_FindCheckoutController returnAdminMenu3 = (Library_FindCheckoutController) pane31.getController();
        Library_SearchController returnHomeC = (Library_SearchController) pane32.getController();
        
        firstPaneC.setLoginScene(scene2);
        searchPaneC.setSearchScene(scene32);
        secondPaneC.setMenuScene(scene3);
        returnMenuPaneC.setHomeScene(scene1);
        registerPPaneC.setRegisterPScene(scene4);
        patronDPaneC.setPatronDScene(scene6);
        returnMenuPaneC2.setConfirmScene(scene10);
        menuPaneC.setReturnMenuS(scene3);
        returnMenuPaneC3.setMenuScene(scene3);
        
            patronInfoController.setUpScene(scene3, scene5, scene7, editPatronController);
            patronInfoPaneC.setInfoScene(scene8, patronInfoController);
            
        booksMenuPaneC.setBooksScene(scene9);
        returnHomePaneC.setHomeScene(scene1);
        
            editPatronController.setUpScene(scene11, scene8);
            
        patronFinePaneC.setDirectoryScene(scene8);
        confirmPaneC.setMenuScene(scene3);
        returnEditPaneC.setReturnEditScene(scene5);
        bookReturnMenuC.setMenuFromBookScene(scene3);
        cdReturnMenuC.setMenuFromCDScene(scene3);
        dvdReturnMenuC.setMenuFromDVDScene(scene3);
        cdsMenuPaneC.setCDsScene(scene12);
        dvdsMenuPaneC.setDVDsScene(scene13);
        addBookPaneC.setAddBookScene(scene14);
        returnBookMenuC.setReturnBMScene(scene9);
        bookDirectoryPaneC.setBookDScene(scene15);
        
            bDirectoryController.setUpScene(scene9, scene17, bInfoController);
            bInfoController.setUpScene(scene16, scene9);
            
        cancelButtonC.setCancelBScene(scene17);
        removeBookC.setRemoveBookScene(scene18);
        returnEditBookC.setReturnEScene(scene16);
        addCDPaneC.setAddCDScene(scene19);
        cdDirectoryPaneC.setCDDirectoryScene(scene20);
        returnCDSceneC.setCDMScene(scene12);
        
            cdDirectoryController.setUpScene(scene12, scene21, cdInfoController);
            cdInfoController.setUpScene(scene12, scene22);
        
        returnCDInfoC.setCDInfoScene(scene21);
        removeCDPaneC.setRemoveCDScene(scene23);
        returnEditCDC.setEditCDScene(scene22);
        addDVDPaneC.setAddDVDScene(scene24);
        returnDVDMenuC.setDVDMenuScene(scene13);
        dvdDirectoryPaneC.setDVDDirectoryScene(scene25);
            dvdDirectoryController.setUpScene(scene13, scene26, dvdInfoController);
            dvdInfoController.setUpScene(scene13, scene27);
        returnDVDInfoC.setDVDInfoScene(scene26);
        removeDVDPaneC.setRemoveDVDScene(scene28);
        returnEditDVDC.setEditDVDScene(scene27);
        returnAdminMenu.setAdminMenuScene(scene3);
        checkoutPaneC.setCheckoutScene(scene29);
        checkinPaneC.setCheckinScene(scene30);
        returnAdminMenu2.setAdminMenuScene(scene3);
        findCheckoutC.setFindCheckoutScene(scene31);
        returnAdminMenu3.setAdminMenuScene(scene3);
        returnHomeC.setHomeScene(scene1); 

        
        stage.setTitle("Library System");
        stage.setScene(scene1);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
