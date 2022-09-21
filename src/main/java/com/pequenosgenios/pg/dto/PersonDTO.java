package com.pequenosgenios.pg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonDTO {
    protected Long id;
    protected String name;
    protected String phoneNumber;

    @Column(name="email_address")
    protected String emailAddress;

    protected AddressDTO address;
}
