/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piece;

import java.awt.Color;
import javax.swing.BorderFactory;
import projet_echec.Board;
import projet_echec.Coordonnee;
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
        
        if(d.getDeplacementY() == 0 || d.getDeplacementX() == 0) {
            return true;
            
        }
           
        return false;
    }

    

   
}
