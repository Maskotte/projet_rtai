package projet_echec;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projet_echec.ChessModel;
import projet_echec.Observateur;

/**
 *
 * @author qdesbin
 */
public class ChessVueFichier implements Observateur {

    private ChessModel chess;
    private File f = new File("partie.txt");
    private FileWriter fw ;
    
    public ChessVueFichier(ChessModel chess) {
        this.fw = null;
        try {
            this.fw = new FileWriter(f, true);
            this.chess = chess;
        } catch(IOException e) {
            System.err.println(e);
        }
    }
    
    @Override
    public void avertir(int i, int j) {
        int joueurActuel = chess.playersActu;
        try {
            this.fw.append("Le joueur "+joueurActuel+" joue en "+i+";"+j+"\r\n");
        } catch (IOException ex) {
            Logger.getLogger(ChessVueFichier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void avertirNewGame() {
        try {
            this.fw.close();
            this.fw = new FileWriter(f, true);
            this.fw.append("\r\nUne nouvelle partie commence ! Le joueur 1 commence\r\n");
        } catch (IOException ex) {
            Logger.getLogger(ChessVueFichier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void avertirFinPartie(boolean avecGagnant) {
        /*try {
            String gagnant;
            if(avecGagnant) {
                this.fw.append("La partie est terminée ! "+gagnant+" a gagné !");
            } else {
                this.fw.append("La partie est terminée ! C'est un match nul");
            }
        } catch (IOException ex) {
            Logger.getLogger(ChessVueFichier.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}

