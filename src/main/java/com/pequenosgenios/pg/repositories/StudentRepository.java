package com.pequenosgenios.pg.repositories;

import com.pequenosgenios.pg.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
