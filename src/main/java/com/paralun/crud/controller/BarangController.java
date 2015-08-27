/*
 * __________                     .__                
 * \______   \_____ ____________  |  |  __ __  ____  
 *  |     ___/\__  \\_  __ \__  \ |  | |  |  \/    \ 
 *  |    |     / __ \|  | \// __ \|  |_|  |  /   |  \
 *  |____|    (____  /__|  (____  /____/____/|___|  /
 * 
 */
package com.paralun.crud.controller;

import com.paralun.crud.entity.Barang;
import com.paralun.crud.model.BarangModel;
import com.paralun.crud.tabelModel.BarangTabelModel;
import com.paralun.crud.view.BarangView;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

public class BarangController {
    
    private final BarangModel model;
    private final BarangView view;

    public BarangController(BarangModel model, BarangView view) {
        this.model = model;
        this.view = view;
    }
    
    public Barang b(){
        Barang barang = new Barang(
                view.getTextKode().getText(), 
                view.getTextNama().getText(), 
                view.getTextKategori().getText(), 
                new BigDecimal(view.getTextHarga().getText()));
        return barang;
    }
    
    public void insert(){
        if(view.getTextKode().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(view, "Kode masih kosong");
        }else if(view.getTextNama().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(view, "Nama masih kosong");
        }else if(view.getTextKategori().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(view, "Kategori masih kosong");
        }else if(view.getTextHarga().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(view, "Harga masih kosong");
        }else{
            if(model.insert(b())){
                JOptionPane.showMessageDialog(view, "Input Berhasil.");
                clear();
                reload();
            }else{
                JOptionPane.showMessageDialog(view, "Input Gagal");
            }
        }
    }
    
    public void update(){
        if(view.getTextKode().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(view, "Kode masih kosong");
        }else if(view.getTextNama().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(view, "Nama masih kosong");
        }else if(view.getTextKategori().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(view, "Kategori masih kosong");
        }else if(view.getTextHarga().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(view, "Harga masih kosong");
        }else{
            if(model.update(b())){
                JOptionPane.showMessageDialog(view, "Update Berhasil.");
                clear();
                reload();
            }else{
                JOptionPane.showMessageDialog(view, "Update Gagal");
            }
        }
    }
    
    public void delete(){
        if(JOptionPane.showConfirmDialog(view, "Hapus Data?", "Delete", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
            String kode = view.getTextKode().getText();
            if(model.delete(kode)){
                JOptionPane.showMessageDialog(view, "Hapus Berhasil");
                clear();
                reload();
            }else{
                JOptionPane.showMessageDialog(view, "Hapus Gagal");
            }
        }
    }
    
    public void reload(){
        view.setTabelModel(new BarangTabelModel());
        view.getTabelModel().setList(model.getBarang());
        view.getTabelBarang().setModel(view.getTabelModel());
    }
    
    public void clear(){
        view.getTextKode().setText("");
        view.getTextNama().setText("");
        view.getTextKategori().setText("");
        view.getTextHarga().setText("");
    }
}
