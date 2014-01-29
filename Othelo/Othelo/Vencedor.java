import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;

/**
 * Counter that displays a number.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Vencedor extends Actor
{
    private int value;

    private String text;
    private int stringLength;
    

    public Vencedor()
    {
        this("", 16);
    }

    public Vencedor(String vencedor, int stringlength)
    {
        text = vencedor;
        stringLength = (text.length() + 2) * stringlength;
        
        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));
        image.setColor(Color.BLACK);
        updateImage();

    }
    
    public void act() {

    }

    /**
     * Make the image
    */
    private void updateImage(){
           GreenfootImage image = getImage();
           image.drawString(text, 1, 18);
        }
    }
