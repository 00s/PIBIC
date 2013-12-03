import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class CoinColector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinColector extends Actor
{
    /**
     * Act - do whatever the CoinColector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private LinkedList<Moeda> moedas = new LinkedList<Moeda>();
    
    public CoinColector(){
        this.getImage().setTransparency(60);
    }
   
    public void act() 
    {
        
        moedas.addAll(this.getObjectsInRange(50, Moeda.class));
    }
    
    public List getMoedas(){
        return this.moedas;
    }
    
    public void zerar(){
        moedas.clear();
    }
}
