/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;


public class CandidatLoginController  {

    Connection conn ; 
     PreparedStatement  pst;
     ResultSet res ;
     @FXML
    private Button btnloginc;

    @FXML
    private PasswordField passwordlc;

    @FXML
    private Button signuplc;

    @FXML
    private TextField usernamelc;

    
    @FXML
    public void login(ActionEvent event) throws  SQLException, IOException {
        
        String username=usernamelc.getText();
        String password=passwordlc.getText();
        if (username.equals("") && password.equals(""))
        {
            JOptionPane.showMessageDialog(null, "username or password blank");
            
        }
        else{
            try {
                
                conn = DriverManager.getConnection("jdbc:mysql://localhost/systemvote","root","");
                 String sql = "select * from candidats where username=? and password=?";
                 
                 pst = conn.prepareStatement(sql);
                 pst.setString(1,username);
                 pst.setString(2,password);
                 res = pst.executeQuery();
                 
                 if (res.next())
                 {
                      JOptionPane.showMessageDialog(null, "login success");
                      Stage logp = new Stage();
                      btnloginc.getScene().getWindow().hide();
                      Parent rootA;
                      rootA = FXMLLoader.load(getClass().getResource("/views/menuCandidat.fxml"));
                      Scene scene = new Scene(rootA);
                      logp.setScene(scene);
                      logp.show();
                      logp.setTitle("Acceuil");
                      
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "login failed");
                 }
                 
                
            
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
    }
    
    @FXML
    public void tosignup(ActionEvent event) throws IOException {
        Stage sigup = new Stage();
                signuplc.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/candidatSignUp.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("SIGNUP");
    
    

}
}