package view;
import processing.core.PApplet;
import processing.core.PImage;
import controller.*;
//import javax.swing.*;

/**
 * View von TicTacToe
 */
public class TicTacToeView extends PApplet implements ITictacToeView {
    private ITicTacToeController controller;

    public TicTacToeView(int width, int height){
        setSize(width,height);
    }

    /**
     * gibt der Wert von Controller zurück
     * @param control
     */
    public void setController(ITicTacToeController control){
        this.controller = control;
    }

    /**
     * Beginn des Spieles
     */
    public void setup(){

        controller.startFrame();

    }

    public void draw(){
    }

    /**
     * zeichnung des Spielbrettes
     */
    public void drawSpielbrett(){
        background(255);
        stroke(0);
        strokeWeight(4);

        float feldwidth =  (float) width /3;
        float feldheight = (float) height/3 ;


        // Vertikale Linie
        line(feldwidth,0,feldwidth,height);
        line(2*feldwidth,0,2*feldwidth,height);


        // Horizontale Linie
        line(0,feldheight,width,feldheight);
        line(0,2*feldheight,width,2*feldheight);


    }

    public void mousePressed(){
        controller.handleMovePlayers();


    }


    public void drawCross(){
        float size = 40;
        line(mouseX - size/2, mouseY -size/2, mouseX + size/2,mouseY + size/2);
        line(mouseX + size/2,mouseY - size/2,mouseX - size/2,mouseY + size/2);

    }

    public void  drawCircle(){

        float size  =  40;
        fill(0);
        circle(mouseX,mouseY,size);
    }


    public void drawPlayer1(){
        PImage player1 = loadImage("images/035.pmg");
        player1.resize(50,50);
        image(player1, mouseX,mouseY);
    }

    public void drawPlayer2(){
        PImage player2 = loadImage("images/114.png");
        player2.resize(50,50);
        image(player2,mouseX,mouseY);
    }


    public void drawPlayer1Won(){
        background(255);
        fill(0);
        textSize(32);
        textAlign(CENTER, CENTER);
        text("Player 1 wins !",(float)width/2,(float)height/2 -20);
        textSize(20);
        text("Press Enter to Restart Game",(float)width/2, (float)height/2 + 30);

    }

    public void drawPlayer2Won(){
        background(255);
        fill(0);
        textSize(32);
        textAlign(CENTER,CENTER);
        text("Player 2 wins !", (float)width/2, (float)height/2);
        textSize(20);
        text("Press Enter to Restart Game",(float)width/2,(float)height/2 + 30);
    }
    public void drawGameOver(){
        background(255);
        fill(0);  // Texte blanc
        textAlign(CENTER, CENTER);  // Alignement du texte au centre
        textSize(32);  // Taille du texte
        text("Game Over", (float)width / 2, (float)height / 2 - 20);
        textSize(20);  // Taille du texte plus petit
        text("Press Enter to Restart Game", (float)width / 2, (float)height / 2 + 30);


    }

    public int getIndex(){
        int index=0 ;
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

    public void keyPressed(){
        if (key==ENTER || key == RETURN){
            controller.onRestartGame();
        }

    }





}

