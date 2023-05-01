/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author DELL
 */
public class Rescandidat {
    
    private String nom;
    private String prenom;
    private int nbr_votes;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNbr_votes(int nbr_votes) {
        this.nbr_votes = nbr_votes;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNbr_votes() {
        return nbr_votes;
    }

    public Rescandidat(String nom, String prenom, int nbr_votes) {
        this.nom = nom;
        this.prenom = prenom;
        this.nbr_votes = nbr_votes;
    }

    
}
