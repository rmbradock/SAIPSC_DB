/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saipsc.visao.Equipe;

import com.mycompany.saipsc.Dao.DaoAcesso;
import com.mycompany.saipsc.Dao.DaoCargo;
import com.mycompany.saipsc.Dao.DaoCor;
import com.mycompany.saipsc.Dao.DaoEquipe;
import com.mycompany.saipsc.Dao.DaoPessoa;
import com.mycompany.saipsc.Modelo.ModEquipe;
import com.mycompany.saipsc.ferramentas.Constantes;
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import com.mycompany.saipsc.ferramentas.Formularios;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Batista
 */
public class CadEquipe extends javax.swing.JFrame {

    /**
     * Creates new form CadEquipe
     */
    public CadEquipe() {
        initComponents();
        
        carregarPessoas();
        carregarFaixas();
        carregarCargos();
        carregarAcessos();
        
        if(existeDadosTemporarios()){
            DaoEquipe daoEquipe = new DaoEquipe();
            DaoPessoa daoPessoa = new DaoPessoa();
            DaoCor daoCor = new DaoCor();
            DaoCargo daoCargo = new DaoCargo();
            
            int id = daoEquipe.buscarProximoId();
            if (id>0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);  
        }
        recuperarIdPessoa();
        recuperarIdCor();
        recuperarIdCargo();
        recuperarIdAcesso();
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
    }
    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModEquipe){
            int id = ((ModEquipe) DadosTemporarios.tempObject).getId();
            int idPessoa = ((ModEquipe) DadosTemporarios.tempObject).getIdPessoa();
            int idCargo = ((ModEquipe) DadosTemporarios.tempObject).getIdCargo();
            int idCor = ((ModEquipe) DadosTemporarios.tempObject).getIdCor();
            String graduacao = ((ModEquipe) DadosTemporarios.tempObject).getGraduacao();
            String salario = ((ModEquipe) DadosTemporarios.tempObject).getSalario();    
            int idAcesso = ((ModEquipe) DadosTemporarios.tempObject).getIdAcesso();
            
            tfId.setText(String.valueOf(id));
            tfGraduacao.setText(String.valueOf(graduacao));
            tfSalario.setText(salario);
                        
            try{
                DaoPessoa daoPessoa = new DaoPessoa();
                ResultSet resultSet = daoPessoa.listarPorId(idPessoa);
                resultSet.next();
                String nome = resultSet.getString("NOME");
                int index = 0;
                for(int i =0; i<jcbNome.getItemCount(); i++){
                    if(jcbNome.getItemAt(i).equals(nome)){
                        index = i;
                        break;
                    }
                }
                jcbNome.setSelectedIndex(index);
            }catch (Exception e){}
            
            try{
                DaoCargo daoCargo = new DaoCargo();
                ResultSet resultSet = daoCargo.listarPorId(idCargo);
                resultSet.next();
                String nome = resultSet.getString("NOME");
                int index = 0;
                for(int i =0; i<jcbNome.getItemCount(); i++){
                    if(jcbNome.getItemAt(i).equals(nome)){
                        index = i;
                        break;
                    }
                }
                jcbNome.setSelectedIndex(index);
            }catch (Exception e){}
            
            try{
                DaoCor daoCor = new DaoCor();
                ResultSet resultSet = daoCor.listarPorId(idCor);
                resultSet.next();
                String descricao = resultSet.getString("DESCRICAO");
                int index = 0;
                for(int i =0; i<jcbFaixa.getItemCount(); i++){
                    if(jcbFaixa.getItemAt(i).equals(descricao)){
                        index = i;
                        break;
                    }
                }
                jcbFaixa.setSelectedIndex(index);
            }catch (Exception e){}
                
            
            try{
                DaoAcesso daoAcesso = new DaoAcesso();
                ResultSet resultSet = daoAcesso.listarPorId(idAcesso);
                resultSet.next();
                String nome = resultSet.getString("NOME");
                int index = 0;
                for(int i =0; i<jcbAcesso.getItemCount(); i++){
                    if(jcbAcesso.getItemAt(i).equals(nome)){
                        index = i;
                        break;
                    }
                }
                jcbAcesso.setSelectedIndex(index);
            }catch (Exception e){}
                            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;  
        
    }
    private void inserir(){
        DaoEquipe daoEquipe = new DaoEquipe();
        
        if (daoEquipe.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfNome.getText()), Integer.parseInt(tfCargo.getText()), Integer.parseInt(tfFaixa.getText()), tfGraduacao.getText(), tfSalario.getText(), Integer.parseInt(tfAcesso.getText()))){
            JOptionPane.showMessageDialog(null, "Equipe salvo com sucesso!");
            
            tfId.setText(String.valueOf(daoEquipe.buscarProximoId()));
            tfNome.setText("");
            tfCargo.setText("");
            tfFaixa.setText("");
            tfGraduacao.setText("");
            tfSalario.setText("");
            tfAcesso.setText("");
                        
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o Equipe!");
        }
    }
    private void alterar(){
        DaoEquipe daoEquipe = new DaoEquipe();
        
        if (daoEquipe.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfNome.getText()), Integer.parseInt(tfCargo.getText()), Integer.parseInt(tfFaixa.getText()), tfGraduacao.getText(), tfSalario.getText(), Integer.parseInt(tfAcesso.getText()))){
            JOptionPane.showMessageDialog(null, "Equipe salvo com sucesso!");
            
            tfId.setText("");
            tfNome.setText("");
            tfCargo.setText("");
            tfFaixa.setText("");
            tfGraduacao.setText("");
            tfSalario.setText("");
            tfAcesso.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o Equipe!");
        }
        
        ((ListEquipe) Formularios.listEquipe).listarTodos();
        
        dispose();
    }
    private void excluir(){
        DaoEquipe daoEquipe = new DaoEquipe();
        
        if (daoEquipe.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, tfNome.getText() + " excluído com sucesso!");
            
            tfId.setText("");
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o "+ tfNome);
        }
        
        ((ListEquipe) Formularios.listEquipe).listarTodos();
        
        dispose();
    }
    public void carregarPessoas(){
        try{
            DaoPessoa daoPessoa = new DaoPessoa();

            ResultSet resultSet = daoPessoa.listarTodos();

            while(resultSet.next())
                jcbNome.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void carregarCargos(){
        try{
            DaoCargo daoCargo = new DaoCargo();

            ResultSet resultSet = daoCargo.listarTodos();

            while(resultSet.next())
                jcbCargo.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void carregarFaixas(){
        try{
            DaoCor daoCor = new DaoCor();

            ResultSet resultSet = daoCor.listarTodos();

            while(resultSet.next())
                jcbFaixa.addItem(resultSet.getString("DESCRICAO"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void carregarAcessos(){
        try{
            DaoAcesso daoAcesso = new DaoAcesso();

            ResultSet resultSet = daoAcesso.listarTodos();

            while(resultSet.next())
                jcbAcesso.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void recuperarIdPessoa(){
        try{
            DaoPessoa daoPessoa = new DaoPessoa();
            ResultSet resultSet = daoPessoa.listarPorNome(jcbNome.getSelectedItem().toString());
            
            resultSet.next();
            tfNome.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private void recuperarIdCargo(){
        try{
            DaoCargo daoCargo = new DaoCargo();
            ResultSet resultSet = daoCargo.listarPorNome(jcbCargo.getSelectedItem().toString());
            
            resultSet.next();
            tfCargo.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private void recuperarIdCor(){
        try{
            DaoCor daoCor = new DaoCor();
            ResultSet resultSet = daoCor.listarPorDescricao(jcbFaixa.getSelectedItem().toString());
            
            resultSet.next();
            tfFaixa.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private void recuperarIdAcesso(){
        try{
            DaoAcesso daoAcesso = new DaoAcesso();
            ResultSet resultSet = daoAcesso.listarPorNome(jcbAcesso.getSelectedItem().toString());
            
            resultSet.next();
            tfAcesso.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        tfId = new javax.swing.JTextField();
        jcbNome = new javax.swing.JComboBox<>();
        tfNome = new javax.swing.JTextField();
        jcbCargo = new javax.swing.JComboBox<>();
        tfCargo = new javax.swing.JTextField();
        jcbFaixa = new javax.swing.JComboBox<>();
        tfFaixa = new javax.swing.JTextField();
        tfGraduacao = new javax.swing.JTextField();
        tfSalario = new javax.swing.JTextField();
        jcbAcesso = new javax.swing.JComboBox<>();
        tfAcesso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("NOME");

        jLabel3.setText("CARGO");

        jLabel4.setText("FAIXA");

        jLabel5.setText("GRADUAÇÃO");

        jLabel6.setText("SALARIO");

        jLabel7.setText("ACESSO");

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

        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        jcbNome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbNomeItemStateChanged(evt);
            }
        });
        jcbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNomeActionPerformed(evt);
            }
        });

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        jcbCargo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCargoItemStateChanged(evt);
            }
        });

        jcbFaixa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFaixaItemStateChanged(evt);
            }
        });

        jcbAcesso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbAcessoItemStateChanged(evt);
            }
        });

        tfAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAcessoActionPerformed(evt);
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
                        .addComponent(btnAcao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbFaixa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(1, 1, 1)
                                .addComponent(jcbAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfCargo)
                            .addComponent(tfFaixa)
                            .addComponent(tfAcesso)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfGraduacao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37)
                        .addComponent(tfSalario)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfGraduacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcbAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
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
            
            if(Formularios.cadEquipe != null){
             
                dispose();
            }
        }else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void tfAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAcessoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAcessoActionPerformed

    private void jcbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNomeActionPerformed

    private void jcbNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbNomeItemStateChanged
       recuperarIdPessoa();
    }//GEN-LAST:event_jcbNomeItemStateChanged

    private void jcbCargoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCargoItemStateChanged
        recuperarIdCargo();
    }//GEN-LAST:event_jcbCargoItemStateChanged

    private void jcbFaixaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFaixaItemStateChanged
        recuperarIdCor();
    }//GEN-LAST:event_jcbFaixaItemStateChanged

    private void jcbAcessoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAcessoItemStateChanged
        recuperarIdAcesso();
    }//GEN-LAST:event_jcbAcessoItemStateChanged

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o " + tfNome.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadEquipe = null;
        
        if(Formularios.cadEquipe != null){
        
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
            java.util.logging.Logger.getLogger(CadEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadEquipe().setVisible(true);
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
    private javax.swing.JComboBox<String> jcbAcesso;
    private javax.swing.JComboBox<String> jcbCargo;
    private javax.swing.JComboBox<String> jcbFaixa;
    private javax.swing.JComboBox<String> jcbNome;
    private javax.swing.JTextField tfAcesso;
    private javax.swing.JTextField tfCargo;
    private javax.swing.JTextField tfFaixa;
    private javax.swing.JTextField tfGraduacao;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSalario;
    // End of variables declaration//GEN-END:variables
}
