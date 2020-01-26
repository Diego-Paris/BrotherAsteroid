package game.entities.dynamic;

import main.Handler;
import resources.Images;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import game.entities.hostile.*;

import game.entities.hostile.Apple;
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

	public int angle;
	public int angleVel;

	public boolean paused = false;

	Laser laser;
	Laser shots[];
	int shotIndex;

	public ArrayList<Laser> shotsFired;
	public ArrayList<Laser> toRemove;



	public Player(Handler handler){
		this.handler = handler;
		xCoord = (handler.getWidth()/2)-70;
		yCoord = (handler.getHeight()/2)-70;
		moveCounter = 0;
		direction= "Right";
		justAte = false;
		lenght= 1;
		xVel = 0;
		shots = new Laser[2];
		shotIndex = 0;
		angle = 0;
		angleVel = 0;
		shotsFired = new ArrayList<Laser>();
		toRemove = new ArrayList<Laser>();


	}

	public void tick() { 

		movementOnPressed();
		wrapAround();
		fire();




	}

	public void render(Graphics g, Boolean[][] playeLocation) {

		for (Laser laser : shotsFired) {
			if(laser != null) {
				laser.render(g);
			}
		}
		g.drawImage(Images.rotate(Images.rockets[0], angle) , xCoord, yCoord, 70, 70,null);
		g.setColor(Color.red);
		g.drawRect(xCoord, yCoord, 70, 70);

	}



	public void movementOnPressed() {
		xCoord += xVel;
		yCoord += yVel;

		angle += angleVel;

		if(angle > 360) {angle = 0;}
		if(angle < 0)   {angle = 360;}

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

		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)) {
			handler.getKeyManager().setarP(true);
			this.angleVel = 3;
		}

		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT)) {
			handler.getKeyManager().setalP(true);
			this.angleVel = -3;
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

		if(key == KeyEvent.VK_RIGHT)  
		{
			handler.getKeyManager().setarP(false);
			if(handler.getKeyManager().isalP()) 
			{
				angleVel= -3;
			} 
			else 
			{
				angleVel = 0;	
			}	
		}

		if(key == KeyEvent.VK_LEFT)  
		{
			handler.getKeyManager().setalP(false);
			if(handler.getKeyManager().isarP()) 
			{
				angleVel = 3;
			} 
			else 
			{
				angleVel = 0;	
			}	
		}


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

		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)) {

			shotsFired.add(new Laser(handler));
			System.out.println("PEW!");

		}
		for (Laser laser : shotsFired) {

			if(laser.life == laser.lifeTotal)
				toRemove.add(laser);

			if(laser != null) {
				laser.tick();
				
				if(handler.getWorld().roid != null && laser.getBounds().intersects(handler.getWorld().roid.getBounds())) {
									System.out.println("LASER HIT AN ASTEROID");
									toRemove.add(laser);
									//handler.getWorld().roid = null;
				}
			}


		}
		shotsFired.removeAll(toRemove);
		toRemove.clear();
	}

	public Rectangle getBounds() {
		return new Rectangle(xCoord,yCoord,70,70);
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
