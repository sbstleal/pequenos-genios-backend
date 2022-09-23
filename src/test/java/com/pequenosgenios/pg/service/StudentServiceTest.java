package com.pequenosgenios.pg.service;

import com.pequenosgenios.pg.Builder;
import com.pequenosgenios.pg.domain.Student;
import com.pequenosgenios.pg.dto.StudentDTO;
import com.pequenosgenios.pg.repositories.StudentRepository;
import com.pequenosgenios.pg.services.impl.StudentService;
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
public class StudentServiceTest {
        @Mock
        StudentRepository studentRepository;
        @InjectMocks
        StudentService underTest;

        @Test
        @DisplayName("Should return StudentDTO when receives StudentDTO")
        void register0() {
            Student expected = Builder.student1();

            when(studentRepository.save(any(Student.class))).thenReturn(expected);

            StudentDTO response = underTest.insert(new StudentDTO(expected));

            assertEquals(expected.getId(), response.getId());
            assertEquals(expected.getName(), response.getName());
            assertEquals(expected.getPhone(), response.getPhone());
            assertEquals(expected.getEmail(), response.getEmail());
        }

        @Test
        @DisplayName("Throws RuntimeException when updating an object that doesn't exist")
        void update0() {
            when(studentRepository.findById(anyLong())).thenReturn(Optional.empty());

            var exception = assertThrows(RuntimeException.class, () ->
                            underTest.update(Builder.teacherDTO1().getId(), Builder.studentDTO1()));

            String expectedMessage = "not found";
            assertEquals(expectedMessage, exception.getMessage());
        }

        @Test
        @DisplayName("Should return StudentDTO when updating valid StudentDTO")
        void update1() {
            Student expected = Builder.student1();
            when(studentRepository.findById(anyLong())).thenReturn(Optional.of(expected));

            String newName = "new name";
            expected.setName(newName);
            when(studentRepository.save(any(Student.class))).thenReturn(expected);

            StudentDTO argument = Builder.studentDTO1();
            argument.setName(newName);
            StudentDTO response = underTest.update(argument.getId(), argument);

            assertEquals(newName, response.getName());
        }

        @Test
        @DisplayName("Should return StudentDTO when receiving a valid id")
        void findById0() {
            StudentDTO argument = Builder.studentDTO1();
            when(studentRepository.findById(anyLong())).thenReturn(Optional.of(new Student(argument)));
            StudentDTO response = underTest.findById(1L);

            assertNotNull(response);
            assertEquals(argument, response);
            assertEquals(argument.getId(), response.getId());
        }

        @Test
        @DisplayName("Throws RuntimeException when id doesn't exist")
        void findById1() {
            when(studentRepository.findById(anyLong())).thenReturn(Optional.empty());
            var exception = assertThrows(RuntimeException.class, () -> underTest.findById(1L));

            String expectedMessage = "not found";
            assertEquals(expectedMessage, exception.getMessage(), exception.getMessage());
        }

        @Test
        @DisplayName("Should return Page<StudentDTO> when receives Pageable")
        void findAll0() {
            List<Student> list = List.of(Builder.student1(), Builder.student1(), Builder.student1());
            Page<Student> page = new PageImpl<>(list);
            when(studentRepository.findAll(any(Pageable.class))).thenReturn(page);

            Page<StudentDTO> response = underTest.findAll(Pageable.unpaged());

            assertNotNull(response.getContent());
            assertEquals(page.getTotalElements(), response.getTotalElements());
            assertEquals(page.getContent().get(0).getId(), response.getContent().get(0).getId());
        }

        @Test
        @DisplayName("Throws PersonException when deleting id that doesn't exist")
        void delete0() {
            when(studentRepository.findById(anyLong())).thenReturn(Optional.empty());

            var exception = assertThrows(RuntimeException.class, () -> underTest.delete(1L));

            String expectedMessage = "not found";
            assertEquals(expectedMessage, exception.getMessage());
        }

        @Test
        @DisplayName("Should update Student with excluded true when receives id that exists")
        void delete1() {
            Student argument = Builder.student1();
            when(studentRepository.findById(anyLong())).thenReturn(Optional.of(argument));

            Assertions.assertThatCode(() -> underTest.delete(1L))
                    .doesNotThrowAnyException();
        }

    }
