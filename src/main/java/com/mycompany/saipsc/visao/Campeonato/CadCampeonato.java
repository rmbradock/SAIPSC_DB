/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saipsc.Visao.Campeonato;

import com.mycompany.saipsc.Dao.DaoCampeonato;
import com.mycompany.saipsc.Modelo.ModCampeonato;
import com.mycompany.saipsc.ferramentas.Constantes;
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import com.mycompany.saipsc.ferramentas.Formularios;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Batista
 */
public class CadCampeonato extends javax.swing.JFrame {

    /**
     * Creates new form CadCampeonato
     */
    public CadCampeonato() {
        initComponents();
        
        if(!existeDadosTemporarios()){
            DaoCampeonato daoCampeonato = new DaoCampeonato();
            
            int id = daoCampeonato.buscarProximoId();
            if (id>= 0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);

    }
        private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModCampeonato){
            int id = ((ModCampeonato) DadosTemporarios.tempObject).getId();
            String nome = ((ModCampeonato) DadosTemporarios.tempObject).getNome();
            String local = ((ModCampeonato) DadosTemporarios.tempObject).getLocal();
            String responsavel = ((ModCampeonato) DadosTemporarios.tempObject).getResponsavel();
            String contato = ((ModCampeonato) DadosTemporarios.tempObject).getContato();
            String data = ((ModCampeonato) DadosTemporarios.tempObject).getData();
            String inscricao = ((ModCampeonato) DadosTemporarios.tempObject).getInscricao();
            
            tfId.setText(String.valueOf(id));
            tfNome.setText(nome);
            tfLocal.setText(local);
            tfResponsavel.setText(responsavel);
            tfContato.setText(contato);
            tfData.setText(data);
            tfInscricao.setText(inscricao);
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
        private void inserir(){
        DaoCampeonato daoCampeonato = new DaoCampeonato();
        
        if  (daoCampeonato.inserir(Integer.parseInt(tfId.getText()), tfNome.getText(), tfLocal.getText(), tfResponsavel.getText(), tfContato.getText(), tfData.getText(), tfInscricao.getText())){
            JOptionPane.showMessageDialog(null, "Campeonato salvo com sucesso!");
            
            tfId.setText(String.valueOf(daoCampeonato.buscarProximoId()));
            tfNome.setText("");
            tfLocal.setText("");
            tfResponsavel.setText("");
            tfContato.setText("");
            tfData.setText("");
            tfInscricao.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o campeonato!");
        }
    }
        private void alterar(){
        DaoCampeonato daoCampeonato = new DaoCampeonato();
        
        if (daoCampeonato.alterar(Integer.parseInt(tfId.getText()), tfNome.getText(), tfLocal.getText(), tfResponsavel.getText(), tfContato.getText(), tfData.getText(), tfInscricao.getText())){
            JOptionPane.showMessageDialog(null, "Campeonato alterado com sucesso!");
            
            tfId.setText("");
            tfNome.setText("");
            tfLocal.setText("");
            tfResponsavel.setText("");
            tfContato.setText("");
            tfData.setText("");
            tfInscricao.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o campeonato!");
        }
        ((ListCampeonato) Formularios.listCampeonato).listarTodos();
        
        dispose();
    }
        private void excluir(){
            DaoCampeonato daoCampeonato = new DaoCampeonato();

            if (daoCampeonato.excluir(Integer.parseInt(tfId.getText()))){
                JOptionPane.showMessageDialog(null, "Campeonato " + tfNome.getText() + " excluído com sucesso!");

                tfId.setText("");
                tfNome.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o campeonato!");
            }

            ((ListCampeonato) Formularios.listCampeonato).listarTodos();

            dispose();
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
        tfId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfContato = new javax.swing.JTextField();
        tfInscricao = new javax.swing.JTextField();
        tfData = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfLocal = new javax.swing.JTextField();
        tfResponsavel = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Nome");

        jLabel3.setText("Local");

        jLabel4.setText("Responsavel");

        jLabel5.setText("Contato");

        jLabel6.setText("Data");

        jLabel7.setText("Inscricao");

        btnAcao.setText("Salvar");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfContato, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(tfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAcao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfLocal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfContato, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            if(Formularios.cadCampeonato != null){
             
                dispose();
            }
        }else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o campeonato " + tfNome.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadCampeonato = null;
        
        if(Formularios.cadCampeonato != null){
        
        }
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(CadCampeonato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCampeonato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCampeonato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCampeonato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadCampeonato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField tfContato;
    private javax.swing.JTextField tfData;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfInscricao;
    private javax.swing.JTextField tfLocal;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfResponsavel;
    // End of variables declaration//GEN-END:variables
}
