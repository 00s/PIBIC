import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Adolfo Melo) 
 * @version (24.01.2014)
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
