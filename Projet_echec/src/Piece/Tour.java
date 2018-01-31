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
public class Tour extends Piece{
    
    @Override
    public boolean deplacementPossible(Deplacement d) {
        /*
            Le déplacement de la tour étant soit vertical ou horizontal, cela signifie
            qu'un des deux déplacements vaudra forcément 0. Son déplacement sera donc possible
            si le produit des deux déplacements vaut donc 0.
        */
        
        boolean test = false;
        
        if(d.getDeplacementY() == 0 ) {
            System.out.println("vrai");
            return true;
            
        }
           
            System.out.println(""+d.getDepart().getLigne());
            System.out.println(""+d.getDepart().getColonne());
            System.out.println(""+d.getArrivee().getLigne());
            System.out.println(""+d.getArrivee().getColonne());
            System.out.println(""+d.getDeplacementX());
            System.out.println(""+d.getDeplacementY());
        return false;
    }


    /*@Override
    public void deplacer(Coordonnee depart, Coordonnee arrivee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
