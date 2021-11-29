/*
 * This file is generated by jOOQ.
 */
package com.apress.jooq.generated.tables.daos;


import com.apress.jooq.generated.tables.Vehicle;
import com.apress.jooq.generated.tables.records.VehicleRecord;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class VehicleDao extends DAOImpl<VehicleRecord, com.apress.jooq.generated.tables.pojos.Vehicle, Long> {

    /**
     * Create a new VehicleDao without any configuration
     */
    public VehicleDao() {
        super(Vehicle.VEHICLE, com.apress.jooq.generated.tables.pojos.Vehicle.class);
    }

    /**
     * Create a new VehicleDao with an attached configuration
     */
    @Autowired
    public VehicleDao(Configuration configuration) {
        super(Vehicle.VEHICLE, com.apress.jooq.generated.tables.pojos.Vehicle.class, configuration);
    }

    @Override
    public Long getId(com.apress.jooq.generated.tables.pojos.Vehicle object) {
        return object.getVehicleId();
    }

    /**
     * Fetch records that have <code>vehicle_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfVehicleId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.VEHICLE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_id IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByVehicleId(Long... values) {
        return fetch(Vehicle.VEHICLE.VEHICLE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>vehicle_id = value</code>
     */
    public com.apress.jooq.generated.tables.pojos.Vehicle fetchOneByVehicleId(Long value) {
        return fetchOne(Vehicle.VEHICLE.VEHICLE_ID, value);
    }

    /**
     * Fetch records that have <code>vehicle_manufacturer BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfVehicleManufacturer(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.VEHICLE_MANUFACTURER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_manufacturer IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByVehicleManufacturer(Long... values) {
        return fetch(Vehicle.VEHICLE.VEHICLE_MANUFACTURER, values);
    }

    /**
     * Fetch records that have <code>vehicle_curr_price BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfVehicleCurrPrice(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.VEHICLE_CURR_PRICE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_curr_price IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByVehicleCurrPrice(BigDecimal... values) {
        return fetch(Vehicle.VEHICLE.VEHICLE_CURR_PRICE, values);
    }

    /**
     * Fetch records that have <code>vehicle_model_year BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfVehicleModelYear(LocalDate lowerInclusive, LocalDate upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.VEHICLE_MODEL_YEAR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_model_year IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByVehicleModelYear(LocalDate... values) {
        return fetch(Vehicle.VEHICLE.VEHICLE_MODEL_YEAR, values);
    }

    /**
     * Fetch records that have <code>vehicle_status BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfVehicleStatus(String lowerInclusive, String upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.VEHICLE_STATUS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_status IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByVehicleStatus(String... values) {
        return fetch(Vehicle.VEHICLE.VEHICLE_STATUS, values);
    }

    /**
     * Fetch records that have <code>vehicle_color BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfVehicleColor(String lowerInclusive, String upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.VEHICLE_COLOR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_color IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByVehicleColor(String... values) {
        return fetch(Vehicle.VEHICLE.VEHICLE_COLOR, values);
    }

    /**
     * Fetch records that have <code>vehicle_model_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfVehicleModelId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.VEHICLE_MODEL_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_model_id IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByVehicleModelId(Long... values) {
        return fetch(Vehicle.VEHICLE.VEHICLE_MODEL_ID, values);
    }

    /**
     * Fetch records that have <code>vehicle_trim BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfVehicleTrim(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.VEHICLE_TRIM, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_trim IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByVehicleTrim(Long... values) {
        return fetch(Vehicle.VEHICLE.VEHICLE_TRIM, values);
    }

    /**
     * Fetch records that have <code>vehicle_style BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfVehicleStyle(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.VEHICLE_STYLE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_style IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByVehicleStyle(Long... values) {
        return fetch(Vehicle.VEHICLE.VEHICLE_STYLE, values);
    }

    /**
     * Fetch records that have <code>featured BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfFeatured(Byte lowerInclusive, Byte upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.FEATURED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>featured IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByFeatured(Byte... values) {
        return fetch(Vehicle.VEHICLE.FEATURED, values);
    }

    /**
     * Fetch records that have <code>created BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfCreated(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.CREATED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByCreated(LocalDateTime... values) {
        return fetch(Vehicle.VEHICLE.CREATED, values);
    }

    /**
     * Fetch records that have <code>version BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfVersion(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.VERSION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>version IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByVersion(Long... values) {
        return fetch(Vehicle.VEHICLE.VERSION, values);
    }

    /**
     * Fetch records that have <code>options BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfOptions(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.OPTIONS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>options IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByOptions(Long... values) {
        return fetch(Vehicle.VEHICLE.OPTIONS, values);
    }

    /**
     * Fetch records that have <code>title BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfTitle(String lowerInclusive, String upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.TITLE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>title IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByTitle(String... values) {
        return fetch(Vehicle.VEHICLE.TITLE, values);
    }

    /**
     * Fetch records that have <code>contact BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchRangeOfContact(String lowerInclusive, String upperInclusive) {
        return fetchRange(Vehicle.VEHICLE.CONTACT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>contact IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.Vehicle> fetchByContact(String... values) {
        return fetch(Vehicle.VEHICLE.CONTACT, values);
    }
}
