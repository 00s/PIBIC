import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameOver extends CandyWorld
{
    static int neww = 0;
    boolean clickedOnce = true;

    public gameOver()
    {    
        super();
    }
    
    public void act(){

        if(Greenfoot.isKeyDown("r")){

            restart();
        }
    }
    
        public void restart(){
            Greenfoot.setWorld(new Level1(Greenfoot.getRandomNumber(2)));
    }
    
}