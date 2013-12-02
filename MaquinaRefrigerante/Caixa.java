import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;
import java.util.Queue;

public class Caixa extends Actor
{
    private int saldoCompra = 0;

    public void adicionarMoedaCliente(Moeda m) {
        this.saldoCompra += m.getValor();
    }
    // lista com moedas convertidas
    public LinkedList<Moeda> disponibilizarMoedas(int valor){
        int devolver = valor;
        LinkedList<Moeda> fila = new LinkedList<Moeda>();
        while(devolver >= 100){
            fila.add(new Moeda(100));
            devolver -= 100;
        }
        while(devolver >= 50){
            fila.add(new Moeda(50));
            devolver -= 50;
        }
        while(devolver >= 25){
            fila.add(new Moeda(25));
            devolver -= 25;
        }
        while(devolver >= 10){
            fila.add(new Moeda(10));
            devolver -= 10;
        }
        return fila;
    }

    public int getSaldoCompra(){
        return this.saldoCompra;
    }
    
    public void zerarSaldoCompra(){
        this.saldoCompra = 0;
    }

    // retorna string convertendo inteiro em Reais
    public String intToString(int valor){
        String saldo = "";
            
        if((valor/100) == 1)
            saldo =  "1 real e ";
        else if((valor/100) >1)
            saldo = (valor/ 100) + " reais e ";
        return saldo + valor %100 + " centavos.";
    }
    //retorna saldo da compra em formato de texto
        public String getSaldoCompraToString(){
        String saldo = "";
        if((saldoCompra/100) == 1)
            saldo =  "1 real e ";
        else if((saldoCompra/100) >1)
            saldo = (saldoCompra / 100) + " reais e ";
        return saldo + saldoCompra %100 + " centavos.";
    }

}
