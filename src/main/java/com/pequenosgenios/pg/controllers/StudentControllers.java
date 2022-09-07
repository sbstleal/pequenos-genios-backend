package com.pequenosgenios.pg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pequenosgenios.pg.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentControllers {

	@Autowired
	private StudentService studentService;
}
