package com.pequenosgenios.pg.domain;

import com.pequenosgenios.pg.dto.ClassDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    private Teacher teacher;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    private Set<Student> students;
    private int grade;

    public Class(ClassDTO dto) {
        this.id = dto.getId();
        this.teacher = new Teacher(dto.getTeacher());
        this.students = dto.getStudents().stream().map(Student::new).collect(Collectors.toSet());
        this.grade = dto.getGrade();
    }

}
