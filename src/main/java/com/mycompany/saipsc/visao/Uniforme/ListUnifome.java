/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saipsc.Visao.Uniforme;

import com.mycompany.saipsc.Dao.DaoCondicao;
import com.mycompany.saipsc.Dao.DaoCor;
import com.mycompany.saipsc.Dao.DaoUniforme;
import com.mycompany.saipsc.Dao.DaoMarca;
import com.mycompany.saipsc.Dao.DaoTamanho;
import com.mycompany.saipsc.Modelo.ModUniforme;
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import com.mycompany.saipsc.ferramentas.Formularios;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Batista
 */
public class ListUnifome extends javax.swing.JFrame {

    /**
     * Creates new form ListUniforme
     */
    public ListUnifome() {
        initComponents();
    
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableUniforme.getModel();
            
            tableUniforme.setModel(defaultTableModel);

            DaoUniforme daoUniforme = new DaoUniforme();

            ResultSet resultSet = daoUniforme.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String categoria = resultSet.getString(3);
                String tamanho = resultSet.getString(4);
                String cor =  resultSet.getString(5);
                String marca =  resultSet.getString(6);
                String condicao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, quantidade, categoria, tamanho, marca, cor, condicao});
            }
        }catch(Exception e){
            
        }
    }
        public void listarPorId(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableUniforme.getModel();
            
            tableUniforme.setModel(defaultTableModel);

            DaoUniforme daoUniforme = new DaoUniforme();

            ResultSet resultSet = daoUniforme.listarPorId(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String categoria = resultSet.getString(3);
                String tamanho = resultSet.getString(4);
                String cor =  resultSet.getString(5);
                String marca =  resultSet.getString(6);
                String condicao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, quantidade, categoria, tamanho, marca, cor, condicao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorCategoria(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableUniforme.getModel();
            
            tableUniforme.setModel(defaultTableModel);

            DaoUniforme daoUniforme = new DaoUniforme();

            ResultSet resultSet = daoUniforme.listarPorCategoria(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String categoria = resultSet.getString(3);
                String tamanho = resultSet.getString(4);
                String cor =  resultSet.getString(5);
                String marca =  resultSet.getString(6);
                String condicao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, quantidade, categoria, tamanho, marca, cor, condicao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorTamanho(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableUniforme.getModel();
            
            tableUniforme.setModel(defaultTableModel);

            DaoUniforme daoUniforme = new DaoUniforme();

            ResultSet resultSet = daoUniforme.listarPorTamanho(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String categoria = resultSet.getString(3);
                String tamanho = resultSet.getString(4);
                String cor =  resultSet.getString(5);
                String marca =  resultSet.getString(6);
                String condicao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, quantidade, categoria, tamanho, marca, cor, condicao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorCor(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableUniforme.getModel();
            
            tableUniforme.setModel(defaultTableModel);

            DaoUniforme daoUniforme = new DaoUniforme();

            ResultSet resultSet = daoUniforme.listarPorCor(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String categoria = resultSet.getString(3);
                String tamanho = resultSet.getString(4);
                String cor =  resultSet.getString(5);
                String marca =  resultSet.getString(6);
                String condicao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, quantidade, categoria, tamanho, marca, cor, condicao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorMarca(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableUniforme.getModel();
            
            tableUniforme.setModel(defaultTableModel);

            DaoUniforme daoUniforme = new DaoUniforme();

            ResultSet resultSet = daoUniforme.listarPorMarca(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String categoria = resultSet.getString(3);
                String tamanho = resultSet.getString(4);
                String cor =  resultSet.getString(5);
                String marca =  resultSet.getString(6);
                String condicao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, quantidade, categoria, tamanho, marca, cor, condicao});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorEstado(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableUniforme.getModel();
            
            tableUniforme.setModel(defaultTableModel);

            DaoUniforme daoUniforme = new DaoUniforme();

            ResultSet resultSet = daoUniforme.listarPorEstado(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String quantidade = resultSet.getString(2);
                String categoria = resultSet.getString(3);
                String tamanho = resultSet.getString(4);
                String cor =  resultSet.getString(5);
                String marca =  resultSet.getString(6);
                String condicao = resultSet.getString(7);
                
                defaultTableModel.addRow(new Object[]{id, quantidade, categoria, tamanho, marca, cor, condicao});
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
        tableUniforme = new javax.swing.JTable();
        jcbBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "CATEGORIA", "TAMANHO", "COR", "MARCA", "CONDICAO" }));

        tableUniforme.setModel(new javax.swing.table.DefaultTableModel(
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
        tableUniforme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUniformeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableUniforme);

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

    private void tableUniformeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUniformeMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModUniforme modUniforme = new ModUniforme();

                modUniforme.setId(Integer.parseInt(String.valueOf(tableUniforme.getValueAt(tableUniforme.getSelectedRow(), 0))));
                modUniforme.setQuantidade(String.valueOf(tableUniforme.getValueAt(tableUniforme.getSelectedRow(), 1)));
                                
                DaoUniforme daoUniforme = new DaoUniforme();
                ResultSet resultSet = daoUniforme.listarPorCategoria(String.valueOf(tableUniforme.getValueAt(tableUniforme.getSelectedRow(), 2)));
                int idCategoria = -1;
                idCategoria = resultSet.getInt("ID");
                modUniforme.setIdCategoria(idCategoria);
                
                DaoTamanho daoTamanho = new DaoTamanho();
                resultSet = daoTamanho.listarPorNome(String.valueOf(tableUniforme.getValueAt(tableUniforme.getSelectedRow(), 3)));
                int idTamanho = -1;
                idTamanho = resultSet.getInt("ID");
                modUniforme.setIdTamanho(idTamanho);
                
                DaoCor daoCor = new DaoCor();
                resultSet = daoCor.listarPorDescricao(String.valueOf(tableUniforme.getValueAt(tableUniforme.getSelectedRow(), 4)));
                int idCor = -1;
                idCor = resultSet.getInt("ID");
                modUniforme.setIdCor(idCor);
                                
                DaoMarca daoMarca = new DaoMarca();
                resultSet = daoMarca.listarPorNome(String.valueOf(tableUniforme.getValueAt(tableUniforme.getSelectedRow(), 5)));
                int idMarca = -1;
                idMarca = resultSet.getInt("ID");
                modUniforme.setIdTamanho(idMarca);
                
                DaoCondicao daoCondicao = new DaoCondicao();
                resultSet = daoCondicao.listarPorEstado(String.valueOf(tableUniforme.getValueAt(tableUniforme.getSelectedRow(), 6)));
                int idCondicao = -1;
                idCondicao = resultSet.getInt("ID");
                modUniforme.setIdTamanho(idCondicao);
                
                DadosTemporarios.tempObject = (ModUniforme) modUniforme;
                
                
                CadUniforme cadUniforme = new CadUniforme();
                cadUniforme.setVisible(true);

            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }

    }//GEN-LAST:event_tableUniformeMouseClicked

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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.listAluno = null;
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
            java.util.logging.Logger.getLogger(ListUnifome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListUnifome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListUnifome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListUnifome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListUnifome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jcbBuscar;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableUniforme;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
