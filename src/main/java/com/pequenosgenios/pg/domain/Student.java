package com.pequenosgenios.pg.domain;

import com.pequenosgenios.pg.dto.StudentDTO;
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
public class Student extends Person {
    private Double fees;

    public Student(StudentDTO dto) {
        super(dto.getId(), dto.getName(), dto.getPhoneNumber(), dto.getEmailAddress(), new Address(dto.getAddress()));
        this.fees = dto.getFees();
    }
}
