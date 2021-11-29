/*
 * This file is generated by jOOQ.
 */
package com.apress.jooq.generated;


import com.apress.jooq.generated.tables.CompleteCarListing;
import com.apress.jooq.generated.tables.Vehicle;
import com.apress.jooq.generated.tables.VehicleArchive;
import com.apress.jooq.generated.tables.VehicleManufacturer;
import com.apress.jooq.generated.tables.VehicleModel;
import com.apress.jooq.generated.tables.VehiclePriceChange;
import com.apress.jooq.generated.tables.VehicleStyle;
import com.apress.jooq.generated.tables.VehicleTrim;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EdensCar extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>edens_car</code>
     */
    public static final EdensCar EDENS_CAR = new EdensCar();

    /**
     * VIEW
     */
    public final CompleteCarListing COMPLETE_CAR_LISTING = CompleteCarListing.COMPLETE_CAR_LISTING;

    /**
     * The table <code>edens_car.vehicle</code>.
     */
    public final Vehicle VEHICLE = Vehicle.VEHICLE;

    /**
     * The table <code>edens_car.vehicle_archive</code>.
     */
    public final VehicleArchive VEHICLE_ARCHIVE = VehicleArchive.VEHICLE_ARCHIVE;

    /**
     * The table <code>edens_car.vehicle_manufacturer</code>.
     */
    public final VehicleManufacturer VEHICLE_MANUFACTURER = VehicleManufacturer.VEHICLE_MANUFACTURER;

    /**
     * The table <code>edens_car.vehicle_model</code>.
     */
    public final VehicleModel VEHICLE_MODEL = VehicleModel.VEHICLE_MODEL;

    /**
     * The table <code>edens_car.vehicle_price_change</code>.
     */
    public final VehiclePriceChange VEHICLE_PRICE_CHANGE = VehiclePriceChange.VEHICLE_PRICE_CHANGE;

    /**
     * The table <code>edens_car.vehicle_style</code>.
     */
    public final VehicleStyle VEHICLE_STYLE = VehicleStyle.VEHICLE_STYLE;

    /**
     * The table <code>edens_car.vehicle_trim</code>.
     */
    public final VehicleTrim VEHICLE_TRIM = VehicleTrim.VEHICLE_TRIM;

    /**
     * No further instances allowed
     */
    private EdensCar() {
        super("edens_car", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            CompleteCarListing.COMPLETE_CAR_LISTING,
            Vehicle.VEHICLE,
            VehicleArchive.VEHICLE_ARCHIVE,
            VehicleManufacturer.VEHICLE_MANUFACTURER,
            VehicleModel.VEHICLE_MODEL,
            VehiclePriceChange.VEHICLE_PRICE_CHANGE,
            VehicleStyle.VEHICLE_STYLE,
            VehicleTrim.VEHICLE_TRIM
        );
    }
}