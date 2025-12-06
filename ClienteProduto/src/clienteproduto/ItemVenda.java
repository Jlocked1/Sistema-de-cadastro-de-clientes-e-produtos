/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteproduto;

/**
 *
 * @author Jean Luca e Josimar Caetano
 */
public class ItemVenda {

    private int id_item_venda;
    private Venda venda;
    private Produto produto;

    private int quantidade;
    private double valor_unit;

    public ItemVenda(int id_item_venda, Venda venda, Produto produto, int quantidade, double valor_unit) {
        this.id_item_venda = id_item_venda;
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor_unit = valor_unit;
    }

    public ItemVenda(Venda venda, Produto produto, int quantidade, double valor_unit) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor_unit = valor_unit;
    }

    public int getId_item_venda() {
        return id_item_venda;
    }

    public void setId_item_venda(int id_item_venda) {
        this.id_item_venda = id_item_venda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor_unit() {
        return valor_unit;
    }

    public void setValor_unit(double valor_unit) {
        this.valor_unit = valor_unit;
    }

}
