package com.pequenosgenios.pg.services;

import com.pequenosgenios.pg.domain.Class;
import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.repositories.ClassRepository;
import com.pequenosgenios.pg.repositories.StudentRepository;
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

        if(student.getClasse() == null){
            student.setClasse(classe);
            studentRepository.save(student);
        } else {
            throw new ObjectNotFoundException("Aluno já se encontra em uma classe! Id: " + studentId + ", Tipo " + Student.class.getName());
        }





    }
}
