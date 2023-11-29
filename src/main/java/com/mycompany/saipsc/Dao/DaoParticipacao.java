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
public class DaoParticipacao extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, int idAluno, int idCampeonato, String resultado){
        try{
            sql = "INSERT INTO PARTICIPACAO (ID, ID_ALUNO, ID_CAMPEONATO, RESULTADO) VALUES (?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idAluno);
            getStatement().setInt(3, idCampeonato);
            getStatement().setString(4, resultado);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar(int id, int idAluno, int idCampeonato, String resultado){
        try{
            sql = "UPDATE PARTICIPACAO SET ID_ALUNO = ?, ID_CAMPEONATO = ?, RESULTADO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(4, id);
            getStatement().setInt(1, idAluno);
            getStatement().setInt(2, idCampeonato);
            getStatement().setString(3, resultado);
                        
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM PARTICIPACAO WHERE ID = ?";
            
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
            sql =
                " SELECT                    " +
                "   PA.ID AS ID,                        " +
                "   P.NOME AS COMPETIDOR,        " +
                "   C.NOME AS COMPETICAO,               " +
                "   PA.RESULTADO AS RESULTADO          " +
                " FROM                                  " +
                "   PARTICIPACAO PA                     " +
                " JOIN ALUNO AL ON                      " +
                "   AL.ID = PA.ID_ALUNO                 " +
                " JOIN CAMPEONATO C ON                  " +
                "   C.ID = PA.ID_CAMPEONATO             " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA             ";    
               
                            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorId(int id){
        try{
            sql = 
                " SELECT                    " +
                "   PA.ID AS ID,                        " +
                "   P.NOME AS COMPETIDOR,        " +
                "   C.NOME AS COMPETICAO,               " +
                "   PA.RESULTADO AS RESULTADO          " +
                " FROM                                  " +
                "   PARTICIPACAO PA                     " +
                " JOIN ALUNO AL ON                      " +
                "   AL.ID = PA.ID_ALUNO                 " +
                " JOIN CAMPEONATO C ON                  " +
                "   C.ID = PA.ID_CAMPEONATO             " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA             " +
                " WHERE P.ID = ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorNome(String nome){
        try{
            sql = 
                " SELECT                    " +
                "   PA.ID AS ID,                        " +
                "   P.NOME AS COMPETIDOR,        " +
                "   C.NOME AS COMPETICAO,               " +
                "   PA.RESULTADO AS RESULTADO          " +
                " FROM                                  " +
                "   PARTICIPACAO PA                     " +
                " JOIN ALUNO AL ON                      " +
                "   AL.ID = PA.ID_ALUNO                 " +
                " JOIN CAMPEONATO C ON                  " +
                "   C.ID = PA.ID_CAMPEONATO             " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA             " +
                " WHERE P.NOME LIKE ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorCompeticao(String competicao){
        try{
            sql = 
                " SELECT                    " +
                "   PA.ID AS ID,                        " +
                "   P.NOME AS COMPETIDOR,        " +
                "   C.NOME AS COMPETICAO,               " +
                "   PA.RESULTADO AS RESULTADO          " +
                " FROM                                  " +
                "   PARTICIPACAO PA                     " +
                " JOIN ALUNO AL ON                      " +
                "   AL.ID = PA.ID_ALUNO                 " +
                " JOIN CAMPEONATO C ON                  " +
                "   C.ID = PA.ID_CAMPEONATO             " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA             " +
                " WHERE C.NOME LIKE ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, competicao + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
        public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM PARTICIPACAO";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
}


