/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import QRCodeReader.zbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

/**
 *
 * @author etudiant
 */
public class Controller implements ActionListener{
    private Modele modele;
    private Vue vue;
    
    private zbar zbar;
    
    public Controller (Modele modele, Vue vue) {
        this.modele = modele;
        this.vue = vue;
        
        //Crée la tâche de lecture des QRCodes
        zbar = new zbar();
        zbar.startProcess();
        Thread check = new Thread(){
            @Override
            public void run(){
                modele.lecture(zbar);
            }
        };
        //Lance la tâche de lecture des QRCodes
        check.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
