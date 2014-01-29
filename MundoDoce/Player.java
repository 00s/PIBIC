import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class boy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private static GreenfootImage boy = new GreenfootImage("boy.gif");
    private static GreenfootImage girl = new GreenfootImage("boyzinha.gif");
    
    int acceleration = 0;
    
    /**
     * Act - do whatever the boy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Player(int personagem){
        if(personagem == 0){
            this.setImage(boy);
        } else{
            this.setImage(girl);
        }
    }
        
    public void act() 
    {
      
      this.setLocation(getX()+acceleration,getY());
      
        if(this.getX() > 1270){
             acceleration = (acceleration * -1) - 3;
        }
       
        if(getX() < 5){
             acceleration = (acceleration * -1) + 3;
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
          goRight();
        }
        else if(Greenfoot.isKeyDown("left"))
        {
          goLeft();
        }
      
      inertia();
      eat();
      getSick();

    }
    
    public void goRight()
    {
        acceleration+=2;
        if (acceleration > 22) acceleration = 22;
    }
    
    public void goLeft()
    {
        acceleration-=2;
        if (acceleration < -22) acceleration = -22;
    }
    
        public void eat(){
        List<Candy> candies = (List) getObjectsInRange(50, Candy.class);
        for(int c = 0; c<candies.size(); c++){
            Greenfoot.playSound("crunch.wav");
            getWorld().removeObject(candies.get(c));
            ((Level1) getWorld()).addCandy();
        }

    }

    public void getSick(){
        List<Carie> caries = (List) getObjectsInRange(50, Carie.class);
        for(int c = 0; c<caries.size(); c++){
            Greenfoot.playSound("game_over.wav");
            getWorld().removeObject(caries.get(c));
            ((Level1) getWorld()).subtractLife();
            
        }
    }
    
    public void inertia(){
        if (Greenfoot.isKeyDown("right") == false && Greenfoot.isKeyDown("left") == false){
            if (acceleration < 0){
                acceleration++;
                if (acceleration >= 0) 
                    acceleration = 0;
            } else if(acceleration > 0){
                acceleration--;
                if (acceleration <= 0) 
                    acceleration = 0;
            }
        }    
    }

}
