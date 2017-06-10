package backend;


import java.util.ArrayList;
import java.util.Date;

public class Festival implements java.io.Serializable {

    
private String nome;
private String local;
private Date data;
private int duraçao;
private int lotaçao;
private ArrayList<Bilhete> bilhetes;
private ArrayList<Colaborador> colaboradores; // ou colaboradores pagos e voluntarios???
private ArrayList<Patrocinio> patrocinios;
private ArrayList<GameDesigners> gameDesigners;


public Festival(){
    bilhetes = new ArrayList<Bilhete>();
    colaboradores = new ArrayList<Colaborador>();
    patrocinios = new ArrayList<Patrocinio>();
    gameDesigners = new ArrayList<GameDesigners>();
}

public String getNome(){
    return nome;
}
    
public String getLocal(){
    return local;
}
public Date getData(){
    return data;
}
public int getDuraçao(){
    return duraçao;
}
public int getLotaçao(){
    return lotaçao;
}
public ArrayList<Colaborador> getColaboradores(){
    return colaboradores;
}
public ArrayList<Bilhete> getBilhetes(){
    return bilhetes;
}
public ArrayList<Patrocinio> getPatrocinio(){
    return patrocinios;
}
public void setNome(String nome){
   this.nome = nome;
}
public void setLocal(String local){
    this.local = local;
}
public void setData(Date data){
    this.data = data;
}
public void setDuraçao(int duraçao){
    this.duraçao = duraçao;
}
public void setLotaçao(int lotaçao){
    this.lotaçao = lotaçao;
}
    
public void imprimePatricinio(){
    for (Patrocinio p : patrocinios){
        System.out.println(p);
    }
}

public void imprimeGameD(){
    for(GameDesigners g : gameDesigners){
        System.out.println(g);
    }
}
    
}
