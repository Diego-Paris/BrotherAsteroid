package game.entities.dynamic;

import main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

import game.entities.Static.Apple;
import gamestates.State;



/**
 * Created by AlexVR on 7/2/2018.
 */
public class Player {

	public int lenght;
	public boolean justAte;
	private Handler handler;

	public int xCoord;
	public int yCoord;

	public int xVel;
	public int yVel;


	public int moveCounter;

	private int moveCheck = 4;  //this value decides the speed of the snake, default speed 4

	public String direction;    //is your first name one?

	public float currScore = 0; // stores current score
	public int stepCounter = 0;

	public boolean paused = false;
	
	Laser laser;
	Laser shots[];
	int shotIndex;

	public Player(Handler handler){
		this.handler = handler;
		xCoord = 0;
		yCoord = 0;
		moveCounter = 0;
		direction= "Right";
		justAte = false;
		lenght= 1;
		xVel = 0;
		shots = new Laser[2];
		shotIndex = 0;
	}
	
	public void tick() { 

		movementOnPressed();
		wrapAround();
		fire();

	}
	
	public void render(Graphics g, Boolean[][] playeLocation) {
		g.setColor(Color.white);
		g.fillRect(xCoord, yCoord, 32, 32);

//		if(laser != null) {
//			laser.render(g);
//		}
		
		for (int i = 0; i < shots.length; i++) {
			if(shots[i] != null) {
				shots[i].render(g);
			}
		}
		
		
		
	}
	
	public void movementOnPressed() {
		xCoord += xVel;
		yCoord += yVel;

		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
			handler.getKeyManager().setuP(true);
			this.yVel = -5;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
			handler.getKeyManager().setdP(true);
			this.yVel = 5;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)) {
			handler.getKeyManager().setlP(true);
			this.xVel = -5;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)) {
			handler.getKeyManager().setrP(true);
			this.xVel = 5;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
			paused = true;
			State.setState(handler.getGame().pauseState);
		}
	}

	public void movementOnRelease(KeyEvent d) {

		int key = d.getKeyCode();

		if(key == KeyEvent.VK_W)  
		{
			handler.getKeyManager().setuP(false);
			if(handler.getKeyManager().isdP()) 
			{
				setYVel(5);
			} 
			else 
			{
				setYVel(0);	
			}	
		}

		if(key == KeyEvent.VK_S)  
		{
			handler.getKeyManager().setdP(false);
			if(handler.getKeyManager().isuP()) 
			{
				setYVel(-5);
			} 
			else 
			{
				setYVel(0);	
			}	
		}

		if(key == KeyEvent.VK_A)  
		{
			handler.getKeyManager().setlP(false);
			if(handler.getKeyManager().isrP()) 
			{
				setXVel(5);
			} 
			else 
			{
				setXVel(0);	
			}	
		}

		if(key == KeyEvent.VK_D)  
		{
			handler.getKeyManager().setrP(false);
			if(handler.getKeyManager().islP()) 
			{
				setXVel(-5);
			} 
			else 
			{
				setXVel(0);	
			}	
		}

//		if(key == KeyEvent.VK_ESCAPE)
//			if(paused = true) {
//				paused = !paused;
//			State.setState(handler.getGame().pauseState);
//			}

	}

	public void wrapAround() {

		// If goes off left, then appear right
		if(xCoord < -20)
			xCoord = handler.getGame().getWidth() -10; 

		// If goes off right, then appear left
		if(xCoord > handler.getGame().getWidth() -5)
			xCoord = -20; 

		// If goes off left, then appear right
		if(yCoord < -20)
			yCoord = handler.getGame().getHeight() -10; 

		// If goes off right, then appear left
		if(yCoord > handler.getGame().getHeight() -5)
			yCoord = -20;


	}

	public void fire() {
		
		for (int i = 0; i < shots.length; i++) {
			
			// creates a new laser and pews
			if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE) && shots[shotIndex] == null) {
				shots[shotIndex] = new Laser(handler);
				
				System.out.println("pew");
			}

			//calls laser tick
			if(shots[shotIndex] != null) {
				System.out.println(shots[shotIndex].yCoord);
				shots[shotIndex].tick();
			}

			//if laser reached its life then nullify
			if(shots[shotIndex] != null && shots[shotIndex].getLife() == shots[shotIndex].getLifeTotal()) {
				shots[shotIndex] = null;
			}	
			shotIndex++;
		}
		
		if(shotIndex > 1) 
			shotIndex = 0;
//		
//		// creates a new laser and pews
//		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE) && laser == null) {
//			laser = new Laser(handler);
//			System.out.println("pew");
//		}
//
//		//calls laser tick
//		if(laser != null) {
//			System.out.println(laser.yCoord);
//			laser.tick();
//		}
//
//		//if laser reached its life then nullify
//		if(laser != null && laser.getLife() == laser.getLifeTotal()) {
//			laser = null;
//		}

		
		
		
		
	}

	public void setXVel(int xVel) {
		this.xVel = xVel;
	}

	public int getXVel() {
		return xVel;
	}

	public void setYVel(int yVel) {
		this.yVel = yVel;
	}

	public int getYVel() {
		return yVel;
	}
}
