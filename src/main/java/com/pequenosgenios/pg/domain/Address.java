package com.pequenosgenios.pg.domain;

import com.pequenosgenios.pg.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String street;
    private Integer number;
    private String district;
    private String city;
    private String state;
    private String country;

    public Address(AddressDTO dto) {
        this.id = dto.getId();
        this.cep = dto.getCep();
        this.street = dto.getStreet();
        this.number = dto.getNumber();
        this.district = dto.getDistrict();
        this.city = dto.getCity();
        this.state = dto.getState();
        this.country = dto.getCountry();
    }


}
