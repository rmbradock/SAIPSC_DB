/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Dao;

import com.mycompany.saipsc.ferramentas.BancoDeDadosMySql;
import static com.mycompany.saipsc.ferramentas.BancoDeDadosMySql.getConexao;
import static com.mycompany.saipsc.ferramentas.BancoDeDadosMySql.getResultado;
import static com.mycompany.saipsc.ferramentas.BancoDeDadosMySql.getStatement;
import static com.mycompany.saipsc.ferramentas.BancoDeDadosMySql.setResultado;
import static com.mycompany.saipsc.ferramentas.BancoDeDadosMySql.setStatement;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author batista.4995
 */
public class DaoPessoa extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, String nome, String rg, String cpf, String endereco, String contato, String obs){
        try{
            sql = "INSERT INTO PESSOA (ID, NOME, RG, CPF, ENDERECO, CONTATO, OBS) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, nome);
            getStatement().setString(3, rg);
            getStatement().setString(4, cpf);
            getStatement().setString(5, endereco);
            getStatement().setString(6, contato);
            getStatement().setString(7, obs);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar(int id, String nome, String rg, String cpf, String endereco, String contato, String obs){
        try{
            sql = "UPDATE PESSOA SET NOME = ?, RG = ?, CPF = ?, ENDERECO =?, CONTATO =?, OBS =? = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(7, id);
            getStatement().setString(1, nome);
            getStatement().setString(2, rg);
            getStatement().setString(3, cpf);
            getStatement().setString(4, endereco);
            getStatement().setString(5, contato);
            getStatement().setString(6, obs);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM PESSOA WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public ResultSet listarTodos(){
        try{
            sql = "SELECT ID, NOME, RG, CPF, ENDERECO, CONTATO, OBS FROM PESSOA";
                
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT ID, NOME, RG, CPF, ENDERECO, CONTATO, OBS FROM PESSOA WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    public ResultSet listarPorNome(String nome){
        try{
            sql = "SELECT ID, NOME, RG, CPF, ENDERECO, CONTATO, OBS FROM PESSOA WHERE NOME = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    public ResultSet listarPorRg(String rg){
        try{
            sql = "SELECT ID, NOME, RG, CPF, ENDERECO, CONTATO, OBS FROM PESSOA WHERE RG = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, rg + "%");
            
            setResultado(getStatement().executeQuery());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    public ResultSet listarPorCpf(String cpf){
        try{
            sql = "SELECT ID, NOME, RG, CPF, ENDERECO, CONTATO, OBS FROM PESSOA WHERE CPF = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cpf + "%");
            
            setResultado(getStatement().executeQuery());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    public int buscarProximoId(){
           int id = -1;

           try{
               sql = "SELECT MAX(ID) + 1 FROM PESSOA";

               setStatement(getConexao().prepareStatement(sql));

               setResultado(getStatement().executeQuery());

               getResultado().next(); 

               id = getResultado().getInt(1); 
           }catch(Exception e){
               System.out.println(e.getMessage());
        }
        return id;
    }
}
