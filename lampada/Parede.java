import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class parede here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Parede extends World
{
    public GreenfootImage fundo = new GreenfootImage(1,1);
    private Interruptor interr = new Interruptor();
    private Lampada lamp1 = new Lampada(interr);
    
    public Parede()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300, 600, 1); 
        fundo.setColor(Color.WHITE);
        fundo.fill();
        this.addObject(interr, 155, 550);
        this.addObject(lamp1, 155, 100);
    }
}
