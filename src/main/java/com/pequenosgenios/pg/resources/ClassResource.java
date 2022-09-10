package com.pequenosgenios.pg.resources;

import com.pequenosgenios.pg.domain.Class;
import com.pequenosgenios.pg.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/class")
public class ClassResource {

    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Class> find(@PathVariable Integer id) {
        Class obj = classService.find(id);
        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Class>> findAll() {
        List<Class> list = classService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public ResponseEntity<String> studentAssigment(@RequestParam(value = "idclass") Integer idClass, @RequestParam(value = "idstudent") Integer idStudent) {
        classService.studentsAssigment(idClass, idStudent);

        return ResponseEntity.ok().body(new String("Aluno de id: " + idStudent + " foi cadastrado na " + idClass + " série!!"));

    }

    @RequestMapping(value = "/teacher", method = RequestMethod.PUT)
    public ResponseEntity<String> teacherAssigment(@RequestParam(value = "idclass") Integer idClass, @RequestParam(value = "idteacher") Integer idTeacher) {
        classService.teacherAssigment(idClass, idTeacher);

        return ResponseEntity.ok().body(new String("Teacher de id: " + idTeacher + " foi cadastrado na " + idClass + " série!!"));

    }
}
