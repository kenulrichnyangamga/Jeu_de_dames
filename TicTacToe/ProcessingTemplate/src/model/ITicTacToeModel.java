package model;
public interface ITicTacToeModel {
    void newGame();

    char getFieldEntry(int var1);

    boolean isEmptyField(int var1);

    char getActivePlayer();

    void move(int var1);

    boolean hasPlayer1Won();

    boolean hasPlayer2Won();

    boolean isGameOver();
}
