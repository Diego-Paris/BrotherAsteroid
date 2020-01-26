package worlds;

import game.entities.dynamic.Player;
import game.entities.dynamic.Tail;
import game.entities.hostile.Apple;
import game.entities.hostile.Asteroid;
import main.Handler;
import resources.Images;

import javax.swing.JOptionPane;

import java.awt.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 * Created by AlexVR on 7/2/2018.
 */
public abstract class WorldBase {

    //How many pixels are from left to right
    //How many pixels are from top to bottom
    //Must be equal
    public int GridWidthHeightPixelCount;

    //automatically calculated, depends on previous input.
    //The size of each box, the size of each box will be GridPixelsize x GridPixelsize.
    public int GridPixelsize;

    public Player player;
    public Asteroid roid;

    protected Handler handler;


    public Boolean appleOnBoard;
    protected Apple apple;
    public Boolean[][] appleLocation;


    public Boolean[][] playerLocation;

    public LinkedList<Tail> body = new LinkedList<>();


    public WorldBase(Handler handler){
        this.handler = handler;

        appleOnBoard = false;
        

    }
    public void tick(){



    }
    
    //TODO This block controls the grid lines, add a debug mode here
    //change to a 64x64 grid
    
    
    
    public void render(Graphics g){

//        for (int i = 0; i <= 800; i = i + GridPixelsize) {
//
//            g.setColor(Color.white);
//            g.drawLine(0, i, handler.getWidth() , i);
//            g.drawLine(i,0,i,handler.getHeight());
//
//        }
    	
//    	g.setColor(Color.GREEN);
//    	g.setFont(new Font("Consolas", Font.PLAIN ,  25));
//    	g.drawString("Score: " + player.currScore, 40, 20);
//    	g.drawImage(Images.gamestateBackground,0,0,handler.getWidth(),handler.getHeight(),null);
    }

}
