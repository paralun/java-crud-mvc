/*
 * __________                     .__                
 * \______   \_____ ____________  |  |  __ __  ____  
 *  |     ___/\__  \\_  __ \__  \ |  | |  |  \/    \ 
 *  |    |     / __ \|  | \// __ \|  |_|  |  /   |  \
 *  |____|    (____  /__|  (____  /____/____/|___|  /
 * 
 */
package com.paralun.crud.dao;

import com.paralun.crud.entity.Barang;
import java.util.List;

public interface BarangDao {
    void insert(Barang b) throws Exception;
    void update(Barang b) throws Exception;
    void delete(String kode) throws Exception;
    Barang getBarang(String kode) throws Exception;
    List<Barang> getBarang() throws Exception;
}
