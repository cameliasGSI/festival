package backend;

public class Colaborador implements java.io.Serializable{
private String nome;
private String morada;
private int telefone;
private String funcao;

public Colaborador(){
}

public Colaborador(String nome, String morada, String funcao, int telefone){
    this.nome=nome;
    this.morada=morada;
    this.funcao=funcao;
    this.telefone=telefone;
}

public String getNome(){
    return nome;
}
public String getMorada(){
    return morada;
}
public String getFuncao(){
    return funcao;
}
public int getTelefone(){
    return telefone;
}

public void setNome(String nome){
    this.nome=nome;
}
public void setMorada(String morada){
    this.morada=morada;
}
public void setFuncao(String funcao){
    this.funcao=funcao;    
}
public void setTelefone(int telefone){
    this.telefone=telefone;    
}

@Override
public String toString(){
    return "Dados do colaborador" + "\n nome: " + nome + "\n telefone: " + telefone + "\n morada:" + morada +  "\n funcao: "  + funcao;
 }

}