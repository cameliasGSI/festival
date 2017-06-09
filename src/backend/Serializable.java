package backend;
import java.io.*;
import javax.swing.JOptionPane; //guarda todos 
import javax.swing.UIManager;

public class Serializable {
 


    public static boolean guardarDados(Object obj, String ficheiroDestino){
        boolean retValue = true;
        
        try{
            FileOutputStream fileOut = new FileOutputStream(ficheiroDestino);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();            
        }catch(IOException i){
          retValue = false;
        }
        
      return retValue;        
    }
    
    
     public static Object lerDados(String ficheiro) throws Exception{
        Object retValue = null;
        
            FileInputStream fileIn = new FileInputStream(ficheiro);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            retValue = in.readObject();
            in.close();
            fileIn.close();            
     
        
      return retValue;        
    }
           public void terminar(Object obj, String ficheiroDestino) {
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.yesButtonText", "Sim");
        if (JOptionPane.showConfirmDialog(null,
                "Deseja realmente terminar o programa?",
                "Terminar",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            sair(obj,ficheiroDestino);
        }
    }
    
    public void exit() {
        System.exit(0);
    }
    
    //sai do programa
    private void sair(Object obj, String ficheiroDestino) {
        guardarDados(obj,ficheiroDestino);
        exit();
    } 
    
}
    

