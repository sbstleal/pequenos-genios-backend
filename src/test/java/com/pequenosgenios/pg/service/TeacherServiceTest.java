package com.pequenosgenios.pg.service;

import com.pequenosgenios.pg.Builder;
import com.pequenosgenios.pg.domain.Teacher;
import com.pequenosgenios.pg.dto.TeacherDTO;
import com.pequenosgenios.pg.repositories.TeacherRepository;
import com.pequenosgenios.pg.services.impl.TeacherService;
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
public class TeacherServiceTest {
        @Mock
        TeacherRepository teacherRepository;
        @InjectMocks
        TeacherService underTest;

        @Test
        @DisplayName("Should return TeacherDTO when receives TeacherDTO")
        void register0() {
            Teacher expected = Builder.teacher1();

            when(teacherRepository.save(any(Teacher.class))).thenReturn(expected);

            TeacherDTO response = underTest.insert(new TeacherDTO(expected));

            assertEquals(expected.getId(), response.getId());
            assertEquals(expected.getName(), response.getName());
            assertEquals(expected.getPhone(), response.getPhone());
            assertEquals(expected.getEmail(), response.getEmail());
        }

        @Test
        @DisplayName("Throws RuntimeException when updating an object that doesn't exist")
        void update0() {
            when(teacherRepository.findById(anyLong())).thenReturn(Optional.empty());

            var exception = assertThrows(RuntimeException.class, () ->
                            underTest.update(Builder.teacherDTO1().getId(), Builder.teacherDTO1()));

            String expectedMessage = "not found";
            assertEquals(expectedMessage, exception.getMessage());
        }

        @Test
        @DisplayName("Should return TeacherDTO when updating valid TeacherDTO")
        void update1() {
            Teacher expected = Builder.teacher1();
            when(teacherRepository.findById(anyLong())).thenReturn(Optional.of(expected));

            String newName = "new name";
            expected.setName(newName);
            when(teacherRepository.save(any(Teacher.class))).thenReturn(expected);

            TeacherDTO argument = Builder.teacherDTO1();
            argument.setName(newName);
            TeacherDTO response = underTest.update(argument.getId(), argument);

            assertEquals(newName, response.getName());
        }

        @Test
        @DisplayName("Should return TeacherDTO when receiving a valid id")
        void findById0() {
            TeacherDTO argument = Builder.teacherDTO1();
            when(teacherRepository.findById(anyLong())).thenReturn(Optional.of(new Teacher(argument)));
            TeacherDTO response = underTest.findById(1L);

            assertNotNull(response);
            assertEquals(argument, response);
            assertEquals(argument.getId(), response.getId());
        }

        @Test
        @DisplayName("Throws RuntimeException when id doesn't exist")
        void findById1() {
            when(teacherRepository.findById(anyLong())).thenReturn(Optional.empty());
            var exception = assertThrows(RuntimeException.class, () -> underTest.findById(1L));

            String expectedMessage = "not found";
            assertEquals(expectedMessage, exception.getMessage(), exception.getMessage());
        }

        @Test
        @DisplayName("Should return Page<TeacherDTO> when receives Pageable")
        void findAll0() {
            List<Teacher> list = List.of(Builder.teacher1(), Builder.teacher1(), Builder.teacher1());
            Page<Teacher> page = new PageImpl<>(list);
            when(teacherRepository.findAll(any(Pageable.class))).thenReturn(page);

            Page<TeacherDTO> response = underTest.findAll(Pageable.unpaged());

            assertNotNull(response.getContent());
            assertEquals(page.getTotalElements(), response.getTotalElements());
            assertEquals(page.getContent().get(0).getId(), response.getContent().get(0).getId());
        }

        @Test
        @DisplayName("Throws PersonException when deleting id that doesn't exist")
        void delete0() {
            when(teacherRepository.findById(anyLong())).thenReturn(Optional.empty());

            var exception = assertThrows(RuntimeException.class, () -> underTest.delete(1L));

            String expectedMessage = "not found";
            assertEquals(expectedMessage, exception.getMessage());
        }

        @Test
        @DisplayName("Should update Teacher with excluded true when receives id that exists")
        void delete1() {
            Teacher argument = Builder.teacher1();
            when(teacherRepository.findById(anyLong())).thenReturn(Optional.of(argument));

            Assertions.assertThatCode(() -> underTest.delete(1L))
                    .doesNotThrowAnyException();
        }

    }
