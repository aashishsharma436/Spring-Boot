package com.Cab.Booking.Application.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class DriverModel {

    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "age")
    private int age;
    @JsonProperty(value = "phone")
    private Long phone;
    @JsonProperty(value = "latitude")
    private Integer latitude;
    @JsonProperty(value = "longitude")
    private Integer longitude;
    @JsonProperty(value = "vehicleNumber")
    private String vehicleNumber;
    @JsonProperty(value = "vehicleName")
    private String vehicleName;
    @JsonProperty(value = "active")
    private boolean active;
    @JsonProperty
    private Double amount;


    //getters
    public Long getId() { return id;}
    public String getName() { return name; }
    public int getAge() { return age; }
    public Long getPhone() { return phone; }
    public Integer getLatitude() { return latitude; }
    public Integer getLongitude() { return longitude; }
    public String getVehicleNumber() { return vehicleNumber; }
    public String getVehicleName() {return vehicleName;}
    public boolean isActive() {return active;}
    public Double getAmount() {return amount;}

    //setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setPhone(Long phone) { this.phone = phone; }
    public void setLatitude(Integer latitude) { this.latitude = latitude; }
    public void setLongitude(Integer longitude) { this.longitude = longitude; }
    public void setVehicleNumber(String vehicleNumber) {this.vehicleNumber = vehicleNumber;}
    public void setVehicleName(String vehicleName) {this.vehicleName = vehicleName;}
    public void setActive(boolean active) {this.active = active;}
    public void setAmount(Double amount) {this.amount = amount; }

    @Override
    public String toString() {
        return "DriverModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                ", active=" + active +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DriverModel)) return false;
        DriverModel that = (DriverModel) o;
        return getAge() == that.getAge() &&
                isActive() == that.isActive() &&
                getId().equals(that.getId()) &&
                getName().equals(that.getName()) &&
                getPhone().equals(that.getPhone()) &&
                getLatitude().equals(that.getLatitude()) &&
                getLongitude().equals(that.getLongitude()) &&
                getVehicleNumber().equals(that.getVehicleNumber()) &&
                getAmount().equals(that.getAmount()) &&
                getVehicleName().equals(that.getVehicleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getPhone(), getLatitude(), getAmount(),getLongitude(), getVehicleNumber(), getVehicleName(), isActive());
    }
}
