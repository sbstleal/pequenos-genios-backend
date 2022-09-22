package com.pequenosgenios.pg.dto;

import com.pequenosgenios.pg.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO extends PersonDTO {
    private Double fees;

    public StudentDTO(Student model) {
        super(model.getId(), model.getName(), model.getPhone(), model.getEmail(), model.getCep(), model.getStreet(),
                model.getNumber(), model.getDistrict(), model.getCity(), model.getState(), model.getCountry());
        this.fees = model.getFees();
    }

    public StudentDTO(Long id, String name, String phone, String email, String cep, String street,
                      Integer number, String district, String city, String state, String country, Double fees) {
        super(id, name, phone, email, cep, street, number, district, city, state, country);
        this.fees = fees;
    }
}
