package game.entities.dynamic;

import main.Handler;
import resources.Images;

import java.awt.*;


public class Laser {

	public Handler handler;
	
	public double xCoord;
	public double yCoord;
	public int speed;
	public int lifeTotal;
	public int life;
	public int angle;
	
	public Laser(Handler handler) {
	
		this.handler = handler;
		xCoord = handler.getWorld().player.xCoord + 20;
		yCoord = handler.getWorld().player.yCoord + 20;
		speed = -8;
		life = 0;
		lifeTotal = 60;
		angle = handler.getWorld().player.angle;
	}
	
	public void tick() {
		
		double givenAngle = angle;
		
		double cosAngle = Math.cos(Math.toRadians(givenAngle));
		double sinAngle = Math.sin(Math.toRadians(givenAngle));
		
		double roundedCos = Math.round(cosAngle * 100) / 100.0;
		double roundedSin = Math.round(sinAngle * 100) / 100.0;
		
		xCoord += (roundedSin) * 7;
		yCoord += (-1 * roundedCos) * 7;
		
		//System.out.println(roundedCos + ", " + roundedSin);
		
		wrapAround();
		life++;
		
	}
	
	public void render(Graphics g) {
		g.drawImage(Images.rotate(Images.lasers[0], angle) , (int)xCoord, (int)yCoord, 30, 30,null);
		g.setColor(Color.red);
		g.drawRect((int)xCoord, (int)yCoord, 30, 30);
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
		return new Rectangle((int)xCoord, (int)yCoord,30,30);
	}
	
	
	public int getLife() {
		return life;
	}
	
	public int getLifeTotal() {
		return lifeTotal;
	}
	
	
}
