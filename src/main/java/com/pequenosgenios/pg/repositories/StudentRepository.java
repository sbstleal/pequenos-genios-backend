package com.pequenosgenios.pg.repositories;

import com.pequenosgenios.pg.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByEmail(String email);
}
