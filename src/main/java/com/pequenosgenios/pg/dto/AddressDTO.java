package com.pequenosgenios.pg.dto;

import com.pequenosgenios.pg.domain.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {
    private Long id;
    private String cep;
    private String street;
    private Integer number;
    private String district;
    private String city;
    private String state;
    private String country;

    public AddressDTO(Address model) {
        this.id = model.getId();
        this.cep = model.getCep();
        this.street = model.getStreet();
        this.number = model.getNumber();
        this.district = model.getDistrict();
        this.city = model.getCity();
        this.state = model.getState();
        this.country = model.getCountry();
    }

}
