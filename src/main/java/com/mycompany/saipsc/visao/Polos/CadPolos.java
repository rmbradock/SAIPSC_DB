/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saipsc.visao.Polos;

import com.mycompany.saipsc.Dao.DaoPolos;
import com.mycompany.saipsc.Modelo.ModPolos;
import com.mycompany.saipsc.ferramentas.Constantes;
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import com.mycompany.saipsc.ferramentas.Formularios;
import javax.swing.JOptionPane;

/**
 *
 * @author Batista
 */
public class CadPolos extends javax.swing.JFrame {

    /**
     * Creates new form CadPolos
     */
    public CadPolos() {
        initComponents();
        
        if(!existeDadosTemporarios()){
            DaoPolos daoPolos = new DaoPolos();

            int id = daoPolos.buscarProximoId(); 
            if (id >= 0)
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
        if(DadosTemporarios.tempObject instanceof ModPolos){
            int id = ((ModPolos) DadosTemporarios.tempObject).getId();
            String nome = ((ModPolos) DadosTemporarios.tempObject).getNome();
            String endereco = ((ModPolos) DadosTemporarios.tempObject).getEndereco();
            String responsavel = ((ModPolos) DadosTemporarios.tempObject).getResponsavel();
            String contato = ((ModPolos) DadosTemporarios.tempObject).getContato();
            
            tfId.setText(String.valueOf(id));
            tfNome.setText(nome);
            tfEndereco.setText(endereco);
            tfResponsavel.setText(responsavel);
            tfContato.setText(contato);
            
        
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
    
    private void inserir(){
        DaoPolos daoPolos = new DaoPolos();
        
        if (daoPolos.inserir(Integer.parseInt(tfId.getText()), tfNome.getText(), tfEndereco.getText(), tfResponsavel.getText(), tfContato.getText())){
            JOptionPane.showMessageDialog(null, "Polo salva com sucesso!");
            
            tfId.setText(String.valueOf(daoPolos.buscarProximoId()));
            tfNome.setText("");
            tfEndereco.setText("");
            tfResponsavel.setText("");
            tfContato.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar Polo!");
        }
    }
    
    private void alterar(){
        DaoPolos daoPolos = new DaoPolos();
        
        if (daoPolos.inserir(Integer.parseInt(tfId.getText()), tfNome.getText(), tfEndereco.getText(), tfResponsavel.getText(), tfContato.getText())){
            JOptionPane.showMessageDialog(null, "Polo alterado com sucesso!");
            
            tfId.setText(String.valueOf(daoPolos.buscarProximoId()));
            tfNome.setText("");
            tfEndereco.setText("");
            tfResponsavel.setText("");
            tfContato.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar Polo!");
        }
        
        ((ListPolos) Formularios.listPolos).listarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoPolos daoPolos = new DaoPolos();
        
        if (daoPolos.inserir(Integer.parseInt(tfId.getText()), tfNome.getText(), tfEndereco.getText(), tfResponsavel.getText(), tfContato.getText())){
            JOptionPane.showMessageDialog(null, "Polo excluido com sucesso!");
            
            tfId.setText(String.valueOf(daoPolos.buscarProximoId()));
            tfNome.setText("");
            tfEndereco.setText("");
            tfResponsavel.setText("");
            tfContato.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o Polo!");
        }
        
        ((ListPolos) Formularios.listPolos).listarTodos();
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        tfResponsavel = new javax.swing.JTextField();
        tfContato = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("NOME");

        jLabel3.setText("ENDEREÇO");

        jLabel4.setText("RESPONSAVEL");

        jLabel5.setText("CONTATO");

        btnAcao.setText("SALVAR");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfContato, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(tfResponsavel)
                            .addComponent(tfEndereco)
                            .addComponent(tfNome)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAcao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                        .addComponent(btnExcluir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        DaoPolos daoPolos = new DaoPolos();
        
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            tfId.setText(String.valueOf(daoPolos.buscarProximoId()));
            tfNome.setText("");
            tfEndereco.setText("");
            tfResponsavel.setText("");
            tfContato.setText("");
        }
        else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT){
            alterar();
            ((ListPolos) Formularios.listPolos).listarTodos();
            dispose();
        }
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o Polo " + tfNome.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadPolos = null;
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
            java.util.logging.Logger.getLogger(CadPolos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPolos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPolos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPolos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPolos().setVisible(true);
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
    private javax.swing.JTextField tfContato;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfResponsavel;
    // End of variables declaration//GEN-END:variables
}