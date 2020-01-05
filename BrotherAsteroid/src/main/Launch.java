package main;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;


public class Launch {

    public static void main(String[] args) {
    	
    
    	
    	Rectangle screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    	int screenHeight = screenSize.height / 2 +400;
    	int screenWidth  = screenSize.width  / 2 +200;
    	
    	
    	
    	
    	
    	
        GameSetUp game = new GameSetUp("Brother Asteroid", screenWidth, screenHeight);
        game.start();
    }
}