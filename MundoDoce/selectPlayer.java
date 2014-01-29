import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class selectPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class selectPlayer extends CandyWorld
{

    /**
     * Constructor for objects of class selectPlayer.
     * 
     */
    public selectPlayer()
    {    
         super(); 
         addObject(new Selector(), 400, 450);
    }
    
    public void act(){
      
      if(Greenfoot.getKey()=="left"){
           setPersonagem(0);
      }else if (Greenfoot.getKey()=="right"){
           setPersonagem(1);
      }
      
      
      if(Greenfoot.isKeyDown("1")){
          Greenfoot.setWorld(new Level1(getPersonagem()));
      }else if(Greenfoot.isKeyDown("2")){
          Greenfoot.setWorld(new Instructions());
      }else if(Greenfoot.isKeyDown("4")){
          Greenfoot.setWorld(new CandyWorld());
      }
      
      
    }
}
