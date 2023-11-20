/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Dao;

import com.mycompany.saipsc.ferramentas.BancoDeDadosMySql;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author batista.4995
 */
public class DaoAluno extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, int idPessoa, int idCor, String nascimento, int idade, String responsavel, String uGrad, String pGrad, String faltas, int idPolo, String cpfResp){
        try{
            sql = "INSERT INTO ALUNO (ID, ID_PESSOA, ID_COR, NASCIMENTO, IDADE, RESPONSAVEL, UGRAD, PGRAD, FALTAS, ID_POLO, CPFRESP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idPessoa);
            getStatement().setInt(3, idCor);
            getStatement().setString(4, nascimento);
            getStatement().setInt(5, idade);
            getStatement().setString(6, responsavel);
            getStatement().setString(7, uGrad);
            getStatement().setString(8, pGrad);
            getStatement().setString(9, faltas);
            getStatement().setInt(10,idPolo );
            getStatement().setString(11,cpfResp );
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar(int id, int idPessoa, int idCor, Date nascimento, String idade, String responsavel, Date uGrad, Date pGrad, String faltas, int idPolo, String cpfResp){
        try{
            sql = "UPDATE ALUNO SET ID_PESSOA = ?, ID_COR = ?, NASCIMENTO = ?, IDADE = ?, RESPONSAVEL = ?, UGRAD = ?, PGRAD = ?, FALTAS = ?, ID_POLO = ?, CPFRESP = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(11, id);
            getStatement().setInt(1, idPessoa);
            getStatement().setInt(2, idCor);
            getStatement().setDate(3, nascimento);
            getStatement().setString(4, idade);
            getStatement().setString(5, responsavel);
            getStatement().setDate(6, uGrad);
            getStatement().setDate(7, pGrad);
            getStatement().setString(8, faltas);
            getStatement().setInt(9,idPolo );
            getStatement().setString(10,cpfResp );
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM ALUNO WHERE ID = ?";
            
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
                " SELECT " +
                //id, idPessoa, idCor, nascimento, idade, responsavel, uGrad, pGrad, faltas, idPolo, cpfResp                           " +
                "   AL.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   AL.NASCIMENTO AS DATA_DE_NASCIMENTO, " +
                "   AL.IDADE AS IDADE,                  " +
                "   AL.RESPONSAVEL AS RESPONSAVEL,      " +
                "   AL.UGRAD AS ULTIMA_GRADUACAO,       " +
                "   AL.PGRAD AS PROVAVEL_PROX_GRAD,     " +
                "   AL.FALTAS AS FALTAS,                " +
                "   PL.NOME AS POLO,                     " +
                "   AL.CPFRESP AS CPF                       " +
                " FROM                                  " +
//idPessoa, idCor, idPolo                    
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLOS PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " ;
            
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
                "   AL.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   AL.NASCIMENTO AS DATA_DE_NASCIMENTO, " +
                "   AL.IDADE AS IDADE,                  " +
                "   AL.RESPONSAVEL AS RESPONSAVEL,      " +
                "   AL.UGRAD AS ULTIMA_GRADUACAO,       " +
                "   AL.PGRAD AS PROVAVEL_PROX_GRAD,     " +
                "   AL.FALTAS AS FALTAS,                " +
                "   PL.NOME AS POLO                     " +
                "   PL.CPF AS CPF                       " +
                " FROM                                  " +
//idPessoa, idCor, idPolo                    
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLO PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
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
                "   AL.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   AL.NASCIMENTO AS DATA_DE_NASCIMENTO, " +
                "   AL.IDADE AS IDADE,                  " +
                "   AL.RESPONSAVEL AS RESPONSAVEL,      " +
                "   AL.UGRAD AS ULTIMA_GRADUACAO,       " +
                "   AL.PGRAD AS PROVAVEL_PROX_GRAD,     " +
                "   AL.FALTAS AS FALTAS,                " +
                "   PL.NOME AS POLO                     " +
                "   PL.CPF AS CPF                       " +
                " FROM                                  " +
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLO PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE P.NOME LIKE = ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorFaixa(String faixa){
        try{
            sql = 
                "   AL.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   AL.NASCIMENTO AS DATA_DE_NASCIMENTO, " +
                "   AL.IDADE AS IDADE,                  " +
                "   AL.RESPONSAVEL AS RESPONSAVEL,      " +
                "   AL.UGRAD AS ULTIMA_GRADUACAO,       " +
                "   AL.PGRAD AS PROVAVEL_PROX_GRAD,     " +
                "   AL.FALTAS AS FALTAS,                " +
                "   PL.NOME AS POLO                     " +
                "   PL.CPF AS CPF                       " +
                " FROM                                  " +
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLO PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE C.DESCRICAO LIKE = ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, faixa + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorNascimento(String nascimento){
        try{
            sql = 
                "   AL.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   AL.NASCIMENTO AS DATA_DE_NASCIMENTO, " +
                "   AL.IDADE AS IDADE,                  " +
                "   AL.RESPONSAVEL AS RESPONSAVEL,      " +
                "   AL.UGRAD AS ULTIMA_GRADUACAO,       " +
                "   AL.PGRAD AS PROVAVEL_PROX_GRAD,     " +
                "   AL.FALTAS AS FALTAS,                " +
                "   PL.NOME AS POLO                     " +
                "   PL.CPF AS CPF                       " +
                " FROM                                  " +
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLO PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE AL.NASCIMENTO LIKE = ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nascimento + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorIdade(String idade){
        try{
            sql = 
                "   AL.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   AL.NASCIMENTO AS DATA_DE_NASCIMENTO, " +
                "   AL.IDADE AS IDADE,                  " +
                "   AL.RESPONSAVEL AS RESPONSAVEL,      " +
                "   AL.UGRAD AS ULTIMA_GRADUACAO,       " +
                "   AL.PGRAD AS PROVAVEL_PROX_GRAD,     " +
                "   AL.FALTAS AS FALTAS,                " +
                "   PL.NOME AS POLO                     " +
                "   PL.CPF AS CPF                       " +
                " FROM                                  " +
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLO PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE AL.IDADE LIKE = ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, idade + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorUGrad(String uGrad){
        try{
            sql = 
                "   AL.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   AL.NASCIMENTO AS DATA_DE_NASCIMENTO, " +
                "   AL.IDADE AS IDADE,                  " +
                "   AL.RESPONSAVEL AS RESPONSAVEL,      " +
                "   AL.UGRAD AS ULTIMA_GRADUACAO,       " +
                "   AL.PGRAD AS PROVAVEL_PROX_GRAD,     " +
                "   AL.FALTAS AS FALTAS,                " +
                "   PL.NOME AS POLO                     " +
                "   PL.CPF AS CPF                       " +
                " FROM                                  " +
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLO PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE AL.UGRAD LIKE = ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, uGrad + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorPGrad(String pGrad){
        try{
            sql = 
                "   AL.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   AL.NASCIMENTO AS DATA_DE_NASCIMENTO, " +
                "   AL.IDADE AS IDADE,                  " +
                "   AL.RESPONSAVEL AS RESPONSAVEL,      " +
                "   AL.UGRAD AS ULTIMA_GRADUACAO,       " +
                "   AL.PGRAD AS PROVAVEL_PROX_GRAD,     " +
                "   AL.FALTAS AS FALTAS,                " +
                "   PL.NOME AS POLO                     " +
                "   PL.CPF AS CPF                       " +
                " FROM                                  " +
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLO PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE C.DESCRICAO LIKE = ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, pGrad + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorFaltas(String faltas){
        try{
            sql = 
                "   AL.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   AL.NASCIMENTO AS DATA_DE_NASCIMENTO, " +
                "   AL.IDADE AS IDADE,                  " +
                "   AL.RESPONSAVEL AS RESPONSAVEL,      " +
                "   AL.UGRAD AS ULTIMA_GRADUACAO,       " +
                "   AL.PGRAD AS PROVAVEL_PROX_GRAD,     " +
                "   AL.FALTAS AS FALTAS,                " +
                "   PL.NOME AS POLO                     " +
                "   PL.CPF AS CPF                       " +
                " FROM                                  " +
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLO PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE AL.FALTAS LIKE = ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, faltas + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorPolo(String polo){
        try{
            sql = 
                "   AL.ID AS ID,                        " +
                "   P.NOME AS NOME,                     " +
                "   C.DESCRICAO AS FAIXA,               " +
                "   AL.NASCIMENTO AS DATA_DE_NASCIMENTO, " +
                "   AL.IDADE AS IDADE,                  " +
                "   AL.RESPONSAVEL AS RESPONSAVEL,      " +
                "   AL.UGRAD AS ULTIMA_GRADUACAO,       " +
                "   AL.PGRAD AS PROVAVEL_PROX_GRAD,     " +
                "   AL.FALTAS AS FALTAS,                " +
                "   PL.NOME AS POLO                     " +
                "   PL.CPF AS CPF                       " +
                " FROM                                  " +
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLO PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE PL.NOME LIKE = ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, polo + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM ALUNO";
            
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
