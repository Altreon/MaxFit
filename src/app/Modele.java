package app;

import Database.Compte;
import Database.Passerelle;
import QRCodeReader.TimerTexte;
import QRCodeReader.zbar;
import java.awt.Color;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author etudiant
 */
public class Modele extends Observable{
    //id de la salle;
    private int idSalle = 1;
    
    //private String code;
    private Compte compte;
    private String text;
    private Color color;
    
    //Lit les QRCodes
    public void lecture(zbar zbar) {
            String s = null;
            Thread timer = null;
            TimerTexte timerTexte = null;
            try {
            //Tant que l'application n'est pas fermé
            while((s = zbar.getInput().readLine()) != null){
                //Permet de supprimer le "QRCode : " du String
                s = s.substring(8);
                Compte c = null;
                
                if(estUnEntier(s)){
                    //Récupére le compte dans la base de données
                    c = Passerelle.getCompte(Integer.parseInt(s));
                }else{
                    c = null;
                }
                
                //Pour la première requète, permet d'éviter de travailler sur un NULL
                if(timer != null){
                    timerTexte.interrupt();
                }

                //Lance une tâche timée pour réabiliter l'affichage de l'application après 3 seconde
                timerTexte = new TimerTexte(this);
                timer = new Thread(timerTexte);
                timer.start();

                //Initialise les différentes informations d'affichage
                compte = c;
                if(compte == null){
                    text = "Le compte est inconnu, veuillez vous rendre à l'accueil";
                    color = Color.RED;
                }else if(compte.expire()){
                    text = "Votre abonnement a expiré, veuillez à le renouveller à l'accueil";
                    color = Color.ORANGE;
                }else{
                    text = "Bienvenue " + compte.toString() + "!";
                    color = Color.GREEN;
                    Passerelle.ajoutVisite(c.getId(), idSalle);
                }
                
                //Applique les changements
                setChanged();
                notifyObservers();
            }
        } catch (IOException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Permet de s'assurer que le QRCode scanné est bien un entier
    public boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e){
			return false;
		}
 
		return true;
	}
    
    /*public String getCode () {
        return code;
    }*/
    
    public String getText () {
        return text;
    }
    
    public Color getColor () {
        return color;
    }

    //Réinitialise l'interface de l'application
    public void iniCode() {
       text = "Passez votre carte";
       color = Color.WHITE;
       
       //Applique les changements
       setChanged();
       notifyObservers();
    }
}
