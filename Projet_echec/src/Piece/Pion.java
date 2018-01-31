/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piece;

import java.awt.Color;
import projet_echec.Coordonnee;
import projet_echec.Deplacement;

/**
 *
 * @author qgers
 */
public class Pion extends Piece{

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
    private int[][] position;
    private int i ;
    private int j;
    int val;
    private String couleur ;

    
    public Pion()
    {
        this.i = 0;
        this.j = 0;
    }
    
    public int[][] getposition()
    {
        return position;
    }
    
    
    
    public void setPosition(int i, int j)
    {
        this.i = i; 
        this.j = j;
    }

    @Override
    public boolean deplacementPossible(Deplacement d) {
        
        
        
        /*System.out.println(""+d.getDepart().getLigne());
        System.out.println(""+d.getDepart().getColonne());
        System.out.println(""+d.getArrivee().getLigne());
        System.out.println(""+d.getArrivee().getColonne());
        System.out.println(""+d.getDeplacementX());
        System.out.println(""+d.getDeplacementY());*/
        
        if (d.getDeplacementX() != 0)
        {	
            if (this.getCouleur().equals("noir")){
                
                if(d.getArrivee().getLigne() == d.getDepart().getLigne() && d.getDeplacementX() > 0)
                {
                    if(d.getDeplacementX() <= 2)
                    {
                        return true;
                    }
                    
                }
            }
            else 
            {
                
                if(d.getArrivee().getLigne() == d.getDepart().getLigne() && d.getDeplacementX() < 0)
                {
                    if(d.getDeplacementX() >= -2)
                    {
                        return true;
                    }
                    
                }
            }
				
	}
        return false;
    }
        

    /*@Override
    public void deplacer(Coordonnee depart, Coordonnee arrive) {
        
        boolean valeur = this.deplacementPossible(d);
    }*/
}
