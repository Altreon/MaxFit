package QRCodeReader;


import app.Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class zbar{
    
    private Process p;
    private BufferedReader input;
        
    public zbar () {
    }

    //Lance le processus de lecture de QRCodes
    public void startProcess() {
        try {
            ProcessBuilder pb = new ProcessBuilder("zbarcam", "--prescale=320x240", "--nodisplay", "/dev/video0");
            //Décommenter en cas de besoin de la caméra à afficher.
            //ProcessBuilder pb = new ProcessBuilder("zbarcam", "--prescale=320x240", "/dev/video0");
            p = pb.start();
            //Récupère le tampon de la caméra
            input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(zbar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
    }
    
    //Retourne le tampon de la caméra
    public BufferedReader getInput() {
        return input;
    }
    
}
