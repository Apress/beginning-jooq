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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


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
public class VehicleManufacturer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long   manufacturerId;
    private String manufacturerName;
    private String status;
    private Long   version;

    public VehicleManufacturer() {}

    public VehicleManufacturer(VehicleManufacturer value) {
        this.manufacturerId = value.manufacturerId;
        this.manufacturerName = value.manufacturerName;
        this.status = value.status;
        this.version = value.version;
    }

    public VehicleManufacturer(
        Long   manufacturerId,
        String manufacturerName,
        String status,
        Long   version
    ) {
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
        this.status = status;
        this.version = version;
    }

    /**
     * Getter for <code>edens_car.vehicle_manufacturer.manufacturer_id</code>.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id", nullable = false, precision = 19)
    public Long getManufacturerId() {
        return this.manufacturerId;
    }

    /**
     * Setter for <code>edens_car.vehicle_manufacturer.manufacturer_id</code>.
     */
    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    /**
     * Getter for <code>edens_car.vehicle_manufacturer.manufacturer_name</code>.
     */
    @Column(name = "manufacturer_name", nullable = false, length = 250)
    public String getManufacturerName() {
        return this.manufacturerName;
    }

    /**
     * Setter for <code>edens_car.vehicle_manufacturer.manufacturer_name</code>.
     */
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    /**
     * Getter for <code>edens_car.vehicle_manufacturer.status</code>.
     */
    @Column(name = "status", nullable = false, length = 15)
    public String getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>edens_car.vehicle_manufacturer.status</code>.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for <code>edens_car.vehicle_manufacturer.version</code>.
     */
    @Column(name = "version", precision = 19)
    public Long getVersion() {
        return this.version;
    }

    /**
     * Setter for <code>edens_car.vehicle_manufacturer.version</code>.
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
        final VehicleManufacturer other = (VehicleManufacturer) obj;
        if (manufacturerId == null) {
            if (other.manufacturerId != null)
                return false;
        }
        else if (!manufacturerId.equals(other.manufacturerId))
            return false;
        if (manufacturerName == null) {
            if (other.manufacturerName != null)
                return false;
        }
        else if (!manufacturerName.equals(other.manufacturerName))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        }
        else if (!status.equals(other.status))
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
        result = prime * result + ((this.manufacturerId == null) ? 0 : this.manufacturerId.hashCode());
        result = prime * result + ((this.manufacturerName == null) ? 0 : this.manufacturerName.hashCode());
        result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
        result = prime * result + ((this.version == null) ? 0 : this.version.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VehicleManufacturer (");

        sb.append(manufacturerId);
        sb.append(", ").append(manufacturerName);
        sb.append(", ").append(status);
        sb.append(", ").append(version);

        sb.append(")");
        return sb.toString();
    }
}
