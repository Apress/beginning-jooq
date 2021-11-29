package com.apress.jooq.executable;

import com.apress.jooq.connectionprovider.CustomConnectionProvider;
import com.apress.jooq.generated.tables.records.VehicleModelRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static com.apress.jooq.generated.Tables.COMPLETE_CAR_LISTING;
import static com.apress.jooq.generated.Tables.VEHICLE_MODEL;
import static org.jooq.impl.DSL.*;

public class JooqAdvancedQuery {

    static Logger logger = LoggerFactory.getLogger(JooqAdvancedQuery.class.getName());

    public static void group() throws SQLException {
        DSLContext context = DSL.using(new CustomConnectionProvider(), SQLDialect.MYSQL);
        Result<Record2<Object, Integer>> results = context.select(field("brand"), count().as("units"))
                .from(table("complete_car_listing"))
                .groupBy(rollup(field("brand")))
                .having(avg(field("price", BigDecimal.class)).gt(BigDecimal.valueOf(20000L)))
                .fetch();
        logger.info("Grouped results:\n {}", results);

    }

    public static void merge(){
        DSLContext context = DSL.using(new CustomConnectionProvider(), SQLDialect.MYSQL);
        int rows = context.mergeInto(VEHICLE_MODEL)
                .using(selectOne())
                .on(VEHICLE_MODEL.VEHICLE_MODEL_NAME.eq("ES 350"))
                .whenMatchedThenUpdate()
                .set(VEHICLE_MODEL.VEHICLE_STYLE_ID, 3L)
                .set(VEHICLE_MODEL.VEHICLE_MAN_ID, 1L)
                .whenNotMatchedThenInsert(VEHICLE_MODEL.VEHICLE_MODEL_NAME, VEHICLE_MODEL.VEHICLE_MAN_ID, VEHICLE_MODEL.VEHICLE_STYLE_ID)
                .values("ES 350", 3L, 1L)
                .execute();
        logger.info("{} rows merged", rows);

    }

    public static void upsert(){
        DSLContext context = DSL.using(new CustomConnectionProvider(), SQLDialect.MYSQL);
        int rows = context.insertInto(VEHICLE_MODEL, VEHICLE_MODEL.VEHICLE_MODEL_NAME, VEHICLE_MODEL.VEHICLE_MAN_ID, VEHICLE_MODEL.VEHICLE_STYLE_ID)
                .values("ES 350", 2L, 1L)
                .values("ES 350", 2L, 1L)
                .onDuplicateKeyUpdate()
                .set(VEHICLE_MODEL.VEHICLE_STYLE_ID, 2L)
                .set(VEHICLE_MODEL.VEHICLE_MAN_ID, 1L)
                .execute();
        logger.info("{} upserted rows", rows);
    }


    public static void windowFunction() {
        DSLContext context = DSL.using(new CustomConnectionProvider(), SQLDialect.MYSQL);
        Result<Record6<Long, String, String, LocalDate, BigDecimal, Integer>> results = context.select(COMPLETE_CAR_LISTING.VEHICLE_ID,
                        COMPLETE_CAR_LISTING.BRAND,
                        COMPLETE_CAR_LISTING.MODEL,
                        COMPLETE_CAR_LISTING.YEAR,
                        avg(COMPLETE_CAR_LISTING.PRICE).
                                as("avg_price"),
                        rank().over(partitionBy(COMPLETE_CAR_LISTING.BRAND)
                                        .orderBy(avg(COMPLETE_CAR_LISTING.PRICE).asc()))
                                .as("price_rank")
                )
                .from(COMPLETE_CAR_LISTING)
                .groupBy(COMPLETE_CAR_LISTING.BRAND,
                        COMPLETE_CAR_LISTING.MODEL, COMPLETE_CAR_LISTING.VEHICLE_ID)
                .fetch();
        logger.info("Window function query results:\n {}", results);

    }

}
