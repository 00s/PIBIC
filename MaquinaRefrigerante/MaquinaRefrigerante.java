import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class MaquinaRefrigerante extends Actor implements InterfaceMaquina 
{
    private String[] refriCoca = {"Coca-Cola", "R$2,50"},
                   refriFanta = {"Fanta Uva", "R$2,20"},
                   refriAntartica = {"Antártica", "R$2,25"},
                   refriDore = {"Dore", "R$2,00"};
    private Caixa caixa = new Caixa();
    private CoinColector coinCol = new CoinColector();
    private Estoque estoque =  new Estoque();
    private Display display = new Display("recButton.png",null, 0);
    private boolean addingCoins = false;
    //cria 4 botoes, um para cada refrigerante
    private Button botao0 = new Button(refriCoca,0, 0),
                   botao1 = new Button(refriFanta,0, 1),
                   botao2 = new Button(refriAntartica,0, 2), 
                   botao3 = new Button(refriDore,0, 3);

    // agrupa os botoes criados
    Button[] botoes = new Button[4];

    public MaquinaRefrigerante(){
        botoes[0] = botao0;
        botoes[1] = botao1;
        botoes[2] = botao2;
        botoes[3] = botao3;
    }
    
    public void act() 
    {
            coletaMoedas();
            // gerenciaBotoes();
    }    

    public void coletaMoedas()
    {
        List<Moeda> moedas = this.coinCol.getMoedas();
        for( Moeda m : moedas){
            if(Greenfoot.mouseDragEnded(m)){
                caixa.adicionarMoedaCliente(m);
                this.getWorld().removeObject(m);
                addingCoins = true;
            }
        }
        this.coinCol.zerar();
    }
    
    public void devolverTroco(Refrigerante r){
        int devolver = caixa.getSaldoCompra();
        if( devolver >= r.getPreco())
            devolver -= r.getPreco();
        
        Queue<Moeda> moedas = caixa.disponibilizarMoedas(devolver);
        while(!moedas.isEmpty()){
            this.getWorld().addObject(
                moedas.poll(), 
                Greenfoot.getRandomNumber(100) + 50,
                Greenfoot.getRandomNumber(80) + 30
            );
        }
    }
    
    public boolean isAddingCoins(){
        return this.addingCoins;
    }
    
    public void setAddingCoins(boolean value){
        this.addingCoins = value;
    }
       
    public CoinColector getCoinColector(){
        return this.coinCol;
    }
    
    public Estoque getEstoque(){
        return this.estoque;
    }
    
    public Caixa getCaixa(){
        return this.caixa;
    }
    
    public Display getDisplay(){
        return this.display;
    }
    
    public Button[] getBotoes(){
        return botoes;
    }
}