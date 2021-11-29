/*
 * This file is generated by jOOQ.
 */
package com.apress.jooq.generated.tables.records;


import com.apress.jooq.generated.tables.VehicleManufacturer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(
    name = "vehicle_manufacturer",
    schema = "edens_car",
    uniqueConstraints = {
        @UniqueConstraint(name = "KEY_vehicle_manufacturer_manufacturer_name_UNIQUE", columnNames = { "manufacturer_name" })
    }
)
public class VehicleManufacturerRecord extends UpdatableRecordImpl<VehicleManufacturerRecord> implements Record4<Long, String, String, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>edens_car.vehicle_manufacturer.manufacturer_id</code>.
     */
    public void setManufacturerId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>edens_car.vehicle_manufacturer.manufacturer_id</code>.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id", nullable = false, precision = 19)
    public Long getManufacturerId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>edens_car.vehicle_manufacturer.manufacturer_name</code>.
     */
    public void setManufacturerName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>edens_car.vehicle_manufacturer.manufacturer_name</code>.
     */
    @Column(name = "manufacturer_name", nullable = false, length = 250)
    public String getManufacturerName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>edens_car.vehicle_manufacturer.status</code>.
     */
    public void setStatus(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>edens_car.vehicle_manufacturer.status</code>.
     */
    @Column(name = "status", nullable = false, length = 15)
    public String getStatus() {
        return (String) get(2);
    }

    /**
     * Setter for <code>edens_car.vehicle_manufacturer.version</code>.
     */
    public void setVersion(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>edens_car.vehicle_manufacturer.version</code>.
     */
    @Column(name = "version", precision = 19)
    public Long getVersion() {
        return (Long) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, String, Long> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, String, String, Long> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return VehicleManufacturer.VEHICLE_MANUFACTURER.MANUFACTURER_ID;
    }

    @Override
    public Field<String> field2() {
        return VehicleManufacturer.VEHICLE_MANUFACTURER.MANUFACTURER_NAME;
    }

    @Override
    public Field<String> field3() {
        return VehicleManufacturer.VEHICLE_MANUFACTURER.STATUS;
    }

    @Override
    public Field<Long> field4() {
        return VehicleManufacturer.VEHICLE_MANUFACTURER.VERSION;
    }

    @Override
    public Long component1() {
        return getManufacturerId();
    }

    @Override
    public String component2() {
        return getManufacturerName();
    }

    @Override
    public String component3() {
        return getStatus();
    }

    @Override
    public Long component4() {
        return getVersion();
    }

    @Override
    public Long value1() {
        return getManufacturerId();
    }

    @Override
    public String value2() {
        return getManufacturerName();
    }

    @Override
    public String value3() {
        return getStatus();
    }

    @Override
    public Long value4() {
        return getVersion();
    }

    @Override
    public VehicleManufacturerRecord value1(Long value) {
        setManufacturerId(value);
        return this;
    }

    @Override
    public VehicleManufacturerRecord value2(String value) {
        setManufacturerName(value);
        return this;
    }

    @Override
    public VehicleManufacturerRecord value3(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public VehicleManufacturerRecord value4(Long value) {
        setVersion(value);
        return this;
    }

    @Override
    public VehicleManufacturerRecord values(Long value1, String value2, String value3, Long value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VehicleManufacturerRecord
     */
    public VehicleManufacturerRecord() {
        super(VehicleManufacturer.VEHICLE_MANUFACTURER);
    }

    /**
     * Create a detached, initialised VehicleManufacturerRecord
     */
    public VehicleManufacturerRecord(Long manufacturerId, String manufacturerName, String status, Long version) {
        super(VehicleManufacturer.VEHICLE_MANUFACTURER);

        setManufacturerId(manufacturerId);
        setManufacturerName(manufacturerName);
        setStatus(status);
        setVersion(version);
    }

    /**
     * Create a detached, initialised VehicleManufacturerRecord
     */
    public VehicleManufacturerRecord(com.apress.jooq.generated.tables.pojos.VehicleManufacturer value) {
        super(VehicleManufacturer.VEHICLE_MANUFACTURER);

        if (value != null) {
            setManufacturerId(value.getManufacturerId());
            setManufacturerName(value.getManufacturerName());
            setStatus(value.getStatus());
            setVersion(value.getVersion());
        }
    }
}
