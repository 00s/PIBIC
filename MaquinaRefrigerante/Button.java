import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe criada para diferenciar o botao do display
 */
public class Button extends Display
{
    private int id;
    public Button(String msg, float fontSize, int id){
        super("squareButton.png",msg, fontSize);
        this.id = id;
    }  
    
    public int getID(){
        return this.id;
    }
}
