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
interface Observateur {
    void avertir(int i, int j);
    void avertirNewGame();
    void avertirFinPartie(boolean avecGagnant);
}
