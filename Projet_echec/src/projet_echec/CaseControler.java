/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_echec;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author qgers
 */
public class CaseControler extends MouseAdapter {
        int i;
        int j;
        int k;
        private int[][] plateau;
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
            
            this.temp = echequier.Plateau[i][j];
            this.temp1 = (ImageIcon) this.temp.getIcon();
            
            boolean valeur = false;
            if(chess.playersActu == 1)
            {
                valeur = echequier.joueur1.verifList(k,this.temp1);
                System.out.println("Joueur 1 "+valeur);
            }
            if(chess.playersActu == 2)
            {
                valeur  = echequier.joueur2.verifList(k,this.temp1);
                System.out.println("Joueur 2 "+valeur);
                
            }
            chess.playersActu = this.chess.getNextJoueur();
            
            
            
            
            //chess.play(i, j,k,echequier);
        }
}
