import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Estoque extends Actor
{
    private int MAX = 10;
    // O estoque é capaz de armazenar os refrigerantes em 4 filas
    private Refrigerante[] refris0 = new Refrigerante[MAX];
    private Refrigerante[] refris1 = new Refrigerante[MAX];
    private Refrigerante[] refris2 = new Refrigerante[MAX];
    private Refrigerante[] refris3 = new Refrigerante[MAX];

    public Estoque()
    {
        this.recarregarEstoque();
    }
    
    // retorna Refrigerante se disponível mas NAO remove da lista    
    public Refrigerante getRefrigerante(int botao){
        Refrigerante[] fila;
        switch(botao){
            case 0:
                fila = refris0;
                break;
            case 1:
                fila = refris1;
                break;
            case 2:
                fila = refris2;
                break;
            default:
                fila = refris3;
                break;
        }
        
        for(int i=0 ; i<MAX ; i++){
            if(fila[i] !=null){
                return fila[i];
            }
        }
        // fila vazia:
        return null;
    }
    
    // retorna Refrigerante se disponível e remove da lista
    public Refrigerante entregarRefrigerante(int botao){
        Refrigerante[] fila;
        switch(botao){
            case 0:
                fila = refris0;
                break;
            case 1:
                fila = refris1;
                break;
            case 2:
                fila = refris2;
                break;
            default:
                fila = refris3;
                break;
        }
        
        for(int i=0 ; i<MAX ; i++){
            if(fila[i] !=null){
                Refrigerante refri = fila[i];
                fila[i] = null;
                return refri;
            }
        }
        // fila vazia:
        return null;
    }
    
    public void recarregarEstoque()
    {
        for(int i=0; i<MAX ;i++){
                refris0[i] = new Refrigerante("Coca-Cola", 250);
                refris1[i] = new Refrigerante("Fanta Uva", 220);
                refris2[i] = new Refrigerante("Antártica", 225);
                refris3[i] = new Refrigerante("Dore", 200);
        }
    }
}
