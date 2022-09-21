package com.pequenosgenios.pg.services.impl;

import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.dto.AddressDTO;
import com.pequenosgenios.pg.dto.NewStudentDTO;
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
    public StudentDTO insert(NewStudentDTO newStudentDTO) {
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setCep(newStudentDTO.getCep());
        addressDTO.setCity(newStudentDTO.getCity());
        addressDTO.setCountry(newStudentDTO.getCountry());
        addressDTO.setNumber(newStudentDTO.getNumber());
        addressDTO.setState(newStudentDTO.getState());
        addressDTO.setDistrict(newStudentDTO.getDistrict());
        addressDTO.setStreet(newStudentDTO.getStreet());
        addressDTO = this.addressService.insert(addressDTO);

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setAddress(addressDTO);
        studentDTO.setName(newStudentDTO.getName());
        studentDTO.setFees(newStudentDTO.getFees());
        studentDTO.setEmail(newStudentDTO.getEmail());
        studentDTO.setPhone(newStudentDTO.getPhone());

        Student model = new Student(studentDTO);
        model = this.studentRepository.save(model);
        studentDTO.setId(model.getId());
        return studentDTO;
    }

    @Transactional(readOnly = true)
    public Page<NewStudentDTO> findAll(Pageable pageable) {
        return this.studentRepository.findAll(pageable).map(NewStudentDTO::new);
    }

    @Transactional(readOnly = true)
    public StudentDTO findById(Long id) {
        return new StudentDTO(this.findModel(id));
    }

    @Transactional(rollbackFor = Exception.class)
    public StudentDTO update(Long id, StudentDTO studentDTO) {
        this.addressService.update(studentDTO.getAddress().getId(), studentDTO.getAddress());

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

}
