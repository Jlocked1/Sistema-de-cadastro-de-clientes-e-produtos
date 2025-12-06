/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import clienteproduto.Cliente;
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
public class ClienteDao {

    public int inserirCliente(Cliente c) {
        Connection con = new ConexaoBanco().getConnection();

        String sql = "INSERT INTO tbcliente(nome, endereco, bairro, cidade, telefone) values(?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEndereco());
            stmt.setString(3, c.getBairro());
            stmt.setString(4, c.getCidade());
            stmt.setString(5, c.getTelefone());

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
            System.out.println("Nao foi possivel inserir o produto: " + ex.getMessage());
            return -1;
        }
    }

    public List<Cliente> buscarClientes() {
        Connection con = new ConexaoBanco().getConnection();

        List<Cliente> clientes = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM tbcliente";

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int idcliente = rs.getInt("id_cliente");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String telefone = rs.getString("telefone");

                Cliente cliente = new Cliente(idcliente, nome, endereco, bairro, cidade, telefone);

                clientes.add(cliente);

            }
        } catch (SQLException ex) {
            System.out.println("Retornando lista de objetos " + ex.getMessage());
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
        return clientes;
    }

    public Cliente buscarIdCliente(int id) {
        Connection con = new ConexaoBanco().getConnection();

        ResultSet rs = null;
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM tbcliente WHERE id_cliente = ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {

                int id_cliente = rs.getInt("id_cliente");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String telefone = rs.getString("telefone");

                Cliente cliente = new Cliente(id_cliente, nome, endereco, bairro, cidade, telefone);

                return cliente;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar cliente: " + ex.getMessage());
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

        return null;
    }
}
