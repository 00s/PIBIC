import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class interruptor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Interruptor extends Actor
{
    GreenfootImage on = new GreenfootImage("onSwitch.jpg");
    GreenfootImage off = new GreenfootImage("offSwitch.jpg");
    private boolean ligado = false;
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            this.doSwitch();
        }
    }
    
    private void doSwitch(){
        if(ligado){
            ligado = false;
            this.setImage(off);
        }
        else{
            ligado = true;
            this.setImage(on);
        }
    }
    
    public boolean getEstado(){
        return ligado;
    }
}
