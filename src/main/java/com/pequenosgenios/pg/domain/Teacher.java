package com.pequenosgenios.pg.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_teachers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

    @OneToOne
    @JoinColumn(name="classe_id")
    private Class classe;

    public Teacher(Integer id, String name, String phoneNumber, String email, Double salary, String country, String city, String street, String postalCode, String state) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.state = state;
    }
}
