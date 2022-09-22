package com.pequenosgenios.pg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonDTO {
    protected Long id;
    protected String name;
    protected String phone;
    protected String email;

    protected String cep;
    protected String street;
    protected Integer number;
    protected String district;
    protected String city;
    protected String state;
    protected String country;
}
