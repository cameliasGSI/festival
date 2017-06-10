package backend;

public class Bilhete {
    private String data;
    private int numero;
    private double preco;
    
    public Bilhete(String data, int numero,double preco){
        this.data=data;
        this.numero=numero;
        this.preco=preco;
        }
    
    
    // Seletores 
    public String getData(){
        return data;
    }
    public int getNumero(){
        return numero;
    }
    public double getPreço(){
        return preco;
    }
    
    public void setData(String data){
        this.data=data;
    }
    public void setNumero(int numero){
        this.numero=numero;
    }
    public void setPreco(double preco){
        this.preco=preco;
    }
    
}
