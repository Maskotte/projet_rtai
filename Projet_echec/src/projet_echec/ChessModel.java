/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_echec;

import Piece.Cavalier;
import Piece.Fou;
import Piece.Pion;
import Piece.Reine;
import Piece.Roi;
import Piece.Tour;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
    Cavalier unCavalier = new Cavalier();
    Tour uneTour = new Tour();
    Reine uneReine = new Reine();
    Roi unRoi = new Roi();
    Fou unFou = new Fou();
    
    Coordonnee mapD;
    Coordonnee mapA;
    
    Deplacement dep;

    CaseControler caseC;
    public ChessModel()
    {
        this.joueur = new ArrayList<Observateur>();
        
        nouvellePartie();
        
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

        System.out.println("Entrez play");
        if(playersActu == 1 && plateau.joueur1.verifList(temp1) == true && temp.getIcon() != null)
        {
            this.temp1 = (ImageIcon) this.temp.getIcon();
            plateau.Plateau[positionX][positionY].setBorder(null);
            temp.setBorder(BorderFactory.createLineBorder(Color.black));
            setValueJoueur(i, j);
        }
        else if(playersActu == 2 && plateau.joueur2.verifList(temp1) == true && temp.getIcon() != null)
        {
            this.temp1 = (ImageIcon) this.temp.getIcon();
            plateau.Plateau[positionX][positionY].setBorder(null);
            temp.setBorder(BorderFactory.createLineBorder(Color.black));
            setValueJoueur(i, j);
        }
        if(positionX == -1 && positionY == -1) //Si les valeurs X et Y sont de -1 alors 
        {
            this.temp1 = (ImageIcon) this.temp.getIcon(); //On récupère k'image ?
            temp.setBorder(BorderFactory.createLineBorder(Color.black));
            this.setValueJoueur(i, j); //On mets les valeurs de i et j dans les valeurs X et Y  
        }
        else if(temp.getIcon() == null)//sinon 
        {
            
            //renseigne les coordonnee de départ
            mapD = new Coordonnee(positionX, positionY);
            //renseigne les coordonnee d'arrivee
            mapA = new Coordonnee(i,j);
                
            //Renseigne le déplacement voulu avec les coordonnee de départ et d'arrivé
            dep = new Deplacement(mapD,mapA);
                
                
            for(int k = 0 ; k< plateau.piece.length; k++){ // On parcours le tableau de pièces
                
                    if(plateau.piece[k] == temp1) //Si une pièce correspond à l'image récupéré en tampon alors 
                    {
                        switch(k) //en fonction de la valeur de k 
                        {
                            case 0 : // Tour 
                                valeur = uneTour.deplacementPossible(dep);
                                break;
                            case 1 : //Cavalier
                                valeur = unCavalier.deplacementPossible(dep);
                                break;
                            case 2 : //Fou
                                valeur = unFou.deplacementPossible(dep);
                                break;  
                            case 3 : //Roi
                                valeur = unRoi.deplacementPossible(dep);
                                break;
                            case 4 : //Reine
                                valeur = uneReine.deplacementPossible(dep);
                                break;
                            case 5 : //Pion et on continue pour les pièces noirs
                                if(playersActu == 1)
                                    unPion.setCouleur("blanc");
                                else
                                    unPion.setCouleur("noir");
                                unPion.setPosition(i, j);
                                valeur = unPion.deplacementPossible(dep);
                                break;
                            case 6 : 
                                valeur = uneTour.deplacementPossible(dep);
                                break;
                            case 7 : 
                               
                                valeur = unCavalier.deplacementPossible(dep);
                                break;
                            case 8 : 
                                valeur = unFou.deplacementPossible(dep);
                                break;  
                            case 9 : 
                                valeur = unRoi.deplacementPossible(dep);
                                break;
                            case 10 : 
                              valeur = uneReine.deplacementPossible(dep);
                                break;
                            case 11 : 
                                if(playersActu == 1)
                                    unPion.setCouleur("blanc");
                                else
                                    unPion.setCouleur("noir");
                                unPion.setPosition(i, j);
                                valeur = unPion.deplacementPossible(dep);
                                
                                break;    
                        }
                        
                    }
                }
                if(valeur == true) // Si le déplacement est possible
                {
                    
                    plateau.Plateau[positionX][positionY].setIcon(null); //supprime l'image du tableau après que le joueur ai joué 
                    plateau.Plateau[i][j].setIcon(temp1); // On place l'image sur la label qui ne contient pas d'image
                    
                    plateau.Plateau[positionX][positionY].setBorder(null);
                    
                    playersActu = this.getNextJoueur(); // On change de joueur 
                    plateau.menuBarJoueur.setText("Joueur "+playersActu); // On renseigne dans la frame dans le menu le joueur qui joue
                    this.nbCoups ++; // On augmente le nombre de coups
                    
                   avertirAllObservateurs(i, j);
                   this.setValueJoueur(-1, -1); // On remet par défaut les valeurs de X et Y en tampon
                   this.temp1 = null; // supprime l'image stocké en mémoire
                    
                }

            }
    }
    
    public String toString()
    {
        String retour ="";
        for(int i = 0; i < 8; i++) {
            retour += Integer.toString(i);
            for(int j = 0; j < 8; i++) {
                retour += " "+Integer.toString(j);
            }
            retour += "\r\n";
        }
        return retour;
    }
    
    
    
    
     public int getNextJoueur() {
        switch (this.playersActu) {
            case 1:
                return 2;
            case 2:
                return 1;
            default:
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
       
       for(int i=0;i<8;i++)
       {
           for(int j =0;j<8;j++){
               plateau[i][j] = 0;
           }
       }
       
       
       nbCoups = 0;    
       avertirNewGameAllObservateurs();
    }
    
    public boolean mangePiece(ImageIcon image,Board plateau)
    {
        if(playersActu == 1 )
        {
            for (ImageIcon imageIcon : plateau.joueur2.listImage) 
            {
                if(image == imageIcon)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else if(playersActu == 2)
        {
            for (ImageIcon imageIcon : plateau.joueur1.listImage) 
            {
                if(image == imageIcon)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
         return false;  
    }
}
