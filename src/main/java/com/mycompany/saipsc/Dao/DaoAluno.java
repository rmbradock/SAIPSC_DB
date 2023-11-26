/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Dao;

import com.mycompany.saipsc.ferramentas.BancoDeDadosMySql;
import java.sql.ResultSet;

/**
 *
 * @author batista.4995
 */
public class DaoAluno extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, int idPessoa, int idCor, String nascimento, String idade, String responsavel, String uGrad, String pGrad, String faltas, int idPolo, String cpfResp){
        try{
            sql = "INSERT INTO ALUNO (ID, ID_PESSOA, ID_COR, NASCIMENTO, IDADE, RESPONSAVEL, UGRAD, PGRAD, FALTAS, ID_POLO, CPFRESP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idPessoa);
            getStatement().setInt(3, idCor);
            getStatement().setString(4, nascimento);
            getStatement().setString(5, idade);
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
    public Boolean alterar(int id, int idPessoa, int idCor, String nascimento, String idade, String responsavel, String uGrad, String pGrad, String faltas, int idPolo, String cpfResp){
        try{
            sql = "UPDATE ALUNO SET ID_PESSOA = ?, ID_COR = ?, NASCIMENTO = ?, IDADE = ?, RESPONSAVEL = ?, UGRAD = ?, PGRAD = ?, FALTAS = ?, ID_POLO = ?, CPFRESP = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(11, id);
            getStatement().setInt(1, idPessoa);
            getStatement().setInt(2, idCor);
            getStatement().setString(3, nascimento);
            getStatement().setString(4, idade);
            getStatement().setString(5, responsavel);
            getStatement().setString(6, uGrad);
            getStatement().setString(7, pGrad);
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
                " SELECT                                " +
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
                " SELECT                                " +
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
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLOS PL ON                       " +
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
                " SELECT                                " +
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
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLOS PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE P.NOME LIKE ?                        " ;
            
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
                 " SELECT                                " +
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
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLOS PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE C.DESCRICAO LIKE ?                        " ;
            
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
                 " SELECT                                " +
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
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLOS PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE AL.NASCIMENTO LIKE  ?                        " ;
            
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
                 " SELECT                                " +
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
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLOS PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE AL.IDADE LIKE  ?                        " ;
            
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
                 " SELECT                                " +
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
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLOS PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE AL.UGRAD LIKE  ?                        " ;
            
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
                 " SELECT                                " +
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
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLOS PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE C.DESCRICAO LIKE  ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, pGrad + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorPolo(String polo){
        try{
            sql = 
                 " SELECT                                " +
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
                "   ALUNO AL                            " +
                " JOIN PESSOA P ON                      " +
                "   P.ID = AL.ID_PESSOA                 " +
                " JOIN COR C ON                         " +
                "   C.ID = AL.ID_COR                    " +
                " JOIN POLOS PL ON                       " +
                "   PL.ID = AL.ID_POLO                  " +
                " WHERE PL.NOME LIKE  ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, polo + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public int buscarProximoId(){
        int id = 0;
        
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
