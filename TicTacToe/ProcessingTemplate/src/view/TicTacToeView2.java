package view;
import processing.core.PApplet;
import processing.core.PImage;
import controller.*;

public class TicTacToeView2 extends PApplet implements ITicTacToeView2 {

    private ITicTacToeController controller;

    public TicTacToeView2(int width, int height){
        setSize(width,height);
    }

    public void setTicTacToeController(ITicTacToeController controller){
        this.controller = controller;
    }

    public void setup(){
        controller.startFrame_2();

    }

    public void draw(){

    }

    public void drawSpielbrett2(){
        background(0);
        stroke(255);
        strokeWeight(4);

        float feldwidth =  width/3;
        float feldheight = height/3;


        // Vertikale Linie
        line(feldwidth,0,feldwidth,height);
        line(2*feldwidth,0,2*feldwidth,height);


        // Horizontale Linie
        line(0,feldheight,width,feldheight);
        line(0,2*feldheight,width,2*feldheight);


    }

    public void mousePressed(){
        controller.handleMovePlayers_2();
    }

    /**
     *     Diese Methode zeigt der erste Player an
      */

    public void drawPlayer1(){
        PImage player1 = loadImage("C:\\Users\\Kharlyne\\IdeaProjects\\TicTacToe\\ProcessingTemplate\\images\\Digimon-PNG-Free-Download.png");
        player1.resize(100,100);
        image(player1,mouseX,mouseY);
    }

    /**
     * Diese Methode zeigt der zweite Player an
     */
    public void drawPlayer2(){
        PImage player2 = loadImage("C:\\Users\\Kharlyne\\IdeaProjects\\TicTacToe\\ProcessingTemplate\\images\\Digimon-PNG-Free-Image.png");
        player2.resize(100,100);
        image(player2,mouseX,mouseY);

    }

    /**
     * Diese Methode zeigt, dass der erste Player  gewonnen hat
     */
    public void drawPlayer1Won(){
        background(0);
        fill(255);
        textSize(32);
        textAlign(CENTER, CENTER);
        text("Der Spieler 1 hat gewonnen !",width/2,height/2 -20);
        textSize(20);
        text("Drücken Sie auf Enter um den Spiel neu zu starten !",width/2, height/2 + 30);

    }

    /**
     * Diese Methode zeigt, dass der zweite Player  gewonnen hat
     */
    public void drawPlayer2Won(){
        background(0);
        fill(255);
        textSize(32);
        textAlign(CENTER,CENTER);
        text("Der Spieler 2 hat gewonnen ! ", width/2, height/2);
        textSize(20);
        text("Drücken Sie auf Enter um den Spiel neu zu starten !",width/2,height/2 + 30);
    }

    /**
     * Diese Methode zeigt, dass der SPiel geendet wurde
     */
    public void drawGameOver(){
        background(0);
        fill(255);
        textAlign(CENTER, CENTER);
        textSize(35);
        text("End Game", width / 2, height / 2 - 20);
        textSize(25);
        text("Drücken Sie auf Enter um den Spiel neu zu starten!", width / 2, height / 2 + 30);


    }

    public int getIndex(){
        int index = 0;
        if (mouseX<width/3 && mouseX >0 && mouseY<height/3 && mouseY>0 ){
            index = 0;
            return  index;
        }else if (mouseX<2*width/3 && mouseX > width/3 && mouseY<height/3 && mouseY>0){
            index = 1;
            return index;
        } else if (mouseX <width && mouseX > 2*width/3 && mouseY<height/3 && mouseY>0) {
            index = 2;
            return index;

        }else if (mouseX<width/3 && mouseX >0 && mouseY <2*height/3 && mouseY>height/3){
            index = 3;
            return index;
        } else if (mouseX<2*width/3 && mouseX > width/3 &&mouseY <2*height/3 && mouseY>height/3 ) {
            index = 4;
            return index;

        } else if (mouseX < width && mouseX > 2*width/3&& mouseY <2*height/3 && mouseY>height/3) {
            index = 5;
            return index;

        } else if (mouseX<width/3 && mouseX >0 && mouseY<height && mouseY > 2*height/3) {
            index = 6;
            return index;

        } else if (mouseX<2*width/3 && mouseX > width/3  && mouseY<height && mouseY > 2*height/3 ) {
            index = 7;
            return index;

        } else if (mouseX <width && mouseX > 2*width/3&&  mouseY<height && mouseY > 2*height/3) {
            index = 8;
            return index;

        }else {
            return index;
        }

    }

    public  void keyPressed(){
        if (key == ENTER || key == RETURN){
            controller.onRestartGame_2();
        }
    }

}
