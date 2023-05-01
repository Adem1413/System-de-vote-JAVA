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
public class UsermainController implements Initializable {

   @FXML
    private Button btncandidat;

    @FXML
    private Button btnelecteur;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void tosignupelecteur(ActionEvent event) throws IOException {
        Stage sigup = new Stage();
                btnelecteur.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/SignUp.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("SIGNUP");
    
    

}
   
  public void tosignupcandidat(ActionEvent event) throws IOException {
        Stage sigup = new Stage();
                btncandidat.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/candidatSignUp.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("SIGNUP CANDIDAT");
  }

}



