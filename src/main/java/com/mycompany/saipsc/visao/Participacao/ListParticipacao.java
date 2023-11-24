/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saipsc.visao.Participacao;

import com.mycompany.saipsc.Dao.DaoAluno;
import com.mycompany.saipsc.Dao.DaoCampeonato;
import com.mycompany.saipsc.Dao.DaoParticipacao;
import com.mycompany.saipsc.Modelo.ModParticipacao;
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import com.mycompany.saipsc.ferramentas.Formularios;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Batista
 */
public class ListParticipacao extends javax.swing.JFrame {

    /**
     * Creates new form ListParticipacao
     */
    public ListParticipacao() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableParticipacao.getModel();
            
            tableParticipacao.setModel(defaultTableModel);

            DaoParticipacao daoParticipacao = new DaoParticipacao();

            ResultSet resultSet = daoParticipacao.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String competicao = resultSet.getString(3);
                String resultado = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, nome, competicao, resultado});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorId(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableParticipacao.getModel();

            tableParticipacao.setModel(defaultTableModel);

            DaoParticipacao daoParticipacao = new DaoParticipacao();

            ResultSet resultSet = daoParticipacao.listarPorId(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String competicao = resultSet.getString(3);
                String resultado = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, nome, competicao, resultado});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorNome(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableParticipacao.getModel();
            
            tableParticipacao.setModel(defaultTableModel);

            DaoParticipacao daoParticipacao = new DaoParticipacao();

            ResultSet resultSet = daoParticipacao.listarPorNome(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String competicao = resultSet.getString(3);
                String resultado = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, nome, competicao, resultado});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorCompeticao(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableParticipacao.getModel();

            tableParticipacao.setModel(defaultTableModel);

            DaoParticipacao daoParticipacao = new DaoParticipacao();

            ResultSet resultSet = daoParticipacao.listarPorCompeticao(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String competicao = resultSet.getString(3);
                String resultado = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, nome, competicao, resultado});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableParticipacao = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "ALUNO", "CAMPEONATO" }));

        tableParticipacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "ALUNO", "CAMPEONATO", "RESULTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableParticipacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableParticipacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableParticipacao);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableParticipacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableParticipacaoMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModParticipacao modParticipacao = new ModParticipacao();

                modParticipacao.setId(Integer.parseInt(String.valueOf(tableParticipacao.getValueAt(tableParticipacao.getSelectedRow(), 0))));
                modParticipacao.setResultado(String.valueOf(tableParticipacao.getValueAt(tableParticipacao.getSelectedRow(), 3)));

                DaoParticipacao daoParticipacao = new DaoParticipacao();
                ResultSet resultSet = daoParticipacao.listarPorNome(String.valueOf(tableParticipacao.getValueAt(tableParticipacao.getSelectedRow(), 1)));
                int idAluno = -1;
                while(resultSet.next())
                idAluno = resultSet.getInt("NOME");
                modParticipacao.setIdAluno(idAluno);
                DadosTemporarios.tempObject = (ModParticipacao) modParticipacao;

                DaoCampeonato daoCampeonato = new DaoCampeonato();
                resultSet = daoCampeonato.listarPorNome(String.valueOf(tableParticipacao.getValueAt(tableParticipacao.getSelectedRow(), 2)));
                int idCompeticao = -1;
                while(resultSet.next())
                idCompeticao = resultSet.getInt("NOME");
                modParticipacao.setIdAluno(idCompeticao);
                
                
                DadosTemporarios.tempObject = (ModParticipacao) modParticipacao;
                CadParticipacao cadParticipacao = new CadParticipacao();
                cadParticipacao.setVisible(true);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        
        }
    }//GEN-LAST:event_tableParticipacaoMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
            listarTodos();
            break;
            case 1:
            listarPorId();
            break;
            case 2:
            listarPorNome();
            break;
            case 3:
            listarPorCompeticao();
            break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.listParticipacao = null;
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
            java.util.logging.Logger.getLogger(ListParticipacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListParticipacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListParticipacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListParticipacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListParticipacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableParticipacao;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}