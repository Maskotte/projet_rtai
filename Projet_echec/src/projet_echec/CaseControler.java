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

        public CaseControler(int _i, int _j, ChessModel chess){
            i = _i;
            j = _j;
            this.chess = chess;
        }

        @Override
        public void mouseClicked(MouseEvent e)
        {            
            System.out.println(""+i +j);
        }
}
