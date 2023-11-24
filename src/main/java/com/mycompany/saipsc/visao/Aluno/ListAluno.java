/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saipsc.Visao.Aluno;

import com.mycompany.saipsc.Dao.DaoAcesso;
import com.mycompany.saipsc.Dao.DaoAluno;
import com.mycompany.saipsc.Dao.DaoCor;
import com.mycompany.saipsc.Dao.DaoPessoa;
import com.mycompany.saipsc.Dao.DaoPolos;
import com.mycompany.saipsc.Modelo.ModAluno;
import com.mycompany.saipsc.Modelo.ModCor;
import com.mycompany.saipsc.Modelo.ModPessoa;
import com.mycompany.saipsc.Modelo.ModPolos;
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import com.mycompany.saipsc.ferramentas.Formularios;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author batista.4995
 */
public class ListAluno extends javax.swing.JFrame {

    /**
     * Creates new form ListAluno
     */
    public ListAluno() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableAluno.getModel();
            
            tableAluno.setModel(defaultTableModel);

            DaoAluno daoAluno = new DaoAluno();

            ResultSet resultSet = daoAluno.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String faixa = resultSet.getString(3);
                String nascimento = resultSet.getString(4);
                String idade = resultSet.getString(5);
                String resp = resultSet.getString(6);
                String uGrad = resultSet.getString(7);
                String pGrad = resultSet.getString(8);
                String faltas = resultSet.getString(9);
                String polo = resultSet.getString(10);
                String cpfResp = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, nome, faixa, nascimento, idade, resp, uGrad, pGrad, faltas, polo, cpfResp});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorId(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableAluno.getModel();
            
            tableAluno.setModel(defaultTableModel);

            DaoAluno daoAluno = new DaoAluno();

            ResultSet resultSet = daoAluno.listarPorId(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String faixa = resultSet.getString(3);
                String nascimento = resultSet.getString(4);
                String idade = resultSet.getString(5);
                String resp = resultSet.getString(6);
                String uGrad = resultSet.getString(7);
                String pGrad = resultSet.getString(8);
                String faltas = resultSet.getString(9);
                String polo = resultSet.getString(10);
                String cpfResp = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, nome, faixa, nascimento, idade, resp, uGrad, pGrad, faltas, polo, cpfResp});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorNome(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableAluno.getModel();
            
            tableAluno.setModel(defaultTableModel);

            DaoAluno daoAluno = new DaoAluno();

            ResultSet resultSet = daoAluno.listarPorNome(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String faixa = resultSet.getString(3);
                String nascimento = resultSet.getString(4);
                String idade = resultSet.getString(5);
                String resp = resultSet.getString(6);
                String uGrad = resultSet.getString(7);
                String pGrad = resultSet.getString(8);
                String faltas = resultSet.getString(9);
                String polo = resultSet.getString(10);
                String cpfResp = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, nome, faixa, nascimento, idade, resp, uGrad, pGrad, faltas, polo, cpfResp});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorFaixa(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableAluno.getModel();
            
            tableAluno.setModel(defaultTableModel);

            DaoAluno daoAluno = new DaoAluno();

            ResultSet resultSet = daoAluno.listarPorFaixa(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String faixa = resultSet.getString(3);
                String nascimento = resultSet.getString(4);
                String idade = resultSet.getString(5);
                String resp = resultSet.getString(6);
                String uGrad = resultSet.getString(7);
                String pGrad = resultSet.getString(8);
                String faltas = resultSet.getString(9);
                String polo = resultSet.getString(10);
                String cpfResp = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, nome, faixa, nascimento, idade, resp, uGrad, pGrad, faltas, polo, cpfResp});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorNascimento(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableAluno.getModel();
            
            tableAluno.setModel(defaultTableModel);

            DaoAluno daoAluno = new DaoAluno();

            ResultSet resultSet = daoAluno.listarPorNascimento(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String faixa = resultSet.getString(3);
                String nascimento = resultSet.getString(4);
                String idade = resultSet.getString(5);
                String resp = resultSet.getString(6);
                String uGrad = resultSet.getString(7);
                String pGrad = resultSet.getString(8);
                String faltas = resultSet.getString(9);
                String polo = resultSet.getString(10);
                String cpfResp = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, nome, faixa, nascimento, idade, resp, uGrad, pGrad, faltas, polo, cpfResp});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorIdade(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableAluno.getModel();
            
            tableAluno.setModel(defaultTableModel);

            DaoAluno daoAluno = new DaoAluno();

            ResultSet resultSet = daoAluno.listarPorIdade(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String faixa = resultSet.getString(3);
                String nascimento = resultSet.getString(4);
                String idade = resultSet.getString(5);
                String resp = resultSet.getString(6);
                String uGrad = resultSet.getString(7);
                String pGrad = resultSet.getString(8);
                String faltas = resultSet.getString(9);
                String polo = resultSet.getString(10);
                String cpfResp = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, nome, faixa, nascimento, idade, resp, uGrad, pGrad, faltas, polo, cpfResp});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorUGrad(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableAluno.getModel();
            
            tableAluno.setModel(defaultTableModel);

            DaoAluno daoAluno = new DaoAluno();

            ResultSet resultSet = daoAluno.listarPorUGrad(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String faixa = resultSet.getString(3);
                String nascimento = resultSet.getString(4);
                String idade = resultSet.getString(5);
                String resp = resultSet.getString(6);
                String uGrad = resultSet.getString(7);
                String pGrad = resultSet.getString(8);
                String faltas = resultSet.getString(9);
                String polo = resultSet.getString(10);
                String cpfResp = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, nome, faixa, nascimento, idade, resp, uGrad, pGrad, faltas, polo, cpfResp});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorPGrad(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableAluno.getModel();
            
            tableAluno.setModel(defaultTableModel);

            DaoAluno daoAluno = new DaoAluno();

            ResultSet resultSet = daoAluno.listarPorPGrad(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String faixa = resultSet.getString(3);
                String nascimento = resultSet.getString(4);
                String idade = resultSet.getString(5);
                String resp = resultSet.getString(6);
                String uGrad = resultSet.getString(7);
                String pGrad = resultSet.getString(8);
                String faltas = resultSet.getString(9);
                String polo = resultSet.getString(10);
                String cpfResp = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, nome, faixa, nascimento, idade, resp, uGrad, pGrad, faltas, polo, cpfResp});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorFaltas(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableAluno.getModel();
            
            tableAluno.setModel(defaultTableModel);

            DaoAluno daoAluno = new DaoAluno();

            ResultSet resultSet = daoAluno.listarPorFaltas(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String faixa = resultSet.getString(3);
                String nascimento = resultSet.getString(4);
                String idade = resultSet.getString(5);
                String resp = resultSet.getString(6);
                String uGrad = resultSet.getString(7);
                String pGrad = resultSet.getString(8);
                String faltas = resultSet.getString(9);
                String polo = resultSet.getString(10);
                String cpfResp = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, nome, faixa, nascimento, idade, resp, uGrad, pGrad, faltas, polo, cpfResp});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorPolo(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableAluno.getModel();
            
            tableAluno.setModel(defaultTableModel);

            DaoAluno daoAluno = new DaoAluno();

            ResultSet resultSet = daoAluno.listarPorPolo(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String faixa = resultSet.getString(3);
                String nascimento = resultSet.getString(4);
                String idade = resultSet.getString(5);
                String resp = resultSet.getString(6);
                String uGrad = resultSet.getString(7);
                String pGrad = resultSet.getString(8);
                String faltas = resultSet.getString(9);
                String polo = resultSet.getString(10);
                String cpfResp = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, nome, faixa, nascimento, idade, resp, uGrad, pGrad, faltas, polo, cpfResp});
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
        tableAluno = new javax.swing.JTable();
        jcbBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "NOME", "FAIXA", "NASCIMENTO", "IDADE", "ULTIMA GRADUAÇÃO", "PROXIMA GRADUAÇÃO", "FALTAS", "POLO", " ", " ", " " }));

        tableAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "FAIXA", "DATA DE NASCIMENTO", "IDADE", "RESPONSAVEL", "ULTIMA GRADUACAO", "PROX GRAD", "FALTAS", "POLO", "CPF RESP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAlunoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAluno);

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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
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
            .addGap(0, 854, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                listarPorFaixa();
                break;
            case 4:
                listarPorNascimento();
                break;
            case 5:
                listarPorIdade();
                break;
            case 6:
                listarPorUGrad();
                break;
            case 7:
                listarPorPGrad();
                break;
            case 8:
                listarPorFaltas();
                break;
            case 9:
                listarPorPolo();
                break;
            
        }
    }//GEN-LAST:event_jcbBuscarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.listAluno = null;
    }//GEN-LAST:event_formWindowClosed

    private void tableAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAlunoMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModAluno modAluno = new ModAluno();
                
                modAluno.setId(Integer.parseInt(String.valueOf(tableAluno.getValueAt(tableAluno.getSelectedRow(), 0))));
                modAluno.setIdade(String.valueOf(tableAluno.getValueAt(tableAluno.getSelectedRow(), 4)));
                modAluno.setResponsavel(String.valueOf(tableAluno.getValueAt(tableAluno.getSelectedRow(), 5)));
                modAluno.setFaltas(String.valueOf(tableAluno.getValueAt(tableAluno.getSelectedRow(), 8)));
                modAluno.setCpfResp(String.valueOf(tableAluno.getValueAt(tableAluno.getSelectedRow(), 10)));
                modAluno.setNascimento(String.valueOf(tableAluno.getValueAt(tableAluno.getSelectedRow(), 3)));
                modAluno.setUGrad(String.valueOf(tableAluno.getValueAt(tableAluno.getSelectedRow(), 6)));
                modAluno.setPGrad(String.valueOf(tableAluno.getValueAt(tableAluno.getSelectedRow(), 7)));
                        
                DaoAluno daoAluno = new DaoAluno();
                ResultSet resultSet = daoAluno.listarPorNome(String.valueOf(tableAluno.getValueAt(tableAluno.getSelectedRow(), 1)));
                int idPessoa = -1;
                while (resultSet.next ())
                    idPessoa = resultSet.getInt("ID");
                    modAluno.setIdPessoa(idPessoa);
                    DadosTemporarios.tempObject = (ModAluno) modAluno;

                String faixa = resultSet.getString(2);
                DaoCor daoCor = new DaoCor();
                resultSet = daoCor.listarPorDescricao(String.valueOf(tableAluno.getValueAt(tableAluno.getSelectedRow(), 2)));
                int idCor = -1;
                while (resultSet.next ())
                    idCor = resultSet.getInt("ID");
                    modAluno.setIdCor(idCor);
                    DadosTemporarios.tempObject2 = (ModAluno) modAluno;

                String polo = resultSet.getString(9);
                DaoPolos daoPolos = new DaoPolos();
                resultSet = daoPolos.listarPorNome(String.valueOf(tableAluno.getValueAt(tableAluno.getSelectedRow(), 9)));
                int idPolo = -1;
                while (resultSet.next ())
                    idPolo = resultSet.getInt("ID");
                    modAluno.setIdPolo(idPolo);
                    DadosTemporarios.tempObject3 = (ModAluno) modAluno;
                
                CadAluno cadAluno = new CadAluno();
                cadAluno.setVisible(true);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
                                            

    }//GEN-LAST:event_tableAlunoMouseClicked

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
            java.util.logging.Logger.getLogger(ListAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jcbBuscar;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableAluno;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables

}