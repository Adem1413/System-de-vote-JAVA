/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import controllers.LoginController;
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

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class SignUpController {

    @FXML
    private Button btnsignup;
    
    @FXML
    private Button btnlogins;

    @FXML
    private TextField signupnom;
    
    @FXML
    private TextField signupprenom;

    @FXML
    private TextField signupusername;
    
     @FXML
    private TextField signupCIN;

    @FXML
    private TextField signusexe;
  
     @FXML
    private PasswordField signuppwd;
    
    @FXML
    private TextField signupcodecart;

    @FXML
    void signup(ActionEvent event) throws SQLException, IOException   {
        
        String nom = signupnom.getText();
        String prenom = signupprenom.getText();
        String username = signupusername.getText();
        String password = signuppwd.getText();
        String CIN = signupCIN.getText();
        String sexe = signusexe.getText();
        String codecart = signupcodecart.getText();
        try {
       
        Connection conn =   DriverManager.getConnection("jdbc:mysql://localhost/systemvote","root","");
        String sql = "INSERT INTO electeurs (nom,prenom,CIN,sexe,username,password,codecart) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,nom);
        statement.setString(2,prenom);
        statement.setString(3,CIN);
        statement.setString(4,sexe);
        statement.setString(5,username);
        statement.setString(6,password);
        statement.setString(7,codecart);
        statement.execute();
        JOptionPane.showMessageDialog(null, "Account Successfully added");
         Stage logp = new Stage();
                      btnsignup.getScene().getWindow().hide();
                      Parent rootA;
                      rootA = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
                      Scene scene = new Scene(rootA);
                      logp.setScene(scene);
                      logp.show();
                      logp.setTitle("Acceuil");
        
        
        
        
        
        
       }catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
}
    } 
     public void tologin (ActionEvent event) throws IOException {
        Stage sigup = new Stage();
                btnlogins.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("Login");
    
    

}
}












    