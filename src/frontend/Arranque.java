package frontend;

import backend.Festival;
import backend.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Arranque {

    private static final String NOME_FICHEIRO = "basededados.dat";
    
    public static void main(String[] args) throws Exception{
        Serializable.guardarDados(new ArrayList<Festival>(), NOME_FICHEIRO);
        List<Festival> festivais = (List<Festival>)Serializable.lerDados(NOME_FICHEIRO);
        
        Menu menu = new Menu(festivais);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }
}
    


// ver se temos de meter tela login ou outra coisa 

