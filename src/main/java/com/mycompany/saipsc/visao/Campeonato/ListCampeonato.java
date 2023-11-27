/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saipsc.Visao.Campeonato;

import com.mycompany.saipsc.Dao.DaoCampeonato;
import com.mycompany.saipsc.Modelo.ModCampeonato;
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Batista
 */
public class ListCampeonato extends javax.swing.JFrame {

    /**
     * Creates new form ListCampeonato
     */
    public ListCampeonato() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
        
    }
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCampeonato.getModel();
            
            tableCampeonato.setModel(defaultTableModel);

            DaoCampeonato daoCampeonato = new DaoCampeonato();

            ResultSet resultSet = daoCampeonato.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String local = resultSet.getString(3);
                String responsavel = resultSet.getString(4);
                String contato = resultSet.getString(5);
                String data = resultSet.getString(6);
                String inscricao = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, nome, local, responsavel, contato, data, inscricao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorId(int pId){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCampeonato.getModel();
            
            tableCampeonato.setModel(defaultTableModel);

            DaoCampeonato daoCampeonato = new DaoCampeonato();

            ResultSet resultSet = daoCampeonato.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String local = resultSet.getString(3);
                String responsavel = resultSet.getString(4);
                String contato = resultSet.getString(5);
                String data = resultSet.getString(6);
                String inscricao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, nome, local, responsavel, contato, data, inscricao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorNome(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCampeonato.getModel();
            
            tableCampeonato.setModel(defaultTableModel);

            DaoCampeonato daoCampeonato = new DaoCampeonato();

            ResultSet resultSet = daoCampeonato.listarPorNome(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String local = resultSet.getString(3);
                String responsavel = resultSet.getString(4);
                String contato = resultSet.getString(5);
                String data = resultSet.getString(6);
                String inscricao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, nome, local, responsavel, contato, data, inscricao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorLocal(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCampeonato.getModel();
            
            tableCampeonato.setModel(defaultTableModel);

            DaoCampeonato daoCampeonato = new DaoCampeonato();

            ResultSet resultSet = daoCampeonato.listarPorLocal(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String local = resultSet.getString(3);
                String responsavel = resultSet.getString(4);
                String contato = resultSet.getString(5);
                String data = resultSet.getString(6);
                String inscricao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, nome, local, responsavel, contato, data, inscricao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorData(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCampeonato.getModel();
            
            tableCampeonato.setModel(defaultTableModel);

            DaoCampeonato daoCampeonato = new DaoCampeonato();

            ResultSet resultSet = daoCampeonato.listarPorData(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String local = resultSet.getString(3);
                String responsavel = resultSet.getString(4);
                String contato = resultSet.getString(5);
                String data = resultSet.getString(6);
                String inscricao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, nome, local, responsavel, contato, data, inscricao});
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
        tableCampeonato = new javax.swing.JTable();
        jcbBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "NOME", "LOCAL", "DATA" }));

        tableCampeonato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "LOCAL", "RESPONSAVEL", "CONTATO", "DATA", "INSCRICAO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCampeonato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCampeonatoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCampeonato);

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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
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
            .addGap(0, 613, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
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

    private void tableCampeonatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCampeonatoMouseClicked
        if (evt.getClickCount() == 2){
                ModCampeonato modCampeonato = new ModCampeonato();

                modCampeonato.setId(Integer.parseInt(String.valueOf(tableCampeonato.getValueAt(tableCampeonato.getSelectedRow(), 0))));
                modCampeonato.setNome(String.valueOf(tableCampeonato.getValueAt(tableCampeonato.getSelectedRow(), 1)));
                modCampeonato.setLocal(String.valueOf(tableCampeonato.getValueAt(tableCampeonato.getSelectedRow(), 2)));
                modCampeonato.setResponsavel(String.valueOf(tableCampeonato.getValueAt(tableCampeonato.getSelectedRow(), 3)));
                modCampeonato.setContato(String.valueOf(tableCampeonato.getValueAt(tableCampeonato.getSelectedRow(), 4)));
                modCampeonato.setData(String.valueOf(tableCampeonato.getValueAt(tableCampeonato.getSelectedRow(), 5)));
                modCampeonato.setInscricao(String.valueOf(tableCampeonato.getValueAt(tableCampeonato.getSelectedRow(), 6)));
                                
                DadosTemporarios.tempObject = (ModCampeonato) modCampeonato;

                CadCampeonato cadCampeonato = new CadCampeonato();
                cadCampeonato.setVisible(true);
            
        }
    }//GEN-LAST:event_tableCampeonatoMouseClicked

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
            listarTodos();
            break;
            case 1:
            listarPorId(Integer.parseInt(tfFiltro.getText()));
            break;
            case 2:
            listarPorNome();
            break;
            case 3:
            listarPorLocal();
            break;
            case 4:
            listarPorData();
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
            java.util.logging.Logger.getLogger(ListCampeonato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListCampeonato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListCampeonato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListCampeonato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListCampeonato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jcbBuscar;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableCampeonato;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
