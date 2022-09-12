package com.pequenosgenios.pg.repositories;

import com.pequenosgenios.pg.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByEmail(String email);
	@Query("SELECT obj FROM Student obj WHERE obj.classe.grade = :classId ORDER BY obj.name")
	List<Student> findByClass(@Param("classId") Integer id);
}
