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
public class DaoEquipe extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, int idPessoa, int idCargo, int idCor, Date graduacao, String salario, int idAcesso){
        try{
            sql = "INSERT INTO EQUIPE (ID, ID_PESSOA, ID_CARGO, ID_COR, GRADUACAO, SALARIO, ID_ACESSO) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idPessoa);
            getStatement().setInt(3, idCargo);
            getStatement().setInt(4, idCor);
            getStatement().setDate(5, graduacao);
            getStatement().setString(6, salario);
            getStatement().setInt(7, idAcesso);
                        
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar(int id, int idPessoa, int idCargo, int idCor, Date graduacao, String salario, int idAcesso){
        try{
            sql = "UPDATE EQUIPE SET ID_PESSOA = ?, ID_CARGO = ?, ID_COR = ?, GRADUACAO = ?, SALARIO = ?, ACESSO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(8, id);
            getStatement().setInt(1, idPessoa);
            getStatement().setInt(2, idCargo);
            getStatement().setInt(3, idCor);
            getStatement().setDate(4, graduacao);
            getStatement().setString(5, salario);
            getStatement().setInt(6, idAcesso);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM EQUIPE WHERE ID = ?";
            
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
                "   EQ.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.NOME AS CARGO,                    " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   EQ.GRADUACAO AS ULTIMA_GRADUACAO,   " +
                "   EQ.SALARIO AS SALARIO,              " +
                "   AC.NOME AS ACESSO,                  " +
                " FROM                                  " +
                "   EQUIPE EQ                           " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = EQ.ID_PESSOA                 " +
                " JOIN CARGO CG ON                      " +
                "   CG.ID = EQ.ID_CARGO                 " +    
                " JOIN COR C ON                         " +
                "   C.ID = EQ.ID_COR                    " +
                " JOIN ACESSO AC ON                     " +
                "   AC.ID = EQ.ID_ACESSO                " ;
            
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
                "   EQ.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.NOME AS CARGO,                    " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   EQ.GRADUACAO AS ULTIMA_GRADUACAO,   " +
                "   EQ.SALARIO AS SALARIO,              " +
                "   AC.NOME AS ACESSO,                  " +
                " FROM                                  " +
                "   EQUIPE EQ                           " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = EQ.ID_PESSOA                 " +
                " JOIN CARGO CG ON                      " +
                "   CG.ID = EQ.ID_CARGO                 " +    
                " JOIN COR C ON                         " +
                "   C.ID = EQ.ID_COR                    " +
                " JOIN ACESSO AC ON                     " +
                "   AC.ID = EQ.ID_ACESSO                " +
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
                "   EQ.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.NOME AS CARGO,                    " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   EQ.GRADUACAO AS ULTIMA_GRADUACAO,   " +
                "   EQ.SALARIO AS SALARIO,              " +
                "   AC.NOME AS ACESSO,                  " +
                " FROM                                  " +
                "   EQUIPE EQ                           " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = EQ.ID_PESSOA                 " +
                " JOIN CARGO CG ON                      " +
                "   CG.ID = EQ.ID_CARGO                 " +    
                " JOIN COR C ON                         " +
                "   C.ID = EQ.ID_COR                    " +
                " JOIN ACESSO AC ON                     " +
                "   AC.ID = EQ.ID_ACESSO                " +
                " WHERE P.NOME LIKE = ?                 " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorCargo(String cargo){
        try{
            sql =
                "   EQ.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.NOME AS CARGO,                    " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   EQ.GRADUACAO AS ULTIMA_GRADUACAO,   " +
                "   EQ.SALARIO AS SALARIO,              " +
                "   AC.NOME AS ACESSO,                  " +
                " FROM                                  " +
                "   EQUIPE EQ                           " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = EQ.ID_PESSOA                 " +
                " JOIN CARGO CG ON                      " +
                "   CG.ID = EQ.ID_CARGO                 " +    
                " JOIN COR C ON                         " +
                "   C.ID = EQ.ID_COR                    " +
                " JOIN ACESSO AC ON                     " +
                "   AC.ID = EQ.ID_ACESSO                " +
                " WHERE CG.NOME LIKE = ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cargo + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorFaixa(String faixa){
        try{
            sql =
                "   EQ.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.NOME AS CARGO,                    " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   EQ.GRADUACAO AS ULTIMA_GRADUACAO,   " +
                "   EQ.SALARIO AS SALARIO,              " +
                "   AC.NOME AS ACESSO,                  " +
                " FROM                                  " +
                "   EQUIPE EQ                           " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = EQ.ID_PESSOA                 " +
                " JOIN CARGO CG ON                      " +
                "   CG.ID = EQ.ID_CARGO                 " +    
                " JOIN COR C ON                         " +
                "   C.ID = EQ.ID_COR                    " +
                " JOIN ACESSO AC ON                     " +
                "   AC.ID = EQ.ID_ACESSO                " +
                " WHERE C.DESCRICAO LIKE = ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, faixa + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public int buscarProximoId(){
            int id = -1;

            try{
                sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM EQUIPE";

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
