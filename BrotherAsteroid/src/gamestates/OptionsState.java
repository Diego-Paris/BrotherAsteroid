package gamestates;

import main.Handler;
import resources.Images;
import ui.UIImageButton;
import ui.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class OptionsState extends State {

	private int count = 0;
	private UIManager uiManager;

	public OptionsState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUimanager(uiManager);

		// back button
		uiManager.addObjects(new UIImageButton(32, 32, 148+40, 64+40, Images.buttonTemp, () -> {
			handler.getMouseManager().setUimanager(null);
			State.setState(handler.getGame().menuState);
		}));

		// TODO help button placeholder
		uiManager.addObjects(new UIImageButton(handler.getWidth() - 32 - 188 , 32, 148+40, 64+40, Images.buttonTemp, () -> {
			handler.getMouseManager().setUimanager(null);
			State.setState(handler.getGame().menuState);
		}));

		//TODO on/off button placeholder
		uiManager.addObjects(new UIImageButton(370, 650, 148+40, 64+40, Images.buttonTemp, () -> {
			handler.getMouseManager().setUimanager(null);
			State.setState(handler.getGame().menuState);
		}));

		//TODO on/off button placeholder
		uiManager.addObjects(new UIImageButton(370, 730, 148+40, 64+40, Images.buttonTemp, () -> {
			handler.getMouseManager().setUimanager(null);
			State.setState(handler.getGame().menuState);
		}));





		//        uiManager.addObjects(new UIImageButton(56, 223, 128, 64, Images.Resume, () -> {
		//            handler.getMouseManager().setUimanager(null);
		//            State.setState(handler.getGame().gameState);
		//        }));
		//
		//        uiManager.addObjects(new UIImageButton(56, 223+(64+16), 128, 64, Images.BTitle, () -> {
		//            handler.getMouseManager().setUimanager(null);
		//            State.setState(handler.getGame().menuState);
		//        }));
		//        
		//        // QUIT Button 
		//        uiManager.addObjects(new UIImageButton(215,480, 128, 64, Images.QuitButton, () -> {
		//            handler.getMouseManager().setUimanager(null);
		//            System.exit(1);
		//        }));





	}

	@Override
	public void tick() {
		handler.getMouseManager().setUimanager(uiManager);
		uiManager.tick();
		


	}


	@Override public void render(Graphics g) {
		g.drawImage(Images.optionsTemp,0,0,handler.getWidth(), handler.getHeight(),null); uiManager.Render(g);

	}

}
