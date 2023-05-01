/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class MenuCandidatController  {
   @FXML
    private Button btnlcav1c;

    @FXML
    private Button btnlogoutc;

    @FXML
    private Button btnrav1c;
     @FXML
   
         void lcc (ActionEvent event) throws IOException {
        
        Stage sigup = new Stage();
                btnlcav1c.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/candidatListCandidat.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("resultat");

}
     @FXML
   void rcc (ActionEvent event) throws IOException {
        
        Stage sigup = new Stage();
                btnrav1c.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/Resultat.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("resultat");

}
       @FXML
   void loc (ActionEvent event) throws IOException {
        
        Stage sigup = new Stage();
                btnlogoutc.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/usermain.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("resultat");

}
    
    
}
