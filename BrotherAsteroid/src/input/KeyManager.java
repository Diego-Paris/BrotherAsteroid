package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.Handler;

/**
 * Created by AlexVR on 7/1/2018.
 */

public class KeyManager implements KeyListener {

	private boolean[] keys,justPressed,cantPress;
	public boolean up=false, down=false, left=false, right=false;
	public boolean pbutt=false;
	
	public boolean uP = false;
	public boolean dP = false;
	public boolean lP = false;
	public boolean rP = false;
	
	private Handler handler;
	

	public KeyManager(Handler handler){

		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
		this.handler = handler;

	}

	public void tick(){
		for(int i =0; i < keys.length;i++){
			if(cantPress[i] && !keys[i]){
				cantPress[i]=false;

			}else if(justPressed[i]){
				cantPress[i]=true;
				justPressed[i] =false;
			}
			if(!cantPress[i] && keys[i]){
				justPressed[i]=true;
			}
		}

		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];

		pbutt = keys[KeyEvent.VK_ESCAPE];

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
		
		handler.getWorld().player.movementOnRelease(e);
			
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	
	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}

	public boolean isuP() {
		return uP;
	}

	public void setuP(boolean uP) {
		this.uP = uP;
	}

	public boolean isdP() {
		return dP;
	}

	public void setdP(boolean dP) {
		this.dP = dP;
	}

	public boolean islP() {
		return lP;
	}

	public void setlP(boolean lP) {
		this.lP = lP;
	}

	public boolean isrP() {
		return rP;
	}

	public void setrP(boolean rP) {
		this.rP = rP;
	}
	
	

}
