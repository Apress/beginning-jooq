/*
 * This file is generated by jOOQ.
 */
package com.apress.jooq.generated.tables.records;


import com.apress.jooq.generated.tables.CompleteCarListing;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * VIEW
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(
    name = "complete_car_listing",
    schema = "edens_car"
)
public class CompleteCarListingRecord extends UpdatableRecordImpl<CompleteCarListingRecord> implements Record9<Long, String, String, String, BigDecimal, String, String, LocalDate, Byte> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>edens_car.complete_car_listing.vehicle_id</code>.
     */
    public void setVehicleId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.vehicle_id</code>.
     */
    @Id
    @Column(name = "vehicle_id", nullable = false, precision = 19)
    public Long getVehicleId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.brand</code>.
     */
    public void setBrand(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.brand</code>.
     */
    @Column(name = "brand", nullable = false, length = 250)
    public String getBrand() {
        return (String) get(1);
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.model</code>.
     */
    public void setModel(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.model</code>.
     */
    @Column(name = "model", nullable = false, length = 250)
    public String getModel() {
        return (String) get(2);
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.trim</code>.
     */
    public void setTrim(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.trim</code>.
     */
    @Column(name = "trim", nullable = false, length = 35)
    public String getTrim() {
        return (String) get(3);
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.price</code>.
     */
    public void setPrice(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.price</code>.
     */
    @Column(name = "price", nullable = false, precision = 15, scale = 4)
    public BigDecimal getPrice() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.color</code>.
     */
    public void setColor(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.color</code>.
     */
    @Column(name = "color", length = 35)
    public String getColor() {
        return (String) get(5);
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.style</code>.
     */
    public void setStyle(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.style</code>.
     */
    @Column(name = "style", nullable = false, length = 35)
    public String getStyle() {
        return (String) get(6);
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.year</code>.
     */
    public void setYear(LocalDate value) {
        set(7, value);
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.year</code>.
     */
    @Column(name = "year")
    public LocalDate getYear() {
        return (LocalDate) get(7);
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.featured</code>.
     */
    public void setFeatured(Byte value) {
        set(8, value);
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.featured</code>.
     */
    @Column(name = "featured", precision = 3)
    public Byte getFeatured() {
        return (Byte) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, String, String, String, BigDecimal, String, String, LocalDate, Byte> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Long, String, String, String, BigDecimal, String, String, LocalDate, Byte> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return CompleteCarListing.COMPLETE_CAR_LISTING.VEHICLE_ID;
    }

    @Override
    public Field<String> field2() {
        return CompleteCarListing.COMPLETE_CAR_LISTING.BRAND;
    }

    @Override
    public Field<String> field3() {
        return CompleteCarListing.COMPLETE_CAR_LISTING.MODEL;
    }

    @Override
    public Field<String> field4() {
        return CompleteCarListing.COMPLETE_CAR_LISTING.TRIM;
    }

    @Override
    public Field<BigDecimal> field5() {
        return CompleteCarListing.COMPLETE_CAR_LISTING.PRICE;
    }

    @Override
    public Field<String> field6() {
        return CompleteCarListing.COMPLETE_CAR_LISTING.COLOR;
    }

    @Override
    public Field<String> field7() {
        return CompleteCarListing.COMPLETE_CAR_LISTING.STYLE;
    }

    @Override
    public Field<LocalDate> field8() {
        return CompleteCarListing.COMPLETE_CAR_LISTING.YEAR;
    }

    @Override
    public Field<Byte> field9() {
        return CompleteCarListing.COMPLETE_CAR_LISTING.FEATURED;
    }

    @Override
    public Long component1() {
        return getVehicleId();
    }

    @Override
    public String component2() {
        return getBrand();
    }

    @Override
    public String component3() {
        return getModel();
    }

    @Override
    public String component4() {
        return getTrim();
    }

    @Override
    public BigDecimal component5() {
        return getPrice();
    }

    @Override
    public String component6() {
        return getColor();
    }

    @Override
    public String component7() {
        return getStyle();
    }

    @Override
    public LocalDate component8() {
        return getYear();
    }

    @Override
    public Byte component9() {
        return getFeatured();
    }

    @Override
    public Long value1() {
        return getVehicleId();
    }

    @Override
    public String value2() {
        return getBrand();
    }

    @Override
    public String value3() {
        return getModel();
    }

    @Override
    public String value4() {
        return getTrim();
    }

    @Override
    public BigDecimal value5() {
        return getPrice();
    }

    @Override
    public String value6() {
        return getColor();
    }

    @Override
    public String value7() {
        return getStyle();
    }

    @Override
    public LocalDate value8() {
        return getYear();
    }

    @Override
    public Byte value9() {
        return getFeatured();
    }

    @Override
    public CompleteCarListingRecord value1(Long value) {
        setVehicleId(value);
        return this;
    }

    @Override
    public CompleteCarListingRecord value2(String value) {
        setBrand(value);
        return this;
    }

    @Override
    public CompleteCarListingRecord value3(String value) {
        setModel(value);
        return this;
    }

    @Override
    public CompleteCarListingRecord value4(String value) {
        setTrim(value);
        return this;
    }

    @Override
    public CompleteCarListingRecord value5(BigDecimal value) {
        setPrice(value);
        return this;
    }

    @Override
    public CompleteCarListingRecord value6(String value) {
        setColor(value);
        return this;
    }

    @Override
    public CompleteCarListingRecord value7(String value) {
        setStyle(value);
        return this;
    }

    @Override
    public CompleteCarListingRecord value8(LocalDate value) {
        setYear(value);
        return this;
    }

    @Override
    public CompleteCarListingRecord value9(Byte value) {
        setFeatured(value);
        return this;
    }

    @Override
    public CompleteCarListingRecord values(Long value1, String value2, String value3, String value4, BigDecimal value5, String value6, String value7, LocalDate value8, Byte value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CompleteCarListingRecord
     */
    public CompleteCarListingRecord() {
        super(CompleteCarListing.COMPLETE_CAR_LISTING);
    }

    /**
     * Create a detached, initialised CompleteCarListingRecord
     */
    public CompleteCarListingRecord(Long vehicleId, String brand, String model, String trim, BigDecimal price, String color, String style, LocalDate year, Byte featured) {
        super(CompleteCarListing.COMPLETE_CAR_LISTING);

        setVehicleId(vehicleId);
        setBrand(brand);
        setModel(model);
        setTrim(trim);
        setPrice(price);
        setColor(color);
        setStyle(style);
        setYear(year);
        setFeatured(featured);
    }

    /**
     * Create a detached, initialised CompleteCarListingRecord
     */
    public CompleteCarListingRecord(com.apress.jooq.generated.tables.pojos.CompleteCarListing value) {
        super(CompleteCarListing.COMPLETE_CAR_LISTING);

        if (value != null) {
            setVehicleId(value.getVehicleId());
            setBrand(value.getBrand());
            setModel(value.getModel());
            setTrim(value.getTrim());
            setPrice(value.getPrice());
            setColor(value.getColor());
            setStyle(value.getStyle());
            setYear(value.getYear());
            setFeatured(value.getFeatured());
        }
    }
}
