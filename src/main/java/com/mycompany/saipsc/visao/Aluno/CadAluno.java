/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saipsc.Visao.Aluno;

import com.mycompany.saipsc.Dao.DaoAluno;
import com.mycompany.saipsc.Dao.DaoCor;
import com.mycompany.saipsc.Dao.DaoPessoa;
import com.mycompany.saipsc.Dao.DaoPolos;
import com.mycompany.saipsc.Modelo.ModAluno;
import com.mycompany.saipsc.ferramentas.Constantes;
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import com.mycompany.saipsc.ferramentas.Formularios;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author batista.4995
 */
public class CadAluno extends javax.swing.JFrame {

    /**
     * Creates new form CadAluno
     */
    public CadAluno() {
        initComponents();
        
        carregarPessoas();
        carregarFaixas();
        carregarPolos();
        
        if(!existeDadosTemporarios()){
            DaoAluno daoAluno = new DaoAluno();
            DaoPessoa daoPessoa = new DaoPessoa();
            DaoCor daoCor = new DaoCor();
            DaoPolos daoPolos = new DaoPolos();
             
            int id = daoAluno.buscarProximoId();
            if (id>0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);  
        }

        recuperaIdPessoa();
        recuperaIdFaixa();
        recuperaIdPolo();
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
              
    }
    
    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModAluno){
            int id = ((ModAluno) DadosTemporarios.tempObject).getId();
            int idPessoa = ((ModAluno) DadosTemporarios.tempObject).getIdPessoa();
            int idCor = ((ModAluno) DadosTemporarios.tempObject).getIdCor();
            String nascimento = ((ModAluno) DadosTemporarios.tempObject).getNascimento();
            String idade = ((ModAluno) DadosTemporarios.tempObject).getIdade();
            String responsavel = ((ModAluno) DadosTemporarios.tempObject).getResponsavel();    
            String uGrad = ((ModAluno) DadosTemporarios.tempObject).getUGrad();
            String pGrad = ((ModAluno) DadosTemporarios.tempObject).getPGrad();
            String faltas = ((ModAluno) DadosTemporarios.tempObject).getFaltas();
            int idPolo = ((ModAluno) DadosTemporarios.tempObject).getIdPolo();
            String cpfResp = ((ModAluno) DadosTemporarios.tempObject).getCpfResp();
            
            tfId.setText(String.valueOf(id));
            tfNasc.setText(nascimento);
            tfIdade.setText(idade);
            tfResp.setText(responsavel);
            tfUgrad.setText(uGrad);
            tfPGrad.setText(pGrad);
            tfFaltas.setText(faltas);
            tfCpfResp.setText(cpfResp);
            
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
                DaoPolos daoPolos = new DaoPolos();
                ResultSet resultSet = daoPolos.listarPorId(idPolo);
                resultSet.next();
                String nome = resultSet.getString("NOME");
                int index = 0;
                for(int i =0; i<jcbPolo.getItemCount(); i++){
                    if(jcbPolo.getItemAt(i).equals(nome)){
                        index = i;
                        break;
                    }
                }
                jcbPolo.setSelectedIndex(index);
            }catch (Exception e){}
                            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;        
    }
        
    private void inserir(){
        DaoAluno daoAluno = new DaoAluno();
        
        if (daoAluno.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdPessoa.getText()), Integer.parseInt(tfIdFaixa.getText()), tfNasc.getText(),tfIdade.getText(), tfResp.getText(), tfUgrad.getText(), tfPGrad.getText(), tfFaltas.getText(), Integer.parseInt(tfIdPolo.getText()), tfCpfResp.getText())){
            JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!");
            
            tfId.setText(String.valueOf(daoAluno.buscarProximoId()));
            tfIdPessoa.setText("");
            tfIdFaixa.setText("");
            tfNasc.setText("");
            tfIdade.setText("");
            tfResp.setText("");
            tfUgrad.setText("");
            tfPGrad.setText("");
            tfFaltas.setText("");
            tfIdPolo.setText("");
            tfCpfResp.setText("");
            
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o Aluno!");
        }
    }
    private void alterar(){
        DaoAluno daoAluno = new DaoAluno();
        
        if (daoAluno.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfIdPessoa.getText()), Integer.parseInt(tfIdFaixa.getText()), tfNasc.getText(), tfIdade.getText(), tfResp.getText(), tfUgrad.getText(), tfPGrad.getText(), tfFaltas.getText(), Integer.parseInt(tfIdPolo.getText()), tfCpfResp.getText())){
            JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");
            
            tfId.setText("");
            tfIdPessoa.setText("");
            tfIdFaixa.setText("");
            tfNasc.setText("");
            tfIdade.setText("");
            tfResp.setText("");
            tfUgrad.setText("");
            tfPGrad.setText("");
            tfFaltas.setText("");
            tfIdPolo.setText("");
            tfCpfResp.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o aluno!");
        }
        
        ((ListAluno) Formularios.listAluno).listarTodos();
        
        dispose();
    }
    private void excluir(){
        DaoAluno daoAluno = new DaoAluno();
        
        if (daoAluno.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, "Aluno " + tfIdPessoa.getText() + " excluída com sucesso!");
            
            tfId.setText("");
            tfIdPessoa.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o aluno!");
        }
        
        ((ListAluno) Formularios.listAluno).listarTodos();
        
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
    
    
    private void recuperaIdPessoa(){
        try{
            DaoPessoa daoPessoa = new DaoPessoa();
            ResultSet resultSet = daoPessoa.listarPorNome(jcbNome.getSelectedItem().toString());
            
            resultSet.next();
            tfIdPessoa.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
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
    
    private void recuperaIdFaixa(){
        try{
            DaoCor daoCor = new DaoCor();
            ResultSet resultSet = daoCor.listarPorDescricao(jcbFaixa.getSelectedItem().toString());
            
            resultSet.next();
            tfIdFaixa.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void carregarPolos(){
        try{
            DaoPolos daoPolos = new DaoPolos();

            ResultSet resultSet = daoPolos.listarTodos();

            while(resultSet.next())
                jcbPolo.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdPolo(){
        try{
            DaoPolos daoPolos = new DaoPolos();
            ResultSet resultSet = daoPolos.listarPorNome(jcbPolo.getSelectedItem().toString());
            
            resultSet.next();
            tfIdPolo.setText(resultSet.getString("ID"));
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
        tfId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNasc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfIdade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfResp = new javax.swing.JTextField();
        jcbNome = new javax.swing.JComboBox<>();
        jcbFaixa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        tfUgrad = new javax.swing.JTextField();
        tfPGrad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfFaltas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jcbPolo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tfCpfResp = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        tfIdPessoa = new javax.swing.JTextField();
        tfIdFaixa = new javax.swing.JTextField();
        tfIdPolo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Nome");

        jLabel3.setText("Faixa");

        jLabel4.setText("Data de Nascimento");

        jLabel5.setText("idade");

        jLabel6.setText("Responsavel");

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

        jcbFaixa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFaixaItemStateChanged(evt);
            }
        });

        jLabel7.setText("Ultima Graducação");

        jLabel8.setText("Proxima Graduação");

        jLabel9.setText("Faltas");

        jLabel10.setText("Polo");

        jcbPolo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPoloItemStateChanged(evt);
            }
        });

        jLabel11.setText("CPF Responsável");

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

        tfIdPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdPessoaActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCpfResp)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfUgrad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfPGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcbPolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfIdPolo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfIdPessoa)
                                    .addComponent(tfIdFaixa)))))
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfResp))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfIdade, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfUgrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jcbPolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdPolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfCpfResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbNomeItemStateChanged
        recuperaIdPessoa();
    }//GEN-LAST:event_jcbNomeItemStateChanged

    private void jcbFaixaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFaixaItemStateChanged
        recuperaIdFaixa();
    }//GEN-LAST:event_jcbFaixaItemStateChanged

    private void jcbPoloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPoloItemStateChanged
        recuperaIdPolo();
    }//GEN-LAST:event_jcbPoloItemStateChanged

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            if(Formularios.cadAluno != null){
             
                dispose();
            }
        }else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o aluno " + tfIdPessoa.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadAluno = null;
        
        if(Formularios.cadAluno != null){
        
        }
    }//GEN-LAST:event_formWindowClosed

    private void tfIdPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdPessoaActionPerformed

    private void jcbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNomeActionPerformed

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
            java.util.logging.Logger.getLogger(CadAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jcbFaixa;
    private javax.swing.JComboBox<String> jcbNome;
    private javax.swing.JComboBox<String> jcbPolo;
    private javax.swing.JTextField tfCpfResp;
    private javax.swing.JTextField tfFaltas;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdFaixa;
    private javax.swing.JTextField tfIdPessoa;
    private javax.swing.JTextField tfIdPolo;
    private javax.swing.JTextField tfIdade;
    private javax.swing.JTextField tfNasc;
    private javax.swing.JTextField tfPGrad;
    private javax.swing.JTextField tfResp;
    private javax.swing.JTextField tfUgrad;
    // End of variables declaration//GEN-END:variables
}
