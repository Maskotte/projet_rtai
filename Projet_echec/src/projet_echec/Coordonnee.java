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
public class Coordonnee {
    
    private int ligne;
    private int colonne;
    
    public Coordonnee(int colonne, int ligne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}

    /**
     * @return the ligne
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * @return the colonne
     */
    public int getColonne() {
        return colonne;
    }
}
