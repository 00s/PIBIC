import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BG here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Espiral extends Actor
{
    /**
     * Act - do whatever the BG wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int t = 0;
    
    public void act() 
    {
        if(++t == 2){
            turn(1);
            t = 0;
        }
    }
}
