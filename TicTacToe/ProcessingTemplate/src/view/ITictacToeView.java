package view;
public interface ITictacToeView {
    public void drawSpielbrett();

    void drawCross();

    void  drawCircle();

    void drawPlayer1();

    void drawPlayer2();

    void drawGameOver();

    void drawPlayer2Won();

    void drawPlayer1Won();

    int getIndex();
}
