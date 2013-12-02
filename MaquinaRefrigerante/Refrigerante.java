import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Refrigerante extends Actor
{
    private String nome;
    private int preco;
    
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            this.getWorld().removeObject(this);
        }
    }
    
    public Refrigerante(String nome, int preco){
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public int getPreco(){
        return this.preco;
    }
    
    public void setPreco(int preco){
        this.preco = preco;
    }
    
}
