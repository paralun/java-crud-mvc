/*
 * __________                     .__                
 * \______   \_____ ____________  |  |  __ __  ____  
 *  |     ___/\__  \\_  __ \__  \ |  | |  |  \/    \ 
 *  |    |     / __ \|  | \// __ \|  |_|  |  /   |  \
 *  |____|    (____  /__|  (____  /____/____/|___|  /
 * 
 */
package com.paralun.crud.utility;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.paralun.crud.dao.BarangDao;
import com.paralun.crud.dao.impl.BarangDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseUtil {
    
    private static Connection connection;
    private static BarangDao barangDao;

    public static Connection getConnection() {
        if(connection==null){
            try {
                MysqlDataSource source = new MysqlDataSource();
                source.setUrl("jdbc:mysql://localhost:3306/crud_mvc");
                source.setUser("root");
                source.setPassword("");
                connection = source.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    public static BarangDao getBarangDao() {
        if(barangDao==null){
            barangDao = new BarangDaoImpl(getConnection());
        }
        return barangDao;
    }
}
