/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saipsc.visao.KimonoF;

import com.mycompany.saipsc.Dao.DaoCondicao;
import com.mycompany.saipsc.Dao.DaoCor;
import com.mycompany.saipsc.Dao.DaoKimonoF;
import com.mycompany.saipsc.Dao.DaoMarca;
import com.mycompany.saipsc.Dao.DaoTamanho;
import com.mycompany.saipsc.Modelo.ModKimonoF;
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Batista
 */
public class ListKimonoF extends javax.swing.JFrame {

    /**
     * Creates new form ListKimonoF
     */
    public ListKimonoF() {
        initComponents();
    
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    public void listarTodos(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableKimonoF.getModel();
            
            tableKimonoF.setModel(defaultTableModel);

            DaoKimonoF daoKimonoF = new DaoKimonoF();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoKimonoF.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String categoria = resultSet.getString(2);
                String marca = resultSet.getString(3);
                String nome =  resultSet.getString(4);
                String descricao =  resultSet.getString(5);
                String preco = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{id, categoria, marca, nome, descricao, preco});
            }
        }catch(Exception e){
            
        }
    }
        public void listarPorId(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableKimonoF.getModel();
            
            tableKimonoF.setModel(defaultTableModel);

            DaoKimonoF daoKimonoF = new DaoKimonoF();

            ResultSet resultSet = daoKimonoF.listarPorId(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String idCategoria = resultSet.getString(3);
                String idTamanho = resultSet.getString(4);
                String idCor = resultSet.getString(5);
                String idMarca = resultSet.getString(6);
                String idCondicao = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, quantidade, idCategoria, idTamanho, idCor, idMarca, idCondicao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorCategoria(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableKimonoF.getModel();
            
            tableKimonoF.setModel(defaultTableModel);

            DaoKimonoF daoKimonoF = new DaoKimonoF();

            ResultSet resultSet = daoKimonoF.listarPorCategoria(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String idCategoria = resultSet.getString(3);
                String idTamanho = resultSet.getString(4);
                String idCor = resultSet.getString(5);
                String idMarca = resultSet.getString(6);
                String idCondicao = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, quantidade, idCategoria, idTamanho, idCor, idMarca, idCondicao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorTamanho(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableKimonoF.getModel();
            
            tableKimonoF.setModel(defaultTableModel);

            DaoKimonoF daoKimonoF = new DaoKimonoF();

            ResultSet resultSet = daoKimonoF.listarPorTamanho(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String idCategoria = resultSet.getString(3);
                String idTamanho = resultSet.getString(4);
                String idCor = resultSet.getString(5);
                String idMarca = resultSet.getString(6);
                String idCondicao = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, quantidade, idCategoria, idTamanho, idCor, idMarca, idCondicao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorCor(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableKimonoF.getModel();
            
            tableKimonoF.setModel(defaultTableModel);

            DaoKimonoF daoKimonoF = new DaoKimonoF();

            ResultSet resultSet = daoKimonoF.listarPorCor(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String idCategoria = resultSet.getString(3);
                String idTamanho = resultSet.getString(4);
                String idCor = resultSet.getString(5);
                String idMarca = resultSet.getString(6);
                String idCondicao = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, quantidade, idCategoria, idTamanho, idCor, idMarca, idCondicao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorMarca(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableKimonoF.getModel();
            
            tableKimonoF.setModel(defaultTableModel);

            DaoKimonoF daoKimonoF = new DaoKimonoF();

            ResultSet resultSet = daoKimonoF.listarPorMarca(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String idCategoria = resultSet.getString(3);
                String idTamanho = resultSet.getString(4);
                String idCor = resultSet.getString(5);
                String idMarca = resultSet.getString(6);
                String idCondicao = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, quantidade, idCategoria, idTamanho, idCor, idMarca, idCondicao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorEstado(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableKimonoF.getModel();
            
            tableKimonoF.setModel(defaultTableModel);

            DaoKimonoF daoKimonoF = new DaoKimonoF();

            ResultSet resultSet = daoKimonoF.listarPorEstado(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String idCategoria = resultSet.getString(3);
                String idTamanho = resultSet.getString(4);
                String idCor = resultSet.getString(5);
                String idMarca = resultSet.getString(6);
                String idCondicao = resultSet.getString(7);
                                
                defaultTableModel.addRow(new Object[]{id, quantidade, idCategoria, idTamanho, idCor, idMarca, idCondicao});
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
        tableKimonoF = new javax.swing.JTable();
        jcbBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "CATEGORIA", "TAMANHO", "COR", "MARCA", "CONDICAO" }));

        tableKimonoF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "QUANTIDADE", "CATEGORIA", "TAMANHO", "COR", "MARCA", "CONDICAO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKimonoF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKimonoFMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKimonoF);

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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
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
            .addGap(0, 572, Short.MAX_VALUE)
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

    private void tableKimonoFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKimonoFMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModKimonoF modKimonoF = new ModKimonoF();

                modKimonoF.setId(Integer.parseInt(String.valueOf(tableKimonoF.getValueAt(tableKimonoF.getSelectedRow(), 0))));
                                
                DaoKimonoF daoKimonoF = new DaoKimonoF();
                ResultSet resultSet = daoKimonoF.listarPorCategoria(String.valueOf(tableKimonoF.getValueAt(tableKimonoF.getSelectedRow(), 1)));
                int idCategoria = -1;
                resultSet.next ();
                idCategoria = resultSet.getInt("ID");
                modKimonoF.setIdCategoria(idCategoria);
                
                DaoTamanho daoTamanho = new DaoTamanho();
                resultSet = daoTamanho.listarPorNome(String.valueOf(tableKimonoF.getValueAt(tableKimonoF.getSelectedRow(), 2)));
                int idTamanho = -1;
                idTamanho = resultSet.getInt("ID");
                modKimonoF.setIdTamanho(idTamanho);
                
                DaoCor daoCor = new DaoCor();
                resultSet = daoCor.listarPorDescricao(String.valueOf(tableKimonoF.getValueAt(tableKimonoF.getSelectedRow(), 3)));
                int idCor = -1;
                idCor = resultSet.getInt("ID");
                modKimonoF.setIdCor(idCor);
                DadosTemporarios.tempObject3 = (ModKimonoF) modKimonoF;
                
                DaoMarca daoMarca = new DaoMarca();
                resultSet = daoMarca.listarPorNome(String.valueOf(tableKimonoF.getValueAt(tableKimonoF.getSelectedRow(), 5)));
                int idMarca = -1;
                idMarca = resultSet.getInt("ID");
                modKimonoF.setIdTamanho(idMarca);
                
                DaoCondicao daoCondicao = new DaoCondicao();
                resultSet = daoCondicao.listarPorEstado(String.valueOf(tableKimonoF.getValueAt(tableKimonoF.getSelectedRow(), 6)));
                int idCondicao = -1;
                idCondicao = resultSet.getInt("ID");
                modKimonoF.setIdTamanho(idCondicao);
                
                DadosTemporarios.tempObject = (ModKimonoF) modKimonoF;
                
                CadKimonoF cadKimonoF = new CadKimonoF();
                cadKimonoF.setVisible(true);

            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }

    }//GEN-LAST:event_tableKimonoFMouseClicked

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
            listarTodos();
            break;
            case 1:
            listarPorId();
            break;
            case 2:
            listarPorCategoria();
            break;
            case 3:
            listarPorTamanho();
            break;
            case 4:
            listarPorCor();
            break;
            case 5:
            listarPorMarca();
            break;
            case 6:
            listarPorEstado();
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
            java.util.logging.Logger.getLogger(ListKimonoF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListKimonoF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListKimonoF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListKimonoF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListKimonoF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jcbBuscar;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableKimonoF;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
