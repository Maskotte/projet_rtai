/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_echec;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author tok
 */
public class Board extends JFrame implements Observateur{

    private ChessModel chess;
    public Icon[] piece;
    Color blackColor = new Color(209, 139, 71);
    Color whiteColor = new Color(255, 206, 158);
    Joueur joueur1 ; 
    Joueur joueur2 ;
    public JLabel Plateau[][];
    //Menu
    JMenuBar menuBar ;
    JMenu menuBarJoueur;
    JMenu menu;
    JMenuItem menu_1;
    JMenuItem menu_2;
    //Afficher joueur
    JTextArea playJoueur;
    
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
    
    
    

	public Board(ChessModel title) {
		
		// Defini la couleur des cases
		
                
                //Initialisation du menu
                menuBar = new JMenuBar();
                menu = new JMenu("Fichier");
                menuBarJoueur = new JMenu("Joueur 1");
                menu_1 = new JMenuItem("Nouvelle Partie");
                menu_2 = new JMenuItem("Quitter");
                
                //Initialisation des joueurs 
                joueur1 = new Joueur(1);
                joueur2 = new Joueur(2);
                
                this.chess = title;
                Plateau = new JLabel[8][8];
                
                piece = new Icon[12];
                
                //Rempli un tableau pour chaque type de pièce en prenant en compte la couleur
                this.initialiseTableau();
                
		
                //Initialisation du plateau    
                JLabel chessButton = null;
                
                for(int i =0; i<8; i++)
                {
                    for(int j=0; j<8; j++)
                    {
                        if (j % 2 == 0) { // Toutes les 2 cases on ajoute un bouton noir
				chessButton = new JLabel();
				chessButton.setBackground(blackColor);
                                chessButton.setOpaque(true);
                                Plateau[i][j] = chessButton;
                                Plateau[i][j].setHorizontalAlignment(JLabel.CENTER);
                                this.add(chessButton);
			} else {
				
				chessButton = new JLabel();
				chessButton.setBackground(whiteColor);
                                chessButton.setOpaque(true);
                                Plateau[i][j] = chessButton;
                                Plateau[i][j].setHorizontalAlignment(JLabel.CENTER);
				this.add(chessButton);
			}
                        Plateau[i][j].addMouseListener(
                        new CaseControler(i,j, this.chess,this));
                    }
                    Color temp = blackColor;
                    blackColor = whiteColor;
                    whiteColor = temp;
                }
                
                //Positionne les pieces sur le plateau
                this.positionPiece();
              
                //Ajout des pieces dans la list des joueurs
                this.addJoueurList();
               
                //this.setMenuBar(mb);
                this.initialiseMenu();
                
                
		this.setTitle("Jeu échec");//Défini le titre de la frame
		this.setLayout(new GridLayout(8, 8)); //définit une grille de 8 par 8 
		this.setSize(650, 650); //Le plateau à une dimensions de 650 par 650 
		this.setVisible(true);//Affiche la frame
	}
        
        public void initialiseMenu()
        {
            menuBar.add(menu);//Ajoute un menu sur la bar (il sera constitué de 2 items)
            menuBar.add(menuBarJoueur);//Ajoute au menu une barre qui indique le joueur
            menu_1.addActionListener( new ActionListener() {//Définit une action sur l'item 1 du menu
                @Override
                 public void actionPerformed(ActionEvent ae) {
                    nouvellePartie(ae); //Déclenche une nouvelle partie
                }

                
            });
            menu_2.addActionListener( new ActionListener() { //Définit une action sur l'item 2 du menu
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.exit(1);//Force le porgramme à ce fermé.
                }
            });
            menu.add(menu_1);//Ajoute les items au menu 
            menu.add(menu_2);
                
