package com.apress.jooq.executable.generate;

import com.apress.jooq.connectionprovider.CustomConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.codegen.GenerationTool;
import org.jooq.impl.DSL;
import org.jooq.meta.jaxb.*;

import javax.xml.bind.JAXB;
import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static com.apress.jooq.generated.Tables.VEHICLE;

public class JooqGenerator {

    public static void generateCodeWithConfigFile() throws Exception {
        org.jooq.meta.jaxb.Configuration generatorConfiguration = JAXB.unmarshal(new File("src/main/resources/jooq-configuration.xml"), org.jooq.meta.jaxb.Configuration.class);
        GenerationTool.generate(generatorConfiguration);
    }

    public static void generateCodeWithCode(String jdbcUrl, String userName, String password) throws Exception {
        org.jooq.meta.jaxb.Configuration generatorConfiguration = new org.jooq.meta.jaxb.Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("com.mysql.cj.jdbc.Driver")
                        .withUrl(jdbcUrl)
                        .withUsername("root").withPassword("admin"))
                .withGenerator(new Generator()
                        .withName("org.jooq.codegen.JavaGenerator")
                        .withDatabase(new Database()
                                .withName("org.jooq.meta.mysql.MySQLDatabase")
                                .withInputSchema("edens_car")
                                .withIncludeTables(true)
                                .withIncludes(".*")
                                .withRecordVersionFields("edens_car\\.*\\.version")
                                .withSyntheticPrimaryKeys("edens_car.complete_car_listing.vehicle_id"))
                        .withGenerate(new Generate()
                                .withJpaAnnotations(true)
                                .withJavaTimeTypes(true)
                                .withJavaBeansGettersAndSetters(true)
                                .withDaos(true)
                                .withPojos(true)
                                .withPojosEqualsAndHashCode(true)
                                .withPojosToString(true))
                        .withTarget(new Target()
                                .withClean(true)
                                .withDirectory("target/generated-sources/java")
                                .withEncoding(StandardCharsets.UTF_8.toString())
                                .withPackageName("com.apress.jooq.generated")
                        ))
                .withLogging(Logging.DEBUG)
                .withOnError(OnError.LOG);

        GenerationTool.generate(generatorConfiguration);
    }

    public static void generateCodeWithCode() throws Exception {
        org.jooq.meta.jaxb.Configuration generatorConfiguration = new org.jooq.meta.jaxb.Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("com.mysql.cj.jdbc.Driver")
                        .withUrl("jdbc:mysql://localhost/edens_car")
                        .withUsername("root").withPassword("admin"))
                .withGenerator(new Generator()
                        .withName("org.jooq.codegen.JavaGenerator")
                        .withDatabase(new Database()
                                .withName("org.jooq.meta.mysql.MySQLDatabase")
                                .withInputSchema("edens_car")
                                .withIncludeTables(true)
                                .withIncludes(".*")
                                .withRecordVersionFields("edens_car\\.*\\.version")
                                .withSyntheticPrimaryKeys("edens_car.complete_car_listing.vehicle_id"))
                        .withGenerate(new Generate()
                                .withJavaTimeTypes(true)
                                .withJavaBeansGettersAndSetters(true)
                                .withDaos(true)
                                .withPojos(true)
                                .withPojosEqualsAndHashCode(true)
                                .withPojosToString(true))
                        .withTarget(new Target()
                                .withClean(true)
                                .withDirectory("target/generated-sources/java")
                                .withEncoding(StandardCharsets.UTF_8.toString())
                                .withPackageName("com.apress.jooq.generated")
                        ))
                .withLogging(Logging.DEBUG)
                .withOnError(OnError.LOG);

        GenerationTool.generate(generatorConfiguration);
    }

    public static void insertGeneratedVehicle() {
        DSLContext context = DSL.using(new CustomConnectionProvider(), SQLDialect.MYSQL);
        long execute = context.insertInto(VEHICLE, VEHICLE.VEHICLE_MANUFACTURER, VEHICLE.VEHICLE_CURR_PRICE, VEHICLE.VEHICLE_MODEL_YEAR, VEHICLE.VEHICLE_STATUS, VEHICLE.VEHICLE_COLOR, VEHICLE.VEHICLE_MODEL_ID, VEHICLE.VEHICLE_TRIM, VEHICLE.VEHICLE_STYLE)
                .values(4L, BigDecimal.valueOf(46350.00), LocalDate.parse("2021-01-01"), "ACTIVE", "BLUE", 13L, 2L, 1L)
                .returningResult(VEHICLE.VEHICLE_ID)
                .execute();
    }

}
