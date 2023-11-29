/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saipsc.Visao.Uniforme;

import com.mycompany.saipsc.Dao.DaoCategoriaU;
import com.mycompany.saipsc.Dao.DaoCondicao;
import com.mycompany.saipsc.Dao.DaoCor;
import com.mycompany.saipsc.Dao.DaoUniforme;
import com.mycompany.saipsc.Dao.DaoMarca;
import com.mycompany.saipsc.Dao.DaoTamanho;
import com.mycompany.saipsc.Modelo.ModUniforme;
import com.mycompany.saipsc.ferramentas.Constantes;
import com.mycompany.saipsc.ferramentas.DadosTemporarios;
import com.mycompany.saipsc.ferramentas.Formularios;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Batista
 */
public class CadUniforme extends javax.swing.JFrame {

    /**
     * Creates new form CadKimonoF
     */
    public CadUniforme() {
        initComponents();
        
        carregarCategorias();
        carregarTamanhos();
        carregarCores();
        carregarMarcas();
        carregarCondicoes();
        
        if(!existeDadosTemporarios()){
            DaoUniforme daoKimonoF = new DaoUniforme();
            DaoCategoriaU daoCategoriaKF = new DaoCategoriaU();
            DaoTamanho daoTamanho = new DaoTamanho();
            DaoCor daoCor = new DaoCor();
            DaoMarca daoMarca = new DaoMarca();
            DaoCondicao daoCondicao = new DaoCondicao();
                         
            int id = daoKimonoF.buscarProximoId();
            if (id>0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir1.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir1.setVisible(true);  
        }
        recuperaIdCategoria();
        recuperaIdTamanho();
        recuperaIdCor();
        recuperaIdMarca();
        recuperaIdCondicao();

        setLocationRelativeTo(null);
        
        tfId.setEnabled(false);
        
    }
    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModUniforme){
            int id = ((ModUniforme) DadosTemporarios.tempObject).getId();
            String quantidade = ((ModUniforme) DadosTemporarios.tempObject).getQuantidade();
            int idCategoria = ((ModUniforme) DadosTemporarios.tempObject).getIdCategoria();
            int idTamanho = ((ModUniforme) DadosTemporarios.tempObject).getIdTamanho();
            int idCor = ((ModUniforme) DadosTemporarios.tempObject).getIdCor();
            int idMarca = ((ModUniforme) DadosTemporarios.tempObject).getIdMarca();
            int idCondicao = ((ModUniforme) DadosTemporarios.tempObject).getIdCondicao();
                        
            tfId.setText(String.valueOf(id));
            tfQuantidade.setText(quantidade);
            tfCategoria.setText(String.valueOf(idCategoria));
            tfTamanho.setText(String.valueOf(idTamanho));
            tfCor.setText(String.valueOf(idCor));
            tfMarca.setText(String.valueOf(idMarca));
            tfCondicao.setText(String.valueOf(idCondicao));
            
            try{
                DaoCategoriaU daoCategoriaKF = new DaoCategoriaU();
                ResultSet resultSet = daoCategoriaKF.listarPorId(idCategoria);
                resultSet.next();
                String nome = resultSet.getString("NOME");
                int index = 0;
                for(int i =0; i<jcbCategoria.getItemCount(); i++){
                    if(jcbCategoria.getItemAt(i).equals(nome)){
                        index = i;
                        break;
                    }
                }
                jcbCategoria.setSelectedIndex(index);
            }catch (Exception e){}
            
            try{
                DaoTamanho daoTamanho = new DaoTamanho();
                ResultSet resultSet = daoTamanho.listarPorId(idTamanho);
                resultSet.next();
                String tamanho = resultSet.getString("TAMANHO");
                int index = 0;
                for(int i =0; i<jcbTamanho.getItemCount(); i++){
                    if(jcbTamanho.getItemAt(i).equals(tamanho)){
                        index = i;
                        break;
                    }
                }
                jcbTamanho.setSelectedIndex(index);
            }catch (Exception e){}
            
            try{
                DaoCor daoCor = new DaoCor();
                ResultSet resultSet = daoCor.listarPorId(idCor);
                resultSet.next();
                String descricao = resultSet.getString("DESCRICAO");
                int index = 0;
                for(int i =0; i<jcbCor.getItemCount(); i++){
                    if(jcbCor.getItemAt(i).equals(descricao)){
                        index = i;
                        break;
                    }
                }
                jcbCor.setSelectedIndex(index);
            }catch (Exception e){}
            
            try{
                DaoMarca daoMarca = new DaoMarca();
                ResultSet resultSet = daoMarca.listarPorId(idMarca);
                resultSet.next();
                String nome = resultSet.getString("NOME");
                int index = 0;
                for(int i =0; i<jcbMarca.getItemCount(); i++){
                    if(jcbMarca.getItemAt(i).equals(nome)){
                        index = i;
                        break;
                    }
                }
                jcbMarca.setSelectedIndex(index);
            }catch (Exception e){}
                
            try{
                DaoCondicao daoCondicao = new DaoCondicao();
                ResultSet resultSet = daoCondicao.listarPorId(idCondicao);
                resultSet.next();
                String estado = resultSet.getString("ESTADO");
                int index = 0;
                for(int i =0; i<jcbCondicao.getItemCount(); i++){
                    if(jcbCondicao.getItemAt(i).equals(estado)){
                        index = i;
                        break;
                    }
                }
                jcbCondicao.setSelectedIndex(index);
            }catch (Exception e){}
                
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;        
    }
    private void inserir(){
        DaoUniforme daoKimonoF = new DaoUniforme();
        
        if (daoKimonoF.inserir(Integer.parseInt(tfId.getText()), tfQuantidade.getText(), Integer.parseInt(tfCategoria.getText()), Integer.parseInt(tfTamanho.getText()), Integer.parseInt(tfCor.getText()),Integer.parseInt(tfMarca.getText()), Integer.parseInt(tfCondicao.getText()))){
            JOptionPane.showMessageDialog(null, "Uniforme salvo com sucesso!");
            
            tfId.setText(String.valueOf(daoKimonoF.buscarProximoId()));
            tfQuantidade.setText("");
            tfCategoria.setText("");
            tfTamanho.setText("");
            tfCor.setText("");
            tfMarca.setText("");
            tfCondicao.setText("");
                        
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o uniforme!");
        }
    }
    private void alterar(){
        DaoUniforme daoKimonoF = new DaoUniforme();
        
        if (daoKimonoF.alterar(Integer.parseInt(tfId.getText()), tfQuantidade.getText(), Integer.parseInt(tfCategoria.getText()), Integer.parseInt(tfTamanho.getText()), Integer.parseInt(tfCor.getText()),Integer.parseInt(tfMarca.getText()), Integer.parseInt(tfCondicao.getText()))){
            JOptionPane.showMessageDialog(null, "Uniforme salvo com sucesso!");
            
            tfId.setText("");
            tfQuantidade.setText("");
            tfCategoria.setText("");
            tfTamanho.setText("");
            tfCor.setText("");
            tfMarca.setText("");
            tfCondicao.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o Uniforme!");
        }
        
        ((ListUnifome) Formularios.listKimonoF).listarTodos();
        
        dispose();
    }
    private void excluir(){
        DaoUniforme daoKimonoF = new DaoUniforme();
        
        if (daoKimonoF.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, tfCategoria.getText() + " excluído com sucesso!");
            
            tfId.setText("");
            tfCategoria.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir " + tfCategoria + "!" );
        }
        
