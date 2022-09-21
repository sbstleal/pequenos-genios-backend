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
        super(model.getId(), model.getName(), model.getPhoneNumber(), model.getEmailAddress(), new AddressDTO(model.getAddress()));
        this.fees = model.getFees();
    }

}
