package Backend;


import java.util.ArrayList;

public class Festival implements java.io.Serializable {

    
private String nome;
private String local;
private String data;
private int duraçao;
private int lotaçao;
private ArrayList<Bilhete> Bilhetes;
private ArrayList<Colaborador> Colaboradores; // ou colaboradores pagos e voluntarios???
private ArrayList<Patrocinio> Patrocinios;
private ArrayList<GameDesigners> GameDesigners;


public Festival(){
    Bilhetes = new ArrayList<Bilhete>();
    Colaboradores = new ArrayList<Colaborador>();
    Patrocinios = new ArrayList<Patrocinio>();
    GameDesigners = new ArrayList<GameDesigners>();
}

public String getNome(){
    return nome;
}
    
public String getLocal(){
    return local;
}
public String getData(){
    return data;
}
public int getDuraçao(){
    return duraçao;
}
public int getLotaçao(){
    return lotaçao;
}
public ArrayList<Colaborador> getColaboradores(){
    return Colaboradores;
}
public ArrayList<Bilhete> getBilhetes(){
    return Bilhetes;
}
public ArrayList<Patrocinio> getPatrocinio(){
    return Patrocinios;
}
public void setNome(String nome){
   this.nome=nome;
}
public void setLocal(String local){
    this.local=local;
}
public void setData(String Data){
    this.data=data;
}
public void setDuraçao(int duraçao){
    this.duraçao=duraçao;
}
public void setLotaçao(int lotaçao){
    this.lotaçao=lotaçao;
}


public void lucro(){
    
    
   
}
}
