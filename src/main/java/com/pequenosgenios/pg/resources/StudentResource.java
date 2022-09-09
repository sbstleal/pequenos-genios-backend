package com.pequenosgenios.pg.resources;

import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.dto.NewStudentDTO;
import com.pequenosgenios.pg.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pequenosgenios.pg.services.StudentService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/student")
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> find(@PathVariable Integer id) {
        Student obj = studentService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody NewStudentDTO objDto) {
        Student obj = studentService.fromDTO(objDto);
        obj = studentService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update( @RequestBody StudentDTO objDto, @PathVariable Integer id) {
        Student obj = studentService.fromDTO(objDto);
        obj.setId(id);
        obj = studentService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> findAll() {
        List<Student> list = studentService.findAll();
        List<StudentDTO> listDto = list.stream().map(obj -> new StudentDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }


    @RequestMapping(value = "/class/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<NewStudentDTO>> findByClass(@PathVariable Integer id) {
        List<Student> list = studentService.findByClass(id);
        List<NewStudentDTO> listDto = list.stream().map(obj -> new NewStudentDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
