package com.pequenosgenios.pg.domain;

import com.pequenosgenios.pg.dto.NewTeacherDTO;
import com.pequenosgenios.pg.dto.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends Person {
    private Double salary;

    public Teacher(TeacherDTO dto) {
        super(dto.getId(), dto.getName(), dto.getPhone(), dto.getEmail(), dto.getCep(), dto.getStreet(), dto.getNumber(),
                dto.getDistrict(), dto.getCity(), dto.getState(), dto.getCountry());
        this.salary = dto.getSalary();
    }

    public Teacher(NewTeacherDTO dto) {
        super(dto.getId(), dto.getName(), dto.getPhone(), dto.getEmail(), dto.getCep(), dto.getStreet(), dto.getNumber(),
                dto.getDistrict(), dto.getCity(), dto.getState(), dto.getCountry());
        this.salary = dto.getSalary();
    }
}
