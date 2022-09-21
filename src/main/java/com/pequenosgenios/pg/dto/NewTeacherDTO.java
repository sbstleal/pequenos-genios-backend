package com.pequenosgenios.pg.dto;

import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.domain.Teacher;

import java.io.Serializable;

public class NewTeacherDTO implements Serializable {

    private Long id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String cep;
    private String street;
    private Integer number;
    private String district;
    private String city;
    private String state;
    private String country;

    private Double salary;

    public NewTeacherDTO(){

    }

    public NewTeacherDTO(Long id, String name, String phoneNumber, String emailAddress, String cep, String street, Integer number, String district, String city, String state, String country, Double salary) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.salary = salary;
    }

    public NewTeacherDTO(Teacher entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.phoneNumber = entity.getPhoneNumber();
        this.emailAddress = entity.getEmailAddress();
        this.cep = entity.getAddress().getCep();
        this.street = entity.getAddress().getStreet();
        this.number = entity.getAddress().getNumber();
        this.district = entity.getAddress().getDistrict();
        this.city = entity.getAddress().getCity();
        this.state = entity.getAddress().getState();
        this.country = entity.getAddress().getCountry();
        this.salary = entity.getSalary();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