            this.setJMenuBar(menuBar);
        }
        public void addJoueurList()
        {
            //Permet d'ajouter les pieces dans la liste du joueur en fonction de son code couleur
            joueur2.addIcon(tourN);
            joueur2.addIcon(chevalierN);
            joueur2.addIcon(fouN);
            joueur2.addIcon(roiN);
            joueur2.addIcon(reineN);
            joueur2.addIcon(fouN);
            joueur2.addIcon(chevalierN);
            joueur2.addIcon(tourN);
            joueur2.addIcon(pionN);
            joueur2.addIcon(pionN);
            joueur2.addIcon(pionN);
            joueur2.addIcon(pionN);
            joueur2.addIcon(pionN);
            joueur2.addIcon(pionN);
            joueur2.addIcon(pionN);
            joueur2.addIcon(pionN);
            joueur1.addIcon(tourB);
            joueur1.addIcon(chevalierB);
            joueur1.addIcon(fouB);
            joueur1.addIcon(roiB);
            joueur1.addIcon(reineB);
            joueur1.addIcon(fouB);
            joueur1.addIcon(chevalierB);
            joueur1.addIcon(tourB);
            joueur1.addIcon(pionB);
            joueur1.addIcon(pionB);
            joueur1.addIcon(pionB);
            joueur1.addIcon(pionB);
            joueur1.addIcon(pionB);
            joueur1.addIcon(pionB);
            joueur1.addIcon(pionB);
            joueur1.addIcon(pionB);
        }
        
        public boolean mangePiece(String couleur,Joueur j,ImageIcon img)//La couleur qu'il à le droit de mangé
        {                                                               //l'image qui veut manger
           if(couleur == "noir") //Si la couleur est égale à noir
           {
               for (ImageIcon imageIcon : j.listImage) //On parcours la list de l'image du joueur adverse
               {
                   if(imageIcon == img)//Si il contient dans sa liste la pièce que l'on désire manger alors
                    return true;//On retourne true
                   else //Sinon
                       return false; //On retourne false
               }
           }
           else if(couleur == "blanc")//Si la couleur est égale à blanc
           {
               for (ImageIcon imageIcon : j.listImage) //On parcours la list de l'image du joueur adverse
               {
                   if(imageIcon == img)//Si il contient dans sa liste la pièce que l'on désire manger alors
                    return true;//On retourne true
                   else//Sinon
                       return false;//On retourne false
               }
           }
           
           return false;
        }
        
        public void positionPiece(){
            //Cette méthode permet de définir la position des pièces sur le plateau
            Plateau[0][0].setIcon(tourN);
            Plateau[0][1].setIcon(chevalierN);
            Plateau[0][2].setIcon(fouN);
            Plateau[0][3].setIcon(roiN);
            Plateau[0][4].setIcon(reineN);
            Plateau[0][5].setIcon(fouN);
            Plateau[0][6].setIcon(chevalierN);
            Plateau[0][7].setIcon(tourN);
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
            Plateau[7][7].setIcon(tourB);
            Plateau[6][0].setIcon(pionB);
            Plateau[6][1].setIcon(pionB);
            Plateau[6][2].setIcon(pionB);
            Plateau[6][3].setIcon(pionB);
            Plateau[6][4].setIcon(pionB);
            Plateau[6][5].setIcon(pionB);
            Plateau[6][6].setIcon(pionB);
            Plateau[6][7].setIcon(pionB);
        }
        
        public void initialiseTableau()
        {
            //Rempli le tableau des pieces en fonctions de leurs types 
            //Il sera utilisé pour vérifier quels types de pièces le joueur souhaite déplacer et ainsi
            //Effectuer un déplacement qui lui est propre.
            piece[0] = tourB;
            piece[1] = chevalierB;
            piece[2] = fouB;
            piece[3] = reineB;
            piece[4] = roiB;
            piece[5] = pionB;
                
            piece[6] = tourN;
            piece[7] = chevalierN;
            piece[8] = fouN;
            piece[9] = reineN;
            piece[10] = roiN;
            piece[11] = pionN;
        }
        
        public void initBoard()
        {
            for(int i =0; i<8;i++){
                for(int j = 0; j<8;j++)
                {
                     if (j % 2 == 0) {
                         Plateau[i][j].setBackground(blackColor);
                         Plateau[i][j].setIcon(null);
                     }
                     else
                     {
                        Plateau[i][j].setBackground(whiteColor);
                        Plateau[i][j].setIcon(null);
                     }
                }
                Color temp = blackColor;
                blackColor = whiteColor;
                whiteColor = temp;
                
            }
            this.positionPiece();
        }
        
        private void nouvellePartie(ActionEvent ae) {
            chess.nouvellePartie();
            this.initBoard();
            this.menuBarJoueur.setText("Joueur "+chess.playersActu);
         }
    
        public void update(int i, int j)
        {
            this.Plateau[i][j].setIcon(chess.temp1);
            this.Plateau[chess.positionX][chess.positionY].setIcon(null);
            this.menuBarJoueur.setText("Joueur "+chess.playersActu);
        }

    @Override
    public void avertir(int i, int j) {
        this.update(i, j); 
    }

    @Override
    public void avertirNewGame() {
        this.initBoard(); 
    }

    @Override
    public void avertirFinPartie(boolean avecGagnant) {
        System.out.println("On verra plus tard pour les gagnants");
    }
}
