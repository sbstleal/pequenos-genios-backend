package com.pequenosgenios.pg.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.dto.StudentDTO;
import com.pequenosgenios.pg.exception.pGException;
import com.pequenosgenios.pg.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public Student find(Integer studentId) {
		return studentRepository.findById(studentId).orElseThrow(() -> new pGException("Aluno não encontrado"));
	}
	
	@Transactional
	public List<StudentDTO> findAll(){
		List<Student> list = studentRepository.findAll();
		return list.stream().map(x -> new StudentDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public Student savar(Student student) {
		boolean emailUse = studentRepository.findByEmail(student.getEmail())
				.stream()
				.anyMatch(isStudent -> !isStudent.equals(student));
		if (emailUse) {
			throw new pGException("Já exixte este email");
		}
		return studentRepository.save(student);
	}
}
