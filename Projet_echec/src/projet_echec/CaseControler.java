/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_echec;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;

/**
 *
 * @author qgers
 */
public class CaseControler extends MouseAdapter {
        int i;
        int j;
        
        
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
            //System.out.println("Joueur actuel : "+chess.playersActu);
            //System.out.println("Nombres de coups :"+chess.nbCoups);
            //System.out.println("Vous jouez ["+i+"]"+"["+j+"]");
            chess.play(i, j,echequier);
        }
}
