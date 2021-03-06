package worlds;

import main.Handler;
import resources.Images;

import java.awt.*;
import java.util.Random;

import game.entities.hostile.Apple;
import game.entities.hostile.Asteroid;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class WorldOne extends WorldBase{

	
    public WorldOne (Handler handler) {
        super(handler);

        //has to be a number bigger than 20 and even
        
        //TODO this used to be a 40, changes grid to 64x64 now

        GridWidthHeightPixelCount = 60;
        GridPixelsize = (600/GridWidthHeightPixelCount);
        playerLocation = new Boolean[GridWidthHeightPixelCount][GridWidthHeightPixelCount];
        appleLocation = new Boolean[GridWidthHeightPixelCount][GridWidthHeightPixelCount];
        
        //roid = new Asteroid(handler);
    }

    @Override
    public void tick() {
        super.tick();
        player.tick();
        roid.tick();
        
        if(player.getBounds().intersects(roid.getBounds())) {
        	System.out.println("INTERSECTED, YAY!");
        }
        
        
        if(!appleOnBoard){
            appleOnBoard=true;
            int appleX = new Random().nextInt(handler.getWorld().GridWidthHeightPixelCount-1);
            int appley = new Random().nextInt(handler.getWorld().GridWidthHeightPixelCount-1);

            //change coordinates till one is selected in which the player isnt standing
            boolean goodCoordinates=false;
            do{
                if(!handler.getWorld().playerLocation[appleX][appley]){
                    goodCoordinates=true;
                }
            }while(!goodCoordinates);

            apple = new Apple(handler,appleX,appley);
            appleLocation[appleX][appley]=true;

        }
    }

    @Override
    public void render(Graphics g){
        super.render(g);
       
        g.drawImage(Images.gamestateBackground,0,0,handler.getWidth(),handler.getHeight(),null);
        
        g.setColor(Color.GREEN);
    	g.setFont(new Font("Consolas", Font.PLAIN ,  25));
    	g.drawString("Score: " + player.currScore, 40, 20);
    	
    	
        player.render(g,playerLocation);
        roid.render(g);
    }

}
