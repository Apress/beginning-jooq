package com.apress.jooq.executable;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.ExecuteWithoutWhere;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.jooq.impl.DSL.*;

public class JooqDelete {


    public static void deleteRowVehicle() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            Settings settings = new Settings();
            settings.setExecuteDeleteWithoutWhere(ExecuteWithoutWhere.THROW);
            Configuration configuration = new DefaultConfiguration();
            configuration.set(SQLDialect.MYSQL);
            configuration.set(connection);
            configuration.set(settings);
            DSLContext context = DSL.using(configuration);
            context.deleteFrom(table("vehicle_archive"))
                    .where(field("vehicle_id").eq(7))
                    .execute();
        }
    }
}
