package com.pequenosgenios.pg.repositories;

import com.pequenosgenios.pg.domain.Class;
import com.pequenosgenios.pg.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
}
