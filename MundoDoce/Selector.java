import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class selector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Selector extends Actor
{
    /**
     * Act - do whatever the selector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("right")){
            rightMove();
        }else if(Greenfoot.isKeyDown("left")){
            leftMove();
        }
    }
    
    public void rightMove(){
        this.setLocation(750,450);
    }
    
    public void leftMove(){
        this.setLocation(400,450);
    }
}
