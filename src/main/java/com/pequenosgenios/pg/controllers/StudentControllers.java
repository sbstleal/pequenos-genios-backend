package com.pequenosgenios.pg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pequenosgenios.pg.dto.StudentDTO;
import com.pequenosgenios.pg.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentControllers {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<StudentDTO>> findAll() {
		List<StudentDTO> stDtos = studentService.findAll();
		return ResponseEntity.ok().body(stDtos);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<StudentDTO> findById(@PathVariable Integer id) throws Exception {
		StudentDTO studentDTO = studentService.findById(id);
		return ResponseEntity.created(null).body(studentDTO);
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO studentDTO) {
		studentDTO = studentService.insert(studentDTO);
		return ResponseEntity.created(null).body(studentDTO);
	}
}
