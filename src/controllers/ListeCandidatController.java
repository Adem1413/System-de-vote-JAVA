/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;


import models.Candidat;
import java.io.IOException;
import java.sql.DriverManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ListeCandidatController {

    @FXML
    private TableColumn<Candidat, String> nom;

    @FXML
    private TableColumn<Candidat, String> prenom;

     @FXML
    private TableColumn<Candidat, String> description;

     @FXML
    private TableColumn<Candidat, Integer> nbr_votes;

    @FXML
    private TableColumn<Candidat, String> niveau;

    

    @FXML
        private Button showbtn;
     
    @FXML
        private Button btnmml;
    
    @FXML
    private TableView<Candidat> tableinfo;

    @FXML
    void showinfos(ActionEvent event) throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/systemvote","root","");
        ObservableList<Candidat> list = FXCollections.observableArrayList();
        PreparedStatement ps = conn.prepareStatement("select nom,prenom,niveau,info from candidats ");
     
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            list.add(new Candidat(rs.getString("nom"),rs.getString("prenom"),rs.getString("niveau"),rs.getString("info")));
        }
        
        
        nom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("prenom"));
        niveau.setCellValueFactory(new PropertyValueFactory<Candidat,String>("niveau"));
        description.setCellValueFactory(new PropertyValueFactory<Candidat,String>("description"));

        tableinfo.setItems(list);
    }
    
    @FXML

        void mainmenul (ActionEvent event) throws IOException {
        
        Stage sigup = new Stage();
                btnmml.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/mainMenu.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("resultat");

}

}

