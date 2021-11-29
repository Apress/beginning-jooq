package com.apress.jooq.executable;

import com.apress.jooq.connectionprovider.CustomConnectionProvider;
import com.apress.jooq.generated.tables.records.VehicleRecord;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import static com.apress.jooq.generated.Tables.VEHICLE;

public class JooqBatch {
    public static void bulkImport() {
        DSLContext context = DSL.using(new CustomConnectionProvider(), SQLDialect.MYSQL);
        Result<Record> results = context.select().from(VEHICLE).fetch();
        String csv = results.formatCSV();
        context.transaction(txn -> {
            context.loadInto(VEHICLE)
                    .bulkAfter(50)
                    .batchAfter(10)
                    .commitAfter(2)
                    .loadCSV(csv)
                    .fields(VEHICLE.fields())
                    .ignoreRows(1)
                    .separator(',')
                    .nullString("")
                    .execute();
        });
    }

    public static void batchChangedVehicleRecord() {
        DSLContext context = DSL.using(new CustomConnectionProvider(), SQLDialect.MYSQL);
        VehicleRecord vehicleRecord1 = context.newRecord(VEHICLE);
        VehicleRecord vehicleRecord2 = context.newRecord(VEHICLE);
        VehicleRecord vehicleRecord3 = context.newRecord(VEHICLE);

        vehicleRecord1.setVehicleColor(null);
        vehicleRecord1.setVehicleManufacturer(3l);
        vehicleRecord1.setVehicleStyle(2l);
        vehicleRecord1.setVehicleCurrPrice(BigDecimal.valueOf(64500));
        vehicleRecord1.setVehicleModelId(3l);
        vehicleRecord1.setVehicleStatus("ACTIVE");
        vehicleRecord1.setVehicleTrim(3l);
        vehicleRecord1.setVehicleModelYear(LocalDate.now());
        vehicleRecord1.changed(true);
        vehicleRecord2.setVehicleColor("GREY");
        vehicleRecord2.setVehicleManufacturer(4l);
        vehicleRecord2.setVehicleCurrPrice(BigDecimal.valueOf(83530));
        vehicleRecord2.setVehicleStatus("ACTIVE");
        vehicleRecord2.setVehicleModelId(3l);
        vehicleRecord2.setVehicleTrim(3l);
        vehicleRecord2.setVehicleModelYear(LocalDate.now());
        vehicleRecord2.changed(true);
        vehicleRecord3.setVehicleManufacturer(2l);
        vehicleRecord3.setVehicleColor("RED");
        vehicleRecord3.setVehicleCurrPrice(BigDecimal.valueOf(22050));
        vehicleRecord3.setVehicleStatus("ACTIVE");
        vehicleRecord3.setVehicleModelId(3l);
        vehicleRecord3.setVehicleTrim(3l);
        vehicleRecord3.setVehicleModelYear(LocalDate.now());
        vehicleRecord3.changed(true);
        context.batchInsert(Arrays.asList(vehicleRecord1, vehicleRecord2, vehicleRecord3)).execute();
    }

    public static void batchInsertVehicle() {
        DSLContext context = DSL.using(new CustomConnectionProvider(), SQLDialect.MYSQL);
        context.batch(
                        context.insertInto(VEHICLE, VEHICLE.VEHICLE_MANUFACTURER, VEHICLE.VEHICLE_CURR_PRICE, VEHICLE.VEHICLE_MODEL_YEAR, VEHICLE.VEHICLE_STATUS, VEHICLE.VEHICLE_COLOR, VEHICLE.VEHICLE_MODEL_ID, VEHICLE.VEHICLE_TRIM, VEHICLE.VEHICLE_STYLE, VEHICLE.FEATURED)
                                .values((Long) null, (BigDecimal) null, null, null, null, (Long) null, (Long) null, (Long) null, (Byte) null))
                .bind(4L, 46350.00, null, "ACTIVE", "BLUE", 13L, 2L, 1L, Byte.valueOf("0"))
                .bind(9L, 83000.00, null, "ACTIVE", "GREY", 9L, 7L, 1L, Byte.valueOf("0"))
                .bind(9L, 77000.00, null, "ACTIVE", null, 9L, 7L, 1L, Byte.valueOf("0"))
                .execute();
    }
}
