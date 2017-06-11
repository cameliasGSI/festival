/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Festival;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

/**
 *
 * @author Miguel
 */
public class GestaoBilhetes extends javax.swing.JFrame {

    private Menu anterior;
    private List<Festival> festivais;

    /**
     * Creates new form GestãoBilhetes
     */
    public GestaoBilhetes() {
        initComponents();
    }
    
     public GestaoBilhetes(Menu anterior) {
        
        this.anterior = anterior;
        
        initComponents();
    }
     
    public GestaoBilhetes(Menu menu, List<Festival> fest) {
        initComponents();
        this.anterior = menu;
        this.festivais = fest;
        
        ComboBoxModel comboModel = new DefaultComboBoxModel(fest.toArray());
        
        comboBoxGestaoBilhetes.setModel(comboModel);
        
        refreshBilheteira();
    }
    
    public void refreshBilheteira() {
        Festival selecionado = (Festival) comboBoxGestaoBilhetes.getSelectedItem();
        
        if (selecionado != null) {
            precoBilheteInput.setValue(selecionado.getPreco());
            int vendidos = selecionado.getBilhetes().size();
            bilhetesVendidosLabel.setText("" + vendidos);
            
            if (vendidos > 0) {
                atualizarPreco.setEnabled(false);
                precoBilheteInput.setEnabled(false);
            }
            else {
                atualizarPreco.setEnabled(true);
                precoBilheteInput.setEnabled(true);
            }
            
            if (vendidos >= selecionado.getLotacao()) {
                venderBilhetes.setEnabled(false);
            }
            else {
                venderBilhetes.setEnabled(true);
            }
        }
        else {
            venderBilhetes.setEnabled(false);
        }
    }
    
    private void atualizarPreco() {
        Festival selecionado = (Festival) comboBoxGestaoBilhetes.getSelectedItem();
        
        if (selecionado != null) {
            int preco = (Integer)precoBilheteInput.getValue();
            selecionado.setPreco(preco);
            
        }
    }
    
    public void terminar() {
        anterior.terminar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        LabelNomeDoFestival = new javax.swing.JLabel();
        comboBoxGestaoBilhetes = new javax.swing.JComboBox<>();
        LabelBilhetesVendidos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bilhetesVendidosLabel = new javax.swing.JLabel();
        venderBilhetes = new javax.swing.JButton();
        precoBilheteInput = new javax.swing.JSpinner();
        atualizarPreco = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Gestão Bilheiteiras");

        LabelNomeDoFestival.setText("Nome Festival:");

        comboBoxGestaoBilhetes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxGestaoBilhetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGestaoBilhetesActionPerformed(evt);
            }
        });

        LabelBilhetesVendidos.setText("Bilhetes Vendidos:");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Preço Bilhete: ");

        bilhetesVendidosLabel.setText("0");

        venderBilhetes.setText("Vender");
        venderBilhetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderBilhetesActionPerformed(evt);
            }
        });

        atualizarPreco.setText("Atualizar");
        atualizarPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarPrecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelNomeDoFestival, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                            .addComponent(LabelBilhetesVendidos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxGestaoBilhetes, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bilhetesVendidosLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(precoBilheteInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(atualizarPreco)))))
                .addContainerGap(341, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(venderBilhetes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxGestaoBilhetes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelNomeDoFestival, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelBilhetesVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bilhetesVendidosLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precoBilheteInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atualizarPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(venderBilhetes))
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        JFrame janela;
        
        if (this.anterior != null) {
            janela = anterior;
        }
        else {
            janela = new Menu();
            janela.setLocationRelativeTo(null);
        }
        
        this.setVisible(false);
        janela.setVisible(true);
        //System.exit(WIDTH);        // TODO add your handling code here:                   // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboBoxGestaoBilhetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGestaoBilhetesActionPerformed
        refreshBilheteira();
    }//GEN-LAST:event_comboBoxGestaoBilhetesActionPerformed

    private void atualizarPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarPrecoActionPerformed
        atualizarPreco();
    }//GEN-LAST:event_atualizarPrecoActionPerformed

    private void venderBilhetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderBilhetesActionPerformed
        Festival selecionado = (Festival) comboBoxGestaoBilhetes.getSelectedItem();
        
        if (selecionado != null) {
            VenderBilhetes venderBilhetes = new VenderBilhetes(this, selecionado);
            venderBilhetes.setLocationRelativeTo(null);

            this.setVisible(false);
            venderBilhetes.setVisible(true);
        }
    }//GEN-LAST:event_venderBilhetesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        anterior.terminar();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(GestaoBilhetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestaoBilhetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestaoBilhetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestaoBilhetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestaoBilhetes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBilhetesVendidos;
    private javax.swing.JLabel LabelNomeDoFestival;
    private javax.swing.JButton atualizarPreco;
    private javax.swing.JLabel bilhetesVendidosLabel;
    private javax.swing.JComboBox<String> comboBoxGestaoBilhetes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner precoBilheteInput;
    private javax.swing.JButton venderBilhetes;
    // End of variables declaration//GEN-END:variables
}
