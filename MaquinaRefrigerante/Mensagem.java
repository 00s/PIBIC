import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Mensagem
{
    
    public static String desligada(){
        return "A máquina está desligada.";
    }
    
    public static String ligada(){
        return "Maquina ligada. Adicione moedas...";
    }
    
    public static String saldoCliente(MaquinaRefrigerante maquina){
        return "Saldo: " + maquina.getCaixa().getSaldoCompraToString();
    }
    
    public static String saldoInsuficiente(){
        return "Saldo insuficiente. Dinheiro devolvido";
    }
    public static String refriIndisponivel(){
        return "Refrigerante Indisponível.";
    }
    
    public static String compra(Refrigerante r){
        return r.getNome() + " comprada. Boa Escolha!";
    }
}
