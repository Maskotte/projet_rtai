/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_echec;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author qgers
 */
public class CaseControler extends MouseAdapter {
        
        int i;
        int j;
        int verif = 0;
        boolean valeur = false;
        boolean valeurJ1 = false;
        boolean valeurJ2 = false;
        javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
        JLabel temp = new JLabel();
        ImageIcon temp1 = new ImageIcon();
        
        
        private ChessModel chess;
        private Board echequier;

        public CaseControler(int _i, int _j, ChessModel chess,Board echequier){
            i = _i;
            j = _j;
            this.chess = chess;
            this.echequier = echequier;
        }

        @Override
        public void mouseClicked(MouseEvent e)
        {   
            
            
            temp = echequier.Plateau[i][j]; //Récupère le label qui permet de faire l'action 
            
            if(verif == 0)//Si il n'y a pas encore eu de vérification alors
            {
                temp1 = (ImageIcon) this.temp.getIcon();
                //temp.setBorder(BorderFactory.createLineBorder(Color.black));
                if(chess.playersActu == 1) //Si le joueur 1 joue ou que la vérification n'a pas eu lieu
                {
                    valeur = echequier.joueur1.verifList(temp1);// on vérifie que l'icon qui la sélectionné est bien dans sa liste
                    verif = 1;
                    System.out.println("tour joueur 1");
                } 
                else if(chess.playersActu == 2)// sinon il vérifira la liste du joueur 2 
                {
                    valeur = echequier.joueur2.verifList(temp1);
                    verif = 1;
                    System.out.println("tour joueur 2");
                }
                if(valeur == true){ //Si la valeur retournée est vrai alors
                    temp.setBorder(BorderFactory.createLineBorder(Color.black));
                    chess.play(i, j, echequier);
                    
                }
                else //Sinon on affiche un petit message sympa
                    System.out.println("Ce n'est pas à toi de jouer tricheur:) ");
                
            }
            
            if(verif != 0) {
            if(temp.getIcon() == null)//SI il y a déjà eu une vérification et que il n'y a pas d'image sur le label
            {
                chess.play(i, j, echequier);
                //chess.getNextJoueur();
                verif = 0;
            }
            
            
            
            else if(temp1 !=null && temp.getIcon() !=null)
            {
                chess.play(i, j, echequier);
                //chess.getNextJoueur();
                verif = 0;
            }
            }
            
            
            
            
            
        }
       
}
