import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class parede here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class parede extends World
{

    /**
     * Constructor for objects of class parede.
     * 
     */
    
    GreenfootImage bg = new GreenfootImage(10,10);
    public parede()
    {    
        super(600, 400, 1); 
        bg.setColor(Color.getColor("WHITE"));
        bg.fill();
        this.setBackground(bg);
        Interruptor interr = new Interruptor();
        this.addObject(interr, 287, 305);
        this.addObject(new Lampada(interr), 287, 55);
        this.addObject(new Lampada(interr), 497, 55);
        this.addObject(new Lampada(interr), 107, 55);
    }
}
