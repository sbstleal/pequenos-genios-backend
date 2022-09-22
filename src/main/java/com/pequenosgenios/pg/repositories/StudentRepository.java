package com.pequenosgenios.pg.repositories;

import com.pequenosgenios.pg.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByEmail(String email);

	Page<Student> findAllByNameContainsIgnoreCase(String name, Pageable pageable);

}