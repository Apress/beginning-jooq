package com.apress.jooq.spring.config;

import com.apress.jooq.listener.QueryRuntimeListener;
import org.h2.jdbcx.JdbcDataSource;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJdbcRepositories(basePackages = {"com.apress.jooq.spring.repository"})
public class JdbcConfig extends AbstractJdbcConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    DefaultDSLContext dsl() {
        return new DefaultDSLContext(dslConfig());
    }

    private org.jooq.Configuration dslConfig() {
        DefaultConfiguration defaultConfiguration = new DefaultConfiguration();
        defaultConfiguration.set(dataSource)
                .set(SQLDialect.MYSQL)
                .set(new QueryRuntimeListener())
                .set(DefaultExecuteListenerProvider.providers(new QueryRuntimeListener()));
        return defaultConfiguration;
    }
}
