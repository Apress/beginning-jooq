package com.apress.jooq.custom;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class CompleteVehicleRecord {
    String brand;
    String model;
    String trim;
    BigDecimal price;
    String color;
    String style;
    int weight;
    LocalDate year;
    long vehicleId;

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompleteVehicleRecord that = (CompleteVehicleRecord) o;
        return getWeight() == that.getWeight() &&
                getVehicleId() == that.getVehicleId() &&
                Objects.equals(getBrand(), that.getBrand()) &&
                Objects.equals(getModel(), that.getModel()) &&
                Objects.equals(getTrim(), that.getTrim()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getColor(), that.getColor()) &&
                Objects.equals(getStyle(), that.getStyle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), getTrim(), getPrice(), getColor(), getStyle(), getWeight(), getVehicleId());
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "CompleteVehicleRecord{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", trim='" + trim + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
