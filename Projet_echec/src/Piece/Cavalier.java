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
public class Cavalier extends Piece{

    /**
     * @return the couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    
    private String couleur;
   
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

    
    

    
}
