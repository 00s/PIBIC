import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class PossivelBotao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PossivelBotao extends Actor
{
    private static GreenfootImage blue = new GreenfootImage("button-blue.png");
    private static GreenfootImage red = new GreenfootImage("button-red.png");
    private Cor cor;
    private ArrayList<Direcao> direcoes = new ArrayList<Direcao>();
    /**
     * Act - do whatever the PossivelBotao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public PossivelBotao(Cor cor, ArrayList direcoes){
        this.setCor(cor);
        this.getImage().setTransparency(110);
        this.direcoes = direcoes;
    }

    public void act(){    }    
    
    public void setCor(Cor cor){
        this.cor = cor;
        if(cor == Cor.azul)
            this.setImage(blue);
        else
            this.setImage(red);
    }

    public Cor getCor(){
        return this.cor;
    }
    
    public ArrayList<Direcao> getDirecoes(){
        return direcoes;
    }
}
