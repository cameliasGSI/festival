package frontend;

import Backend.Festival;

public class Arranque {
    private Festival fest;
    
    public static void main(String[] args){
        Festival fest;
        
        fest = new Festival();
        TelaLogin1 tela = newTelaLogin (fest);
        tela.setSize(500,400);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }
}
    


// ver se temos de meter tela login ou outra coisa 

