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
public class Pion extends Piece{
    private int[][] position;
    
    public Pion()
    {
        
    }
    
    public int getposition(int i, int j)
    {
        return position[i][j];
    }

    @Override
    public boolean deplacementPossible(Deplacement d) {
        System.out.println("return");
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deplacer() {
        System.out.println("return");
    }
}
