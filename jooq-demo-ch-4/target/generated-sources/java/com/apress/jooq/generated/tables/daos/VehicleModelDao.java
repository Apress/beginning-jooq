/*
 * This file is generated by jOOQ.
 */
package com.apress.jooq.generated.tables.daos;


import com.apress.jooq.generated.tables.VehicleModel;
import com.apress.jooq.generated.tables.records.VehicleModelRecord;

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
public class VehicleModelDao extends DAOImpl<VehicleModelRecord, com.apress.jooq.generated.tables.pojos.VehicleModel, Long> {

    /**
     * Create a new VehicleModelDao without any configuration
     */
    public VehicleModelDao() {
        super(VehicleModel.VEHICLE_MODEL, com.apress.jooq.generated.tables.pojos.VehicleModel.class);
    }

    /**
     * Create a new VehicleModelDao with an attached configuration
     */
    @Autowired
    public VehicleModelDao(Configuration configuration) {
        super(VehicleModel.VEHICLE_MODEL, com.apress.jooq.generated.tables.pojos.VehicleModel.class, configuration);
    }

    @Override
    public Long getId(com.apress.jooq.generated.tables.pojos.VehicleModel object) {
        return object.getVehicleModelId();
    }

    /**
     * Fetch records that have <code>vehicle_model_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.VehicleModel> fetchRangeOfVehicleModelId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(VehicleModel.VEHICLE_MODEL.VEHICLE_MODEL_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_model_id IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.VehicleModel> fetchByVehicleModelId(Long... values) {
        return fetch(VehicleModel.VEHICLE_MODEL.VEHICLE_MODEL_ID, values);
    }

    /**
     * Fetch a unique record that has <code>vehicle_model_id = value</code>
     */
    public com.apress.jooq.generated.tables.pojos.VehicleModel fetchOneByVehicleModelId(Long value) {
        return fetchOne(VehicleModel.VEHICLE_MODEL.VEHICLE_MODEL_ID, value);
    }

    /**
     * Fetch records that have <code>vehicle_model_name BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.VehicleModel> fetchRangeOfVehicleModelName(String lowerInclusive, String upperInclusive) {
        return fetchRange(VehicleModel.VEHICLE_MODEL.VEHICLE_MODEL_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_model_name IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.VehicleModel> fetchByVehicleModelName(String... values) {
        return fetch(VehicleModel.VEHICLE_MODEL.VEHICLE_MODEL_NAME, values);
    }

    /**
     * Fetch a unique record that has <code>vehicle_model_name = value</code>
     */
    public com.apress.jooq.generated.tables.pojos.VehicleModel fetchOneByVehicleModelName(String value) {
        return fetchOne(VehicleModel.VEHICLE_MODEL.VEHICLE_MODEL_NAME, value);
    }

    /**
     * Fetch records that have <code>vehicle_style_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.VehicleModel> fetchRangeOfVehicleStyleId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(VehicleModel.VEHICLE_MODEL.VEHICLE_STYLE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_style_id IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.VehicleModel> fetchByVehicleStyleId(Long... values) {
        return fetch(VehicleModel.VEHICLE_MODEL.VEHICLE_STYLE_ID, values);
    }

    /**
     * Fetch records that have <code>vehicle_man_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.VehicleModel> fetchRangeOfVehicleManId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(VehicleModel.VEHICLE_MODEL.VEHICLE_MAN_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>vehicle_man_id IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.VehicleModel> fetchByVehicleManId(Long... values) {
        return fetch(VehicleModel.VEHICLE_MODEL.VEHICLE_MAN_ID, values);
    }

    /**
     * Fetch records that have <code>version BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.VehicleModel> fetchRangeOfVersion(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(VehicleModel.VEHICLE_MODEL.VERSION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>version IN (values)</code>
     */
    public List<com.apress.jooq.generated.tables.pojos.VehicleModel> fetchByVersion(Long... values) {
        return fetch(VehicleModel.VEHICLE_MODEL.VERSION, values);
    }
}
