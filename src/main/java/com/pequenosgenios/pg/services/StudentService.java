package com.pequenosgenios.pg.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.dto.StudentDTO;
import com.pequenosgenios.pg.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional(readOnly = true)
	public List<StudentDTO> findAll() {
		List<Student> students = studentRepository.findAll();
		
		return students
				.stream()
				.map(entity -> new StudentDTO(entity))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public StudentDTO findById(Integer id) throws Exception {
		Optional<Student> studentObj = studentRepository.findById(id);
		Student studentEntity = studentObj.orElseThrow(() -> new Exception());
		
		return new StudentDTO(studentEntity);
	}
	
	@Transactional
	public StudentDTO insert(StudentDTO dto) {
		/*boolean emailUse = studentRepository.findByEmail(dto.getEmail())
				.stream()
				.anyMatch(isStudent -> !isStudent.equals(dto));
		if (emailUse) {
			throw new pGException("Estudante já cadastrado");
		}*/
		Student entity = new Student(dto);
		entity = studentRepository.save(entity);
		return new StudentDTO(entity);	
	}
}
