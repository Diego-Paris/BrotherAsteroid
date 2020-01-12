package resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
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
    
    

    public Images() {

        butstart = new BufferedImage[3];
        Resume = new BufferedImage[2];
        BTitle = new BufferedImage[2];
        Options = new BufferedImage[3];
        reStartButt = new BufferedImage[2];		//for the restart button
        QuitButton = new BufferedImage[2];		//for the quit button
        menuButt = new BufferedImage[3];
        
        buttonTemp = new BufferedImage[3];
        
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

}
