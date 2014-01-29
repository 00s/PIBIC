import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import javax.imageio;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carie extends Actor
{
    private static GreenfootImage monstro0 = new GreenfootImage("monstroRosa.gif");
    private static GreenfootImage monstro1 = new GreenfootImage("monstroRoxo.gif");
    private static GreenfootImage monstro2 = new GreenfootImage("monstroChumbo.gif");
    private static GreenfootImage monstro3 = new GreenfootImage("monstroAmarelo.gif");
    private static GreenfootImage monstro4 = new GreenfootImage("monstroAzul.gif");
    private static GreenfootImage monstro5 = new GreenfootImage("monstroVerde.gif");
    
    public Carie(int i){
        switch (i){
                    case 0:
                this.setImage(monstro0);
              break;
            case 1:
                this.setImage(monstro1);
              break;
            case 2:
                this.setImage(monstro2);
              break;
            case 3:
                this.setImage(monstro3);
              break;
            case 4:
                this.setImage(monstro4);
              break;
            case 5:
                this.setImage(monstro5);
              break;
        }
    }
    
    int velocidade = 5, aux=0;
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() + velocidade);
        
        if(aux++%50==0){
            velocidade++;
        }
        if (getY() >= 710) {
            getWorld().removeObject(this);
        }

    }    
}
