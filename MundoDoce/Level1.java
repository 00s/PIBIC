import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Terceira versão do jogo CandyWorld desenvolvido no software Greenfoot.
 * 
 * @author (Adolfo Lucas e Larissa Trindade) 
 * @version (Versão 3)
 */
public class Level1 extends CandyWorld
{
    
    Counter candyCounter = new Counter("Candies: ", 0);
    Counter lifeCounter = new Counter("Lifes: ", 2);
    GreenfootImage tela = new GreenfootImage(1280, 720);
    Color color = new Color(Greenfoot.getRandomNumber(200)+50,Greenfoot.getRandomNumber(200)+50,Greenfoot.getRandomNumber(200)+50);
    int dificuldade = 1;
    int round = 0;
    /**
     * Constructor for objects of class Fase1.
     * 
     */
    public Level1(int personagem)
    {    
        super();
        tela = getBackground();
        tela.setColor(color);
        tela.fillRect(0, 0, 1280, 720);
        Greenfoot.setSpeed(50);
        removeObjects(getObjects(Menu.class));
        addObject(candyCounter, 96, 105);
        addObject(lifeCounter, 99, 130);
        addObject(new Espiral(), 640, 360);
        addObject(new Piso(), 640, 360);
        addObject(new Player(personagem), 640,550);
        setPaintOrder(Counter.class, Carie.class, Candy.class, Player.class, Piso.class, Espiral.class); 
        
   }
    
    public void act() 
    {

        if(Greenfoot.getRandomNumber(100) < 3) {
            
            addObject(new Candy(Greenfoot.getRandomNumber(6)), Greenfoot.getRandomNumber(1280), 0);
        }
        
        if(Greenfoot.getRandomNumber(200) < dificuldade) {
            addObject(new Carie(Greenfoot.getRandomNumber(6)), Greenfoot.getRandomNumber(1280), 0);
        }
        
        if ((++round % 1000) == 0){
            dificuldade++;
        }
        
        gameOver();
        
    }

    public void subtractLife(){
        lifeCounter.add(-1);
    }
    
    public void addCandy(){
        candyCounter.add(1);
    }
   
    public void gameOver(){
        if(lifeCounter.getValue() < 0){
            Greenfoot.setWorld(new gameOver());
        }
    }

}
