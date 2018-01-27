/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piece;

import projet_echec.Deplacement;

/**
 *
 * @author qgers
 */
public class Fou extends Case{
   
    public boolean deplacementPossible(Deplacement d) {
        /*
            On vérifie que la soustraction des déplacements vaut bien 0,
            ce qui correspond au déplacement en diagonale du Fou
        */
        
        boolean test = false;
        
        if((Math.abs(d.getDeplacementX()) - Math.abs(d.getDeplacementY())) == 0) {
            test = true;
        }
        return test;
    }
}
