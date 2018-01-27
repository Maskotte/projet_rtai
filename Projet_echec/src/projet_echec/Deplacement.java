/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_echec;


/**
 *
 * @author Thomas
 */
public class Deplacement {
    
    private double deplacementX; // Le déplacement ne sera pas forcément un entier selon la pièce
    private double deplacementY;
    
    private Coordonnee  depart; // Position en ligne et colonne
    private Coordonnee  arrivee; //Position en ligne et colonne
    
    public Deplacement(Coordonnee depart, Coordonnee  arrivee)
	{
		this.arrivee = arrivee;
		this.depart = depart;
		this.deplacementX = arrivee.getColonne() - depart.getColonne();
		this.deplacementY = arrivee.getLigne() - depart.getLigne();
	}

    /**
     * @return the deplacementX
     */
    public double getDeplacementX() {
        return deplacementX;
    }

    /**
     * @return the deplacementY
     */
    public double getDeplacementY() {
        return deplacementY;
    }

    /**
     * @return the depart
     */
    public Coordonnee getDepart() {
        return depart;
    }

    /**
     * @return the arrivee
     */
    public Coordonnee getArrivee() {
        return arrivee;
    }
}
