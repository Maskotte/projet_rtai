/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piece;

import projet_echec.Coordonnee;
import projet_echec.Deplacement;

/**
 *
 * @author qgers
 */
public class Roi extends Piece{
    
    public boolean deplacementPossible(Deplacement d) {
        
       boolean test = false;
       /*
            Le roi ne se déplace que d'une case parmi celles qui l'entoure.
            Les soustractions vérifieront qu'il ne se déplace que d'une seule case de manière rectiligne.
            La multiplication vérifiera qu'il ne se déplace que d'une seule case en diagonale.
       */
       
       if(Math.abs(d.getDeplacementX()) * Math.abs(d.getDeplacementY()) <= 1 &&
          Math.abs(d.getDeplacementX()) - Math.abs(d.getDeplacementY()) <= 1 &&
          Math.abs(d.getDeplacementX()) - Math.abs(d.getDeplacementY()) >= -1) {
           
           test = true;
       }
       return test;
    }


    /**public void deplacer(Coordonnee depart, Coordonnee arrivee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
