package com.pequenosgenios.pg.domain;

import com.pequenosgenios.pg.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {
    private Double fees;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Class classe;

    public Student(StudentDTO dto) {
        super(dto.getId(), dto.getName(), dto.getPhone(), dto.getEmail(), dto.getCep(), dto.getStreet(), dto.getNumber(),
                dto.getDistrict(), dto.getCity(), dto.getState(), dto.getCountry());
        this.fees = dto.getFees();
    }

}
