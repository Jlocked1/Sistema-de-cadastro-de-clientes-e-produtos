/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Jean Luca e Josimar Caetano
 */
public class ConexaoBanco {
    public Connection getConnection() {
      
      try {
           Class.forName("org.postgresql.Driver");
           return  DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/clienteproduto","postgres","admin");
      }catch(SQLException ex){
           System.out.println("Problema ao abrir o banco " + ex.getMessage());
           return null;
      }catch(ClassNotFoundException e){
           System.out.println("Problema ao carregar o driver de " + "conexão!");
      }
      return null;
    }
}
