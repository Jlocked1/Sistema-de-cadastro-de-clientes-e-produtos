/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import clienteproduto.Cliente;
import clienteproduto.Venda;
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
public class VendaDao {

    public int inserirVenda(Venda venda) {
        Connection con = new ConexaoBanco().getConnection();

        String sql = "INSERT INTO tbvenda(id_cliente, data_venda, valor_total) values(?, ?, ?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, venda.getCliente().getIdcliente());
            stmt.setString(2, venda.getData_venda());
            stmt.setDouble(3, venda.getValor_total());

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
            System.out.println("Nao foi possivel inserir venda" + ex.getMessage());
            return -1;

        }
    }

    public List<Venda> buscarVendas() {
        Connection con = new ConexaoBanco().getConnection();

        List<Venda> vendas = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM tbvenda";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_venda = rs.getInt("id_venda");
                int id_cliente = rs.getInt("id_cliente");  // ← Só temos o ID!
                String data_venda = rs.getString("data_venda");
                double valor_total = rs.getDouble("valor_total");

                ClienteDao clientedao = new ClienteDao();
                Cliente cliente = clientedao.buscarIdCliente(id_cliente);

                Venda venda = new Venda(id_venda, cliente, data_venda, valor_total);

                vendas.add(venda);
            }
        } catch (SQLException ex) {
            System.out.println("Nao foi possivel buscar vendas" + ex.getMessage());
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
        return vendas;
    }

    public boolean excluirVenda(Venda venda) {
        Connection con = new ConexaoBanco().getConnection();

        String sql = "DELETE FROM tbvenda WHERE id_venda = ?";

        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,  venda.getId_venda());

            stmt.execute();

            stmt.close();
            con.close();

            return true;

        } catch (SQLException ex) {
            System.err.println("Não foi possível excluir a venda");
        }

        return false;
    }
}
