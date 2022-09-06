package com.pequenosgenios.pg;

import com.pequenosgenios.pg.domain.Class;
import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.domain.Teacher;
import com.pequenosgenios.pg.repositories.ClassRepository;
import com.pequenosgenios.pg.repositories.StudentRepository;
import com.pequenosgenios.pg.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PgApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private ClassRepository classRepository;

	public static void main(String[] args) {

		SpringApplication.run(PgApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Estou funcionando");
	}
}
