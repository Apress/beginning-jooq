/*
 * This file is generated by jOOQ.
 */
package com.apress.jooq.generated.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * VIEW
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(
    name = "complete_car_listing",
    schema = "edens_car"
)
public class CompleteCarListing implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long       vehicleId;
    private String     brand;
    private String     model;
    private String     trim;
    private BigDecimal price;
    private String     color;
    private String     style;
    private LocalDate  year;
    private Byte       featured;

    public CompleteCarListing() {}

    public CompleteCarListing(CompleteCarListing value) {
        this.vehicleId = value.vehicleId;
        this.brand = value.brand;
        this.model = value.model;
        this.trim = value.trim;
        this.price = value.price;
        this.color = value.color;
        this.style = value.style;
        this.year = value.year;
        this.featured = value.featured;
    }

    public CompleteCarListing(
        Long       vehicleId,
        String     brand,
        String     model,
        String     trim,
        BigDecimal price,
        String     color,
        String     style,
        LocalDate  year,
        Byte       featured
    ) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.trim = trim;
        this.price = price;
        this.color = color;
        this.style = style;
        this.year = year;
        this.featured = featured;
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.vehicle_id</code>.
     */
    @Id
    @Column(name = "vehicle_id", nullable = false, precision = 19)
    public Long getVehicleId() {
        return this.vehicleId;
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.vehicle_id</code>.
     */
    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.brand</code>.
     */
    @Column(name = "brand", nullable = false, length = 250)
    public String getBrand() {
        return this.brand;
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.brand</code>.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.model</code>.
     */
    @Column(name = "model", nullable = false, length = 250)
    public String getModel() {
        return this.model;
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.model</code>.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.trim</code>.
     */
    @Column(name = "trim", nullable = false, length = 35)
    public String getTrim() {
        return this.trim;
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.trim</code>.
     */
    public void setTrim(String trim) {
        this.trim = trim;
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.price</code>.
     */
    @Column(name = "price", nullable = false, precision = 15, scale = 4)
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.price</code>.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.color</code>.
     */
    @Column(name = "color", length = 35)
    public String getColor() {
        return this.color;
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.color</code>.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.style</code>.
     */
    @Column(name = "style", nullable = false, length = 35)
    public String getStyle() {
        return this.style;
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.style</code>.
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.year</code>.
     */
    @Column(name = "year")
    public LocalDate getYear() {
        return this.year;
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.year</code>.
     */
    public void setYear(LocalDate year) {
        this.year = year;
    }

    /**
     * Getter for <code>edens_car.complete_car_listing.featured</code>.
     */
    @Column(name = "featured", precision = 3)
    public Byte getFeatured() {
        return this.featured;
    }

    /**
     * Setter for <code>edens_car.complete_car_listing.featured</code>.
     */
    public void setFeatured(Byte featured) {
        this.featured = featured;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CompleteCarListing other = (CompleteCarListing) obj;
        if (vehicleId == null) {
            if (other.vehicleId != null)
                return false;
        }
        else if (!vehicleId.equals(other.vehicleId))
            return false;
        if (brand == null) {
            if (other.brand != null)
                return false;
        }
        else if (!brand.equals(other.brand))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        }
        else if (!model.equals(other.model))
            return false;
        if (trim == null) {
            if (other.trim != null)
                return false;
        }
        else if (!trim.equals(other.trim))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        }
        else if (!price.equals(other.price))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        }
        else if (!color.equals(other.color))
            return false;
        if (style == null) {
            if (other.style != null)
                return false;
        }
        else if (!style.equals(other.style))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        }
        else if (!year.equals(other.year))
            return false;
        if (featured == null) {
            if (other.featured != null)
                return false;
        }
        else if (!featured.equals(other.featured))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.vehicleId == null) ? 0 : this.vehicleId.hashCode());
        result = prime * result + ((this.brand == null) ? 0 : this.brand.hashCode());
        result = prime * result + ((this.model == null) ? 0 : this.model.hashCode());
        result = prime * result + ((this.trim == null) ? 0 : this.trim.hashCode());
        result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());
        result = prime * result + ((this.color == null) ? 0 : this.color.hashCode());
        result = prime * result + ((this.style == null) ? 0 : this.style.hashCode());
        result = prime * result + ((this.year == null) ? 0 : this.year.hashCode());
        result = prime * result + ((this.featured == null) ? 0 : this.featured.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CompleteCarListing (");

        sb.append(vehicleId);
        sb.append(", ").append(brand);
        sb.append(", ").append(model);
        sb.append(", ").append(trim);
        sb.append(", ").append(price);
        sb.append(", ").append(color);
        sb.append(", ").append(style);
        sb.append(", ").append(year);
        sb.append(", ").append(featured);

        sb.append(")");
        return sb.toString();
    }
}
