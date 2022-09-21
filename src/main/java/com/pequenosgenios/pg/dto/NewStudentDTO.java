package com.pequenosgenios.pg.dto;

import com.pequenosgenios.pg.domain.Student;

import java.io.Serializable;

public class NewStudentDTO implements Serializable {

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
    private Double fees;

    public NewStudentDTO(){

    }

    public NewStudentDTO(Long id, String name, String phoneNumber, String emailAddress, String cep, String street, Integer number, String district, String city, String state, String country, Double fees) {
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
        this.fees = fees;
    }

    public NewStudentDTO(Student entity) {
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
        this.fees = entity.getFees();
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

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }
}
