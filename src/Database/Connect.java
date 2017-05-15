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


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection conn;

	public static Connection get() {
		return conn;
	}
        
        //Connexion à la base de données
        public static void loadConnexion () {
            try {
                System.out.println("Connexion a la base de donnees en cours...");
                //Remplacer "172.16.5.194:3306/maxfit" par la localisation de la base de données
                conn = DriverManager.getConnection("jdbc:mysql://172.16.5.194:3306/maxfit","pi","123456");
                System.out.println("Connexion etablie");
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        }
}

