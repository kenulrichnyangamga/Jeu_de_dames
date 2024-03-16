package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {
    @Test
    void getFieldEntry_Test(){
        TicTacToeModel model = new TicTacToeModel();
        char testjj = model.getFieldEntry(10);
        assertEquals(testjj,  model.getFieldEntry(1));

    }

    @Test
    // hier sollte getestet werden, dass ein Field Entry valid ist ( verifier si lorsque jentre un index il est valide cest a dire si
    //il est libre ou pas ou si il est entre 0 et 8.
    void isValidFieldIndexTest(){
        TicTacToeModel model = new TicTacToeModel();

        boolean test = model.isValidFieldIndex(5);

        assertNotEquals(test,  model.getFieldEntry(6));
    }

    @Test
    void gameStateTest(){
        TicTacToeModel model = new TicTacToeModel();

        char[] test = model.getGameState();

        char[] newTabelle = new char[]{'X', 'O', 'X', 'O', 'X', 'O','X', 'X', 'O'};
        model.setGameState(newTabelle);

        assertNotEquals(test,  model.getGameState());

    }

    @Test
    public void movetest() {
        TicTacToeModel model = new TicTacToeModel();
        int newMoveCount = model.moveCount;
        model.move(5);
        int test = model.moveCount;

        assertNotEquals(newMoveCount, test);
    }

    @Test
    public void isgameovertest(){
        TicTacToeModel model = new TicTacToeModel();
        boolean a= model.isGameOver();
        model.move(2);
        model.move(3);
        model.move(5);
        model.move(4);
        model.move(8);
        boolean test= model.isGameOver();

        assertNotEquals(a,test);

    }

}
