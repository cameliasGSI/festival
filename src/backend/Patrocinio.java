package backend;

public class Patrocinio {
    private String Patrocinador;
    private float Contribuicao;
    
    public Patrocinio(String Patrocinador, float Contribuiçao){
        this.Patrocinador=Patrocinador;
        this.Contribuicao=Contribuicao;
    }
    
    public String getPatrocinador(){
        return Patrocinador;
    }
    public float getContribuicao(){
        return Contribuicao;
    }
    public void setPatrocinador(String Patrocinador){
        this.Patrocinador=Patrocinador;
    }
    public void setContribuicao(float Contribuicao){
        this.Contribuicao=Contribuicao;
    }
    
    public String toString(){
        return "Patrocinio:" + "\n Nome do Patricinador: " + Patrocinador + "\n Valor da Contribuicao: " + Contribuicao; 
    }
}
