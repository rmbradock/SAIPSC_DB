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
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Batista
 */
public class ListEquipe extends javax.swing.JFrame {

    /**
     * Creates new form ListEquipe
     */
    public ListEquipe() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEquipe.getModel();
            
            tableEquipe.setModel(defaultTableModel);

            DaoEquipe daoEquipe = new DaoEquipe();

            ResultSet resultSet = daoEquipe.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String cargo = resultSet.getString(3);
                String faixa = resultSet.getString(4);
                String graduacao = resultSet.getString(5);
                String salario = resultSet.getString(6);
                String acesso = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, nome, cargo, faixa, graduacao, salario, acesso});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        public void listarPorId(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEquipe.getModel();
            
            tableEquipe.setModel(defaultTableModel);

            DaoEquipe daoEquipe = new DaoEquipe();

            ResultSet resultSet = daoEquipe.listarPorId(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String cargo = resultSet.getString(3);
                String faixa = resultSet.getString(4);
                String graduacao = resultSet.getString(5);
                String salario = resultSet.getString(6);
                String acesso = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, nome, cargo, faixa, graduacao, salario, acesso});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorNome(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEquipe.getModel();
            
            tableEquipe.setModel(defaultTableModel);

            DaoEquipe daoEquipe = new DaoEquipe();

            ResultSet resultSet = daoEquipe.listarPorNome(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String cargo = resultSet.getString(3);
                String faixa = resultSet.getString(4);
                String graduacao = resultSet.getString(5);
                String salario = resultSet.getString(6);
                String acesso = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, nome, cargo, faixa, graduacao, salario, acesso});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorCargo(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEquipe.getModel();
            
            tableEquipe.setModel(defaultTableModel);

            DaoEquipe daoEquipe = new DaoEquipe();

            ResultSet resultSet = daoEquipe.listarPorCargo(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String cargo = resultSet.getString(3);
                String faixa = resultSet.getString(4);
                String graduacao = resultSet.getString(5);
                String salario = resultSet.getString(6);
                String acesso = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, nome, cargo, faixa, graduacao, salario, acesso});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorFaixa(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEquipe.getModel();
            
            tableEquipe.setModel(defaultTableModel);

            DaoEquipe daoEquipe = new DaoEquipe();

            ResultSet resultSet = daoEquipe.listarPorFaixa(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String cargo = resultSet.getString(3);
                String faixa = resultSet.getString(4);
                String graduacao = resultSet.getString(5);
                String salario = resultSet.getString(6);
                String acesso = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, nome, cargo, faixa, graduacao, salario, acesso});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorAcesso(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableEquipe.getModel();
            
            tableEquipe.setModel(defaultTableModel);

            DaoEquipe daoEquipe = new DaoEquipe();

            ResultSet resultSet = daoEquipe.listarPorAcesso(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String cargo = resultSet.getString(3);
                String faixa = resultSet.getString(4);
                String graduacao = resultSet.getString(5);
                String salario = resultSet.getString(6);
                String acesso = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, nome, cargo, faixa, graduacao, salario, acesso});
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
        tableEquipe = new javax.swing.JTable();
        jcbBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "NOME", "CARGO", "FAIXA", "ACESSO", " ", " ", " " }));

        tableEquipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "CARGO", "FAIXA", "GRADUAÇÃO", "SALARIO", "ACESSO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEquipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEquipeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEquipe);

        jcbBuscar.setText("Buscar");
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("RMB");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfFiltro)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbBuscar)
                        .addContainerGap())
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableEquipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEquipeMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModEquipe modEquipe = new ModEquipe();

                modEquipe.setId(Integer.parseInt(String.valueOf(tableEquipe.getValueAt(tableEquipe.getSelectedRow(), 0))));
                modEquipe.setGraduacao(String.valueOf(tableEquipe.getValueAt(tableEquipe.getSelectedRow(), 4)));
                modEquipe.setSalario(String.valueOf(tableEquipe.getValueAt(tableEquipe.getSelectedRow(), 5)));
                               
                DaoPessoa daoPessoa = new DaoPessoa();
                ResultSet resultSet = daoPessoa.listarPorNome(String.valueOf(tableEquipe.getValueAt(tableEquipe.getSelectedRow(), 1)));
                int idPessoa = -1;
                resultSet.next();
                idPessoa = resultSet.getInt("ID");
                modEquipe.setIdPessoa(idPessoa);
                
                DaoCargo daoCargo = new DaoCargo();
                resultSet = daoCargo.listarPorNome(String.valueOf(tableEquipe.getValueAt(tableEquipe.getSelectedRow(), 2)));
                int idCargo = -1;
                resultSet.next();
                idCargo = resultSet.getInt("ID");
                modEquipe.setIdCor(idCargo);
                
                DaoCor daoCor = new DaoCor();
                resultSet = daoCor.listarPorDescricao(String.valueOf(tableEquipe.getValueAt(tableEquipe.getSelectedRow(), 3)));
                int idCor = -1;
                resultSet.next();
                idCor = resultSet.getInt("ID");
                modEquipe.setIdCor(idCor);
                
                DaoAcesso daoAcesso = new DaoAcesso();
                resultSet = daoAcesso.listarPorNome(String.valueOf(tableEquipe.getValueAt(tableEquipe.getSelectedRow(), 6)));
                int idAcesso = -1;
                resultSet.next();
                idAcesso = resultSet.getInt("ID");
                modEquipe.setIdAcesso(idAcesso);
                
                DadosTemporarios.tempObject = (ModEquipe) modEquipe;

                CadEquipe cadEquipe = new CadEquipe();
                cadEquipe.setVisible(true);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }

    }//GEN-LAST:event_tableEquipeMouseClicked

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
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
            listarPorCargo();
            break;
            case 4:
            listarPorFaixa();
            break;
            case 5:
            listarPorAcesso();
            break;
        }
    }//GEN-LAST:event_jcbBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ListEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListEquipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jcbBuscar;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableEquipe;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
