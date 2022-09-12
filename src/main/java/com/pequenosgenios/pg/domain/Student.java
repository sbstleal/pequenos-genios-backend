package com.pequenosgenios.pg.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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


    @ManyToOne
    @JoinColumn(name="classe_id")
    private Class classe;

    public Student(Integer id, String name, String phoneNumber, Double fee, String email, String street, String city, String country, String postalCode, String state) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.fee = fee;
        this.email = email;
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.state = state;
    }
}
