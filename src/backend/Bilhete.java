package backend;

import java.util.Date;

public class Bilhete implements java.io.Serializable {
    private Date data;
    private int numero;
    private double preco;
    
    public Bilhete(Date data, int numero,double preco){
        this.data=data;
        this.numero=numero;
        this.preco=preco;
        }
    
    
    // Seletores 
    public Date getData(){
        return data;
    }
    public int getNumero(){
        return numero;
    }
    public double getPreço(){
        return preco;
    }
    
    public void setData(Date data){
        this.data=data;
    }
    public void setNumero(int numero){
        this.numero=numero;
    }
    public void setPreco(double preco){
        this.preco=preco;
    }
    
}
