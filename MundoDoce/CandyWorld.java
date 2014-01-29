import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CandyWorld extends World
{
    
    static int personagem = Greenfoot.getRandomNumber(2);
    GreenfootImage tela = new GreenfootImage(1280,720);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public CandyWorld()
    {    
        super(1280, 720, 1, true);
//        addObject(new Menu(), 640,360);
        //addObject(new LayerVerde(), 640, 360);
        //addObject(new Layer2(), 640, 360);
        Greenfoot.setSpeed(50);
    }
    public void act(){
        if(Greenfoot.isKeyDown("1")){
            Greenfoot.setWorld(new Level1(personagem));
            
        }else if (Greenfoot.isKeyDown("2")){
            Greenfoot.setWorld(new Instructions());
            
        }else if (Greenfoot.isKeyDown("3")){
            Greenfoot.setWorld(new selectPlayer());
        }
    }    
    

    
    //public static int getCounterValue(){
    //    return counter.getValue();
    //}
    
    
    public static int getPersonagem(){
        return personagem;
    }
    
    public static void setPersonagem(int n){
        personagem = n;
    }
}
