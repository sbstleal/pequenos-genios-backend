package com.pequenosgenios.pg.dto;

import com.pequenosgenios.pg.domain.Class;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassDTO {
    private Long id;
    private TeacherDTO teacher;
    private Set<StudentDTO> students;
    private int grade;

    public ClassDTO(Class model) {
        this.id = model.getId();
        this.teacher = new TeacherDTO(model.getTeacher());
        this.students = model.getStudents().stream().map(StudentDTO::new).collect(Collectors.toSet());
        this.grade = model.getGrade();
    }
}
