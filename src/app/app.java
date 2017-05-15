/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Database.Connect;

/**
 *
 * @author etudiant
 */
public class app {
    
    public static void main (String[] args){
        //Construit l'architecture MVC de l'application
        Modele modele = new Modele();
        Vue vue = new Vue(modele);
        Controller controller = new Controller(modele, vue);
        
        //Affiche que la connexion à la base de données est en cours
        vue.afficheConnexion(true);
        //Charge la connexion à la base de données;
        Connect.loadConnexion();
        //Affiche que la connexion à la base de données est terminé
        vue.afficheConnexion(false);
        
    }
}
