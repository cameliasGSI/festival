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
    
//4
public void imprimePatricinio(){
    for (Patrocinio p : patrocinios){
        System.out.println(p);
    }
}


//5
public void imprimeGameD(){
    for(GameDesigners g : gameDesigners){
        System.out.println(g);
    }
}
    
//6
public void listaColaboradores(){
    for(Colaborador c : colaboradores){
//        System.out.println(c + "   " +c.pagoVoluntario() );
    }
        
}

//tenho que criar o metudo Pago_voluntario mas tenho que mudar umas coisas
// public Colaborador pagoVoluntario(Colaborador c){
//  private string d;
//    if(c not exists ColaboradorPago){
//          d = "Voluntario"}
//         else{ d = "Pago"}
//      return d
//     }


//7
//public Colaborador infoC(Colaborador c){
//    System.out.println(c.pagoVoluntario() + "   " + c.getFuncao());
//}




//8

public void nGameDeSigners(){
    System.out.println("Existem neste festival" + " " + " " + gameDesigners.size() + " " + "game designers contratados");
}

//o 9 e o 10 nao sei fazer temos de ver



//11

public void nBilhetes(){
    System.out.println("Forma comprados" + "  " + "colaboradores.size() " +  "   " + "bilhetes ");
    
}






}
