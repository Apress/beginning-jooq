package com.apress.jooq;

import com.apress.jooq.generated.tables.pojos.Vehicle;
import com.apress.jooq.generated.tables.pojos.VehicleModel;
import com.apress.jooq.spring.JooqBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers
public class JooqSpringBootTests {

    @Autowired
    JooqBean jooqBean;

    final static String DATABASE_NAME = "edens_car";
    final static String USERNAME = "auserhasnoname";
    final static String PW = "anawfulpasword";

    @Container
    static GenericContainer mySqlContainer = new MySQLContainer(DockerImageName.parse("mysql:latest"))
            .withDatabaseName(DATABASE_NAME)
            .withUsername(USERNAME)
            .withPassword(PW)
            .withEnv("TESTCONTAINERS_CHECKS_DISABLE","true")
            .withExposedPorts(3306);

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        JdbcDatabaseContainer container = (JdbcDatabaseContainer) mySqlContainer;
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @Test
    @Sql("/schema_with_data.sql")
    public void test_springboot_loading(){
        List<VehicleModel> vehicleModels = jooqBean.runJpaJooqSql();
        assertTrue(vehicleModels.size() >= 1);
    }

}
