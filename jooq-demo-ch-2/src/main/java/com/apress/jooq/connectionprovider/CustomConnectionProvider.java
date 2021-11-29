package com.apress.jooq.connectionprovider;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jooq.ConnectionProvider;
import org.jooq.exception.DataAccessException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class CustomConnectionProvider implements ConnectionProvider {

    DataSource dataSource;

    public CustomConnectionProvider(){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setDatabaseName("edens_car");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("password");
        mysqlDataSource.setServerName("localhost");
        mysqlDataSource.setPort(3306);
        this.dataSource = mysqlDataSource;
    }

    @Override
    public Connection acquire() throws DataAccessException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void release(Connection connection) throws DataAccessException {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
