/*
 * This file is generated by jOOQ.
 */
package com.apress.jooq.generated.tables;


import com.apress.jooq.generated.EdensCar;
import com.apress.jooq.generated.Indexes;
import com.apress.jooq.generated.Keys;
import com.apress.jooq.generated.tables.records.VehiclePriceChangeRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VehiclePriceChange extends TableImpl<VehiclePriceChangeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>edens_car.vehicle_price_change</code>
     */
    public static final VehiclePriceChange VEHICLE_PRICE_CHANGE = new VehiclePriceChange();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VehiclePriceChangeRecord> getRecordType() {
        return VehiclePriceChangeRecord.class;
    }

    /**
     * The column <code>edens_car.vehicle_price_change.price_change_id</code>.
     */
    public final TableField<VehiclePriceChangeRecord, Long> PRICE_CHANGE_ID = createField(DSL.name("price_change_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>edens_car.vehicle_price_change.vehicle_id</code>.
     */
    public final TableField<VehiclePriceChangeRecord, Long> VEHICLE_ID = createField(DSL.name("vehicle_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>edens_car.vehicle_price_change.current_price</code>.
     */
    public final TableField<VehiclePriceChangeRecord, BigDecimal> CURRENT_PRICE = createField(DSL.name("current_price"), SQLDataType.DECIMAL(10, 4).nullable(false), this, "");

    /**
     * The column <code>edens_car.vehicle_price_change.revised_price</code>.
     */
    public final TableField<VehiclePriceChangeRecord, BigDecimal> REVISED_PRICE = createField(DSL.name("revised_price"), SQLDataType.DECIMAL(10, 4).nullable(false), this, "");

    /**
     * The column <code>edens_car.vehicle_price_change.last_changed</code>.
     */
    public final TableField<VehiclePriceChangeRecord, LocalDateTime> LAST_CHANGED = createField(DSL.name("last_changed"), SQLDataType.LOCALDATETIME(0).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>edens_car.vehicle_price_change.version</code>.
     */
    public final TableField<VehiclePriceChangeRecord, Long> VERSION = createField(DSL.name("version"), SQLDataType.BIGINT, this, "");

    private VehiclePriceChange(Name alias, Table<VehiclePriceChangeRecord> aliased) {
        this(alias, aliased, null);
    }

    private VehiclePriceChange(Name alias, Table<VehiclePriceChangeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>edens_car.vehicle_price_change</code> table
     * reference
     */
    public VehiclePriceChange(String alias) {
        this(DSL.name(alias), VEHICLE_PRICE_CHANGE);
    }

    /**
     * Create an aliased <code>edens_car.vehicle_price_change</code> table
     * reference
     */
    public VehiclePriceChange(Name alias) {
        this(alias, VEHICLE_PRICE_CHANGE);
    }

    /**
     * Create a <code>edens_car.vehicle_price_change</code> table reference
     */
    public VehiclePriceChange() {
        this(DSL.name("vehicle_price_change"), null);
    }

    public <O extends Record> VehiclePriceChange(Table<O> child, ForeignKey<O, VehiclePriceChangeRecord> key) {
        super(child, key, VEHICLE_PRICE_CHANGE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : EdensCar.EDENS_CAR;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.VEHICLE_PRICE_CHANGE_VEHICLE_ID_CHANGED_IDX);
    }

    @Override
    public Identity<VehiclePriceChangeRecord, Long> getIdentity() {
        return (Identity<VehiclePriceChangeRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<VehiclePriceChangeRecord> getPrimaryKey() {
        return Keys.KEY_VEHICLE_PRICE_CHANGE_PRIMARY;
    }

    @Override
    public List<ForeignKey<VehiclePriceChangeRecord, ?>> getReferences() {
        return Arrays.asList(Keys.VEHICLE_ID_CHANGED);
    }

    private transient Vehicle _vehicle;

    public Vehicle vehicle() {
        if (_vehicle == null)
            _vehicle = new Vehicle(this, Keys.VEHICLE_ID_CHANGED);

        return _vehicle;
    }

    @Override
    public VehiclePriceChange as(String alias) {
        return new VehiclePriceChange(DSL.name(alias), this);
    }

    @Override
    public VehiclePriceChange as(Name alias) {
        return new VehiclePriceChange(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public VehiclePriceChange rename(String name) {
        return new VehiclePriceChange(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public VehiclePriceChange rename(Name name) {
        return new VehiclePriceChange(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, Long, BigDecimal, BigDecimal, LocalDateTime, Long> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}