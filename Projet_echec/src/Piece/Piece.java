/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piece;

import projet_echec.ChessModel;
import projet_echec.Coordonnee;
import projet_echec.Deplacement;

/**
 *
 * @author quent
 */
public abstract class Piece{
    
    
    public abstract boolean deplacementPossible(Deplacement d);
    
    
}
