import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Moeda extends Actor{
    private final int valor;
    private final String imagem;
    
    
    public void act(){
        if( Greenfoot.mouseDragged(this) )
                this.setLocation(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    
    
    public Moeda(int valor)
    {
       String image = "";
       
       switch(valor){
            case 25:
                image = "vinteCinco.png";
              break;
            case 50:
                image = "cinquentaC.png";
              break;
            case 100:
                image = "umreal.png";
              break;
            default: // 10 centavos
                image = "dezC.png";
                valor = 10;
              break;
       }
       this.valor = valor;
       this.imagem = "moedas/" + image;
       this.setImage(imagem);
    }
                      
     public int getValor(){
        return this.valor;
    }
    
    
    
}