/**
 * Diese Package enthält alle die Controller Classe
 */
package controller;

import model.*;
import view.*;

/**
 * Diese Class stellt der Controller des TicTAcToeprogrammmes dar.
 */
public class TicTacToeController implements ITicTacToeController {
    private ITicTacToeModel model;

    private ITictacToeView view;

    private ITicTacToeView2 view2;


    public void setModel(TicTacToeModel model) {
        this.model = model;

    }

    public void setView(TicTacToeView view) {
        this.view = view;
    }


    /**
     * Setter
     *
     * @param view2
     */
    public void setView2(ITicTacToeView2 view2) {
        this.view2 = view2;
    }

    /**
     * Diese Methode gibt an der Start des Spieles
     */
    public void startFrame() {

        view.drawSpielbrett();

    }


 /*   public void nextFrame() {


    }
*/


    /**
     * Cette methode gère les mouvements des jouers
     * lorsqu´un premier joueur joue ca dessine une croix et lorsquun deuxieme joueur joue ca dessine un cercle
     */
    public void handleMovePlayers() {

        if (model.getActivePlayer() == 'X') {
            view.drawCross();
            // view.drawPlayer1();


        } else if (model.getActivePlayer() == 'O') {
            view.drawCircle();
            // view.drawPlayer2();


        }
        model.move(view.getIndex());

        manageWinner();

    }

    /**
     * Diese Methode verwaltet der Gewinner und schickt der Ergebnis dem View
     */

    public void manageWinner() {
        if (model.hasPlayer1Won() && model.isGameOver()) {
            view.drawPlayer1Won();


        } else if (model.hasPlayer2Won()) {
            view.drawPlayer2Won();

            model.newGame();
        } else if (model.isGameOver()) {
            view.drawGameOver();

        }

    }

    /**
     * diese MEthode verwaltet wie der Spiel neu zu starten ist
     */
    public void onRestartGame() {
        model.newGame();
        startFrame();


    }

    //#############################################################################################################
    //############################                       View 2                        ############################
    // ############################################################################################################

    public void startFrame_2() {
        view2.drawSpielbrett2();
    }

    public void handleMovePlayers_2() {

        if (model.getActivePlayer() == 'X') {
            view2.drawPlayer1();


        } else if (model.getActivePlayer() == 'O') {
            view2.drawPlayer2();


        }
        model.move(view2.getIndex());

        manageWinner_2();


    }

    public void manageWinner_2() {
        if (model.hasPlayer1Won() && model.isGameOver()) {

            view2.drawPlayer2Won();


        } else if (model.hasPlayer2Won()) {

            view2.drawPlayer2Won();
            model.newGame();
        } else if (model.isGameOver()) {
            view2.drawGameOver();


        }

    }

    public void onRestartGame_2() {
        model.newGame();
        startFrame_2();


    }


}

