/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QRCodeReader;

import app.Modele;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author etudiant
 */
public class TimerTexte implements Runnable{

    private Modele modele;
    private boolean interrupt = false;
    
    public TimerTexte (Modele modele) {
        this.modele = modele;
    }
    
    @Override
    public void run(){
        try {
            //Attendre 3 secondes
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Si un nouveau thread à été créé, ne pas activer celui-ci
        if(!interrupt){
            modele.iniCode();
        }
    }

    //Désactive le thread
    public void interrupt(){
        interrupt = true;
    }
    
}
