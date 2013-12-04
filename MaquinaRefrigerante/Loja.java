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
        super(580, 580, 1); 
        this.addObject((Actor) maquina, 245, 290);
        int x = 170, y = 170, dist =150;
        //adiciona botões à posição desejada
            this.addObject(maquina.getBotoes()[0], x, y);
            this.addObject(maquina.getBotoes()[1], x, y + dist);
            this.addObject(maquina.getBotoes()[2], x + dist, y);
            this.addObject(maquina.getBotoes()[3], x + dist, y + dist);
        
        this.addObject(maquina.getCoinColector(), 245, 62);
        
            for( Moedas moeda : Moedas.values())
            {
                this.adicionarMoeda(moeda);
            }
        
        this.addObject(maquina.getDisplay(), 245, 470);
    }
    
    public void act(){
        gerenciarBotoes();
        if(maquina.isAddingCoins()){
            maquina.getDisplay().setMensagem(Mensagem.saldoCliente(this.maquina));
            adicionarMoeda(maquina.getMoedaColetada());
        }
    }
    
    public void gerenciarBotoes(){
        for(Button b : maquina.getBotoes()){
            this.ouvirBotao(b);
        }
    }
    
    public void adicionarMoeda(Moedas moeda){
        int x = 500, y = 40;
            Moeda m = null;
        switch(moeda){
            case dez:
                m = new Moeda(10);
                y *= 1;
                break;
            case vintecinco:
                m = new Moeda(25);
                y *= 2;
                break;
            case cinquenta:
                m = new Moeda(50);
                y *= 3;
                break;
            default:
                m = new Moeda(100);
                y *= 4;
                break;
        }
        y +=30;
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
