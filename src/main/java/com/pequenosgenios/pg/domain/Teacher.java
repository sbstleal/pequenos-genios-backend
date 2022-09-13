package com.pequenosgenios.pg.domain;

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
        super(dto.getId(), dto.getName(), dto.getPhoneNumber(), dto.getEmailAddress(), new Address(dto.getAddress()));
        this.salary = dto.getSalary();
    }
}
