/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import clienteproduto.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jean Luca e Josimar Caetano
 */
public class ProdutoDao {

    public int inserirProduto(Produto p) {
        Connection con = new ConexaoBanco().getConnection();

        String sql = "INSERT INTO tbproduto(nome, marca, valor) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getMarca());
            stmt.setDouble(3, p.getValor());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                rs.close();
                stmt.close();
                con.close();
                return idGerado;
            }

            stmt.close();
            con.close();
            return -1;
        } catch (SQLException ex) {
            System.out.print("Nao foi possivel inserir o produto " + ex.getMessage());
            return -1;
        }
    }

    public List<Produto> buscarProdutos() {
        Connection con = new ConexaoBanco().getConnection();

        List<Produto> produtos = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM tbproduto";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                int id_produto = rs.getInt("id_produto");
                String nome = rs.getString("nome");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");

                Produto produto = new Produto(id_produto, nome, marca, valor);

                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.out.print("Nao foi possivel buscar os produtos" + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null);
                    stmt.close();
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Finalizando conexoes: " + ex.getMessage());
            }
        }
        return produtos;
    }
}
