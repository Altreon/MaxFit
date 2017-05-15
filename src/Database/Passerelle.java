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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Passerelle {
	
    //Retourne un compte associer à l'id entré en paramètres
    public static Compte getCompte (int id) {
        try {
            Statement statement = Connect.get().createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM membre WHERE idMembre = " + id);
            Compte c = null;
            while(res.next()){
                c = new Compte(res.getInt("idMembre"), res.getString("nomMembre"), res.getString("prenomMembre"));
            }

            res.close();
            statement.close();
            return c;

        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return null;
    }

    //Ajouter une visite dans la base de données
    public static void ajoutVisite(int idMembre, int idSalle) {
        try {
            Statement statement = Connect.get().createStatement();
            statement.executeUpdate("INSERT INTO visiter VALUES("+idMembre+", "+idSalle+", DEFAULT)");
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}