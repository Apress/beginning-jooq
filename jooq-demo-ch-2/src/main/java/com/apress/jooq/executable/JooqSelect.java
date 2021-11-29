package com.apress.jooq.executable;

import com.apress.jooq.custom.CompleteVehicleRecord;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.conf.Settings;
import org.jooq.impl.CustomCondition;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.DSL.table;

public class JooqSelect {

    static Logger logger = LoggerFactory.getLogger(JooqSelect.class.getName());

    public static void selectWithGroupByAndHaving() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            Result<Record2<Object, Integer>> results = context.select(field("brand"), count().as("units"))
                    .from(table("complete_car_listing"))
                    .groupBy(rollup(field("brand")))
                    .having(avg(field("price", BigDecimal.class)).gt(BigDecimal.valueOf(20000L)))
                    .fetch();
            logger.info("{}", results);

        }
    }

    public static void selectWithCursor() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            try (final Cursor<Record> records = context.select().from(table("complete_car_listing")).fetchSize(100).fetchLazy()) {
                while (records.hasNext()) {
                    CompleteVehicleRecord completeVehicleRecord = records.fetchNextInto(CompleteVehicleRecord.class);
                }
            }
        }
    }

    public static void selectStream() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            try (final Stream<Record> records = context.select().from(table("complete_car_listing")).fetchSize(100).fetchStream()) {
                records.parallel().forEach(recordList -> {
                    //deal with records
                });
            }
        }
    }

    public static void selectFrom() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            List<CompleteVehicleRecord> allVehicles = context.select().from(table("complete_car_listing")).fetchInto(CompleteVehicleRecord.class);
            logger.info(allVehicles.toString());
        }
    }

    public static void selectField() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            Field brandField = field("brand");
            Field<String> modelField = field("model", String.class);
            Field priceField = field("price", BigDecimal.class);
            List<Field> fieldList = Arrays.asList(brandField, modelField, priceField);
            //List<CompleteVehicleRecord> allVehicles = context.select(field(name("brand")),field("model"),field("price")).from(table("complete_car_listing")).fetchInto(CompleteVehicleRecord.class);
            List<CompleteVehicleRecord> allVehicles =
                    context.select(fieldList)
                            .from(table("complete_car_listing"))
                            .orderBy(field("price").desc())
                            .limit(10)
                            .withTies()
                            .fetchInto(CompleteVehicleRecord.class);
            logger.info(allVehicles.toString());
        }
    }

    public static void selectWhere() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            Condition emptyCondition = DSL.noCondition();

            List<CompleteVehicleRecord> allVehicles = context.select(field(name("brand")), field("model"), field("price")).from(table("complete_car_listing")).where(condition("color = ?", "BLUE")).fetchInto(CompleteVehicleRecord.class);
            logger.info(allVehicles.toString());
        }
    }

    public static void selectCondition() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            Condition colourCondition = condition("color = ?", "BLUE");
            List<CompleteVehicleRecord> allVehicles = context.select(field(name("brand")), field("model"), field("price")).from(table("complete_car_listing")).where(colourCondition).fetchInto(CompleteVehicleRecord.class);
            logger.info(allVehicles.toString());
        }
    }

    public static void selectWithCte() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            Field<BigDecimal> price = field("price", BigDecimal.class);
            Table completeCarListing = table("complete_car_listing");
            Name rowPos = name("rowPos");
            CommonTableExpression<Record1<BigDecimal>> medianCte = name("median_cte").as(context
                    .select(round(avg(price)).as("median"))
                    .from(select(price, rowNumber().over(orderBy(price.asc())).as(rowPos),
                            count().over().as("total_cars"))
                            .from(completeCarListing))
                    .where("rowpos BETWEEN (total_cars / 2.0) AND (total_cars / 2.0 + 1)")
            );
            Result<Record5<Object, Object, Object, Object, String>> results = context.with(medianCte)
                    .select(
                            field("brand"),
                            field("model"),
                            field("trim"),
                            field("price"),
                            concat(round((price.subtract(medianCte.field("median"))).divide(2), 2).multiply(100), field("'%'"))
                                    .as("relative to median price"))
                    .from(completeCarListing, medianCte)
                    .fetch();
            results.forEach(record ->{
                logger.info("Record: {}",record);
            });
        }
    }

    public static void selectWithCase() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            Settings settings = new Settings();
            settings.setExecuteLogging(true);
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL, settings);
            Field<Long> vehicleId = field(name("vehicle_id"), Long.class);
            Field<BigDecimal> vehicleRevisedPrice = field(name("revised_price"), BigDecimal.class);
            Field<BigDecimal> vehicleCurrentPrice = field(name("current_price"), BigDecimal.class);
            context.select(vehicleId, vehicleCurrentPrice, vehicleRevisedPrice, max(field("last_changed")),
                            when((vehicleCurrentPrice.subtract(vehicleRevisedPrice))
                                    .divide(vehicleCurrentPrice)
                                    .multiply(Integer.parseInt("100"))
                                    .lessOrEqual(BigDecimal.valueOf(5)), "OK")
                                    .when(condition("((current_price - revised_price)/current_price)*100 BETWEEN 5 AND 10"), "GOOD")
                                    .when(condition("((current_price - revised_price)/current_price)*100 > 10"), "GREAT")
                                    .otherwise("NO DEAL").as("deal"))
                    .from(table("vehicle_price_change")).where(vehicleRevisedPrice.lessThan(vehicleCurrentPrice))
                    .groupBy(vehicleId)
                    .fetch()
                    .forEach(results -> {
                        logger.info("Available deals:");
                        logger.info("Result: {}", results);
                    });
        }
    }

    public static void selectWithSubquery() throws SQLException {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);

            Field<Long> vehicleId = field(name("vehicle_id"), Long.class);
            Field<BigDecimal> vehicleRevisedPrice = field(name("revised_price"), BigDecimal.class);
            Field<BigDecimal> vehicleCurrentPrice = field(name("current_price"), BigDecimal.class);
            Field<BigDecimal> price = field(name("price"), BigDecimal.class);
            Table vehiclePriceChange = table(name("vehicle_price_change"));
            Field<LocalDateTime> lastPriceUpdate = field(name("last_changed"), LocalDateTime.class);
            final SelectCorrelatedSubqueryStep<Record2<Long, LocalDateTime>> mostRecentPriceChange = context.select(vehicleId, max(lastPriceUpdate)).from(vehiclePriceChange).groupBy(vehicleId);
            final SelectConditionStep<Record2<Long, BigDecimal>> mostRecentPriceReduction = context.select(vehicleId, vehicleRevisedPrice).from(vehiclePriceChange).where(vehicleRevisedPrice.lessThan(vehicleCurrentPrice)).and(row(vehicleId, lastPriceUpdate).in(mostRecentPriceChange));
            SelectConditionStep<Record> potentialDealsQuery = context.select().from(table(name("complete_car_listing"))).where(row(vehicleId, price).in(mostRecentPriceReduction));

            String sql = potentialDealsQuery.getSQL();
            logger.info("The generated SQL: \n" + sql);
            List<CompleteVehicleRecord> potentialDeals = potentialDealsQuery.fetchInto(CompleteVehicleRecord.class);
            logger.info(potentialDeals.toString());
        }
    }

    public static void selectWithOptionalCondition(boolean hasFilter, Map<String, Object> filterValues) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            Condition conditionChainStub = DSL.noCondition();
            CustomCondition customCondition = CustomCondition.of(conditionChain -> {
                conditionChain.sql("color ='BLUE'")
                        .sql(" AND price < 35000");
            });
            if (hasFilter) {
                for (String key : filterValues.keySet()) {
                    conditionChainStub = conditionChainStub.and(field(key).eq(filterValues.get(key)));
                }
            }
            List<CompleteVehicleRecord> allVehicles = context.select().from(table("complete_car_listing")).where(customCondition).fetchInto(CompleteVehicleRecord.class);
            logger.info(allVehicles.toString());
        }
    }

    public static void selectWithFetchMany() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            ResultQuery resultQuery = context.resultQuery("SELECT * FROM edens_car.complete_car_listing");
            resultQuery.fetchMany().forEach(results -> {
                //container for all the results
                results.forEach(record -> {
                    logger.info("New row");
                    logger.info("Brand: {}", record.getValue("brand"));
                    logger.info("Model: {}", record.getValue("model"));
                    logger.info("Trim: {}", record.getValue("trim"));
                    logger.info("Color: {}", record.getValue("color"));
                    logger.info("Style: {}", record.getValue("style"));
                    logger.info("Price: {}", record.getValue("price"));
                });
            });
        }
    }

    public static void basicSelect() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            ResultQuery resultQuery = context.resultQuery("SELECT * FROM edens_car.complete_car_listing");
            List<CompleteVehicleRecord> allVehicles = resultQuery.fetchInto(CompleteVehicleRecord.class);
            logger.info(allVehicles.toString());
        }
    }

}
