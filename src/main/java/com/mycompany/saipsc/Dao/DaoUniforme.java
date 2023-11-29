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
public class DaoUniforme extends BancoDeDadosMySql {
    String sql;
    
    public Boolean inserir(int id, String quantidade, int idCategoria, int idTamanho, int idCor, int idMarca, int idCondicao){
        try{
            sql = "INSERT INTO KIMONOF (ID, QUANTIDADE, ID_CATEGORIA, ID_TAMANHO, ID_COR, ID_MARCA, ID_CONDICAO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, quantidade);
            getStatement().setInt(3, idCategoria);
            getStatement().setInt(4, idTamanho);
            getStatement().setInt(5, idCor);
            getStatement().setInt(6, idMarca);
            getStatement().setInt(7, idCondicao);
                        
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar(int id, String quantidade, int idCategoria, int idTamanho, int idCor, int idMarca, int idCondicao){
        try{
            sql = "UPDATE KIMONOF SET QUANTIDADE = ?, ID_CATEGORIA = ?, ID_TAMANHO = ?, ID_COR = ?, ID_MARCA = ?, ID_CONDICAO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(7, id);
            getStatement().setString(1, quantidade);
            getStatement().setInt(2, idCategoria);
            getStatement().setInt(3, idTamanho);
            getStatement().setInt(4, idCor);
            getStatement().setInt(5, idMarca);
            getStatement().setInt(6, idCondicao);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM KIMONOF WHERE ID = ?";
            
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
                " SELECT                                 " +
                "   K.ID AS ID,                          " +
                "   K.QUANTIDADE AS QUANTIDADE,          " +
                "   CA.NOME AS KIMONO_OU_FAIXA,          " +
                "   TM.TAM AS TAMANHO,               " +
                "   C.DESCRICAO AS COR,                  " +
                "   M.NOME AS MARCA,                     " +
                "   CD.ESTADO AS CONDICAO               " +
                " FROM                                   " +
                "   KIMONOF K                            " +
                " JOIN CATEGORIAKF CA ON                   " +
                "   CA.ID = K.ID_CATEGORIA              " +
                " JOIN TAMANHO TM ON                     " +
                "   TM.ID = K.ID_TAMANHO                 " +    
                " JOIN COR C ON                          " +
                "   C.ID = K.ID_COR                      " +
                " JOIN MARCA M ON                        " +
                "   M.ID = K.ID_MARCA                   " +
                " JOIN CONDICAO CD ON                    " +
                "   CD.ID = K.ID_CONDICAO                " ;
            
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
                " SELECT                                 " +
                "   K.ID AS ID,                          " +
                "   K.QUANTIDADE AS QUANTIDADE,          " +
                "   CA.NOME AS KIMONO_OU_FAIXA,          " +
                "   TM.TAM AS TAMANHO,               " +
                "   C.DESCRICAO AS COR,                  " +
                "   M.NOME AS MARCA,                     " +
                "   CD.ESTADO AS CONDICAO               " +
                " FROM                                   " +
                "   KIMONOF K                            " +
                " JOIN CATEGORIAKF CA ON                   " +
                "   CA.ID = K.ID_CATEGORIA              " +
                " JOIN TAMANHO TM ON                     " +
                "   TM.ID = K.ID_TAMANHO                 " +    
                " JOIN COR C ON                          " +
                "   C.ID = K.ID_COR                      " +
                " JOIN MARCA M ON                        " +
                "   M.ID = K.ID_MARCA                   " +
                " JOIN CONDICAO CD ON                    " +
                "   CD.ID = K.ID_CONDICAO                " +
                " WHERE K.ID = ?                         " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
     public ResultSet listarPorCategoria(String categoria){
        try{
            sql =
                " SELECT                                 " +
                "   K.ID AS ID,                          " +
                "   K.QUANTIDADE AS QUANTIDADE,          " +
                "   CA.NOME AS KIMONO_OU_FAIXA,          " +
                "   TM.TAM AS TAMANHO,               " +
                "   C.DESCRICAO AS COR,                  " +
                "   M.NOME AS MARCA,                     " +
                "   CD.ESTADO AS CONDICAO               " +
                " FROM                                   " +
                "   KIMONOF K                            " +
                " JOIN CATEGORIAKF CA ON                   " +
                "   CA.ID = K.ID_CATEGORIA              " +
                " JOIN TAMANHO TM ON                     " +
                "   TM.ID = K.ID_TAMANHO                 " +    
                " JOIN COR C ON                          " +
                "   C.ID = K.ID_COR                      " +
                " JOIN MARCA M ON                        " +
                "   M.ID = K.ID_MARCA                   " +
                " JOIN CONDICAO CD ON                    " +
                "   CD.ID = K.ID_CONDICAO                " +
                " WHERE CA.NOME LIKE ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, categoria + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
        
    }
    public ResultSet listarPorTamanho(String tamanho){
        try{
            sql =
                " SELECT                                 " +
                "   K.ID AS ID,                          " +
                "   K.QUANTIDADE AS QUANTIDADE,          " +
                "   CA.NOME AS KIMONO_OU_FAIXA,          " +
                "   TM.TAM AS TAMANHO,               " +
                "   C.DESCRICAO AS COR,                  " +
                "   M.NOME AS MARCA,                     " +
                "   CD.ESTADO AS CONDICAO               " +
                " FROM                                   " +
                "   KIMONOF K                            " +
                " JOIN CATEGORIAKF CA ON                   " +
                "   CA.ID = K.ID_CATEGORIA              " +
                " JOIN TAMANHO TM ON                     " +
                "   TM.ID = K.ID_TAMANHO                 " +    
                " JOIN COR C ON                          " +
                "   C.ID = K.ID_COR                      " +
                " JOIN MARCA M ON                        " +
                "   M.ID = K.ID_MARCA                   " +
                " JOIN CONDICAO CD ON                    " +
                "   CD.ID = K.ID_CONDICAO                " +
                " WHERE TM.TAM LIKE  ?              " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, tamanho + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorCor(String cor){
        try{
            sql =
                " SELECT                                 " +
                "   K.ID AS ID,                          " +
                "   K.QUANTIDADE AS QUANTIDADE,          " +
                "   CA.NOME AS KIMONO_OU_FAIXA,          " +
                "   TM.TAM AS TAMANHO,               " +
                "   C.DESCRICAO AS COR,                  " +
                "   M.NOME AS MARCA,                     " +
                "   CD.ESTADO AS CONDICAO               " +
                " FROM                                   " +
                "   KIMONOF K                            " +
                " JOIN CATEGORIAKF CA ON                   " +
                "   CA.ID = K.ID_CATEGORIA              " +
                " JOIN TAMANHO TM ON                     " +
                "   TM.ID = K.ID_TAMANHO                 " +    
                " JOIN COR C ON                          " +
                "   C.ID = K.ID_COR                      " +
                " JOIN MARCA M ON                        " +
                "   M.ID = K.ID_MARCA                   " +
                " JOIN CONDICAO CD ON                    " +
                "   CD.ID = K.ID_CONDICAO                " +
                " WHERE C.DESCRICAO LIKE  ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cor + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorMarca(String marca){
        try{
            sql =
                " SELECT                                 " +
                "   K.ID AS ID,                          " +
                "   K.QUANTIDADE AS QUANTIDADE,          " +
                "   CA.NOME AS KIMONO_OU_FAIXA,          " +
                "   TM.TAM AS TAMANHO,               " +
                "   C.DESCRICAO AS COR,                  " +
                "   M.NOME AS MARCA,                     " +
                "   CD.ESTADO AS CONDICAO               " +
                " FROM                                   " +
                "   KIMONOF K                            " +
                " JOIN CATEGORIAKF CA ON                   " +
                "   CA.ID = K.ID_CATEGORIA              " +
                " JOIN TAMANHO TM ON                     " +
                "   TM.ID = K.ID_TAMANHO                 " +    
                " JOIN COR C ON                          " +
                "   C.ID = K.ID_COR                      " +
                " JOIN MARCA M ON                        " +
                "   M.ID = K.ID_MARCA                   " +
                " JOIN CONDICAO CD ON                    " +
                "   CD.ID = K.ID_CONDICAO                " +
                " WHERE M.NOME LIKE  ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, marca + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorEstado(String estado){
        try{
            sql =
               " SELECT                                 " +
                "   K.ID AS ID,                          " +
                "   K.QUANTIDADE AS QUANTIDADE,          " +
                "   CA.NOME AS KIMONO_OU_FAIXA,          " +
                "   TM.TAM AS TAMANHO,               " +
                "   C.DESCRICAO AS COR,                  " +
                "   M.NOME AS MARCA,                     " +
                "   CD.ESTADO AS CONDICAO               " +
                " FROM                                   " +
                "   KIMONOF K                            " +
                " JOIN CATEGORIAKF CA ON                   " +
                "   CA.ID = K.ID_CATEGORIA              " +
                " JOIN TAMANHO TM ON                     " +
                "   TM.ID = K.ID_TAMANHO                 " +    
                " JOIN COR C ON                          " +
                "   C.ID = K.ID_COR                      " +
                " JOIN MARCA M ON                        " +
                "   M.ID = K.ID_MARCA                   " +
                " JOIN CONDICAO CD ON                    " +
                "   CD.ID = K.ID_CONDICAO                " +
                " WHERE CD.ESTADO LIKE  ?                        " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, estado + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public int buscarProximoId(){
            int id = 0;

            try{
                sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM KIMONOF";

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
