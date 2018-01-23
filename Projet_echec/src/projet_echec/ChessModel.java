/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_echec;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author tok
 */
public class ChessModel {
    ArrayList<Observateur> joueur;
    private int[][] plateau;
    int playersActu = 1;
    JLabel temp = new JLabel();
    ImageIcon temp1 = new ImageIcon();
    int positionX = -1;
    int positionY = -1;
    int nbCoups;

    
    public ChessModel()
    {
        this.joueur = new ArrayList<Observateur>();
        
    }
    public int getCase(int i, int j) {
        return plateau[i][j];
    }
    public void setValueJoueur(int i, int j)
    {
        positionX = i;
        positionY = j;
    }
    
    public void play(int i, int j,Board plateau) {
        System.out.println("Vous jouez ["+i+"]"+"["+j+"]");
        this.nbCoups ++;
        int def = -1;
        int defY = -1;
        this.temp = plateau.Plateau[i][j];
        if(positionX == -1 && positionY ==-1 )
        {
            
            this.temp1 = (ImageIcon) this.temp.getIcon();
            //System.out.println("Salut");
            this.setValueJoueur(i, j);
        }
        else
        {
            plateau.Plateau[positionX][positionY].setIcon(null);
            plateau.Plateau[i][j].setIcon(temp1);
            this.temp1 = null;
            //System.out.println("Bonjour");
            this.setValueJoueur(-1, -1);
        }
        
        playersActu = this.getNextJoueur();
    }
    
    
    
    
     public int getNextJoueur() {
        if(this.playersActu == 1) {
            return 2;
        } else if(this.playersActu == 2) {
            return 1;
        } else {
            return 0;
        }
    }
    
     // Ajouter l'observateur
    public void register(Observateur o) {
        this.joueur.add(o);
    }
    
    // Retirer l'observateur
    public void unRegister(Observateur o) {
        this.joueur.remove(o);
    }
    
    // Avertir TOUS les observateurs d'un coup
    public void avertirAllObservateurs(int i, int j) {
        for(Observateur o : this.joueur) {
            o.avertir(i, j);
        }
    }
    
    
    // Avertir TOUS les observateurs d'une fin de partie (avec gagnant ou non)
    public void avertirFinPartieAllObservateurs(boolean avecGagnant) {
        for(Observateur o : this.joueur) {
            o.avertirFinPartie(avecGagnant);
        } 
    }
    
    // Avertir TOUS les observateurs d'une nouvelle partie
    public void avertirNewGameAllObservateurs() {
        for(Observateur o : this.joueur) {
            o.avertirNewGame();
        }
    }
     
     
    public int getJoueur()
    {
        return playersActu;
    }
    public int getNbcoups() {
        return this.nbCoups;
    }
    
    
    public void nouvellePartie()
    {
        this.playersActu = 1;
        this.plateau = new int[8][8];
         
         
        System.out.println("Nouvelle partie");
        
        
        nbCoups = 0; // On reset le nombre de coups
         
    }
 
    
}
