package frontend;

import backend.Festival;
import backend.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Arranque {

    private static String ficheiro = "basededados.dat";
    private static List<Festival> fest;
    
    public static void main(String[] args) throws Exception{
        
        Festival test = new Festival();
        test.setNome("Festival 1");
        test.setData("Hoje");
        test.setDuraçao(10);
        test.setLocal("aqui");
        test.setLotaçao(20);
        
        List<Festival> festivais = new ArrayList<Festival>();
        festivais.add(test);
        
        Serializable.guardarDados(festivais, ficheiro);
        
        
        festivais = (List<Festival>)Serializable.lerDados(ficheiro);
        
        Menu menu = new Menu(festivais);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        /*TelaLogin1 tela = newTelaLogin (fest);
        tela.setSize(500,400);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);*/
    }
}
    


// ver se temos de meter tela login ou outra coisa 

