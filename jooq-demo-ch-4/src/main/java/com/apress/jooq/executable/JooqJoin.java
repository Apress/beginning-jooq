package com.apress.jooq.executable;

import com.apress.jooq.generated.tables.pojos.CompleteCarListing;
import com.apress.jooq.generated.tables.pojos.VehicleManufacturer;
import com.apress.jooq.generated.tables.records.VehicleManufacturerRecord;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.apress.jooq.generated.Tables.*;
import static com.apress.jooq.generated.Tables.VEHICLE_STYLE;

public class JooqJoin {
    static Logger logger = LoggerFactory.getLogger(JooqJoin.class.getName());

    public static void mapStreamJoin() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            List<Field<?>> fields = Arrays.asList(
                    VEHICLE.VEHICLE_ID,
                    VEHICLE_MANUFACTURER.MANUFACTURER_NAME.as("brand"),
                    VEHICLE_MODEL.VEHICLE_MODEL_NAME.as("model"),
                    VEHICLE_TRIM.TRIM_NAME.as("trim"),
                    VEHICLE.VEHICLE_CURR_PRICE.as("price"),
                    VEHICLE.VEHICLE_COLOR.as("color"),
                    VEHICLE_STYLE.VEHICLE_STYLE_NAME.as("style"),
                    VEHICLE.VEHICLE_MODEL_YEAR.as("year"),
                    VEHICLE.FEATURED);

            Map<VehicleManufacturer, List<CompleteCarListing>> vehiclesGroupedByBrand = context
                    .select(VEHICLE_MANUFACTURER.fields())
                    .select(fields)
                    .from(VEHICLE)
                    .join(VEHICLE_MANUFACTURER).on(VEHICLE.VEHICLE_MANUFACTURER.eq(VEHICLE_MANUFACTURER.MANUFACTURER_ID))
                    .join(VEHICLE_MODEL).on(VEHICLE.VEHICLE_MODEL_ID.eq(VEHICLE_MODEL.VEHICLE_MODEL_ID))
                    .join(VEHICLE_TRIM).onKey()
                    .join(VEHICLE_STYLE).on(VEHICLE.VEHICLE_STYLE.eq(VEHICLE_STYLE.VEHICLE_STYLE_ID))
                    .fetchSize(100)
                    .fetchLazy()
                    .collect(
                            Collectors.groupingBy(record -> record.into(VehicleManufacturer.class), Collectors.mapping(record -> record.into(CompleteCarListing.class), Collectors.toList()))
                    );

            logger.info("{}", vehiclesGroupedByBrand);

        }
    }

    public static void mapJoin() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            List<Field<?>> fields = Arrays.asList(
                    VEHICLE.VEHICLE_ID,
                    VEHICLE_MANUFACTURER.MANUFACTURER_NAME.as("brand"),
                    VEHICLE_MODEL.VEHICLE_MODEL_NAME.as("model"),
                    VEHICLE_TRIM.TRIM_NAME.as("trim"),
                    VEHICLE.VEHICLE_CURR_PRICE.as("price"),
                    VEHICLE.VEHICLE_COLOR.as("color"),
                    VEHICLE_STYLE.VEHICLE_STYLE_NAME.as("style"),
                    VEHICLE.VEHICLE_MODEL_YEAR.as("year"),
                    VEHICLE.FEATURED);

            Map<VehicleManufacturer, List<CompleteCarListing>> vehiclesGroupedByBrand = context
                    .select(VEHICLE_MANUFACTURER.fields())
                    .select(fields)
                    .from(VEHICLE)
                    .join(VEHICLE_MANUFACTURER).on(VEHICLE.VEHICLE_MANUFACTURER.eq(VEHICLE_MANUFACTURER.MANUFACTURER_ID))
                    .join(VEHICLE_MODEL).on(VEHICLE.VEHICLE_MODEL_ID.eq(VEHICLE_MODEL.VEHICLE_MODEL_ID))
                    .join(VEHICLE_TRIM).onKey()
                    .join(VEHICLE_STYLE).on(VEHICLE.VEHICLE_STYLE.eq(VEHICLE_STYLE.VEHICLE_STYLE_ID))
                    .fetchGroups(keyRecord -> {
                        return keyRecord.into(VEHICLE_MANUFACTURER).into(VehicleManufacturer.class);
                    }, valueRecord -> {
                        return valueRecord.into(COMPLETE_CAR_LISTING).into(CompleteCarListing.class);
                    });

            vehiclesGroupedByBrand.forEach((manufacturer, vehicles) -> {
                logger.info("Available {} vehicles (record mapper grouping): \n {}", manufacturer, vehicles);
            });

            Map<VehicleManufacturerRecord, Result<Record>> vehiclesGroupedByBrandv2 = context.select(VEHICLE_MANUFACTURER.fields())
                    .select(fields)
                    .from(VEHICLE)
                    .join(VEHICLE_MANUFACTURER).on(VEHICLE.VEHICLE_MANUFACTURER.eq(VEHICLE_MANUFACTURER.MANUFACTURER_ID))
                    .join(VEHICLE_MODEL).on(VEHICLE.VEHICLE_MODEL_ID.eq(VEHICLE_MODEL.VEHICLE_MODEL_ID))
                    .join(VEHICLE_TRIM).onKey()
                    .join(VEHICLE_STYLE).on(VEHICLE.VEHICLE_STYLE.eq(VEHICLE_STYLE.VEHICLE_STYLE_ID))
                    .fetchGroups(VEHICLE_MANUFACTURER);

            vehiclesGroupedByBrandv2.forEach((manufacturer, vehicles) ->{
                logger.info("Available {} vehicles (simpler grouping): \n {}",manufacturer,vehicles);
            });

        }
    }

    public static void join() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/edens_car?user=root&password=admin")) {
            DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
            List<Field<?>> fields = Arrays.asList(
                    VEHICLE.VEHICLE_ID,
                    VEHICLE_MANUFACTURER.MANUFACTURER_NAME.as("brand"),
                    VEHICLE_MODEL.VEHICLE_MODEL_NAME.as("model"),
                    VEHICLE_TRIM.TRIM_NAME.as("trim"),
                    VEHICLE.VEHICLE_CURR_PRICE.as("price"),
                    VEHICLE.VEHICLE_COLOR.as("color"),
                    VEHICLE_STYLE.VEHICLE_STYLE_NAME.as("style"),
                    VEHICLE.VEHICLE_MODEL_YEAR.as("year"),
                    VEHICLE.FEATURED);

            Result<Record> results = context.selectDistinct(fields).from(VEHICLE)
                    .innerJoin(VEHICLE_MANUFACTURER).on(VEHICLE.VEHICLE_MANUFACTURER.eq(VEHICLE_MANUFACTURER.MANUFACTURER_ID))
                    .join(VEHICLE_MODEL).on(VEHICLE.VEHICLE_MODEL_ID.eq(VEHICLE_MODEL.VEHICLE_MODEL_ID))
                    .join(VEHICLE_TRIM).onKey()
                    .join(VEHICLE_STYLE).on(VEHICLE.VEHICLE_STYLE.eq(VEHICLE_STYLE.VEHICLE_STYLE_ID))
                            .fetch();
            logger.info("Join results (on):{}",results);
        }

    }

}
