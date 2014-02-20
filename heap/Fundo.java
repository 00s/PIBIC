import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;

public class Fundo extends World
{
  
    Objeto ref1, ref2, ref3;
    Me botao;
    public Variavel[] log;
    
    public Fundo()
    {    
        super(600, 400, 1);
        this.addObject(botao = new Me(), 50, 50);
        log = new Variavel[3];
        log[0] = new Variavel("");
        log[1] = new Variavel("");
        log[2] = new Variavel("");
        
        this.addObject(log[0], 360, 320);
        this.addObject(log[1], 360, 350);
        this.addObject(log[2], 360, 380);
        
        this.addObject(ref1 = new Objeto(), 300, 162);
        this.addObject(ref2 = new Objeto(), 300, 262);
        this.addObject(ref3 = new Objeto(), 300, 362);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("q")){
            ref1.setLocation(ref1.getX()-4, ref1.getY());
        }
        if(Greenfoot.isKeyDown("e")){
            ref1.setLocation(ref1.getX()+4, ref1.getY());
        }
        
        if(Greenfoot.isKeyDown("a")){
            ref2.setLocation(ref2.getX()-4, ref2.getY());
        }
        if(Greenfoot.isKeyDown("d")){
            ref2.setLocation(ref2.getX()+4, ref2.getY());
        }
        
        if(Greenfoot.isKeyDown("z")){
            ref3.setLocation(ref3.getX()-4, ref3.getY());
        }
        if(Greenfoot.isKeyDown("c")){
            ref3.setLocation(ref3.getX()+4, ref3.getY());
        }
        
        
        
        if (Greenfoot.mouseClicked(botao)) 
        {
            String codigo = (String) JOptionPane.showInputDialog(null, "Insira o código aqui");
            String [] text = codigo.split(" ");
            
            if((text.length == 2) && (text[0].equals("Objeto")))
            {/*Primeiro caso: Variavel NOME... (onde tenho apenas a declaração)*/
                
                codigo = "Criou a variavel: " + text[1].substring(0, text[1].length()-1);
                logComandos(codigo);
            }
            else if((text.length == 4) && (text[1].equals("=")) && (text[2].equals("new")))
            {/*Segundo caso: NOME = new Variavel(); (onde tenho apenas a instancia)*/
                
                codigo = "Instanciou a variavel: " + text[0];
                logComandos(codigo);
            }
            else if((text.length == 5) && (text[0].equals("Objeto")) && (text[2].equals("=")) && (text[3].equals("new")))
            {/*Terceiro caso: Variavel NOME = new Variavel(); (onde tenho  a declaração e a instancia)*/
                
                codigo = "Criou e instanciou a variavel: " + text[1];
                logComandos(codigo);
            }
            else if((text.length == 3) && (text[1].equals("=")))
            {/*Quarto caso: NOME_1 = NOME_2; (atribuo uma variavel a outra)*/
                
                codigo = "Atribuiu '" + text[0] + "' a '" + text[2].substring(0, text[2].length()-1) + "'";
                logComandos(codigo);
            }
        } 
    }
    
    
    private void logComandos(String comando)
    {
        log[0].update(log[1].getTexto());
        log[1].update(log[2].getTexto());
        log[2].update(comando);
    }
    
    
}
