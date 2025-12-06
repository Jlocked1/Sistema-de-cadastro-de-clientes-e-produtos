/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import clienteproduto.Cliente;
import clienteproduto.ItemVenda;
import clienteproduto.Produto;
import clienteproduto.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jean Luca e Josimar Caetano
 */
public class ItemVendaDao {

    public boolean inserirItemVenda(ItemVenda item) {
        Connection con = new ConexaoBanco().getConnection();

        String sql = "INSERT INTO tbitemvenda(id_venda, id_produto, quantidade, valor_unitario) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, item.getVenda().getId_venda());
            stmt.setInt(2, item.getProduto().getIdproduto());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getValor_unit());
            stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Nao foi possivel inserir o item da venda: " + ex.getMessage());
            return false;
        }
    }

    public List<ItemVenda> buscarTodosItensVenda() {
        Connection con = new ConexaoBanco().getConnection();
        List<ItemVenda> itens = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT "
                + "iv.id_item_venda, iv.quantidade, iv.valor_unitario, "
                + "v.id_venda, v.data_venda, v.valor_total, "
                + "c.id_cliente, c.nome AS nome_cliente, c.endereco, c.bairro, c.cidade, c.telefone, "
                + "p.id_produto, p.nome AS nome_produto, p.marca, p.valor "
                + "FROM tbitemvenda iv "
                + "JOIN tbvenda v ON iv.id_venda = v.id_venda "
                + "JOIN tbcliente c ON v.id_cliente = c.id_cliente "
                + "JOIN tbproduto p ON iv.id_produto = p.id_produto";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome_cliente"),
                        rs.getString("endereco"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("telefone")
                );

                Venda venda = new Venda(
                        rs.getInt("id_venda"),
                        cliente, // Usa o objeto Cliente que acabamos de criar
                        rs.getString("data_venda"),
                        rs.getDouble("valor_total")
                );

                Produto produto = new Produto(
                        rs.getInt("id_produto"),
                        rs.getString("nome_produto"),
                        rs.getString("marca"),
                        rs.getDouble("valor")
                );

                ItemVenda item = new ItemVenda(
                        rs.getInt("id_item_venda"),
                        venda, // Usa o objeto Venda
                        produto, // Usa o objeto Produto
                        rs.getInt("quantidade"),
                        rs.getDouble("valor_unitario")
                );

                itens.add(item);
            }
        } catch (SQLException ex) {
            System.out.println("Retornando lista de itens: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Finalizando conexoes: " + ex.getMessage());
            }
        }
        return itens;
    }

    public boolean excluirItemVenda(int idItemVenda) {
        Connection con = new ConexaoBanco().getConnection();

        String sql = "DELETE FROM tbitemvenda WHERE id_item_venda = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idItemVenda);
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            System.err.println("Não foi possível excluir o item da venda: " + ex.getMessage());
            return false;
        }
    }
}
