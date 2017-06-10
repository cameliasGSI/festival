package backend;

public class ColaboradorPago extends Colaborador{
    
    private int nif;
    private double pagamento;
    
public ColaboradorPago(String nome, String morada, String funcao, int telefone, int nif, double pagamento){
    super(nome, morada, funcao, telefone);
    this.nif = nif;
    this.pagamento = pagamento;
}
    
//Seletores
public double getPagamento(){
  return pagamento;  
}

public int getNif(){
  return nif;
}

//modificadores

public void setNif(int nif){
    this.nif = nif;
}
    
public void setPagamento(double pagamento){
    this.pagamento = pagamento;
}
}
