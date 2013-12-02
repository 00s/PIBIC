import greenfoot.*; 
import java.awt.Color;
import java.awt.Font;

public class Display  extends Actor
{
   String imagem = "squareButton.png";
   String mensagem;
   float fontSize = 24.0F;

    public Display(String imagem, String mensagem , float fontSize)
    {
        if(imagem !=null)
            this.imagem = imagem;
            
        this.setImage(this.imagem);
        this.getImage().setTransparency(50);
        if (fontSize != 0)
           this.fontSize = fontSize;
           
        this.mensagem = mensagem;
 
        GreenfootImage image = this.getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(this.fontSize));
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
    
    public void setFontSize(float size){
        this.fontSize = size;
    }
}
