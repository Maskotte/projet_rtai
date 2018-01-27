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
        int tempo = 0;
        int i;
        int j;
        boolean valeur = false;
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
            
            if(this.temp.getIcon() == null && this.temp1 == null) 
            {
                valeur = true;
            }
            else
            {
                if(chess.playersActu == 1)
                {
                    valeur = echequier.joueur1.verifList(temp1);
                }
                else
                {   
                    valeur = echequier.joueur2.verifList(temp1);
                }
            }
            if(valeur == true)
                chess.play(i, j, echequier);
            
            
            
            //chess.play(i, j,k,echequier);
        }
}
