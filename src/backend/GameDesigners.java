
package backend;

import java.util.Date;



public class GameDesigners implements java.io.Serializable {
    private String nome;
    private int telefone;
    private double cache;
    private Date diaHora;

    public GameDesigners() {
    }
    
    public GameDesigners(String nome, int telefone, int cache, Date diaHora) {
        this.nome = nome;
        this.telefone = telefone;
        this.cache = cache;
        this.diaHora = diaHora;
    }
      

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public double getCache() {
        return cache;
    }

    public void setCache(double cache) {
        this.cache = cache;
    }

    public Date getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(Date diaHora) {
        this.diaHora = diaHora;
    }    
}
