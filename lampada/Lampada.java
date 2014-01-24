import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lampada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lampada extends Actor
{
    public static GreenfootImage acesa = new GreenfootImage("lamp1.jpg");
    public static GreenfootImage apagada = new GreenfootImage("lamp2.jpg");
    private Interruptor interr;
    
    public Lampada(Interruptor interr){
        this.setImage(apagada);
        this.interr = interr;
    }
    
    public void act(){
        if(interr.getEstado()){
            this.setImage(acesa);
        }else{
            this.setImage(apagada);
        }
    }
}
