package com.pequenosgenios.pg.resources;

import com.pequenosgenios.pg.dto.StudentDTO;
import com.pequenosgenios.pg.services.impl.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/student")
public class StudentResource {
    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Page<StudentDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(this.studentService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.studentService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<StudentDTO>> findByName(@PathVariable String name, Pageable pageable) {
        return ResponseEntity.ok(this.studentService.findByName(name, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.accepted().body(this.studentService.update(id, studentDTO));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> insert(@RequestBody StudentDTO newStudentDTO) {
        StudentDTO studentDTO = this.studentService.insert(newStudentDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(studentDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(studentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
