import controller.TicTacToeController;
import model.TicTacToeModel;
import processing.core.PApplet;
import view.TicTacToeView2;

public class Main2 {
    public  static void main(String[] args){

        final int GAME_WIDTH = 800;
        final int GAME_HEIGHT = 600;
        var model = new TicTacToeModel();
        var view = new TicTacToeView2(GAME_WIDTH,GAME_HEIGHT);
        var controller = new TicTacToeController();



        // Connect M, V and C
        controller.setView2(view);
        controller.setModel(model);
        view.setTicTacToeController(controller);


        PApplet.runSketch(new String[]{"TicTacToeView2"}, view);


    }
}
