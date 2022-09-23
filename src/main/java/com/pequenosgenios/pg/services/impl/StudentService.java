package com.pequenosgenios.pg.services.impl;

import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.dto.StudentDTO;
import com.pequenosgenios.pg.repositories.StudentRepository;
import com.pequenosgenios.pg.services.Util;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final AddressService addressService;

    public StudentService(StudentRepository studentRepository, AddressService addressService) {
        this.studentRepository = studentRepository;
        this.addressService = addressService;
    }

    @Transactional(rollbackFor = Exception.class)
    public StudentDTO insert(StudentDTO newStudentDTO) {
        Student model = new Student(newStudentDTO);

        model = this.studentRepository.save(model);
        newStudentDTO.setId(model.getId());
        return newStudentDTO;
    }

    @Transactional(readOnly = true)
    public Page<StudentDTO> findAll(Pageable pageable) {
        return this.studentRepository.findAll(pageable).map(StudentDTO::new);
    }

    @Transactional(readOnly = true)
    public StudentDTO findById(Long id) {
        return new StudentDTO(this.findModel(id));
    }

    @Transactional(rollbackFor = Exception.class)
    public StudentDTO update(Long id, StudentDTO studentDTO) {

        StudentDTO fromDatabase = this.findById(id);
        Util.myCopyProperties(studentDTO, fromDatabase);
        this.studentRepository.save(new Student(fromDatabase));
        return studentDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        this.studentRepository.delete(this.findModel(id));
    }

    protected Student findModel(Long id) {
        return this.studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public Page<StudentDTO> findByName(String name, Pageable pageable) {
        return this.studentRepository.findAllByNameContainsIgnoreCase(name, pageable).map(StudentDTO::new);
    }
}
