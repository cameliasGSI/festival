
package backend;



public class GameDesigners {
    private String nome;
    private int telefone;
    private int cache;
    private String dia;    // Dia e hora da sessao
    private String hora;

    public GameDesigners(String nome, int telefone, int cache, String dia, String hora) {
        this.nome = nome;
        this.telefone = telefone;
        this.cache = cache;
        this.dia = dia;
        this.hora = hora;
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

    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
