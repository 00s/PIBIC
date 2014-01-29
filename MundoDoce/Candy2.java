import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Candy2 extends Actor
{
    private static GreenfootImage image0 = new GreenfootImage("muffin.png");
    private static GreenfootImage image1 = new GreenfootImage("bonecoDoce.gif");
    private static GreenfootImage image2 = new GreenfootImage("donutBranco.gif");
    private static GreenfootImage image3 = new GreenfootImage("donutMarrom.gif");
    private static GreenfootImage image4 = new GreenfootImage("cupcake.gif");
    private static GreenfootImage image5 = new GreenfootImage("pirulito.gif");
    
    private int xMove = 3, yMove = -3;
    

    public Candy2(int i){
        switch (i){
            case 0:
                this.setImage(image0);
              break;
            case 1:
                this.setImage(image1);
              break;
            case 2:
                this.setImage(image2);
              break;
            case 3:
                this.setImage(image3);
              break;
            case 4:
                this.setImage(image4);
              break;
            case 5:
                this.setImage(image5);
              break;
        }
    }
    
    /**
     * Act - do whatever the monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        if (getY() >= 710) {
            getWorld().removeObject(this);
        }
    }
    
    private void move(){
        if(canMoveX()){
            setLocation(getX()+xMove,getY());
        } else {
            xMove *= -1;
            setLocation(getX()+xMove,getY());
        }
        
        if(canMoveY()){
            setLocation(getX(),getY()+yMove);
        } else {
            yMove *= -1;
            setLocation(getX(),getY()+yMove);
        }
        
    }
    
    boolean canMoveX(){
        if (getX() <=1 || getX() >= 1279){
            return false;
        }else {
            return true;
        }
    }
    
        boolean canMoveY(){
        if (getY() <=1 || getY() >= 719){
            return false;
        }else {
            return true;
        }
    }
}
