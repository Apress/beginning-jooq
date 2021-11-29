package com.apress.jooq.executable;

import org.jooq.*;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.jooq.impl.DSL.*;

public class JooqLocking {

    static Logger logger = LoggerFactory.getLogger(JooqLocking.class.getName());

    public static void selectWithLockingForUpdate(int vehicleId, BigDecimal price) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL,new Settings().withRenderFormatted(true));
            Table vehicleTable = table("vehicle");
            Field<BigDecimal> vehicleCurrentPrice = field("vehicle_curr_price", BigDecimal.class);
            Condition vehicleCondition = condition("vehicle_id = ?", vehicleId);
            Result result = context.select(vehicleCurrentPrice)
                    .from(vehicleTable)
                    .where(vehicleCondition)
                    .forUpdate()
                    .wait(3000)
                    .fetch();
            int rows = context.update(vehicleTable).set(vehicleCurrentPrice, price).where(vehicleCondition).returning().execute();
            logger.info("Update with lock complete. Rows affected: {}", rows);
        }
    }

    public static void selectWithLockingForShare(int vehicleId, BigDecimal price) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            Table vehicleTable = table("vehicle");
            Field<BigDecimal> vehicleCurrentPrice = field("vehicle_curr_price", BigDecimal.class);
            Condition vehicleCondition = condition("vehicle_id = ?", vehicleId);
            Result result = context.select(vehicleCurrentPrice)
                    .from(vehicleTable)
                    .where(vehicleCondition)
                    .forShare()
                    .wait(2000)
                    .fetch();
            int rows = context.update(vehicleTable).set(vehicleCurrentPrice, price).where(vehicleCondition).returning().execute();
            logger.info("Update with lock complete. Rows affected: {}", rows);
        }
    }
}
