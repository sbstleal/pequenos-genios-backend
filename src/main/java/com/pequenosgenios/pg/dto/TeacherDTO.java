package com.pequenosgenios.pg.dto;

import com.pequenosgenios.pg.domain.Class;
import com.pequenosgenios.pg.domain.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TeacherDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private Double salary;
    private String country;
    private String city;
    private String street;
    private String postalCode;
    private String state;

    private Class classe;

    public TeacherDTO(Teacher obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.phoneNumber = obj.getPhoneNumber();
        this.email = obj.getEmail();
        this.salary = obj.getSalary();
        this.country = obj.getCountry();
        this.city = obj.getCity();
        this.street = obj.getStreet();
        this.postalCode = obj.getPostalCode();
        this.state = obj.getState();
        this.classe = obj.getClasse();
    }
}
