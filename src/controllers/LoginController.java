/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
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
/**
 *
 * @author DELL
 */
public class LoginController {
    
    @FXML
    private Button btnlogin;
    @FXML
    private Button signupbtn;
    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtusername;
     
     Connection conn ; 
     PreparedStatement  pst;
     ResultSet res ;

    @FXML
    public void login(ActionEvent event) throws  SQLException, IOException {
        
        String username=txtusername.getText();
        String password=txtpassword.getText();
        if (username.equals("") && password.equals(""))
        {
            JOptionPane.showMessageDialog(null, "username or password blank");
            
        }
        else{
            try {
                
                 conn =   DriverManager.getConnection("jdbc:mysql://localhost/systemvote","root","");
                 String sql = "select * from electeurs where username=? and password=?";
                 
                 pst = conn.prepareStatement(sql);
                 pst.setString(1,username);
                 pst.setString(2,password);
                 res = pst.executeQuery();
               
                 if (res.next())
                      
                 {
                      String vote = res.getString("vote");
                     if (vote.equals("0")) {
                   PreparedStatement psr = conn.prepareStatement("update electeurs set vote = 1 where username=? and password=?  ");
                        psr.setString(1, username);
                        psr.setString(2,password);
                        psr.execute();
                      JOptionPane.showMessageDialog(null, "login success");
                      Stage logp = new Stage();
                      btnlogin.getScene().getWindow().hide();
                      Parent rootA;
                      rootA = FXMLLoader.load(getClass().getResource("/views/mainMenu.fxml"));
                      Scene scene = new Scene(rootA);
                      logp.setScene(scene);
                      logp.show();
                      logp.setTitle("Acceuil");
                       }
                     else {
                         JOptionPane.showMessageDialog(null, "login success");
                      Stage logp = new Stage();
                      btnlogin.getScene().getWindow().hide();
                      Parent rootA;
                      rootA = FXMLLoader.load(getClass().getResource("/views/Resultat.fxml"));
                      Scene scene = new Scene(rootA);
                      logp.setScene(scene);
                      logp.show();
                      logp.setTitle("resultat");
                     }
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
                signupbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/views/SignUp.fxml"));
                Scene scene = new Scene(rootA);
                sigup.setScene(scene);
                sigup.show();
                sigup.setTitle("SIGNUP");
    
    

}
}
