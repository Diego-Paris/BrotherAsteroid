package game.entities.Static;

import main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

    private Handler handler;

    public int xCoord;
    public int yCoord;
    private static boolean stateOfApple = true;
    
    
    public Apple(Handler handler,int x, int y){
        this.handler=handler;
        this.xCoord=x;
        this.yCoord=y;
    }

    public static void setGood(boolean state)
    {
    	stateOfApple = state;
    }
    
    
    public static boolean isGood()
    {
    	return stateOfApple;
    }
    
}
