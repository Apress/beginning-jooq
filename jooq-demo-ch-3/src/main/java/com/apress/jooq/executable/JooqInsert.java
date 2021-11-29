package com.apress.jooq.executable;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class JooqInsert {

    public static void insertVehicleAsSelect() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            context.insertInto(table("vehicle_archive"))
                    .select(DSL.selectFrom("vehicle").where("datediff(date(now()),created) > 365"))
                    .execute();
        }
    }

    public static void insertVehicle() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            context.insertInto(table("vehicle"), field("vehicle_manufacturer"), field("vehicle_curr_price"), field("vehicle_model_year"), field("vehicle_status"), field("vehicle_color"), field("vehicle_model_id"), field("vehicle_trim"), field("vehicle_style"), field("featured"))
                    .values(4, BigDecimal.valueOf(46350.00), LocalDate.parse("2021-01-01"), "ACTIVE", "BLUE", 13, 2, 1, 1)
                    .values(9, BigDecimal.valueOf(83000.00), LocalDate.parse("2021-01-01"), "ACTIVE", "GREY", 9, 7, 1, 1)
                    .values(9, BigDecimal.valueOf(77000.00), LocalDate.parse("2016-01-01"), "ACTIVE", "WHITE", 9, 7, 1, 1)
                    .execute();
        }
    }


}
