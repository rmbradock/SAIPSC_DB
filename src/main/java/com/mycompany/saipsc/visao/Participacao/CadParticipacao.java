/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saipsc.visao.Participacao;

import com.mycompany.saipsc.Dao.DaoAluno;
import com.mycompany.saipsc.Dao.DaoCampeonato;
import com.mycompany.saipsc.Dao.DaoParticipacao;
import com.mycompany.saipsc.Dao.DaoPessoa;
import com.mycompany.saipsc.Modelo.ModParticipacao;
import com.mycompany.saipsc.ferramentas.Constantes;
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import com.mycompany.saipsc.ferramentas.Formularios;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Batista
 */
public class CadParticipacao extends javax.swing.JFrame {

    /**
     * Creates new form CadParticipacao
     */
    public CadParticipacao() {
        initComponents();
        
        carregarAlunos();
        carregarCampeonatos();
        
        if(!existeDadosTemporarios()){
            DaoParticipacao daoParticipacao = new DaoParticipacao();
            DaoAluno daoAluno = new DaoAluno();
            DaoCampeonato daoCampeonato = new DaoCampeonato ();
            
            int id = daoParticipacao.buscarProximoId(); 
            if (id>0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        recuperaIdAluno();
        recuperaIdCampeonato();
        
        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
    }
    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModParticipacao){
            int id = ((ModParticipacao) DadosTemporarios.tempObject).getId();
            int idAluno = ((ModParticipacao) DadosTemporarios.tempObject).getIdAluno();
            int idCampeonato = ((ModParticipacao) DadosTemporarios.tempObject).getIdCampeonato();
            String resultado = ((ModParticipacao) DadosTemporarios.tempObject).getResultado();
            
            tfId.setText(String.valueOf(id));
            tfResultado.setText(resultado);
            
            try{
                DaoPessoa daoPessoa = new DaoPessoa();
                ResultSet resultSet = daoPessoa.listarPorId(idAluno);
                resultSet.next();
                String aluno = resultSet.getString("NOME");
                int index = 0;
                for(int i = 0; i < jcbAluno.getItemCount(); i++){
                    if(jcbAluno.getItemAt(i).equals(aluno)){
                        index = i;
                        break;
                    }
                }
                jcbAluno.setSelectedIndex(index);
            }catch(Exception e){}
            
            try{
                DaoCampeonato daoCampeonato = new DaoCampeonato();
                ResultSet resultSet = daoCampeonato.listarPorId(idCampeonato);
                resultSet.next();
                String campeonato = resultSet.getString("NOME");
                int index = 0;
                for(int i = 0; i < jcbCampeonato.getItemCount(); i++){
                    if(jcbCampeonato.getItemAt(i).equals(campeonato)){
                        index = i;
                        break;
                    }
                }
                jcbCampeonato.setSelectedIndex(index);
            }catch(Exception e){}
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
        private void inserir(){
            DaoParticipacao daoParticipacao = new DaoParticipacao();

            if (daoParticipacao.inserir(Integer.parseInt(tfId.getText()), Integer.parseInt(tfAluno.getText()), Integer.parseInt(tfCampeonato.getText()),tfResultado.getText())){
                JOptionPane.showMessageDialog(null, "Participação salva com sucesso!");

                tfId.setText(String.valueOf(daoParticipacao.buscarProximoId()));
                tfAluno.setText("");
                tfCampeonato.setText("");
                tfResultado.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível salvar a Participacao!");
            }
        }

        private void alterar(){
            DaoParticipacao daoParticipacao = new DaoParticipacao();

            if (daoParticipacao.alterar(Integer.parseInt(tfId.getText()), Integer.parseInt(tfAluno.getText()), Integer.parseInt(tfCampeonato.getText()),tfResultado.getText())){
                JOptionPane.showMessageDialog(null, "Campeonato alterado com sucesso!");

                tfId.setText("");
                tfAluno.setText("");
                tfCampeonato.setText("");
                tfResultado.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível alterar a Participacao!");
            }

            ((ListParticipacao) Formularios.listParticipacao).listarTodos();

            dispose();
        }

        private void excluir(){
            DaoParticipacao daoParticipacao = new DaoParticipacao();

            if (daoParticipacao.excluir(Integer.parseInt(tfId.getText()))){
                JOptionPane.showMessageDialog(null, "Partipacao excluída com sucesso!");

                tfId.setText("");
                tfAluno.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível excluir a Participacao!");
            }

            ((ListParticipacao) Formularios.listParticipacao).listarTodos();

            dispose();
    }
    public void carregarAlunos(){
        try{
            DaoPessoa daoPessoa = new DaoPessoa();

            ResultSet resultSet = daoPessoa.listarTodos();

            while(resultSet.next()){
                jcbAluno.addItem(resultSet.getString("NOME"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void recuperaIdAluno(){
        try{
            DaoPessoa daoPessoa = new DaoPessoa();
            ResultSet resultSet = daoPessoa.listarPorNome(jcbAluno.getSelectedItem().toString());
            
            resultSet.next();
            tfAluno.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }   
    public void carregarCampeonatos(){
        try{
            DaoCampeonato daoCampeonato = new DaoCampeonato();

            ResultSet resultSet = daoCampeonato.listarTodos();

            while(resultSet.next()){
                jcbCampeonato.addItem(resultSet.getString("NOME"));
            }
        }catch(Exception e){
           System.out.println(e.getMessage()); 
        }
    }
    
    private void recuperaIdCampeonato(){
        try{
            DaoCampeonato daoCampeonato = new DaoCampeonato();
            ResultSet resultSet = daoCampeonato.listarPorNome(jcbCampeonato.getSelectedItem().toString());
            
            resultSet.next();
            tfCampeonato.setText(resultSet.getString("ID"));
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
        jcbAluno = new javax.swing.JComboBox<>();
        jcbCampeonato = new javax.swing.JComboBox<>();
        tfId = new javax.swing.JTextField();
        tfAluno = new javax.swing.JTextField();
        tfCampeonato = new javax.swing.JTextField();
        tfResultado = new javax.swing.JTextField();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Aluno");

        jLabel3.setText("Campeonato");

        jLabel4.setText("Resultado");

        jcbAluno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbAlunoItemStateChanged(evt);
            }
        });

        jcbCampeonato.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCampeonatoItemStateChanged(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jcbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfAluno))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(31, 31, 31)
                                        .addComponent(tfResultado))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcbCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAcao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jcbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
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
        if(Formularios.cadParticipacao != null){
             
                dispose();
            }
        }else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void jcbAlunoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAlunoItemStateChanged
        recuperaIdAluno();
    }//GEN-LAST:event_jcbAlunoItemStateChanged

    private void jcbCampeonatoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCampeonatoItemStateChanged
        recuperaIdCampeonato();
    }//GEN-LAST:event_jcbCampeonatoItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadParticipacao = null;
    }//GEN-LAST:event_formWindowClosed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir a participacão?" );
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(CadParticipacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadParticipacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadParticipacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadParticipacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadParticipacao().setVisible(true);
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
    private javax.swing.JComboBox<String> jcbAluno;
    private javax.swing.JComboBox<String> jcbCampeonato;
    private javax.swing.JTextField tfAluno;
    private javax.swing.JTextField tfCampeonato;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfResultado;
    // End of variables declaration//GEN-END:variables
}
