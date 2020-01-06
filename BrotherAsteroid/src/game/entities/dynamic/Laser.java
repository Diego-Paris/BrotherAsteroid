package game.entities.dynamic;

import main.Handler;

import java.awt.*;


public class Laser {

	public Handler handler;
	
	public int xCoord;
	public int yCoord;
	public int speed;
	public int lifeTotal;
	public int life;
	
	public Laser(Handler handler) {
	
		this.handler = handler;
		xCoord = handler.getWorld().player.xCoord+11;
		yCoord = handler.getWorld().player.yCoord;
		speed = -8;
		life = 0;
		lifeTotal = 60;
	}
	
	public void tick() {
		yCoord += speed;
		wrapAround();
		life++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(xCoord, yCoord, 10, 30);
		
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
	
	public int getLife() {
		return life;
	}
	
	public int getLifeTotal() {
		return lifeTotal;
	}
	
	
}
