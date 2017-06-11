package backend;

public class Patrocinio implements java.io.Serializable {
    private String patrocinador;
    private double contribuicao;
    
    public Patrocinio() {
    }
    
    public Patrocinio(String patrocinador, double contribuicao){
        this.patrocinador = patrocinador;
        this.contribuicao = contribuicao;
    }
    
    public String getPatrocinador(){
        return patrocinador;
    }
    public double getContribuicao(){
        return contribuicao;
    }
    public void setPatrocinador(String patrocinador){
        this.patrocinador = patrocinador;
    }
    public void setContribuicao(double contribuicao){
        this.contribuicao = contribuicao;
    }
    
    @Override
    public String toString(){
        return "Patrocinio:" + "\n Nome do Patricinador: " + patrocinador + "\n Valor da Contribuicao: " + contribuicao; 
    }
}
