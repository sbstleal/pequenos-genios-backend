package com.pequenosgenios.pg.resources;

import com.pequenosgenios.pg.domain.Teacher;
import com.pequenosgenios.pg.dto.NewTeacherDTO;
import com.pequenosgenios.pg.dto.TeacherDTO;
import com.pequenosgenios.pg.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherResource {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Teacher> find(@PathVariable Integer id) {
        Teacher obj = teacherService.find(id);
        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody NewTeacherDTO objDto) {
        Teacher obj = teacherService.fromDTO(objDto);
        obj = teacherService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        teacherService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update( @RequestBody TeacherDTO objDto, @PathVariable Integer id) {
        Teacher obj = teacherService.fromDTO(objDto);
        obj.setId(id);
        obj = teacherService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TeacherDTO>> findAll() {
        List<Teacher> list = teacherService.findAll();
        List<TeacherDTO> listDto = list.stream().map(obj -> new TeacherDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
