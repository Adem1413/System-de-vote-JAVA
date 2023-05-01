package controllers;


import models.Rescandidat;
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
public class ResultatController {
    
    @FXML
    private Button btnmmr;
   
    @FXML
    private Button btnres;    
    
    @FXML
    private TableColumn<Rescandidat, Integer> nbvoter;

    
    @FXML
    private TableColumn<Rescandidat,String> nomr;

    @FXML
    private TableColumn<Rescandidat,String> prenomr;

    @FXML
    private TableView<Rescandidat> tabres;
   
    @FXML
    void consultresultat(ActionEvent event) throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/systemvote","root","");
        ObservableList<Rescandidat> list = FXCollections.observableArrayList();
        PreparedStatement ps = conn.prepareStatement("select nom,prenom,nbr_votes from candidats ");
     
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            list.add(new Rescandidat(rs.getString("nom"),rs.getString("prenom"),Integer.parseInt(rs.getString("nbr_votes"))));
        }
        
        
        nomr.setCellValueFactory(new PropertyValueFactory<Rescandidat,String>("nom"));
        prenomr.setCellValueFactory(new PropertyValueFactory<Rescandidat,String>("prenom"));
        nbvoter.setCellValueFactory(new PropertyValueFactory<Rescandidat,Integer>("nbr_votes"));
        
        tabres.setItems(list);
    }
    @FXML

        void mainmenur (ActionEvent event) throws IOException {
        
        Stage sigup = new Stage();
                btnmmr.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/menuCandidat.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("menu");

}

}

    

