package com.pequenosgenios.pg.resources;

import com.pequenosgenios.pg.dto.ClassDTO;
import com.pequenosgenios.pg.services.impl.ClassService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/class")
public class ClassResource {
    private final ClassService classService;

    public ClassResource(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public ResponseEntity<Page<ClassDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(this.classService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.classService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassDTO> update(@PathVariable Long id, @RequestBody ClassDTO classDTO) {
        return ResponseEntity.accepted().body(this.classService.update(id, classDTO));
    }

    @PostMapping
    public ResponseEntity<ClassDTO> insert(@RequestBody ClassDTO classDTO) {
        classDTO = this.classService.insert(classDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(classDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(classDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.classService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
