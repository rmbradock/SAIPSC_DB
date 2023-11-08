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
import java.sql.ResultSet;

/**
 *
 * @author batista.4995
 */
public class DaoPolos extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, String nome, String endereco, String responsavel, String contato){
        try{
            sql = "INSERT INTO POLOS (ID, NOME, ENDERECO, RESPONSAVEL, CONTATO) VALUES (?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, nome);
            getStatement().setString(3, endereco);
            getStatement().setString(4, responsavel);
            getStatement().setString(5, contato);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar(int id, String nome, String endereco, String responsavel, String contato){
        try{
            sql = "UPDATE POLOS SET NOME = ?, ENDERECO = ?, RESPONSAVEL = ?,  =?, CONTATO =? = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(5, id);
            getStatement().setString(1, nome);
            getStatement().setString(2, endereco);
            getStatement().setString(3, responsavel);
            getStatement().setString(4, contato);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM POLOS WHERE ID = ?";
            
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
            sql = "SELECT ID, NOME, ENDERECO, RESPONSAVEL, CONTATO, OBS FROM POLOS";
                
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT ID, NOME, ENDERECO, RESPONSAVEL, CONTATO, OBS FROM POLOS WHERE ID = ?";
            
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
            sql = "SELECT ID, NOME, ENDERECO, RESPONSAVEL, CONTATO, OBS FROM POLOS WHERE NOME = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    public int buscarProximoId(){
           int id = -1;

           try{
               sql = "SELECT MAX(ID) + 1 FROM POLOS";

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
