import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public interface InterfaceMaquina
{
    public void act();
    public Caixa getCaixa();
    public Estoque getEstoque();
    public Display getDisplay();
    public Button[] getBotoes();
    public void coletaMoedas();
    public void setAddingCoins(boolean b);
    public boolean isAddingCoins();
    public void devolverTroco(Refrigerante r);
    public CoinColector getCoinColector();
    //public void gerenciaBotoes();
    //public boolean entregarRefrigerante();
}
