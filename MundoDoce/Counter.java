import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;

/**
 * Counter that displays a number.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Counter extends Actor
{
    private int value;
    private int target = 0;
    private int highScore = 0;
    private String text;
    private int stringLength;
    

    public Counter()
    {
        this("", 0);
    }

    public Counter(String prefix, int inicialValue)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));
        image.setColor(Color.WHITE);
        target = inicialValue;        
        value = 0;
        updateImage();

    }
    
    public void act() {

        if(value < target) {
            value++;
            updateImage();
        }
        else if(value > target) {
            value--;
            updateImage();
        }
    }

    public void add(int score)
    {
        target += score;
    }

    public void subtract(int score)
    {
        target -= score;
    }

    public int getValue()
    {
        return value;
    }
    
    public void setValue(int value){
         this.value = value;
    }

    public void updateHighestScore(){
        if(highScore > target){
            highScore = target;
        }
    }
    
    /**
     * Make the image
     */
    private void updateImage(){
        if(target >=0){
           GreenfootImage image = getImage();
           image.clear();
           image.drawString(text + value, 1, 18);
        }
    }
}
