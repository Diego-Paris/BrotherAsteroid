package gamestates;

import main.Handler;
import resources.Images;
import ui.UIImageButton;
import ui.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class HelpState extends State {

	private int count = 0;
	private UIManager uiManager;

	public HelpState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUimanager(uiManager);






		// Options button
		uiManager.addObjects(new UIImageButton(75, 25, 148+40, 64+40, Images.buttonTemp, () -> {
			handler.getMouseManager().setUimanager(null);
			State.setState(handler.getGame().pauseState);
		}));






	}

	@Override
	public void tick() {
		handler.getMouseManager().setUimanager(uiManager);
		uiManager.tick();
		

	}


	@Override public void render(Graphics g) {
		g.drawImage(Images.helpTemp,0,0,handler.getWidth(), handler.getHeight(),null); uiManager.Render(g);

	}

}
