/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteproduto;

/**
 *
 * @author Jean Luca e Josimar Caetano
 */
public class Produto {
    private int idproduto;

    private String Nome, Marca;
    private double Valor;

    public Produto(String Nome, String Marca, double Valor) {
        this.Nome = Nome;
        this.Marca = Marca;
        this.Valor = Valor;
    }

    public Produto(int idproduto, String nome, String marca, double valor) {
        this.idproduto = idproduto;
        this.Nome = nome;
        this.Marca = marca;
        this.Valor = valor;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
}
