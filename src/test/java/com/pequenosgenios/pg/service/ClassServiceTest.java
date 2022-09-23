package com.pequenosgenios.pg.service;

import com.pequenosgenios.pg.Builder;
import com.pequenosgenios.pg.domain.Class;
import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.domain.Teacher;
import com.pequenosgenios.pg.dto.ClassDTO;
import com.pequenosgenios.pg.dto.TeacherDTO;
import com.pequenosgenios.pg.repositories.ClassRepository;
import com.pequenosgenios.pg.services.impl.ClassService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClassServiceTest {
    @Mock
    ClassRepository classRepository;
    @InjectMocks
    ClassService underTest;

    @Test
    @DisplayName("Should return ClassDTO when receives ClassDTO")
    void register0() {
        Class expected = Builder.class1();

        when(classRepository.save(any(Class.class))).thenReturn(expected);

        ClassDTO response = underTest.insert(new ClassDTO(expected));

        assertEquals(expected.getId(), response.getId());
    }

    @Test
    @DisplayName("Throws RuntimeException when updating an object that doesn't exist")
    void update0() {
        when(classRepository.findById(anyLong())).thenReturn(Optional.empty());

        var exception = assertThrows(RuntimeException.class, () ->
                underTest.update(Builder.teacherDTO1().getId(), Builder.classDTO1()));

        String expectedMessage = "not found";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    @DisplayName("Should return ClassDTO when updating valid ClassDTO")
    void update1() {
        Class expected = Builder.class1();
        when(classRepository.findById(anyLong())).thenReturn(Optional.of(expected));

        when(classRepository.save(any(Class.class))).thenReturn(expected);

        ClassDTO argument = Builder.classDTO1();
        ClassDTO response = underTest.update(argument.getId(), argument);

    }

    @Test
    @DisplayName("Should return ClassDTO when receiving a valid id")
    void findById0() {
        ClassDTO argument = Builder.classDTO1();
        when(classRepository.findById(anyLong())).thenReturn(Optional.of(new Class(argument)));
        ClassDTO response = underTest.findById(1L);

        assertNotNull(response);
        assertEquals(argument, response);
        assertEquals(argument.getId(), response.getId());
    }

    @Test
    @DisplayName("Throws RuntimeException when id doesn't exist")
    void findById1() {
        when(classRepository.findById(anyLong())).thenReturn(Optional.empty());
        var exception = assertThrows(RuntimeException.class, () -> underTest.findById(1L));

        String expectedMessage = "not found";
        assertEquals(expectedMessage, exception.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("Should return Page<ClassDTO> when receives Pageable")
    void findAll0() {
        List<Class> list = List.of(Builder.class1(), Builder.class1(), Builder.class1());
        Page<Class> page = new PageImpl<>(list);
        when(classRepository.findAll(any(Pageable.class))).thenReturn(page);

        Page<ClassDTO> response = underTest.findAll(Pageable.unpaged());

        assertNotNull(response.getContent());
        assertEquals(page.getTotalElements(), response.getTotalElements());
        assertEquals(page.getContent().get(0).getId(), response.getContent().get(0).getId());
    }

    @Test
    @DisplayName("Throws PersonException when deleting id that doesn't exist")
    void delete0() {
        when(classRepository.findById(anyLong())).thenReturn(Optional.empty());

        var exception = assertThrows(RuntimeException.class, () -> underTest.delete(1L));

        String expectedMessage = "not found";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    @DisplayName("Should update Class with excluded true when receives id that exists")
    void delete1() {
        Class argument = Builder.class1();
        when(classRepository.findById(anyLong())).thenReturn(Optional.of(argument));

        Assertions.assertThatCode(() -> underTest.delete(1L))
                .doesNotThrowAnyException();
    }

}
