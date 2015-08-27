/*
 * __________                     .__                
 * \______   \_____ ____________  |  |  __ __  ____  
 *  |     ___/\__  \\_  __ \__  \ |  | |  |  \/    \ 
 *  |    |     / __ \|  | \// __ \|  |_|  |  /   |  \
 *  |____|    (____  /__|  (____  /____/____/|___|  /
 * 
 */
package com.paralun.crud.dao.impl;

import com.paralun.crud.dao.BarangDao;
import com.paralun.crud.entity.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BarangDaoImpl implements BarangDao{
    
    private final Connection connection;
    private final String INSERT_SQL = "insert into barang (kode,nama,kategori,harga) values (?,?,?,?)";
    private final String UPDATE_SQL = "update barang set nama = ?, kategori = ?, harga = ? where kode = ?";
    private final String DELETE_SQL = "delete from barang where kode = ?";
    private final String SELECT_ID_SQL = "select * from barang where kode = ?";
    private final String SELECT_SQL = "select * from barang";

    public BarangDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Barang b) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_SQL)){
            connection.setAutoCommit(false);
            statement.setString(1, b.getKode());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getKategori());
            statement.setBigDecimal(4, b.getHarga());
            statement.executeUpdate();
            connection.commit();
        }catch(SQLException sqle){
            connection.rollback();
            throw new Exception(sqle.getMessage());
        }finally{
            connection.setAutoCommit(true);
        }
    }

    @Override
    public void update(Barang b) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)){
            connection.setAutoCommit(false);
            statement.setString(1, b.getNama());
            statement.setString(2, b.getKategori());
            statement.setBigDecimal(3, b.getHarga());
            statement.setString(4, b.getKode());
            statement.executeUpdate();
            connection.commit();
        }catch(SQLException sqle){
            connection.rollback();
            throw new Exception(sqle.getMessage());
        }finally{
            connection.setAutoCommit(true);
        }
    }

    @Override
    public void delete(String kode) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_SQL)){
            connection.setAutoCommit(false);
            statement.setString(1, kode);
            statement.executeUpdate();
            connection.commit();
        }catch(SQLException sqle){
            connection.rollback();
            throw new Exception(sqle.getMessage());
        }finally{
            connection.setAutoCommit(true);
        }
    }

    @Override
    public Barang getBarang(String kode) throws Exception {
        Barang barang = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ID_SQL)){
            connection.setAutoCommit(false);
            statement.setString(1, kode);
            try (ResultSet result = statement.executeQuery()){
                if(result.next()){
                    barang = new Barang();
                    barang.setKode(result.getString(1));
                    barang.setNama(result.getString(2));
                    barang.setKategori(result.getString(3));
                    barang.setHarga(result.getBigDecimal(4));
                }
            }
            connection.commit();
        }catch(SQLException sqle){
            connection.rollback();
            throw new Exception(sqle.getMessage());
        }finally{
            connection.setAutoCommit(true);
            return barang;
        }
    }

    @Override
    public List<Barang> getBarang() throws Exception {
        List<Barang> list = new ArrayList<>();
        try (Statement statement = connection.createStatement(); 
                ResultSet result = statement.executeQuery(SELECT_SQL)){
            while(result.next()){
                Barang barang = new Barang();
                barang.setKode(result.getString(1));
                barang.setNama(result.getString(2));
                barang.setKategori(result.getString(3));
                barang.setHarga(result.getBigDecimal(4));
                list.add(barang);
            }  
        }catch(SQLException sqle){
            throw new Exception(sqle.getMessage());
        }finally{
            return list;
        }
    }
}