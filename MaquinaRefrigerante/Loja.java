import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Loja extends World
{
    private static Mensagem msg;
    enum Moedas{
        dez, vintecinco, cinquenta, umreal;
    }
    InterfaceMaquina maquina =  new MaquinaRefrigerante();
    
    public Loja()
    {    
        super(480, 620, 1); 
        int j = 0;
        for(int i = 170; i <= 380; i = i+70){
            this.addObject(maquina.getBotoes()[j++], 500, i);
        }
        this.addObject((Actor) maquina, 120, 360);
        int MAX = 5;
        for(int i = 0; i< MAX; i++)
        {
            for( Moedas moeda : Moedas.values())
            {
                this.adicionarMoeda(moeda);
            }
        }
        this.addObject(maquina.getDisplay(), 240, 600);
    }
    
    public void act(){
        gerenciarBotoes();
        if(maquina.isAddingCoins())
            maquina.getDisplay().setMensagem("Saldo: " + maquina.getCaixa().getSaldoCompraToString());
    }
    
    public void gerenciarBotoes(){
        for(Button b : maquina.getBotoes()){
            this.ouvirBotao(b);
        }
    }
    
    public void adicionarMoeda(Moedas moeda){
        int x = Greenfoot.getRandomNumber(100) + 320,
            y = Greenfoot.getRandomNumber(80) + 30;
            Moeda m = null;
        switch(moeda){
            case dez:
                m = new Moeda(10);
                break;
            case vintecinco:
                m = new Moeda(25);
                break;
            case cinquenta:
                m = new Moeda(50);
                break;
            default:
                m = new Moeda(100);
                break;
        }
        this.addObject(m, x,y);    
    }
    
    private void ouvirBotao(Button button){
        if(Greenfoot.mouseClicked(button)){
            Refrigerante refri = maquina.getEstoque().getRefrigerante(button.getID());
            if(refri != null && maquina.getCaixa().getSaldoCompra() >= refri.getPreco()){
                maquina.getEstoque().entregarRefrigerante(button.getID());
                this.addObject(refri, 350, 500);
                maquina.getDisplay().setMensagem(Mensagem.compra(refri));
            } else if (maquina.getCaixa().getSaldoCompra() < refri.getPreco()){
                maquina.getDisplay().setMensagem(Mensagem.saldoInsuficiente());
            }else{
                maquina.getDisplay().setMensagem(Mensagem.refriIndisponivel());
            }
            maquina.devolverTroco(refri);
            maquina.getCaixa().zerarSaldoCompra();
            maquina.setAddingCoins(false);
        }
    }
}
