/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import models.Candidat;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class VoterController {
      
    @FXML
    private Button refreshbtn;

    @FXML
    private Button btnmmv ;
    
      @FXML
    private VBox radiobtnvbox;
    ToggleGroup tg = new ToggleGroup();
    @FXML
    void refreshh(ActionEvent event) throws SQLException {
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/systemvote","root","");
        ObservableList<Candidat> list = FXCollections.observableArrayList();
        PreparedStatement ps = conn.prepareStatement("select nom,prenom,niveau,info from candidats ");
     
        ResultSet rs = ps.executeQuery();
        
        
        while (rs.next())
        {
            
            RadioButton rb = new RadioButton(rs.getString("nom")+" "+rs.getString("prenom"));
            
            radiobtnvbox.getChildren().add(rb);
            rb.setToggleGroup(tg);
           
        }

    }
    @FXML
    void majnbvotes() throws SQLException{
        String nom= tg.getSelectedToggle().toString().split("'")[1].split(" ")[0];
        String prenom= tg.getSelectedToggle().toString().split("'")[1].split(" ")[1];
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/systemvote","root","");
        PreparedStatement ps = conn.prepareStatement("update candidats set nbr_votes=nbr_votes+1 where nom=? and prenom=?  ");
        ps.setString(1,nom);
        ps.setString(2,prenom);
        ps.execute();  
    }

    @FXML

        void mainmenuv (ActionEvent event) throws IOException {
        
        Stage sigup = new Stage();
                btnmmv.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/Resultat.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("menu");

}

    }
    
 