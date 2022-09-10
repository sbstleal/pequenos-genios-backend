package com.pequenosgenios.pg.services;

import com.pequenosgenios.pg.domain.Class;
import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.domain.Teacher;
import com.pequenosgenios.pg.repositories.ClassRepository;
import com.pequenosgenios.pg.repositories.StudentRepository;
import com.pequenosgenios.pg.repositories.TeacherRepository;
import com.pequenosgenios.pg.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional
    public Class find(Integer id) {
        Optional<Class> obj = classRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Classe não encontrada! Id: " + id + ", Tipo " + Class.class.getName()));
    }

    @Transactional
    public List<Class> findAll() {
        return classRepository.findAll();
    }

    public void studentsAssigment(Integer idClass, Integer studentId) {

        Class classe = find(idClass);

        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado! Id: " + studentId + ", Tipo " + Student.class.getName()));

        student.setClasse(classe);
        studentRepository.save(student);


    }

    public void teacherAssigment(Integer idClass, Integer teacherId) {

        Class classe = find(idClass);

        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ObjectNotFoundException("Professor não encontrado! Id: " + teacherId + ", Tipo " + Teacher.class.getName()));

        teacher.setClasse(classe);
        teacherRepository.save(teacher);
    }
}
