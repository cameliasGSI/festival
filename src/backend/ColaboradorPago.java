package Backend;

public class ColaboradorPago extends Colaborador{
    
    private int NIF;
    private float Pagamento;
    
public ColaboradorPago(String nome, String morada, String funcao, int telefone, int NIF, float Pagamento){
    super(nome, morada, funcao, telefone);
    this.NIF=NIF;
    this.Pagamento=Pagamento;
}
    
//Seletores
public float getPagamento(){
  return Pagamento;  
}

public int getNIF(){
  return NIF;
}

//modificadores

public void setNIF(int NIF){
    this.NIF=NIF;
}
    
public void setPagamento(float Pagamento){
    this.Pagamento=Pagamento;
}
}
