import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fundo extends World
{
  
    Objeto ref1, ref2, ref3;
    
    public Fundo()
    {    
        super(600, 400, 1);
        this.addObject(ref1 = new Objeto(), 300, 362);
        this.addObject(ref2 = new Objeto(), 200, 362);
        ref3 = ref1;
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("left")){
            ref1.setLocation(ref1.getX()-4, ref1.getY());
        }
        
        if(Greenfoot.isKeyDown("right")){
            ref3.setLocation(ref3.getX()+4, ref1.getY());
        }
    }
    
    
    
}
