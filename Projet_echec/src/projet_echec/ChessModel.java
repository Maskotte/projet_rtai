/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_echec;

import Piece.Cavalier;
import Piece.Pion;
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
    JLabel temp = new JLabel();
    ImageIcon temp1 = new ImageIcon();
    
    int[][] plateau;
    int playersActu = 1;
    int positionX = -1;
    int positionY = -1;
    int nbCoups;
    boolean valeur = false;
    
    Pion unPion = new Pion();
    Cavalier unChevalier = new Cavalier();
    
    Coordonnee mapD;
    Coordonnee mapA;
    
    Deplacement dep;

    
    public ChessModel()
    {
        this.joueur = new ArrayList<Observateur>();
        
    }
    public int[][] getCase() {
        return plateau;
    }
    public void setValueJoueur(int i, int j)
    {
        positionX = i;
        positionY = j;
    }
    
    public void play(int i, int j, Board plateau) {
        
        //Récupère la case sélectionné
        this.temp = plateau.Plateau[i][j];
        
        
        if(this.temp.getIcon() == null && this.temp1 == null)
        {
            System.out.println("Choissisez une pièce qui vous appartient :) ");
        }
        else  
        {
            if(positionX == -1 && positionY == -1 )
            {

                this.temp1 = (ImageIcon) this.temp.getIcon();
                this.setValueJoueur(i, j);
                mapD = new Coordonnee(i,j);
            }
            else
            {
                mapA = new Coordonnee(i,j);
                dep = new Deplacement(mapD,mapA);
                for(int l = 0 ; l< plateau.piece.length; l++)
                {
                    if(plateau.piece[l] == temp1)
                    {
                        switch(l)
                        {
                            case 0 : 
                                
                                break;
                            case 1 : 
                                if(playersActu == 1)
                                    unChevalier.setCouleur("blanc");
                                else
                                    unChevalier.setCouleur("noir");
                                //unChevalier.setPosition(i, j);
                                valeur = unChevalier.deplacementPossible(dep);
                                break;
                            case 2 : 
                                
                                break;  
                            case 3 : 
                                
                                break;
                            case 4 : 
                                
                                break;
                            case 5 : 
                                if(playersActu == 1)
                                    unPion.setCouleur("blanc");
                                else
                                    unPion.setCouleur("noir");
                                unPion.setPosition(i, j);
                                valeur = unPion.deplacementPossible(dep);
                                break;
                            case 6 : 
                                
                                break;
                            case 7 : 
                               
                                break;
                            case 8 : 
                                
                                break;  
                            case 9 : 
                                
                                break;
                            case 10 : 
                              
                                break;
                            case 11 : 
                                
                                break;    
                        }
                        this.nbCoups ++;
                    }
                }
                if(valeur == true)
                {
                    plateau.Plateau[positionX][positionY].setIcon(null);
                    plateau.Plateau[i][j].setIcon(temp1);
                    this.temp1 = null;
                    this.setValueJoueur(-1, -1);
                    playersActu = this.getNextJoueur();
                    plateau.menuBarJoueur.setText("Joueur "+playersActu);
                }
                else
                    System.out.println("Deplacement impossible");
                
            }
        }
        
        /*for(int l = 0 ; l< 6; l++)
        {
            if(plateau.piece[l] == temp1)
            {
                switch(l)
                {
                    case 0 : 
                        System.out.println("Tour");
                        break;
                    case 1 : 
                        System.out.println("chevalier");
                        break;
                    case 2 : 
                        System.out.println("fou");
                        break;  
                    case 3 : 
                        System.out.println("roi");
                        break;
                    case 4 : 
                        System.out.println("reine");
                        break;
                    case 5 : 
                        System.out.println("pion");
                        break;
                }
            }
        }*/
        
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
        
        
        ChessModel unModel = new ChessModel();
        Board unBoard = new Board(unModel);
        
        
        
        nbCoups = 0; // On reset le nombre de coups
         
    }
 
    
}
