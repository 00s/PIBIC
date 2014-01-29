import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends CandyWorld
{

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions()
    {    
        super(); 
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("1")){
            Greenfoot.setWorld(new Level1(personagem));
        }else if(Greenfoot.isKeyDown("3")){
            Greenfoot.setWorld(new selectPlayer());
        }else if(Greenfoot.isKeyDown("4")){
            Greenfoot.setWorld(new CandyWorld());
        }
    }
}
