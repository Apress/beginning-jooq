package com.apress.jooq;

import com.apress.jooq.record.CompleteVehicleRecord;
import org.flywaydb.core.Flyway;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.testcontainers.containers.*;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static com.apress.jooq.executable.JooqInsert.insertVehicle;
import static org.jooq.impl.DSL.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JooqIntegrationTests {

    static MockedStatic mockedDriver;
    static final Network localContainerNetwork = Network.newNetwork();
    final static String DATABASE_NAME = "edens_car";
    final static String USERNAME = "auserhasnoname";
    final static String PW = "anawfulpasword";

    @Container
    static GenericContainer mySqlContainer = new MySQLContainer(DockerImageName.parse("mysql:latest"))
            .withDatabaseName(DATABASE_NAME)
            //.withInitScript("schema_with_data.sql")
            .withUsername(USERNAME)
            .withPassword(PW)
            .withNetwork(localContainerNetwork)
            .withEnv("TESTCONTAINERS_CHECKS_DISABLE","true")
            .withExposedPorts(3306);

    @BeforeAll
    public static void setup(){
        mockedDriver = mockStatic(DriverManager.class);
        JdbcDatabaseContainer container = (JdbcDatabaseContainer) mySqlContainer;
        Flyway flyway = Flyway.configure().dataSource(container.getJdbcUrl(),container.getUsername(),container.getPassword()).load();
        flyway.migrate();

        /*
        DatabaseDelegate delegate = new JdbcDatabaseDelegate((JdbcDatabaseContainer) container,null);
        ScriptUtils.runInitScript(delegate,"src/test/resources/schema_with_data.sql");
        */
    }

    @Test
    @Order(2)
    public void test_portable_database() throws SQLException {
        if(!mySqlContainer.isRunning()){
            mySqlContainer.start();
        }
        JdbcDatabaseContainer container = (JdbcDatabaseContainer) mySqlContainer;
        container.getJdbcUrl();
        Connection connection =container.createConnection("");
        DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
        List<CompleteVehicleRecord> allVehicles = context.select(field(name("brand")), field("model"), field("price")).from(table("complete_car_listing")).orderBy(field("year").asc(), two()).fetchInto(CompleteVehicleRecord.class);
        assertTrue(allVehicles.size() >= 1);
    }

    @Test
    @Order(1)
    public void test_mocked_out_connection() throws SQLException {
        JdbcDatabaseContainer container = (JdbcDatabaseContainer) mySqlContainer;
        Connection connection =container.createConnection("");
        mockedDriver.when(()-> DriverManager.getConnection(anyString())).thenReturn(connection);
        insertVehicle();
    }


}
