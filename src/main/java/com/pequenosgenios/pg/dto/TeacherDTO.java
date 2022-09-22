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

    public TeacherDTO(Long id, String name, String phone, String email, String cep, String street,
                      Integer number, String district, String city, String state, String country, Double salary) {
        super(id, name, phone, email, cep, street, number, district, city, state, country);
        this.salary = salary;
    }

    public TeacherDTO(Teacher model) {
        super(model.getId(), model.getName(), model.getPhone(), model.getEmail(), model.getCep(), model.getStreet(),
                model.getNumber(), model.getDistrict(), model.getCity(), model.getState(), model.getCountry());
        this.salary = model.getSalary();

    }
}
