/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.saipsc;

import com.mycompany.saipsc.ferramentas.BancoDeDadosMySql;

/**
 *
 * @author batista.4995
 */
public class SAIPSC {

    public static void main(String[] args) {
        if (BancoDeDadosMySql.conectar())
            System.out.println("Banco de dados conectado com sucesso!");
        else
            System.out.println("Não foi possível conectar ao banco de dados. O sistema será finalizado.");
    }
}
