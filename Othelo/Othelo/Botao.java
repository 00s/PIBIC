import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class botao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Botao extends Actor
{
    private static GreenfootImage blue = new GreenfootImage("button-blue.png");
    private static GreenfootImage red = new GreenfootImage("button-red.png");
    private Cor cor;
    
    // botao sempre sera azul ao ser criado
    public Botao(){
        this(Cor.azul);
    }

    public Botao(Cor cor){
        this.setCor(cor);
    }

    public void act(){    }    

    public void virar(){
        if(this.getCor() == Cor.azul){
            this.setCor(Cor.vermelho);
        } else{
            this.setCor(Cor.azul);
        }
    }

    public String getColor(){
        if(this.getImage() == blue) return "blue";
        else return "red";
    }
    
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
    
    public void transparencia(int quanto){
        this.getImage().setTransparency(quanto);
    }
}
