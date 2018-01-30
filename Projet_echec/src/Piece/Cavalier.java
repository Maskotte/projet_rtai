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
public class Cavalier extends Piece{
    
    @Override
    public boolean deplacementPossible(Deplacement d) {
        /* On vérifie si la division de nos déplacements est égal à 2 ou 0.5,
        qui correspond au mouvement en L du Cavalier
        */
        boolean test = false;
        if ((Math.abs(d.getDeplacementX() / d.getDeplacementY())) == 2 ||
            (Math.abs(d.getDeplacementX() / d.getDeplacementY())) == .5) {
            
            test = true;
        }
        return test;
    }

    @Override
    public void deplacer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
