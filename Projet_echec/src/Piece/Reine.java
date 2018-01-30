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
public class Reine extends Piece{
    
    public boolean deplacementPossible(Deplacement d) {
        
        /*
            La reine peut se déplacer verticalement, horizontalement ou diagonalement.
            On vérifiera donc si elle se déplace de manère rectiligne ou en diagonale
            en reprenant les conditions du Fou et de la Tour.

        */
        
        boolean test = false;
        
        if (d.getDeplacementX() * d.getDeplacementY() == 0 ||
            Math.abs(d.getDeplacementX()) - Math.abs(d.getDeplacementY()) == 0) {
            
            test = true;
        }
        return test;
    }

    @Override
    public void deplacer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
