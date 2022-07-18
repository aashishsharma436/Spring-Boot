package com.Cab.Booking.Application.Model;

import com.Cab.Booking.Application.Entity.Driver;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class RideModel {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty (value = "userName")
    private String userName;

    @JsonProperty(value = "phone")
    private Long phone;

    @JsonProperty(value = "latitude")
    private Integer latitude;

    @JsonProperty(value = "longitude")
    private Integer longitude;

    @JsonProperty(value = "dlatitude")
    private Integer dlatitude;

    @JsonProperty(value = "dlongitude")
    private Integer dlongitude;

    @JsonProperty(value = "drivers")
    private Driver driver;


    //getters
    public Long getId() { return  id; }
    public String getUserName() { return userName;}
    public Long getPhone(){ return phone;}
    public Integer getLatitude() { return latitude;}
    public Integer getLongitude() { return longitude;}
    public Integer getDlatitude() { return dlatitude;}
    public Integer getDlongitude() {return dlongitude;}
    public Driver getDriver() { return driver;}

    //setters
    public void setId(Long id) {this.id = id;}
    public void setUserName(String userName) {this.userName = userName;}
    public void setPhone(Long phone) {this.phone = phone;}
    public void setLatitude(Integer latitude) { this.latitude = latitude;}
    public void setLongitude(Integer longitude) { this.longitude = longitude;}
    public void setDlatitude(Integer dlatitude) {this.dlatitude = dlatitude;}
    public void setDlongitude(Integer dlongitude) { this.dlongitude = dlongitude;}
    public void setDriver(Driver driver) {this.driver = driver;}

    @Override
    public String toString() {
        return "RideModel{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", phone=" + phone +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", dlatitude=" + dlatitude +
                ", dlongitude=" + dlongitude +
                ", driver=" + driver +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RideModel)) return false;
        RideModel rideModel = (RideModel) o;
        return getId().equals(rideModel.getId()) &&
                getUserName().equals(rideModel.getUserName()) &&
                getPhone().equals(rideModel.getPhone()) &&
                getLatitude().equals(rideModel.getLatitude()) &&
                getLongitude().equals(rideModel.getLongitude()) &&
                getDlatitude().equals(rideModel.getDlatitude()) &&
                getDlongitude().equals(rideModel.getDlongitude()) &&
                getDriver().equals(rideModel.getDriver());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getPhone(), getLatitude(),getLongitude(), getDlatitude(),getDlongitude(),getDriver());
    }
}
