/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_echec;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author tok
 */
public class Board extends JFrame {

    public static final int squareCount = 64;

	public Board(String title) {
		
		// Color of chess board this you can change accordingly like red or white
		Color blackColor = Color.BLACK;
		Color whiteColor = Color.WHITE;

		JButton chessButton = null;
		
		for (int i = 1; i <= squareCount; i++) {

			if (i % 2 == 0) { // Adding color based on the odd and even initially.
		
				chessButton = new JButton();
				chessButton.setBackground(blackColor);
				add(chessButton);
			} else {
				
				chessButton = new JButton();
				chessButton.setBackground(whiteColor);
				add(chessButton);
			}
			
			if (i % 8 == 0) { // swapping the color when adding the next row 
				
				Color temp = blackColor;
				blackColor = whiteColor;
				whiteColor = temp;
			}
			
		}

		this.setTitle(title); // Setting the title of board
		this.setLayout(new GridLayout(8, 8)); // GridLayout will arrange elements in Grid Manager 8 X 8
		this.setSize(650, 650); // Size of the chess board
		this.setVisible(true);

	}
   
}
