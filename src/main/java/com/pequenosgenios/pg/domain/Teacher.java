package com.pequenosgenios.pg.domain;

import com.pequenosgenios.pg.dto.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends Person {
    private Double salary;
    @OneToOne
    @Cascade(CascadeType.ALL)
    private Class classe;

    public Teacher(TeacherDTO dto) {
        super(dto.getId(), dto.getName(), dto.getPhone(), dto.getEmail(), dto.getCep(), dto.getStreet(), dto.getNumber(),
                dto.getDistrict(), dto.getCity(), dto.getState(), dto.getCountry());
        this.salary = dto.getSalary();
    }

}
