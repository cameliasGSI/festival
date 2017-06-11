package backend;

public class ColaboradorVoluntario extends Colaborador implements java.io.Serializable {

    public ColaboradorVoluntario(){
        super();
    }
        
    public ColaboradorVoluntario(String nome, String morada, String funcao, int telefone){
        super(nome, morada, funcao, telefone);
    }    
    
}