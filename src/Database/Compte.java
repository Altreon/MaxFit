/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author etudiant
 */
public class Compte {
    private int id;
    private String nom;
    private String prenom;

    Compte(int id, String nom, String prenom) {
        this.id =id;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public boolean expire () {
        return false;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public String toString () {
        return nom + " " + prenom;
    }
}
