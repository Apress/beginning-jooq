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


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(
    name = "vehicle_style",
    schema = "edens_car"
)
public class VehicleStyle implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long   vehicleStyleId;
    private String vehicleStyleName;
    private String vehicleStyleStatus;
    private Long   version;

    public VehicleStyle() {}

    public VehicleStyle(VehicleStyle value) {
        this.vehicleStyleId = value.vehicleStyleId;
        this.vehicleStyleName = value.vehicleStyleName;
        this.vehicleStyleStatus = value.vehicleStyleStatus;
        this.version = value.version;
    }

    public VehicleStyle(
        Long   vehicleStyleId,
        String vehicleStyleName,
        String vehicleStyleStatus,
        Long   version
    ) {
        this.vehicleStyleId = vehicleStyleId;
        this.vehicleStyleName = vehicleStyleName;
        this.vehicleStyleStatus = vehicleStyleStatus;
        this.version = version;
    }

    /**
     * Getter for <code>edens_car.vehicle_style.vehicle_style_id</code>.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_style_id", nullable = false, precision = 19)
    public Long getVehicleStyleId() {
        return this.vehicleStyleId;
    }

    /**
     * Setter for <code>edens_car.vehicle_style.vehicle_style_id</code>.
     */
    public void setVehicleStyleId(Long vehicleStyleId) {
        this.vehicleStyleId = vehicleStyleId;
    }

    /**
     * Getter for <code>edens_car.vehicle_style.vehicle_style_name</code>.
     */
    @Column(name = "vehicle_style_name", nullable = false, length = 35)
    public String getVehicleStyleName() {
        return this.vehicleStyleName;
    }

    /**
     * Setter for <code>edens_car.vehicle_style.vehicle_style_name</code>.
     */
    public void setVehicleStyleName(String vehicleStyleName) {
        this.vehicleStyleName = vehicleStyleName;
    }

    /**
     * Getter for <code>edens_car.vehicle_style.vehicle_style_status</code>.
     */
    @Column(name = "vehicle_style_status", nullable = false, length = 10)
    public String getVehicleStyleStatus() {
        return this.vehicleStyleStatus;
    }

    /**
     * Setter for <code>edens_car.vehicle_style.vehicle_style_status</code>.
     */
    public void setVehicleStyleStatus(String vehicleStyleStatus) {
        this.vehicleStyleStatus = vehicleStyleStatus;
    }

    /**
     * Getter for <code>edens_car.vehicle_style.version</code>.
     */
    @Column(name = "version", precision = 19)
    public Long getVersion() {
        return this.version;
    }

    /**
     * Setter for <code>edens_car.vehicle_style.version</code>.
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
        final VehicleStyle other = (VehicleStyle) obj;
        if (vehicleStyleId == null) {
            if (other.vehicleStyleId != null)
                return false;
        }
        else if (!vehicleStyleId.equals(other.vehicleStyleId))
            return false;
        if (vehicleStyleName == null) {
            if (other.vehicleStyleName != null)
                return false;
        }
        else if (!vehicleStyleName.equals(other.vehicleStyleName))
            return false;
        if (vehicleStyleStatus == null) {
            if (other.vehicleStyleStatus != null)
                return false;
        }
        else if (!vehicleStyleStatus.equals(other.vehicleStyleStatus))
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
        result = prime * result + ((this.vehicleStyleId == null) ? 0 : this.vehicleStyleId.hashCode());
        result = prime * result + ((this.vehicleStyleName == null) ? 0 : this.vehicleStyleName.hashCode());
        result = prime * result + ((this.vehicleStyleStatus == null) ? 0 : this.vehicleStyleStatus.hashCode());
        result = prime * result + ((this.version == null) ? 0 : this.version.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VehicleStyle (");

        sb.append(vehicleStyleId);
        sb.append(", ").append(vehicleStyleName);
        sb.append(", ").append(vehicleStyleStatus);
        sb.append(", ").append(version);

        sb.append(")");
        return sb.toString();
    }
}
