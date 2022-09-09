package com.pequenosgenios.pg.services;

import com.pequenosgenios.pg.domain.Teacher;
import com.pequenosgenios.pg.dto.NewTeacherDTO;
import com.pequenosgenios.pg.dto.TeacherDTO;
import com.pequenosgenios.pg.repositories.TeacherRepository;
import com.pequenosgenios.pg.services.exceptions.DataIntegrityException;
import com.pequenosgenios.pg.services.exceptions.EmailAlredyExistsException;
import com.pequenosgenios.pg.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional
    public Teacher find(Integer id) {
        Optional<Teacher> obj = teacherRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Professor não encontrado! Id: " + id + ", Tipo " + Teacher.class.getName()));
    }

    @Transactional
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher insert(Teacher obj) {
        boolean emailUse = teacherRepository.findByEmail(obj.getEmail()).stream().anyMatch(isStudent -> !isStudent.equals(obj));
        if (emailUse) {
            throw new EmailAlredyExistsException("Este email já existe");
        }
        obj.setId(null);
        return teacherRepository.save(obj);
    }

    public void delete(Integer id) {
        find(id);

        try {
            teacherRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir esse aluno");
        }
    }

    private void updateData(Teacher newObj, Teacher obj) {
        newObj.setName(obj.getName());
        newObj.setPhoneNumber(obj.getPhoneNumber());
        newObj.setSalary(obj.getSalary());
        newObj.setEmail(obj.getEmail());
        newObj.setStreet(obj.getStreet());
        newObj.setCity(obj.getCity());
        newObj.setCountry(obj.getCountry());
        newObj.setPostalCode(obj.getPostalCode());
        newObj.setState(obj.getState());
        newObj.setClasse(obj.getClasse());
    }

    public Teacher fromDTO(NewTeacherDTO objDto) {
        return new Teacher(objDto.getId(), objDto.getName(), objDto.getPhoneNumber(), objDto.getEmail(), objDto.getSalary(), objDto.getStreet(), objDto.getCity(), objDto.getCountry(), objDto.getPostalCode(), objDto.getState());
    }

    public Teacher fromDTO(TeacherDTO objDto) {
        return new Teacher(objDto.getId(), objDto.getName(), objDto.getPhoneNumber(), objDto.getEmail(), objDto.getSalary(), objDto.getStreet(), objDto.getCity(), objDto.getCountry(), objDto.getPostalCode(), objDto.getState());
    }

    public Teacher update(Teacher obj) {
        Teacher newObj = find(obj.getId());
        updateData(newObj, obj);
        return teacherRepository.save(newObj);
    }



}
