/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Festival;
import backend.GameDesigners;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

/**
 *
 * @author lfss9
 */
public class GameDesigner extends javax.swing.JFrame {

    private Menu anterior;
    private List<Festival> festivais;
    private GameDesigners gameDesigner;
    private Festival festival;
    
    public GameDesigner() {   // tem que se ter o construtor vazio para iniciar;
        initComponents();
   
    }

    public GameDesigner(Menu anterior) {
        initComponents();
        this.anterior=anterior;
    }
    
    public GameDesigner(Menu menu, List<Festival> fest) {
        initComponents();
        this.anterior = menu;
        this.festivais = fest;
        
        ComboBoxModel comboModel = new DefaultComboBoxModel(fest.toArray());
        
        gameDesignerFestivalCombo.setModel(comboModel);
    }
    
    public GameDesigner(Menu menu, List<Festival> fest, GameDesigners gameDesigners, Festival festival) {
        initComponents();
        this.anterior = menu;
        this.festivais = fest;
        this.gameDesigner = gameDesigners;
        this.festival = festival;
        
        ComboBoxModel comboModel = new DefaultComboBoxModel(fest.toArray());
        
        gameDesignerFestivalCombo.setModel(comboModel);
        
        gameDesignerFestivalCombo.setEnabled(false);
        
        preencheGameDesigner();
    }
    
    public void preencheGameDesigner() {
        nomeGameDesignerInput.setText(gameDesigner.getNome());
        telefoneGameDesignerInput.setText("" + gameDesigner.getTelefone());
        cacheGameDesignerInput.setText("" + gameDesigner.getCache());
        dataGameDesignerInput.setDate(gameDesigner.getDiaHora());
        
        gameDesignerFestivalCombo.setSelectedItem(festival);
        gameDesignerFestivalCombo.setEditable(false);        
    }
    
    public void setAnterior(Menu anterior) {
        this.anterior = anterior;
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nomeGameDesignerInput = new javax.swing.JTextField();
        telefoneGameDesignerInput = new javax.swing.JTextField();
        cacheGameDesignerInput = new javax.swing.JTextField();
        dataGameDesignerInput = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        guardarGameDesigner = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        gameDesignerFestivalCombo = new javax.swing.JComboBox<>();
        gameDesignerFestivalLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nomeGameDesignerInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeGameDesignerInputActionPerformed(evt);
            }
        });

        telefoneGameDesignerInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneGameDesignerInputActionPerformed(evt);
            }
        });

        jLabel1.setText("GameDesigner");

        jLabel2.setText("Todos os campos devem ser preenchidos");

        guardarGameDesigner.setText("Gravar");
        guardarGameDesigner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarGameDesignerActionPerformed(evt);
            }
        });

        jButton6.setText("Voltar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome");

        jLabel4.setText("Telefone");

        jLabel5.setText("Cache");

        jLabel6.setText("Data");

        gameDesignerFestivalCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gameDesignerFestivalCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameDesignerFestivalComboActionPerformed(evt);
            }
        });

        gameDesignerFestivalLabel.setText("Festival");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(guardarGameDesigner, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(gameDesignerFestivalLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataGameDesignerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(gameDesignerFestivalCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cacheGameDesignerInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                        .addComponent(telefoneGameDesignerInput, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nomeGameDesignerInput, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(21, 21, 21))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gameDesignerFestivalCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameDesignerFestivalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nomeGameDesignerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(telefoneGameDesignerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cacheGameDesignerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataGameDesignerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarGameDesigner)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 132, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeGameDesignerInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeGameDesignerInputActionPerformed
       
        
        
        
        
        
    }//GEN-LAST:event_nomeGameDesignerInputActionPerformed

    private void telefoneGameDesignerInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneGameDesignerInputActionPerformed
        
        
        
        
        
    }//GEN-LAST:event_telefoneGameDesignerInputActionPerformed

    private void guardarGameDesignerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarGameDesignerActionPerformed
        GameDesigners gameDesigners;
        
        //estamos a atualizar ou criar?
        if (this.gameDesigner != null) {
            gameDesigners = this.gameDesigner;
        }
        else {
            gameDesigners = new GameDesigners();
        }
        
        double cache = 0;
        int telefone = 0;
        
        try {
            cache = Double.parseDouble(cacheGameDesignerInput.getText());
            telefone = Integer.parseInt(telefoneGameDesignerInput.getText());
        }
        catch (NumberFormatException ne) {
            System.out.println("Não foi possivel ler o numero");
        }
        
        gameDesigners.setNome(nomeGameDesignerInput.getText());
        gameDesigners.setDiaHora(dataGameDesignerInput.getDate());
        gameDesigners.setCache(cache);
        gameDesigners.setTelefone(telefone);
        
        //Se é atualização não adiciona ao arraylist porque ja la está
        if (this.gameDesigner == null) {
            
            Festival f = (Festival) gameDesignerFestivalCombo.getSelectedItem();
            f.getGameDesigners().add(gameDesigners);
        }
        
        anterior.refreshListaGameDesigners();
                
        voltar();
    }//GEN-LAST:event_guardarGameDesignerActionPerformed

    private void voltar() {
        Menu janela;
        
        if (this.anterior != null){
            janela = anterior;
        }
        else{
            janela = new Menu();
            janela.setLocationRelativeTo(null);
        }
        
        this.setVisible(false);
        janela.setVisible(true);
    }
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JFrame janela;
     
        if(this.anterior !=null){
            janela=anterior;
        }else {
            janela = new Menu();
            janela.setLocationRelativeTo(null);
        }
        this.setVisible(false);
         janela.setVisible(true);
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void gameDesignerFestivalComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameDesignerFestivalComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gameDesignerFestivalComboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameDesigner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameDesigner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameDesigner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameDesigner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameDesigner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cacheGameDesignerInput;
    private com.toedter.calendar.JDateChooser dataGameDesignerInput;
    private javax.swing.JComboBox<String> gameDesignerFestivalCombo;
    private javax.swing.JLabel gameDesignerFestivalLabel;
    private javax.swing.JButton guardarGameDesigner;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nomeGameDesignerInput;
    private javax.swing.JTextField telefoneGameDesignerInput;
    // End of variables declaration//GEN-END:variables
}
