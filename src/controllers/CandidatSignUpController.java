/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.sql.DriverManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

   
public class CandidatSignUpController  {
   
    @FXML
    private Button btnSignupc;
     @FXML
    private Button btnloginsc;

    @FXML
    private TextField infoc;

    @FXML
    private TextField niveauc;

    @FXML
    private TextField nomc;

    @FXML
    private PasswordField passwordc;

    @FXML
    private TextField prenomc;

    @FXML
    private TextField usernamec;
 @FXML
     void signupc (ActionEvent event) throws SQLException, IOException   {
        
        String nom = nomc.getText();
        String prenom = prenomc.getText();
        String username = usernamec.getText();
        String password = passwordc.getText();
        String info = infoc.getText();
        String niveau = niveauc.getText();
        
        try {
       
        Connection conn =   DriverManager.getConnection("jdbc:mysql://localhost/systemvote","root","");
        String sql = "INSERT INTO candidats (nom,prenom,niveau,info,username,password) VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,nom);
        statement.setString(2,prenom);
        statement.setString(3,niveau);
        statement.setString(4,info);
        statement.setString(5,username);
        statement.setString(6,password);
        statement.execute();
        JOptionPane.showMessageDialog(null, "Account Successfully added");
         Stage logp = new Stage();
                      btnSignupc.getScene().getWindow().hide();
                      Parent rootA;
                      rootA = FXMLLoader.load(getClass().getResource("/views/candidatLogin.fxml"));
                      Scene scene = new Scene(rootA);
                      logp.setScene(scene);
                      logp.show();
                      logp.setTitle("signupc");
        
        
        
        
        
        
       }catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
}
    } 
     @FXML
    public void tologin (ActionEvent event) throws IOException {
        Stage sigup = new Stage();
                btnloginsc.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/candidatLogin.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("Login");
    
    

}
}
