/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_echec;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author quent
 */
public class Joueur {
    int playersActu = 1;
    //Couleur 1-Blanc Couleur 2-Noir
    int couleur = 0;
    ArrayList<ImageIcon> listImage = new ArrayList<ImageIcon>();
    
    public Joueur(int valeurCouleur)
    {
        couleur = valeurCouleur;
    }
    public int getJoueur()
    {
        return playersActu;
    }
    public void setValueJoueur(int i, int j)
    {
        
    }
    public void addIcon(ImageIcon pieces)
    {
        listImage.add(pieces);
    }
    
    public boolean verifList(int couleur,ImageIcon image)
    {
        boolean temp = false;
        int valeur = this.getCouleur();
        for (ImageIcon imageIcon : listImage) 
        {
            if(image == imageIcon)
            {
                return true;
            }
            else
            {
                temp = false;
            }
        }
        return temp;
    }
    
    public int getCouleur()
    {
        return couleur;
    }
}
