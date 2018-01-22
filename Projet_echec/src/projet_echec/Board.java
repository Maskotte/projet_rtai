/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_echec;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tok
 */
public class Board extends JFrame {

    public static final int squareCount = 64;
    ArrayList<JButton> listButton = new ArrayList<>();
    JLabel Plateau[][];
    /*public ImageIcon chevalierB = new ImageIcon("icons\\blanches\\CB_B.png");
    public ImageIcon reineB = new ImageIcon("icons\\blanches\\DB_B.png");
    public ImageIcon roiB = new ImageIcon("icons\\blanches\\RB_B.png");
    public ImageIcon fouB = new ImageIcon("icons\\blanches\\FB_B.png");
    public ImageIcon tourB = new ImageIcon("icons\\blanches\\TB_B.png");
    public ImageIcon pionB = new ImageIcon("icons\\blanches\\PB_B.png");
    public ImageIcon chevalierN = new ImageIcon("icons\\noires\\CN_N.png");
    public ImageIcon reineN = new ImageIcon("icons\\noires\\DN_N.png");
    public ImageIcon roiN = new ImageIcon("icons\\noires\\RN_N.png");
    public ImageIcon fouN = new ImageIcon("icons\\noires\\FN_N.png");
    public ImageIcon tourN = new ImageIcon("icons\\noires\\TN_N.png");
    public ImageIcon pionN = new ImageIcon("icons\\noires\\PN_N.png");*/
    
    public ImageIcon chevalierB = new ImageIcon("icons\\blanches transparentes\\cavalierB.png");
    public ImageIcon reineB = new ImageIcon("icons\\blanches transparentes\\reineB.png");
    public ImageIcon roiB = new ImageIcon("icons\\blanches transparentes\\roiB.png");
    public ImageIcon fouB = new ImageIcon("icons\\blanches transparentes\\fouB.png");
    public ImageIcon tourB = new ImageIcon("icons\\blanches transparentes\\tourB.png");
    public ImageIcon pionB = new ImageIcon("icons\\blanches transparentes\\pionB.png");
    public ImageIcon chevalierN = new ImageIcon("icons\\noires transparentes\\cavalierN.png");
    public ImageIcon reineN = new ImageIcon("icons\\noires transparentes\\reineN.png");
    public ImageIcon roiN = new ImageIcon("icons\\noires transparentes\\roiN.png");
    public ImageIcon fouN = new ImageIcon("icons\\noires transparentes\\fouN.png");
    public ImageIcon tourN = new ImageIcon("icons\\noires transparentes\\tourN.png");
    public ImageIcon pionN = new ImageIcon("icons\\noires transparentes\\pionN.png");
    
    
    

