package com.pequenosgenios.pg.services.impl;

import com.pequenosgenios.pg.repositories.ClassRepository;
import com.pequenosgenios.pg.repositories.StudentRepository;
import com.pequenosgenios.pg.repositories.TeacherRepository;

//@Service
public class DBService {
    private final ClassRepository classRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public DBService(ClassRepository classRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public void instantiateTestDatabase() {


//        Teacher teacher01 = new Teacher(null, "Pascal", "4898484984", "pascal@teste.com", 5879.35, "USA", "Albuquerque", "Everywhere Street", "4984-8984", "New Mexico");
//
//        Student student01 = new Student(null, "Arlindo Neves", "699845899854", 352.15, "arlindo@teste.com", "Random Street", "Albuquerque", "USA", "7698-987", "New Mexico");
//        Student student02 = new Student(null, "Alicia", "874987498", 563.58, "alice@teste.com", "Elsewhere Street", "Albuquerque", "USA", "4988-987", "New Mexico");
//        Student student03 = new Student(null, "Jesse", "7849848489", 847.3, "jesse@teste.com", "Nowhere Street", "Albuquerque", "USA", "8498-987", "New Mexico");

//        Class class01 = new Class(1);
//        Class class02 = new Class(2);
//        Class class03 = new Class(3);
//        Class class04 = new Class(4);
//        Class class05 = new Class(5);
//        Class class06 = new Class(6);
//        Class class07 = new Class(7);
//        Class class08 = new Class(8);
//
//        classRepository.saveAll((Arrays.asList(class01, class02, class03, class04, class05, class06, class07, class08)));
//        studentRepository.saveAll(Arrays.asList(student01, student02, student03));
//        teacherRepository.saveAll(Arrays.asList(teacher01));
    }

}
