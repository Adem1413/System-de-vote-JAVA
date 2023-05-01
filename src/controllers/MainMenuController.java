/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author DELL
 */
public class MainMenuController  {

    @FXML
    private Button resultmainmenu;
    
    @FXML
    private Button menucandidatbtn;
    
    @FXML
    private Button votebtn;

    @FXML
    void menulistcandidat(ActionEvent event) throws IOException {
        
        Stage sigup = new Stage();
                menucandidatbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/listeCandidat.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("listecandidat");

}
    @FXML
    void menulistvote(ActionEvent event) throws IOException {
        
        Stage sigup = new Stage();
                votebtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/voter.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("vote");

}

    @FXML

        void menuresult(ActionEvent event) throws IOException {
        
        Stage sigup = new Stage();
                votebtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/Resultat.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("resultat");

}

}
