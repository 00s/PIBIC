import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Mensagem
{
    
    public static String[] desligada(){
        String[] txt = {"A máquina está desligada."};
        return txt;
    }
    
    public static String[] ligada(){
        String[] txt = {"Maquina ligada.", "Adicione moedas..."};
        return txt;
    }
    
    public static String[] saldoCliente(InterfaceMaquina maquina){
        String[] txt = {"Saldo atual:", maquina.getCaixa().getSaldoCompraToString()};
        return txt;
    }
    
    public static String[] saldoInsuficiente(){
        String[] txt = {"Saldo insuficiente.", "Dinheiro devolvido"};
        return txt;
    }
    public static String[] refriIndisponivel(){
        String[] txt = {"Refrigerante Indisponível."};
        return txt;
    }
    
    public static String[] compra(Refrigerante r){
        String[] txt = {r.getNome(), " comprada. Boa Escolha!"};
        return txt;
    }
}
