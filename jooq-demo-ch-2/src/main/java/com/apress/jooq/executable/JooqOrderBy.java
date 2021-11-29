package com.apress.jooq.executable;

import com.apress.jooq.custom.CompleteVehicleRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.DSL.name;

public class JooqOrderBy {

    public static void selectWithOrderByCase() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            List<CompleteVehicleRecord> allVehicles = context
                    .select(field(name("brand")), field("model"), field("price"))
                    .from(table("complete_car_listing"))
                    .orderBy(
                            case_(field("featured"))
                                    .when(true, 0)
                                    .otherwise(1))
                    .fetchInto(CompleteVehicleRecord.class);
        }
    }

    public static void selectWithOrderByLimit() throws SQLException{
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            List<CompleteVehicleRecord> allVehicles = context.select(field(name("brand")), field("model"), field("price"))
                    .from(table("complete_car_listing"))
                    .orderBy(field("year").asc().nullsLast(), two())
                    .limit(10)
                    .withTies()
                    .fetchInto(CompleteVehicleRecord.class);
        }
    }

    public static void selectWithOrderByOffset() throws SQLException{
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            List<CompleteVehicleRecord> allVehicles = context.select(field(name("brand")), field("model"), field("price"))
                    .from(table("complete_car_listing"))
                    .orderBy(field("year").asc().nullsLast(), two())
                    .offset(2)
                    .limit(10)
                    .fetchInto(CompleteVehicleRecord.class);
        }
    }

    public static void selectWithOrderBy() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            List<CompleteVehicleRecord> allVehicles = context.select(field(name("brand")), field("model"), field("price"))
                    .from(table("complete_car_listing"))
                    .orderBy(field("year").asc().nullsLast(), two())
                    .fetchInto(CompleteVehicleRecord.class);
        }
    }

    public static void selectWithOrderByMap() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            HashMap<String, Integer> sortMap = new HashMap<>();
            sortMap.put("Toyota", Integer.valueOf(0));
            sortMap.put("Acura", Integer.valueOf(5));

            List<CompleteVehicleRecord> allVehicles = context
                    .select(field(name("brand")), field("model"), field("price"))
                    .from(table("complete_car_listing"))
                    .orderBy(field(name("brand"), String.class).sort(sortMap))
                    .fetchInto(CompleteVehicleRecord.class);
        }
    }

}
