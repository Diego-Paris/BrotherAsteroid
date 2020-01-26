package resources;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class Images {


    public static BufferedImage[] butstart;
    public static BufferedImage title;
    public static BufferedImage Pause;
    public static BufferedImage GameOverState;		//image for the Game Over's background 
    public static BufferedImage reStartButt[];   		//image for the reset button 
    public static BufferedImage QuitButton[];   		//image for the quit button 
    public static BufferedImage[] Resume;
    public static BufferedImage[] BTitle;
    public static BufferedImage[] Options;
    public static ImageIcon icon;
    public static BufferedImage titleCard;
    public static BufferedImage[] menuButt;
    
    // Placeholders
    public static BufferedImage optionsTemp;
    public static BufferedImage pauseTemp;
    public static BufferedImage gameoverTemp;
    public static BufferedImage helpTemp;
    public static BufferedImage scoreTemp;
    public static BufferedImage[] buttonTemp;
    
    //Rockets
    public static BufferedImage[] rockets;
    
    //Lasers
    public static BufferedImage[] lasers;
    
    //Wallpapers
    public static BufferedImage gamestateBackground;
    
    //Asteroids
    public static BufferedImage[] asteroids;
    
    

    public Images() {

        butstart = new BufferedImage[3];
        Resume = new BufferedImage[2];
        BTitle = new BufferedImage[2];
        Options = new BufferedImage[3];
        reStartButt = new BufferedImage[2];		//for the restart button
        QuitButton = new BufferedImage[2];		//for the quit button
        menuButt = new BufferedImage[3];
        
        buttonTemp = new BufferedImage[3];
        
        rockets = new BufferedImage[2];
        lasers = new BufferedImage[2];
        asteroids = new BufferedImage[3];
        
        try {

            title = ImageIO.read(getClass().getResourceAsStream("/Wallpapers/mainmenu_background.jpg"));
            titleCard = ImageIO.read(getClass().getResourceAsStream("/Wallpapers/brother_asteroid_title.png"));
            GameOverState = ImageIO.read(getClass().getResourceAsStream("/Buttons/GameOverState.jpg"));
            Pause = ImageIO.read(getClass().getResourceAsStream("/Buttons/Pause.png"));
            Resume[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Resume.png"));
            Resume[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/ResumeP.png"));
            reStartButt[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/reStartButt.png"));	//reStart button n
            reStartButt[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/reStartButt.png"));	//reStart button after clicked?
            QuitButton[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/QuitButton.png"));		//for the quit button
            QuitButton[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/QuitButton.png"));	//for the quit button
            BTitle[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitle.png"));
            BTitle[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitleP.png"));
            Options[0] = ImageIO.read(getClass().getResourceAsStream("/NButtons/options_button_idle_2.png"));
            Options[1] = ImageIO.read(getClass().getResourceAsStream("/NButtons/options_button_hover_2.png"));
            Options[2] = ImageIO.read(getClass().getResourceAsStream("/NButtons/options_button_pressed_2.png"));
            butstart[0]= ImageIO.read(getClass().getResourceAsStream("/NButtons/play_button_idle_2.png"));//normbut
            butstart[1]= ImageIO.read(getClass().getResourceAsStream("/NButtons/play_button_hover_2.png"));//hoverbut
            butstart[2]= ImageIO.read(getClass().getResourceAsStream("/NButtons/play_button_pressed_2.png"));//clickbut
            menuButt[0]= ImageIO.read(getClass().getResourceAsStream("/NButtons/menu_button_idle.png"));//normbut
            menuButt[1]= ImageIO.read(getClass().getResourceAsStream("/NButtons/menu_button_hover.png"));//hoverbut
            menuButt[2]= ImageIO.read(getClass().getResourceAsStream("/NButtons/menu_button_pressed.png"));//clickbut
            
            icon =  new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Sheets/icon.png")));
            
            optionsTemp = ImageIO.read(getClass().getResourceAsStream("/Temp/placeholder_options_menu.png"));
            pauseTemp = ImageIO.read(getClass().getResourceAsStream("/Temp/placeholder_pause_menu.png"));
            gameoverTemp = ImageIO.read(getClass().getResourceAsStream("/Temp/placeholder_options_menu.png"));
            helpTemp = ImageIO.read(getClass().getResourceAsStream("/Temp/placeholder_help_menu.png"));
            scoreTemp = ImageIO.read(getClass().getResourceAsStream("/Temp/placeholder_score_menu.png"));
            buttonTemp[0] = ImageIO.read(getClass().getResourceAsStream("/Temp/placeholder_button_idle.png"));
            buttonTemp[1] = ImageIO.read(getClass().getResourceAsStream("/Temp/placeholder_button_hover.png"));
            buttonTemp[2] = ImageIO.read(getClass().getResourceAsStream("/Temp/placeholder_button_pressed.png"));
            
            rockets[0] = ImageIO.read(getClass().getResourceAsStream("/Spaceships/rocket_default.png"));
            rockets[1] = ImageIO.read(getClass().getResourceAsStream("/Spaceships/The_classic_mk2.png"));
            lasers[0]  = ImageIO.read(getClass().getResourceAsStream("/Lasers/laser_default.png"));
            lasers[1]  = ImageIO.read(getClass().getResourceAsStream("/Lasers/classic_laser_mk2.png"));
            
            asteroids[0]  = ImageIO.read(getClass().getResourceAsStream("/Asteroids/big_asteroid.png"));
            asteroids[1]  = ImageIO.read(getClass().getResourceAsStream("/Asteroids/med_asteroid.png"));
            asteroids[2]  = ImageIO.read(getClass().getResourceAsStream("/Asteroids/small_asteroid.png"));
            
            gamestateBackground = ImageIO.read(getClass().getResourceAsStream("/Wallpapers/gamestate_background.jpg"));
            
            

        }catch (IOException e) {
        e.printStackTrace();
    }


    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(Images.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public static BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {

        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = img.getWidth();
        int h = img.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, null);
        g2d.setColor(Color.RED);
        //g2d.drawRect(0, 0, newWidth - 1, newHeight - 1);
        g2d.dispose();

        return rotated;
    }
    
    public static BufferedImage rotate(BufferedImage bimg, double angle) {

        int w = bimg.getWidth();    
        int h = bimg.getHeight();

        BufferedImage rotated = new BufferedImage(w+100, h+100, bimg.getType());  
        Graphics2D graphic = rotated.createGraphics();
        graphic.rotate(Math.toRadians(angle), (w/2)+50, (h/2)+50);
        graphic.drawImage(bimg, null, 0+50, 0+50);
        graphic.dispose();
        return rotated;
    }
    
    
}
