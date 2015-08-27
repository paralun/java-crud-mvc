/*
 * __________                     .__                
 * \______   \_____ ____________  |  |  __ __  ____  
 *  |     ___/\__  \\_  __ \__  \ |  | |  |  \/    \ 
 *  |    |     / __ \|  | \// __ \|  |_|  |  /   |  \
 *  |____|    (____  /__|  (____  /____/____/|___|  /
 * 
 */
package com.paralun.crud.tabelModel;

import com.paralun.crud.entity.Barang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BarangTabelModel extends AbstractTableModel{
    
    private final String[] judul = {"Kode","Nama","Kategori","Harga"};
    private List<Barang> list;

    public BarangTabelModel() {
        list = new ArrayList<>();
    }

    public BarangTabelModel(List<Barang> list) {
        this.list = list;
    }

    public void setList(List<Barang> list) {
        this.list = list;
    }

    public List<Barang> getList() {
        return list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 :
                return list.get(rowIndex).getKode();
            case 1 :
                return list.get(rowIndex).getNama();
            case 2 :
                return list.get(rowIndex).getKategori();
            case 3 :
                return list.get(rowIndex).getHarga();
                default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return judul[column];
    }

    public Barang get(int index) {
        return list.get(index);
    }
}
