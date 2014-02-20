import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;

/**
 * 
 * @author Michael Kolling
 * Modified by Adolfo LUcas and Marcos Antas
 * @version 1.0.1
 */
public class Variavel extends Actor
{
    private String text;
    private int stringLength;

    public Variavel(String nomeVariavel)
    {
        text = nomeVariavel;
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));
        image.setColor(Color.BLACK);
        image.drawString(text, 1, 18);
    }
    
    public void act(){
    }
    
    public void update(String up)
    {
        text = up;
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));
        image.setColor(Color.BLACK);
        image.drawString(text, 1, 18);
    }
    
    public String getTexto()
    {
        return text;
    }
}