package com.Cab.Booking.Application.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class AppUserModel {
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "age")
    private int age;
    @JsonProperty(value = "phone")
    private Long phone;
    @JsonProperty(value = "latitude")
    private int latitude;
    @JsonProperty(value = "longitude")
    private int longitude;


    //getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age;}
    public Long getPhone() { return phone;}
    public int getLatitude() { return latitude; }
    public int getLongitude() { return longitude; }

    //setters
    public void setId(Long id) { this.id = id;}
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setPhone(Long phone) { this.phone = phone; }
    public void setLatitude(int latitude) { this.latitude = latitude; }
    public void setLongitude(int longitude) { this.longitude = longitude; }

    @Override
    public String toString() {
        return
                "AppUserModel{" + "id=" + id +", " +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        ", phone=" + phone +
                        ", location=" + latitude +","+longitude+ '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUserModel)) return false;
        AppUserModel that = (AppUserModel) o;
        return getAge() == that.getAge() &&
                getLatitude() == that.getLatitude() &&
                getLongitude() == that.getLongitude() &&
                getId().equals(that.getId()) &&
                getName().equals(that.getName()) &&
                getPhone().equals(that.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getPhone(), getLatitude(),getLongitude());
    }
}
