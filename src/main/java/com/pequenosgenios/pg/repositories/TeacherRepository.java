package com.pequenosgenios.pg.repositories;

import com.pequenosgenios.pg.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByEmailAddress(String email);
}
