package com.apress.jooq.connectionprovider;

import org.jooq.impl.DataSourceConnectionProvider;

import javax.sql.DataSource;

public class CustomDataSourceConnectionProvider extends DataSourceConnectionProvider {
    public CustomDataSourceConnectionProvider(DataSource dataSource) {
        super(dataSource);
    }
    //override acquire() and release()
}
