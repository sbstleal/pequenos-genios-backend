package com.pequenosgenios.pg.dto;

import java.io.Serializable;

import com.pequenosgenios.pg.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private Integer id;
    private String name;
    private String phoneNumber;
    private Double fee;
    private String email;
    private String street;
    private String city;
    private String country;
    private String postalCode;
    private String state;

    
    public StudentDTO(Student student) {
    	super();
		this.id = student.getId();
		this.name = student.getName();
		this.phoneNumber = student.getPhoneNumber();
		this.fee = student.getFee();
		this.email = student.getEmail();
		this.street = student.getStreet();
		this.city = student.getCity();
		this.country = student.getCountry();
		this.postalCode = student.getPostalCode();
		this.state = student.getState();
    }
}
