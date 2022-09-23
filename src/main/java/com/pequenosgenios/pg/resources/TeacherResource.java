package com.pequenosgenios.pg.resources;

import com.pequenosgenios.pg.dto.TeacherDTO;
import com.pequenosgenios.pg.services.impl.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/teacher")
public class TeacherResource {
    private final TeacherService teacherService;

    public TeacherResource(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<Page<TeacherDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(this.teacherService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.teacherService.findById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<TeacherDTO>> findByName(@PathVariable String name, Pageable pageable) {
        return ResponseEntity.ok(this.teacherService.findByName(name, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> update(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO) {
        return ResponseEntity.accepted().body(this.teacherService.update(id, teacherDTO));
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> insert(@RequestBody TeacherDTO newTeacherDTO) {
        TeacherDTO teacherDTO = this.teacherService.insert(newTeacherDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(teacherDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(teacherDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.teacherService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
