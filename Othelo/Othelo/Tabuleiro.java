import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

enum Direcao{
    norte, nordeste, leste, sudeste, sul, sudoeste, oeste, noroeste
}

/**
 * Write a description of class Tabuleiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tabuleiro extends World{
    List<PossivelBotao> posicoesPossiveis = new LinkedList<PossivelBotao>();
    public static final int TAMANHO = 8;
    Botao matriz[][] = new Botao[TAMANHO][TAMANHO];
    private int vX = 0, vY = 0, qtdAzuis = 0, qtdVermelhos = 0;
    private Cor vez;
    /**
     * Constructor for objects of class Tabuleiro.
     * 
     */
    public Tabuleiro()
    {    
        // Create a new world with 8x8 cells with a cell size of 60x60 pixels.
          super(TAMANHO, TAMANHO, 60);
          this.addObject(new Botao(Cor.azul), 3,3);
          this.addObject(new Botao(Cor.vermelho), 3,4);
          this.addObject(new Botao(Cor.vermelho), 4,3);
          this.addObject(new Botao(Cor.azul), 4,4);
          this.setarTransparenciaBotoes(255);
        // o botao azul é o primeiro a jogar
        this.vez = Cor.azul;
        this.checarVez();
    }

    public void act()
    {
     
        if(Greenfoot.mouseClicked(null)){
            this.checarVencedor();
            int x = Greenfoot.getMouseInfo().getX();
            int y = Greenfoot.getMouseInfo().getY();
            List<PossivelBotao> possivel = this.getObjectsAt(x, y, PossivelBotao.class);
            if(possivel.size()>0){
                this.virar(possivel.get(0));
            }
        }
    }

    // overrides addObject() method from superclass
    public void addObject(Actor actor, int x, int y)
    {
       if(actor instanceof Botao){
           matriz[x][y] = (Botao) actor;
           if(matriz[x][y].getColor() == "blue"){
               this.qtdAzuis++;
           }else{
               this.qtdVermelhos++;
            }
       } else if (actor instanceof PossivelBotao){
           posicoesPossiveis.add((PossivelBotao) actor);
       }
       
       super.addObject(actor, x,y);
    }

    private boolean checar(int pos_X, int pos_Y, Direcao direcao)
    {
        List<Botao> botoes = new LinkedList<Botao>();
        Botao bot;
        int x, y;
        x = pos_X;
        y = pos_Y;
        
        this.definirVelocidade(direcao, vX, vY);

        x += vX;
        y += vY;
        
        while(x < TAMANHO && x >= 0 && y < TAMANHO && y >= 0)
        {
            bot = this.matriz[x][y];

            if(bot != null){
                if(bot.getCor() != this.vez){
                    botoes.add(bot);
                }else{
                    if(botoes.size() > 0){
                        return true;
                    }
                    break;
                }
            } else {
                break;
            }
            x += vX;
            y += vY;
        }
        return false;
    }
   
    private void virar(PossivelBotao pb){
        
        int x, y;
       
        for(Direcao dir : pb.getDirecoes()){
            List<Botao> botoes = new LinkedList<Botao>();
            Botao bot;
            x = pb.getX();
            y = pb.getY();
             
            this.definirVelocidade(dir, vX, vY);

            x += vX;
            y += vY;
            bot = this.matriz[x][y];
            
            while(bot.getCor() != vez && bot != null)
            {
                botoes.add(bot);
                x += vX;
                y += vY;
                bot = this.matriz[x][y];
            }
            
            if(bot.getCor() == this.vez){
                for(int j = 0; j < botoes.size(); j++){
                    botoes.get(j).virar();
                    this.corrigirQtdBotoes(bot.getCor());
                }
            }
        }
        this.addObject(new Botao(this.vez), pb.getX(), pb.getY());
        this.removerPosicoesPossiveis();
        this.passarVez();
        this.checarVez();
    }
    
    private void checarDirecoes(int pos_X, int pos_Y){
        boolean checked = false;
        ArrayList<Direcao> direcoes = new ArrayList<Direcao>();
        for(Direcao dir : Direcao.values()){
            if (this.checar(pos_X, pos_Y, dir)){
                direcoes.add(dir);
                checked = true;
            }
        }
        
        if (checked){
            this.addObject(new PossivelBotao(this.vez, direcoes), pos_X, pos_Y);
        }

    }

        private void passarVez(){
        if(vez == Cor.azul){
            vez = Cor.vermelho;
        }else{
            vez = Cor.azul;
        }
    }
    
    private void removerPosicoesPossiveis(){
        for(PossivelBotao pb : posicoesPossiveis){
            this.removeObject(pb);
        }
        this.posicoesPossiveis.clear();
    }
    
    private void checarVez(){
        for (int x=0; x < TAMANHO; x++){
            for(int y = 0; y < TAMANHO; y++){
                if(matriz[x][y] == null){
                    checarDirecoes(x, y);
                }
            }
        }
        
        if(posicoesPossiveis.size() <= 0 && !this.checarVencedor()){
            this.passarVez();
            this.checarVez();
        }
    }
    
    private boolean checarVencedor(){
        if(qtdAzuis == 0 || qtdVermelhos == 0 || (qtdAzuis+qtdVermelhos) >= 63){
            this.setarTransparenciaBotoes(100);
            this.addObject(new Vencedor(this.getVencedor(), 30), 6, 4);
            Greenfoot.stop();
            return true;
        }
        return false;
    }
    
    private String getVencedor(){
        if(qtdAzuis > qtdVermelhos){
            return "O azul venceu!";
        } else if(qtdAzuis < qtdVermelhos){
            return "O vermelho venceu!";
        } else{
            return "Empatou!";
        }
    }
    
    private void setarTransparenciaBotoes(int transp){
        for(Botao b : (ArrayList<Botao>)(this.getObjects(Botao.class))){
                b.transparencia(transp);
        }
    }
    
    private void definirVelocidade(Direcao dir, int vX, int vY){
        switch(dir){
            case norte:
                   this.setVX(0);
                   this.setVY(-1);
              break;
            case nordeste:
                   this.setVX(1);
                   this.setVY(-1);
              break;
            case leste:
                   this.setVX(1);
                   this.setVY(0);
              break;
            case sudeste:
                   this.setVX(1);
                   this.setVY(1);
              break;
            case sul:
                   this.setVX(0);
                   this.setVY(1);
              break;
            case sudoeste:
                   this.setVX(-1);
                   this.setVY(1);
              break;
            case oeste:
                   this.setVX(-1);
                   this.setVY(0);
              break;
            default: // noroeste
                   this.setVX(-1);
                   this.setVY(-1);
              break;
        }
    }
    
    private void setVX(int vX){
        this.vX = vX;
    }
    
    private void setVY(int vY){
        this.vY = vY;
    }
    
    private void corrigirQtdBotoes(Cor cor){
        if(cor == Cor.azul){
            qtdVermelhos--;
            qtdAzuis++;
        }else{
            qtdVermelhos++;
            qtdAzuis--;
        }
    }
}
