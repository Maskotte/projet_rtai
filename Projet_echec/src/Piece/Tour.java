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
public class Tour extends Piece{
    
    @Override
    public boolean deplacementPossible(Deplacement d) {
        /*
            Le déplacement de la tour étant soit vertical ou horizontal, cela signifie
            qu'un des deux déplacements vaudra forcément 0. Son déplacement sera donc possible
            si le produit des deux déplacements vaut donc 0.
        */
        
        boolean test = false;
        
        if((d.getDeplacementX() * d.getDeplacementY()) == 0) {
            test = true;
        }
        return test;
    }

    @Override
    public void deplacer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
