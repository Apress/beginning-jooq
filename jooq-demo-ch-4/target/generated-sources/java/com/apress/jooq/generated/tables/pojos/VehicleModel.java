/*
 * This file is generated by jOOQ.
 */
package com.apress.jooq.generated.tables.pojos;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(
    name = "vehicle_model",
    schema = "edens_car",
    uniqueConstraints = {
        @UniqueConstraint(name = "KEY_vehicle_model_vehicle_model_name_UNIQUE", columnNames = { "vehicle_model_name" })
    },
    indexes = {
        @Index(name = "manufacturer_id_idx", columnList = "vehicle_man_id ASC"),
        @Index(name = "model_style_id_idx", columnList = "vehicle_style_id ASC")
    }
)
public class VehicleModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long   vehicleModelId;
    private String vehicleModelName;
    private Long   vehicleStyleId;
    private Long   vehicleManId;
    private Long   version;

    public VehicleModel() {}

    public VehicleModel(VehicleModel value) {
        this.vehicleModelId = value.vehicleModelId;
        this.vehicleModelName = value.vehicleModelName;
        this.vehicleStyleId = value.vehicleStyleId;
        this.vehicleManId = value.vehicleManId;
        this.version = value.version;
    }

    public VehicleModel(
        Long   vehicleModelId,
        String vehicleModelName,
        Long   vehicleStyleId,
        Long   vehicleManId,
        Long   version
    ) {
        this.vehicleModelId = vehicleModelId;
        this.vehicleModelName = vehicleModelName;
        this.vehicleStyleId = vehicleStyleId;
        this.vehicleManId = vehicleManId;
        this.version = version;
    }

    /**
     * Getter for <code>edens_car.vehicle_model.vehicle_model_id</code>.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_model_id", nullable = false, precision = 19)
    public Long getVehicleModelId() {
        return this.vehicleModelId;
    }

    /**
     * Setter for <code>edens_car.vehicle_model.vehicle_model_id</code>.
     */
    public void setVehicleModelId(Long vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }

    /**
     * Getter for <code>edens_car.vehicle_model.vehicle_model_name</code>.
     */
    @Column(name = "vehicle_model_name", nullable = false, length = 250)
    public String getVehicleModelName() {
        return this.vehicleModelName;
    }

    /**
     * Setter for <code>edens_car.vehicle_model.vehicle_model_name</code>.
     */
    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    /**
     * Getter for <code>edens_car.vehicle_model.vehicle_style_id</code>.
     */
    @Column(name = "vehicle_style_id", nullable = false, precision = 19)
    public Long getVehicleStyleId() {
        return this.vehicleStyleId;
    }

    /**
     * Setter for <code>edens_car.vehicle_model.vehicle_style_id</code>.
     */
    public void setVehicleStyleId(Long vehicleStyleId) {
        this.vehicleStyleId = vehicleStyleId;
    }

    /**
     * Getter for <code>edens_car.vehicle_model.vehicle_man_id</code>.
     */
    @Column(name = "vehicle_man_id", nullable = false, precision = 19)
    public Long getVehicleManId() {
        return this.vehicleManId;
    }

    /**
     * Setter for <code>edens_car.vehicle_model.vehicle_man_id</code>.
     */
    public void setVehicleManId(Long vehicleManId) {
        this.vehicleManId = vehicleManId;
    }

    /**
     * Getter for <code>edens_car.vehicle_model.version</code>.
     */
    @Column(name = "version", precision = 19)
    public Long getVersion() {
        return this.version;
    }

    /**
     * Setter for <code>edens_car.vehicle_model.version</code>.
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final VehicleModel other = (VehicleModel) obj;
        if (vehicleModelId == null) {
            if (other.vehicleModelId != null)
                return false;
        }
        else if (!vehicleModelId.equals(other.vehicleModelId))
            return false;
        if (vehicleModelName == null) {
            if (other.vehicleModelName != null)
                return false;
        }
        else if (!vehicleModelName.equals(other.vehicleModelName))
            return false;
        if (vehicleStyleId == null) {
            if (other.vehicleStyleId != null)
                return false;
        }
        else if (!vehicleStyleId.equals(other.vehicleStyleId))
            return false;
        if (vehicleManId == null) {
            if (other.vehicleManId != null)
                return false;
        }
        else if (!vehicleManId.equals(other.vehicleManId))
            return false;
        if (version == null) {
            if (other.version != null)
                return false;
        }
        else if (!version.equals(other.version))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.vehicleModelId == null) ? 0 : this.vehicleModelId.hashCode());
        result = prime * result + ((this.vehicleModelName == null) ? 0 : this.vehicleModelName.hashCode());
        result = prime * result + ((this.vehicleStyleId == null) ? 0 : this.vehicleStyleId.hashCode());
        result = prime * result + ((this.vehicleManId == null) ? 0 : this.vehicleManId.hashCode());
        result = prime * result + ((this.version == null) ? 0 : this.version.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VehicleModel (");

        sb.append(vehicleModelId);
        sb.append(", ").append(vehicleModelName);
        sb.append(", ").append(vehicleStyleId);
        sb.append(", ").append(vehicleManId);
        sb.append(", ").append(version);

        sb.append(")");
        return sb.toString();
    }
}
