package com.pequenosgenios.pg.dto;

import com.pequenosgenios.pg.domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO extends PersonDTO {
    private Double salary;

    public TeacherDTO(Teacher model) {
        super(model.getId(), model.getName(), model.getPhone(), model.getEmail(), new AddressDTO(model.getAddress()));
        this.salary = model.getSalary();
    }

}