        ((ListUnifome) Formularios.listKimonoF).listarTodos();
        
        dispose();
    }
    public void carregarCategorias(){
        try{
            DaoCategoriaU daoCategoriaKF = new DaoCategoriaU();

            ResultSet resultSet = daoCategoriaKF.listarTodos();

            while(resultSet.next())
                jcbCategoria.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    private void recuperaIdCategoria(){
        try{
            DaoCategoriaU daoCategoriaKF = new DaoCategoriaU();
            ResultSet resultSet = daoCategoriaKF.listarPorNome(jcbCategoria.getSelectedItem().toString());
            
            resultSet.next();
            tfCategoria.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void carregarTamanhos(){
        try{
            DaoTamanho daoTamanho = new DaoTamanho();

            ResultSet resultSet = daoTamanho.listarTodos();

            while(resultSet.next())
                jcbTamanho.addItem(resultSet.getString("TAM"));
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    private void recuperaIdTamanho(){
        try{
            DaoTamanho daoTamanho = new DaoTamanho();
            ResultSet resultSet = daoTamanho.listarPorNome(jcbTamanho.getSelectedItem().toString());
            
            resultSet.next();
            tfTamanho.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
public void carregarCores(){
        try{
            DaoCor daoCor = new DaoCor();

            ResultSet resultSet = daoCor.listarTodos();

            while(resultSet.next())
                jcbCor.addItem(resultSet.getString("DESCRICAO"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    private void recuperaIdCor(){
        try{
            DaoCor daoCor = new DaoCor();
            ResultSet resultSet = daoCor.listarPorDescricao(jcbCor.getSelectedItem().toString());
            
            resultSet.next();
            tfCor.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }    
public void carregarMarcas(){
        try{
            DaoMarca daoMarca = new DaoMarca();

            ResultSet resultSet = daoMarca.listarTodos();

            while(resultSet.next())
                jcbMarca.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    private void recuperaIdMarca(){
        try{
            DaoMarca daoMarca = new DaoMarca();
            ResultSet resultSet = daoMarca.listarPorNome(jcbMarca.getSelectedItem().toString());
            
            resultSet.next();
            tfMarca.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void carregarCondicoes(){
        try{
            DaoCondicao daoCondicao = new DaoCondicao();

            ResultSet resultSet = daoCondicao.listarTodos();

            while(resultSet.next())
                jcbCondicao.addItem(resultSet.getString("ESTADO"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    private void recuperaIdCondicao(){
        try{
            DaoCondicao daoCondicao = new DaoCondicao();
            ResultSet resultSet = daoCondicao.listarPorEstado(jcbCondicao.getSelectedItem().toString());
            
            resultSet.next();
            tfCondicao.setText(resultSet.getString("ID"));
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
        tfId = new javax.swing.JTextField();
        jcbCategoria = new javax.swing.JComboBox<>();
        jcbCor = new javax.swing.JComboBox<>();
        jcbMarca = new javax.swing.JComboBox<>();
        jcbCondicao = new javax.swing.JComboBox<>();
        btnAcao = new javax.swing.JButton();
        tfQuantidade = new javax.swing.JTextField();
        tfCategoria = new javax.swing.JTextField();
        tfTamanho = new javax.swing.JTextField();
        tfCor = new javax.swing.JTextField();
        tfMarca = new javax.swing.JTextField();
        tfCondicao = new javax.swing.JTextField();
        btnExcluir1 = new javax.swing.JButton();
        jcbTamanho = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("QUANTIDADE");

        jLabel3.setText("CATEGORIA");

        jLabel4.setText("TAMANHO");

        jLabel5.setText("COR");

        jLabel6.setText("MARCA");

        jLabel7.setText("CONDICAO");

        jcbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCategoriaItemStateChanged(evt);
            }
        });
        jcbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCategoriaActionPerformed(evt);
            }
        });

        jcbCor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCorItemStateChanged(evt);
            }
        });

        jcbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMarcaItemStateChanged(evt);
            }
        });

        jcbCondicao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCondicaoItemStateChanged(evt);
            }
        });

        btnAcao.setText("SALVAR");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir1.setText("EXCLUIR");
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir1ActionPerformed(evt);
            }
        });

        jcbTamanho.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTamanhoItemStateChanged(evt);
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
                        .addComponent(btnAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(22, 22, 22)
                                .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbCondicao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbTamanho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbCor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(tfCor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTamanho, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCategoria, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCondicao))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcbCondicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCondicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCategoriaActionPerformed

    private void jcbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCategoriaItemStateChanged
        recuperaIdCategoria();
    }//GEN-LAST:event_jcbCategoriaItemStateChanged

    private void jcbCorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCorItemStateChanged
        recuperaIdCor();
    }//GEN-LAST:event_jcbCorItemStateChanged

    private void jcbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMarcaItemStateChanged
        recuperaIdMarca();
    }//GEN-LAST:event_jcbMarcaItemStateChanged

    private void jcbCondicaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCondicaoItemStateChanged
        recuperaIdCondicao();
    }//GEN-LAST:event_jcbCondicaoItemStateChanged

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            if(Formularios.cadKimonoF != null){
             
                dispose();
            }
        }else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT)
            alterar();
    }                                       

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadKimonoF = null;
        
        if(Formularios.cadKimonoF != null){
        
        }
    }//GEN-LAST:event_formWindowClosed

    private void btnExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir1ActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o/a " + tfCategoria.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();
    }//GEN-LAST:event_btnExcluir1ActionPerformed

    private void jcbTamanhoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTamanhoItemStateChanged
        recuperaIdTamanho();
    }//GEN-LAST:event_jcbTamanhoItemStateChanged

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
            java.util.logging.Logger.getLogger(CadUniforme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadUniforme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadUniforme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadUniforme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadUniforme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> jcbCategoria;
    private javax.swing.JComboBox<String> jcbCondicao;
    private javax.swing.JComboBox<String> jcbCor;
    private javax.swing.JComboBox<String> jcbMarca;
    private javax.swing.JComboBox<String> jcbTamanho;
    private javax.swing.JTextField tfCategoria;
    private javax.swing.JTextField tfCondicao;
    private javax.swing.JTextField tfCor;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfTamanho;
    // End of variables declaration//GEN-END:variables
}
