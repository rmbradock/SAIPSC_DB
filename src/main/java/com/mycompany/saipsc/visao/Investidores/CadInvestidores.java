/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saipsc.visao.Investidores;

import com.mycompany.saipsc.Dao.DaoInvestidores;
import com.mycompany.saipsc.Dao.DaoPessoa;
import com.mycompany.saipsc.Modelo.ModInvestidores;
import com.mycompany.saipsc.ferramentas.Constantes;
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import com.mycompany.saipsc.ferramentas.Formularios;
import com.mycompany.saipsc.visao.Pessoa.CadPessoa;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Batista
 */
public class CadInvestidores extends javax.swing.JFrame {

    /**
     * Creates new form CadInvestidores
     */
    public CadInvestidores() {
        initComponents();
        carregarPessoas();
        
        if(!existeDadosTemporarios()){
            DaoInvestidores daoInvestidores = new DaoInvestidores();
            DaoPessoa daoPessoa = new DaoPessoa();
            
            int id = daoInvestidores.buscarProximoId();
            if (id>0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);  
        }

        recuperaIdPessoa();
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
    }
        private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModInvestidores){
            int id = ((ModInvestidores) DadosTemporarios.tempObject).getId();
            int idPessoa = ((ModInvestidores) DadosTemporarios.tempObject).getIdPessoa();
            String obs = ((ModInvestidores) DadosTemporarios.tempObject).getObs();
            String investimento = ((ModInvestidores) DadosTemporarios.tempObject).getInvestimento();
            String periodicidade = ((ModInvestidores) DadosTemporarios.tempObject).getPeriodicidade();    
                        
            tfId.setText(String.valueOf(id));
            tfNome.setText(String.valueOf(idPessoa));
            taObs.setText(obs);
            tfInvest.setText(investimento);
            tfPeriodicidade.setText(periodicidade);
            
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
                
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
                
    }
    private void inserir(){
        DaoInvestidores daoInvestidores = new DaoInvestidores();
        
        if (daoInvestidores.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfNome.getText()), taObs.getText(), tfInvest.getText(), tfPeriodicidade.getText())){
            JOptionPane.showMessageDialog(null, "Investidor salvo com sucesso!");
            
            tfId.setText(String.valueOf(daoInvestidores.buscarProximoId()));
            tfNome.setText("");
            taObs.setText("");
            tfInvest.setText("");
            tfPeriodicidade.setText("");
                        
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o Investidor!");
        }
    }
    private void alterar(){
        DaoInvestidores daoInvestidores = new DaoInvestidores();
        
        if (daoInvestidores.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfNome.getText()), taObs.getText(), tfInvest.getText(), tfPeriodicidade.getText())){
            JOptionPane.showMessageDialog(null, "Investidor salvo com sucesso!");
            
            tfId.setText(String.valueOf(daoInvestidores.buscarProximoId()));
            tfNome.setText("");
            taObs.setText("");
            tfInvest.setText("");
            tfPeriodicidade.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o Investidor!");
        }
        
        ((ListInvestidores) Formularios.listInvestidores).listarTodos();
        
        dispose();
    }
    private void excluir(){
        DaoInvestidores daoInvestidores = new DaoInvestidores();
        
        if (daoInvestidores.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, "Investidor " + tfNome.getText() + " excluído com sucesso!");
            
            tfId.setText("");
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o Investidor!");
        }
        
        ((ListInvestidores) Formularios.listInvestidores).listarTodos();
        
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
            tfNome.setText(resultSet.getString("ID"));
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
        tfId = new javax.swing.JTextField();
        jcbNome = new javax.swing.JComboBox<>();
        tfNome = new javax.swing.JTextField();
        tfInvest = new javax.swing.JTextField();
        tfPeriodicidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taObs = new javax.swing.JTextArea();
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

        jLabel3.setText("OBS");

        jLabel4.setText("INVESTIMENTO");

        jLabel5.setText("PERIODICIDADE");

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

        tfInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfInvestActionPerformed(evt);
            }
        });

        taObs.setColumns(20);
        taObs.setRows(5);
        jScrollPane1.setViewportView(taObs);

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(tfInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(60, 60, 60)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfPeriodicidade)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(64, 64, 64))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNome))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAcao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluir)))
                        .addContainerGap())))
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
                    .addComponent(jcbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfInvest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPeriodicidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfInvestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfInvestActionPerformed

    private void jcbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNomeActionPerformed
        recuperaIdPessoa();
    }//GEN-LAST:event_jcbNomeActionPerformed

    private void jcbNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbNomeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNomeItemStateChanged

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT)
            inserir();
        else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o investidor " + tfNome.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION){
            excluir();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadPessoa = null;
        
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
            java.util.logging.Logger.getLogger(CadInvestidores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadInvestidores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadInvestidores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadInvestidores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadInvestidores().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbNome;
    private javax.swing.JTextArea taObs;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfInvest;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPeriodicidade;
    // End of variables declaration//GEN-END:variables
}
