import greenfoot.*; 
import java.awt.Color;
import java.awt.Font;

public class Display  extends Actor
{
   String imagem = "fundoDisplay.png";
   String mensagem;

    public Display(String mensagem)
    {
        this.mensagem = mensagem;
 
        GreenfootImage image = this.getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));
        image.setColor(Color.WHITE);
        image.drawString(mensagem, 30, 30);
    }
    
    public void act(){
        update();
    }
    
    public void update(){
        GreenfootImage image = new GreenfootImage(this.imagem);
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));
        image.setColor(Color.WHITE);
        image.drawString(this.mensagem, 30, 30);
        setImage(image);
    }
    
    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }
}
