/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author etudiant
 */
public class Compte {
    private int id;
    private String nom;
    private String prenom;
    
    private Date dateFin;

    Compte(int id, String nom, String prenom, Date dateFin) {
        this.id =id;
        this.nom = nom;
        this.prenom = prenom;
        
        this.dateFin = dateFin;
    }
    
    //Détermine si l'abonnement du compte a expiré
    public boolean expire () {
        return Passerelle.getDateCourant().after(dateFin);
    }
    
    public int getId() {
        return id;
    }
        
    @Override
    public String toString () {
        return nom + " " + prenom;
    }
}
