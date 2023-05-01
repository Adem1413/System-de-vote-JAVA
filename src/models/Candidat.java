
package models;


public class Candidat {
    private String nom ;
    private String prenom ; 
    private String niveau ; 
    private String description ;
    private int nbr_votes;
     
    public Candidat(String nom, String prenom, String niveau, String description ) {
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.description = description;
 
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getDescription() {
        return description;
    }

    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 
   
    
    
    
}
