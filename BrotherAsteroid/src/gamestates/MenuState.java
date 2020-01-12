package gamestates;

import main.Handler;
import resources.Images;
import ui.ClickListlener;
import ui.UIImageButton;
import ui.UIManager;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class MenuState extends State {
	
	public int ypos = 0;
	public int delay = 0;
	public int direction = 1;
	
	
    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);


        uiManager.addObjects(new UIImageButton(handler.getWidth()/8, handler.getHeight()/3+125, (500/3)+40, (180/3)+20, Images.butstart, new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null);
                handler.getGame().reStart();
                State.setState(handler.getGame().gameState);
            }
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/8, handler.getHeight()/3+125+80, (500/3)+40, (180/3)+20, Images.Options, new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null);
                handler.getGame().reStart();
                State.setState(handler.getGame().optionsState);
            }
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/8, handler.getHeight()/3+125+160, 499/3+33, 150/3+18, Images.menuButt, new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null);
                handler.getGame().reStart();
                State.setState(handler.getGame().scoresState);
            }
        }));
        
        uiManager.addObjects(new UIImageButton(handler.getWidth()/8, handler.getHeight()/3+125+240, 499/3+33, 150/3+18, Images.QuitButton , new ClickListlener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUimanager(null);
                System.exit(0);
            }
        }));
        
        
        
    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();
        jiggle();
    }

    @Override
    public void render(Graphics g) {
    	
    	
        g.setColor(Color.darkGray);
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        g.drawImage(Images.title,0,0,handler.getWidth(),handler.getHeight(),null);
        g.drawImage(Images.titleCard,0,ypos,handler.getWidth(),handler.getHeight(),null);
        uiManager.Render(g);

    }
    
    
    

    public void jiggle() {
    	
    	
    	if(delay % 10 == 0)
    		ypos += direction;
    	
    	if(delay > 90)
    		delay = 0;
    		direction *= -1;
    	
    	delay++;
    	
    }
}
