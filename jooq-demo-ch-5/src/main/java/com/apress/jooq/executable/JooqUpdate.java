package com.apress.jooq.executable;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.ExecuteWithoutWhere;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.DSL.field;

public class JooqUpdate {

    static Logger logger = LoggerFactory.getLogger(JooqUpdate.class.getName());

    public static void updateRowVehicle() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            new Settings().setExecuteUpdateWithoutWhere(ExecuteWithoutWhere.THROW);
            context.update(table("vehicle_archive"))
                    .set(row(field("featured"), field("vehicle_status")),
                            row(0, "ARCHIVED"))
                    .where(row(field("vehicle_status"), field("featured")).eq(row("ACTIVE", 1)))
                    .execute();
        }
    }

    public static void updateVehicle() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            Settings settings = new Settings();
            settings.setExecuteUpdateWithoutWhere(ExecuteWithoutWhere.THROW);
            Configuration configuration = new DefaultConfiguration();
            configuration.set(SQLDialect.MYSQL);
            configuration.set(connection);
            configuration.set(settings);
            DSLContext context = DSL.using(configuration);
            context.update(table("vehicle"))
                    .set(field("featured"), false)
                    .where(field("vehicle_id").eq(7))
                    .execute();
        }
    }
}
