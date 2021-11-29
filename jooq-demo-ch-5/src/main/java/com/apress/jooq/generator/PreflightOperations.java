package com.apress.jooq.generator;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.sql.Connection;
import java.sql.SQLException;

import static com.apress.jooq.executable.generate.JooqGenerator.generateCodeWithCode;

public class PreflightOperations {

    final static Logger logger = LoggerFactory.getLogger(PreflightOperations.class);

    static GenericContainer mySql;

    final static String DATABASE_NAME = "edens_car";
    final static String USERNAME = "auserhasnoname";
    final static String PW = "anawfulpasword";

    public static void main(String[] args) throws Exception {
            logger.info("Running preflight operations");
            Connection connection = startDatabaseContainer();
            runMigrations(connection);
            generateJooqCode(mySql);
            connection.close();
            mySql.close();
    }

    public static void runMigrations(Connection connection){
        JdbcDatabaseContainer container = (JdbcDatabaseContainer) mySql;
        Flyway flyway = Flyway.configure().dataSource(container.getJdbcUrl(),container.getUsername(),container.getPassword()).load();
        flyway.migrate();
    }

    public static Connection startDatabaseContainer() throws SQLException {
         mySql = new MySQLContainer(DockerImageName.parse("mysql:latest"))
                .withDatabaseName(DATABASE_NAME)
                .withUsername(USERNAME)
                .withPassword(PW)
                .withEnv("TESTCONTAINERS_CHECKS_DISABLE","true")
                 .withEnv("TESTCONTAINERS_RYUK_DISABLED ","false")
                .withExposedPorts(3306);
        mySql.start();
        return ((JdbcDatabaseContainer)mySql).createConnection("");
    }

    public static void generateJooqCode(GenericContainer container) throws Exception {
        JdbcDatabaseContainer mySql = (JdbcDatabaseContainer) PreflightOperations.mySql;
        generateCodeWithCode(mySql.getJdbcUrl(),mySql.getUsername(),mySql.getPassword());
        logger.info("Migration complete");
    }

}
