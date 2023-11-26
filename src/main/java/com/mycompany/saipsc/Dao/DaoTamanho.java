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
public class DaoTamanho extends BancoDeDadosMySql{
    private String sql;
        public Boolean inserir(int id, String nome, String descricao){
                try{
                    sql = "INSERT INTO TAMANHO (ID, TAM, DESCRICAO) VALUES (?,?,?)";

                    setStatement(getConexao().prepareStatement(sql));

                    getStatement().setInt(1, id);
                    getStatement().setString(2, nome);
                    getStatement().setString(3, descricao);

                    getStatement().executeUpdate();

                    return true;
                }catch(Exception e){
                    System.out.println(e.getMessage());
                    return false;
                }
            }
            public Boolean alterar(int id, String novoNome, String novaDescricao){
                try{
                    sql = "UPDATE TAMANHO SET TAM = ?, DESCRICAO = ? WHERE ID = ?";

                    setStatement(getConexao().prepareStatement(sql));

                    getStatement().setInt(3, id);
                    getStatement().setString(1, novoNome);
                    getStatement().setString(2, novaDescricao);

                    getStatement().executeUpdate();

                    return true;
                }catch(Exception e){
                    System.out.println(e.getMessage());
                    return false;
                }
            }
            public Boolean excluir(int id){
                try{
                    sql = "DELETE FROM TAMANHO WHERE ID = ?";

                    setStatement(getConexao().prepareStatement(sql));

                    getStatement().setInt(1, id);

                    getStatement().executeUpdate();

                    return true;
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    return false;
                }
            }
            public ResultSet listarTodos(){
                try{
                    sql = "SELECT ID, TAM, IFNULL(DESCRICAO, '') FROM TAMANHO";

                    setStatement(getConexao().prepareStatement(sql));

                    setResultado(getStatement().executeQuery());
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                return getResultado();
            }

            public ResultSet listarPorId(int id){
                try{
                    sql = "SELECT ID, TAM, IFNULL(DESCRICAO, '') FROM TAMANHO WHERE ID = ?";

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
                    sql = "SELECT ID, TAM, IFNULL(DESCRICAO, '') FROM TAMANHO WHERE TAM LIKE ?";

                    setStatement(getConexao().prepareStatement(sql));

                    getStatement().setString(1, nome + "%");

                    setResultado(getStatement().executeQuery());
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                return getResultado();
            }

            public ResultSet listarPorDescricao(String descricao){
                try{
                    sql = "SELECT ID, TAM, IFNULL(DESCRICAO, '') FROM TAMANHO WHERE DESCRICAO LIKE ?";

                    setStatement(getConexao().prepareStatement(sql));

                    getStatement().setString(1, descricao + "%");

                    setResultado(getStatement().executeQuery());
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                return getResultado();
            }

            public int buscarProximoId(){
                   int id = -1;

                   try{
                       sql = "SELECT MAX(ID) + 1 FROM TAMANHO";

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