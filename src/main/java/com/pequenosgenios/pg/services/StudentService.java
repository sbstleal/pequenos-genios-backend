package com.pequenosgenios.pg.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.pequenosgenios.pg.services.exceptions.DataIntegrityException;
import com.pequenosgenios.pg.services.exceptions.EmailAlredyExistsException;
import com.pequenosgenios.pg.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.dto.StudentDTO;
import com.pequenosgenios.pg.resources.exception.ResourceExceptionHandler;
import com.pequenosgenios.pg.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public Student find(Integer id) {
		Optional<Student> obj = studentRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", TipoL " + Student.class.getName()));
	}
	
	@Transactional
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student insert(Student obj) {
		boolean emailUse = studentRepository.findByEmail(obj.getEmail())
				.stream()
				.anyMatch(isStudent -> !isStudent.equals(obj));
		if (emailUse) {
			throw new EmailAlredyExistsException("Este email já existe");
		}
		obj.setId(null);
		return studentRepository.save(obj);
	}

	public Student update(Student obj) {
		Student newObj = find(obj.getId());
		updateData(newObj, obj);
		return studentRepository.save(newObj);
	}

	private void updateData(Student newObj, Student obj) {
		newObj.setName(obj.getName());
		newObj.setPhoneNumber(obj.getPhoneNumber());
		newObj.setFee(obj.getFee());
		newObj.setEmail(obj.getEmail());
		newObj.setStreet(obj.getStreet());
		newObj.setCity(obj.getCity());
		newObj.setCountry(obj.getCountry());
		newObj.setPostalCode(obj.getPostalCode());
		newObj.setState(obj.getState());
		newObj.setClasse(obj.getClasse());
	}

	public void delete(Integer id) {
		find(id);

		try{
			studentRepository.deleteById(id);
		}
		catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possivel excluir esse aluno");
		}
	}

	public Student fromDTO(StudentDTO objDto) {
		return new Student(
				objDto.getId(),
				objDto.getName(),
				objDto.getPhoneNumber(),
				objDto.getFee(),
				objDto.getEmail(),
				objDto.getStreet(),
				objDto.getCity(),
				objDto.getCountry(),
				objDto.getPostalCode(),
				objDto.getState());
	}
}
