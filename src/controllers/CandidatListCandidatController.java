/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import models.Candidat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class CandidatListCandidatController  {

   



    @FXML
    private Button btnmmlc;

    @FXML
    private TableColumn<Candidat, String> descriptionc;

    @FXML
    private TableColumn<Candidat, String> niveauc;

    @FXML
    private TableColumn<Candidat, String> nomc;

    @FXML
    private TableColumn<Candidat, String> prenomc;

    @FXML
    private Button showbtnc;

    @FXML
    private TableView<Candidat> tableinfoc;

    

    @FXML
    void showinfosc(ActionEvent event) throws SQLException {
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/systemvote","root","");
        ObservableList<Candidat> list = FXCollections.observableArrayList();
        PreparedStatement ps = conn.prepareStatement("select nom,prenom,niveau,info from candidats ");
     
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            list.add(new Candidat(rs.getString("nom"),rs.getString("prenom"),rs.getString("niveau"),rs.getString("info")));
        }
        
        
        nomc.setCellValueFactory(new PropertyValueFactory<Candidat,String>("nom"));
        prenomc.setCellValueFactory(new PropertyValueFactory<Candidat,String>("prenom"));
        niveauc.setCellValueFactory(new PropertyValueFactory<Candidat,String>("niveau"));
        descriptionc.setCellValueFactory(new PropertyValueFactory<Candidat,String>("description"));

        tableinfoc.setItems(list);
    }
     @FXML

        void mainmenulc (ActionEvent event) throws IOException {
        
        Stage sigup = new Stage();
                btnmmlc.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/menuCandidat.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("resultat");

}


}

    

