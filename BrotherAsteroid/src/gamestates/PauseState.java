package gamestates;

import main.Handler;
import resources.Images;
import ui.UIImageButton;
import ui.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class PauseState extends State {

	private int count = 0;
	private UIManager uiManager;

	public PauseState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUimanager(uiManager);






		// Resume button
		uiManager.addObjects(new UIImageButton(400, 370, 148+40, 64+40, Images.buttonTemp, () -> {
			handler.getMouseManager().setUimanager(null);
			State.setState(handler.getGame().gameState);
		}));

		// Restart button
		uiManager.addObjects(new UIImageButton(400, 460, 148+40, 64+40, Images.buttonTemp, () -> {
			handler.getMouseManager().setUimanager(null);
			handler.getGame().reStart();
			State.setState(handler.getGame().gameState);
		}));

		// Help button
		uiManager.addObjects(new UIImageButton(400, 550, 148+40, 64+40, Images.buttonTemp, () -> {
			handler.getMouseManager().setUimanager(null);
			
			State.setState(handler.getGame().helpState);
		}));

		// Menu button
		uiManager.addObjects(new UIImageButton(400, 640, 148+40, 64+40, Images.buttonTemp, () -> {
			handler.getMouseManager().setUimanager(null);
			handler.getGame().reStart();
			State.setState(handler.getGame().menuState);
		}));


		// QUIT Button 
		uiManager.addObjects(new UIImageButton(400, 730, 148+40, 64+40, Images.buttonTemp, () -> {
			handler.getMouseManager().setUimanager(null);
			System.exit(1);
		}));





	}

	@Override
	public void tick() {
		handler.getMouseManager().setUimanager(uiManager);
		uiManager.tick();
		count++;
		if( count>=40){
			count=40;
		}
		if(handler.getKeyManager().pbutt && count>=40){
			count=0;

			State.setState(handler.getGame().gameState);
		}


	}


	@Override public void render(Graphics g) {
		g.drawImage(Images.pauseTemp,0,0,handler.getWidth(), handler.getHeight(),null); uiManager.Render(g);

	}

}
