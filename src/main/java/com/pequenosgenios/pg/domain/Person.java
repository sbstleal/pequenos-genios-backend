package com.pequenosgenios.pg.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    @Id
    protected Long id;
    protected String name;
    protected String phoneNumber;
    protected String emailAddress;
    @OneToOne(cascade = CascadeType.REMOVE)
    protected Address address;
}
