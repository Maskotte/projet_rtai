/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_echec;

/**
 *
 * @author quent
 */
public class ChessTextuelle implements Observateur{
    private ChessModel chess;
    
    public ChessTextuelle(ChessModel chess) {
        this.chess = chess;
    }

    @Override
    public void avertir(int i, int j) {
        int joueurActuel = chess.getJoueur();
        System.out.println("Le joueur "+joueurActuel+" joue en case ["+i+"["+j+"]");
    }

    @Override
    public void avertirNewGame() {
        System.out.println("Une nouvelle partie commence ! C'est au joueur 1 de jouer !");
    }

    @Override
    public void avertirFinPartie(boolean avecGagnant) {
//        if(avecGagnant) {
//            String gagnant = ((chess.getJoueur()==2)?"CROIX":"ROND"); // morpion.getJoueur contient le futur joueur
//            System.out.println("La partie est terminée ! "+gagnant+" a gagné !");
//        } else {
//            System.out.println("La partie est terminée ! C'est un match nul");
//        }
    }
}
