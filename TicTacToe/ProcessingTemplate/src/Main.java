
import controller.TicTacToeController;
import model.TicTacToeModel;
import processing.core.PApplet;
import view.TicTacToeView;

/**
 * Erste Main Class
 */
    public  class Main{

public static void main(String[]args){

        TicTacToeModel model=new TicTacToeModel();
        TicTacToeView view=new TicTacToeView(800,700);
        TicTacToeController controller=new TicTacToeController();
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);
        PApplet.runSketch(new String[]{"TicTacToeView"},view);
        }
        }
