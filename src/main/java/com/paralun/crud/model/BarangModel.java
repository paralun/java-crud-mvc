/*
 * __________                     .__                
 * \______   \_____ ____________  |  |  __ __  ____  
 *  |     ___/\__  \\_  __ \__  \ |  | |  |  \/    \ 
 *  |    |     / __ \|  | \// __ \|  |_|  |  /   |  \
 *  |____|    (____  /__|  (____  /____/____/|___|  /
 * 
 */
package com.paralun.crud.model;

import com.paralun.crud.dao.BarangDao;
import com.paralun.crud.entity.Barang;
import com.paralun.crud.utility.DatabaseUtil;
import java.util.List;

public class BarangModel {
    
    private final BarangDao dao;

    public BarangModel() {
        dao = DatabaseUtil.getBarangDao();
    }
    
    public boolean insert(Barang b){
        try {
            dao.insert(b);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public boolean update(Barang b){
        try {
            dao.update(b);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public boolean delete(String kode){
        try {
            dao.delete(kode);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public Barang getBarang(String kode){
        try {
            Barang barang = dao.getBarang(kode);
            return barang;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public List<Barang> getBarang(){
        try {
            List<Barang> list = dao.getBarang();
            return list;
        } catch (Exception ex) {
           return null;
        }
    }
}
