package game.entities.hostile;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.awt.Rectangle;

import main.Handler;
import resources.Images;


public class Asteroid {

	public Handler handler;
	protected int xCoord;
	protected int yCoord;
	protected int width;
	protected int height;
	protected int type;

	protected int location;
	protected boolean toSpawn;
	private Random r;
	private int xVel;
	private int yVel;
	
	List<Integer> directions;

	public Asteroid(Handler handler, int type) 
	{
		this.handler = handler;
		//r.nextInt(max)+min;
		xCoord = 0;
		yCoord = 0;
		xVel = 1;
		yVel = 1;
		toSpawn = true;
		r = new Random();
		location = 0;
		directions = Arrays.asList(-1, -1, 1, 1);
		width = 0;
		height = 0;	
		this.type = type;
	}

	public void tick() {
		//Executes once
		if(toSpawn) {
			System.out.println("toSpawn");
			//type = r.nextInt(2);
			location = r.nextInt(4)+1;
			spawnAsteroid();
			toSpawn = false;
		}
		
		xCoord += xVel;
		yCoord += yVel;
		wrapAround();

	}

	public void render(Graphics g) {
		
		if(type == 0) {
			g.drawImage(Images.asteroids[0], xCoord, yCoord, width, height,null);
			
		} else if(type == 1) {
			g.drawImage(Images.asteroids[1], xCoord, yCoord, width, height,null);
			
		} else {
			g.drawImage(Images.asteroids[2], xCoord, yCoord, width, height,null);
			
		}
		
		g.setColor(Color.red);
		g.drawRect(xCoord, yCoord, width, height);
	}

	public void spawnAsteroid() {
		System.out.println("spawned");
		
		if(type == 0) {
			width = 128;
			height = 128;
		} else if(type == 1) {
			width = 64;
			height = 64;
		} else {
			width = 32;
			height = 32;
		}
		
		switch(location) {
		case 1:
			// spawns left side of the screen
			xCoord = -100;
			yCoord = r.nextInt(handler.getHeight());
			break;
		case 2:
			// spawns right side of the screen
			xCoord = 100;
			yCoord = r.nextInt(handler.getHeight());
			break;
		case 3:
			// spawns on the top of the screen
			xCoord = r.nextInt(handler.getWidth());
			yCoord = -100;
			break;	
		default:
			// spawns at the bottom of the screen
			xCoord = r.nextInt(handler.getWidth());
			yCoord = 100;
		}
		Collections.shuffle(directions);
		xVel = directions.get(0);
		yVel = directions.get(1);
		
		

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
	
	public Rectangle getBounds() {
		return new Rectangle(xCoord,yCoord,width,height);
	}

	public int getxCoord() {
		return xCoord;
	}


	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}


	public int getyCoord() {
		return yCoord;
	}


	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}



}
