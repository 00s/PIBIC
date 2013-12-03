import greenfoot.*; 
import java.awt.Color;
import java.awt.Font;

public class Display  extends Actor
{
   private String imagem = "squareButton.png";
   private String[] mensagem = {"", ""};
   private float fontSize = 22.0F;
   private final int initPosX = 90;
   private final int initPosY = 10;
   private final int transparence = 70;
    public Display(String imagem, String[] mensagem , float fontSize)
    {
        if(imagem !=null)
            this.imagem = imagem;
            
        this.setImage(this.imagem);
        this.getImage().setTransparency(transparence);
        if (fontSize != 0)
           this.fontSize = fontSize;
           
        this.mensagem = mensagem;
 
        GreenfootImage image = this.getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(this.fontSize));
        image.setColor(Color.WHITE);
        int pos = initPosX;
        if(this.mensagem != null)
            for(String msg : this.mensagem){
                if( msg != null){
                    image.drawString(msg, initPosY, pos);
                    pos +=30;
                }
            }
    }
    
    public void act(){
        update();
    }
    
    public void update(){
        GreenfootImage image = new GreenfootImage(this.imagem);
        Font font = image.getFont();
        image.setFont(font.deriveFont(this.fontSize));
        image.setColor(Color.BLACK);
        int pos = initPosX;
        if(this.mensagem != null)
        for(String msg : this.mensagem){
            if(msg!=null){
                image.drawString(msg, initPosY, pos);
                pos +=30;
            }
        }

        setImage(image);
        this.getImage().setTransparency(transparence);
    }
    
    public void setMensagem(String[] mensagem){
        this.mensagem = mensagem;
    }
    
    public void setFontSize(float size){
        this.fontSize = size;
    }
}
