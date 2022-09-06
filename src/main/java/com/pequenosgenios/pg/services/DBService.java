package com.pequenosgenios.pg.services;

import com.pequenosgenios.pg.domain.Class;
import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.domain.Teacher;
import com.pequenosgenios.pg.repositories.ClassRepository;
import com.pequenosgenios.pg.repositories.StudentRepository;
import com.pequenosgenios.pg.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Service
public class DBService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassRepository classRepository;
    public void instantiateTestDatabase() {


        Teacher teacher01 = new Teacher(null, "Pascal", "4898484984", "pascal@teste.com", 5879.35, "USA", "Albuquerque", "Everywhere Street", "4984-8984", "New Mexico");

        Student student01 = new Student(null, "Arlindo Neves", "699845899854", 352.15, "arlindo@teste.com", "Random Street", "Albuquerque", "USA", "7698-987", "New Mexico");
        Student student02 = new Student(null, "Alicia", "874987498", 563.58, "alice@teste.com", "Elsewhere Street", "Albuquerque", "USA", "4988-987", "New Mexico");
        Student student03 = new Student(null, "Jesse", "7849848489", 847.3, "jesse@teste.com", "Nowhere Street", "Albuquerque", "USA", "8498-987", "New Mexico");

        Class class01 = new Class(null, 8);

        class01.getStudents().addAll(Arrays.asList(student01, student02, student03));
        teacher01.setClasse(class01);
        class01.setTeacher(teacher01);

        student01.setClasse(class01);
        student02.setClasse(class01);
        student03.setClasse(class01);

        classRepository.saveAll(Arrays.asList(class01));
        teacherRepository.saveAll(Arrays.asList(teacher01));
        studentRepository.saveAll(Arrays.asList(student01, student02, student03));
    }
}
