/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteproduto;

/**
 *
 * @author Jean Luca e Josimar Caetano
 */
public class Venda {

    private int id_venda;
    private Cliente cliente;

    private String data_venda;
    private double valor_total;

    public Venda(int id_venda, Cliente cliente, String data_venda, double valor_total) {
        this.id_venda = id_venda;
        this.cliente = cliente;
        this.data_venda = data_venda;
        this.valor_total = valor_total;
    }

    public Venda(Cliente cliente, String data_venda, double valor_total) {
        this.cliente = cliente;
        this.data_venda = data_venda;
        this.valor_total = valor_total;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public void calcularValorTotal(int quantidade, double valorUnitario) {
        this.valor_total = quantidade * valorUnitario;
    }
}
