/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import clienteproduto.ItemVenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @authors Jean Luca e Josimar Caetano
 */

public class TableModel extends AbstractTableModel {
    
    private List<ItemVenda> dados = new ArrayList<>();
    private final String[] colunas = {"ID VENDA", "Cliente", "Produto", "Quantidade", "Valor Unitário", "Data da compra", "Total"};
    
    public TableModel(List<ItemVenda> itens) {
        this.dados = itens;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        ItemVenda item = dados.get(linha);
        
        switch(coluna) {
            case 0:
                return item.getVenda().getId_venda();
            case 1:
                return item.getVenda().getCliente().getNome();
            case 2:
                return item.getProduto().getNome();
            case 3:
                return item.getQuantidade();
            case 4:
                return item.getValor_unit();
            case 5:
                return item.getVenda().getData_venda();
            case 6:
                return item.getVenda().getValor_total();
        }
        
        return null;
    }
    
    public void addRow(ItemVenda item) {
        this.dados.add(item);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
}