	public Board(String title) {
		
		// Defini la couleur des cases
		Color blackColor = new Color(209, 139, 71);
		Color whiteColor = new Color(255, 206, 158);

		JLabel chessButton = null;
                Plateau = new JLabel[8][8];
		
		/*for (int i = 1; i <= squareCount; i++) {

			if (i % 2 == 0) { // Toutes les 2 cases on ajoute un bouton noir
				chessButton = new JButton();
                                chessButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        System.out.println("Bouton pair"); //To change body of generated methods, choose Tools | Templates.
                                    }
                                });
				chessButton.setBackground(blackColor);
                                listButton.add(chessButton);
				add(chessButton);
			} else {
				
				chessButton = new JButton();
                                chessButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        System.out.println("Bouton impair"); //To change body of generated methods, choose Tools | Templates.
                                    }
                                });
				chessButton.setBackground(whiteColor);
                                listButton.add(chessButton);
				add(chessButton);
			}
			
			if (i % 8 == 0) { // Une fois à la fin de la ligne, on inverse les couleurs. 
				
				Color temp = blackColor;
				blackColor = whiteColor;
				whiteColor = temp;
			}
			
		}
                this.PionNoir(listButton);
                this.PionBlanc(listButton);*/

                for(int i =0; i<8; i++)
                {
                    for(int j=0; j<8; j++)
                    {
                        if (j % 2 == 0) { // Toutes les 2 cases on ajoute un bouton noir
				chessButton = new JLabel();
				chessButton.setBackground(blackColor);
                                chessButton.setOpaque(true);
                                Plateau[i][j] = chessButton;
                                this.add(chessButton);
			} else {
				
				chessButton = new JLabel();
				chessButton.setBackground(whiteColor);
                                chessButton.setOpaque(true);
                                Plateau[i][j] = chessButton;
				this.add(chessButton);
			}
                    }
                    Color temp = blackColor;
                    blackColor = whiteColor;
                    whiteColor = temp;
                }
                Plateau[0][0].setIcon(tourN);
                Plateau[0][1].setIcon(chevalierN);
                Plateau[0][2].setIcon(fouN);
                Plateau[0][3].setIcon(roiN);
                Plateau[0][4].setIcon(reineN);
                Plateau[0][5].setIcon(fouN);
                Plateau[0][6].setIcon(chevalierN);
                Plateau[0][7].setIcon(pionN);
                Plateau[1][0].setIcon(pionN);
                Plateau[1][1].setIcon(pionN);
                Plateau[1][2].setIcon(pionN);
                Plateau[1][3].setIcon(pionN);
                Plateau[1][4].setIcon(pionN);
                Plateau[1][5].setIcon(pionN);
                Plateau[1][6].setIcon(pionN);
                Plateau[1][7].setIcon(pionN);
                Plateau[7][0].setIcon(tourB);
                Plateau[7][1].setIcon(chevalierB);
                Plateau[7][2].setIcon(fouB);
                Plateau[7][3].setIcon(roiB);
                Plateau[7][4].setIcon(reineB);
                Plateau[7][5].setIcon(fouB);
                Plateau[7][6].setIcon(chevalierB);
                Plateau[7][7].setIcon(pionB);
                Plateau[6][0].setIcon(pionB);
                Plateau[6][1].setIcon(pionB);
                Plateau[6][2].setIcon(pionB);
                Plateau[6][3].setIcon(pionB);
                Plateau[6][4].setIcon(pionB);
                Plateau[6][5].setIcon(pionB);
                Plateau[6][6].setIcon(pionB);
                Plateau[6][7].setIcon(pionB);
                 
                
		this.setTitle(title); // Setting the title of board
		this.setLayout(new GridLayout(8, 8)); // GridLayout will arrange elements in Grid Manager 8 X 8
		this.setSize(650, 650); // Size of the chess board
		this.setVisible(true);

	}
        
      /* public void PionBlanc(ArrayList listeButon)
       {
           JButton unbouton = new JButton();
           
           for(int j=48;j<=55;j++)
           {
               unbouton = (JButton) listeButon.get(j);
               unbouton.setIcon(pionB);
           } 
           for(int i =56; i<=63;i++)
           {
               unbouton = (JButton) listeButon.get(i);
               switch(i)
               {
                   case 56: 
                       unbouton.setIcon(tourB);
                       break;
                   case 57: 
                       unbouton.setIcon(chevalierB);
                       break;
                    case 58: 
                       unbouton.setIcon(fouB);
                       break;
                    case 59: 
                       unbouton.setIcon(reineB);
                       break;
                    case 60: 
                       unbouton.setIcon(roiB);
                       break;
                    case 61: 
                       unbouton.setIcon(fouB);
                       break;
                    case 62: 
                       unbouton.setIcon(chevalierB);
                       break;
                    case 63: 
                       unbouton.setIcon(tourB);
                       break;
               }
           }
            
       }
       
       public void PionNoir(ArrayList listBouttonBlanc)
       {
           JButton unbouton = new JButton();
           
             
           for(int i= 0; i<8;i++)
           {
               unbouton = (JButton) listBouttonBlanc.get(i);
               switch(i)
               {
                   case 0: 
                       unbouton.setIcon(tourN);
                       break;
                   case 1: 
                       unbouton.setIcon(chevalierN);
                       break;
                    case 2: 
                       unbouton.setIcon(fouN);
                       break;
                    case 3: 
                       unbouton.setIcon(reineN);
                       break;
                    case 4: 
                       unbouton.setIcon(roiN);
                       break;
                    case 5: 
                       unbouton.setIcon(fouN);
                       break;
                    case 6: 
                       unbouton.setIcon(chevalierN);
                       break;
                    case 7: 
                       unbouton.setIcon(tourN);
                       break;
               }
           }
           
           for(int j=8;j<16;j++)
           {
               unbouton = (JButton) listBouttonBlanc.get(j);
               unbouton.setIcon(pionN);
           }
           
       }*/

       
   
}
