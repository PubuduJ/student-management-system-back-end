package lk.ijse.dep9.app.service.custom.impl;

import lk.ijse.dep9.app.dto.StudentDTO;
import lk.ijse.dep9.app.entity.Student;
import lk.ijse.dep9.app.repository.StudentRepository;
import lk.ijse.dep9.app.service.util.Transformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private Transformer transformer;
    @InjectMocks
    private StudentServiceImpl studentServiceImpl;

    @Test
    void createNewStudent() {
        StudentDTO studentDTO = new StudentDTO("123456789V", "Pubudud", "Horana", "071-1234567");
        Student student = new Student("123456789V", "Pubudud", "Horana", "071-1234567");

        when(studentRepository.findById(studentDTO.getNic())).thenReturn(Optional.empty());
        when(transformer.toStudentEntity(studentDTO)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(student);

        assertDoesNotThrow(() -> {
            studentServiceImpl.createNewStudent(studentDTO);
        });
    }

    @Test
    void getStudentInfo() {
        String nic = "123456789V";
        StudentDTO studentDTO = new StudentDTO("123456789V", "Pubudud", "Horana", "071-1234567");
        Student student = new Student("123456789V", "Pubudud", "Horana", "071-1234567");

        when(studentRepository.existsById(nic)).thenReturn(true);
        when(studentRepository.findById(nic)).thenReturn(Optional.of(student));
        when(studentServiceImpl.getStudentInfo(nic)).thenReturn(studentDTO);

        assertEquals(nic, studentServiceImpl.getStudentInfo(nic).getNic());
    }

    @Test
    void updateStudentDetails() {
        StudentDTO studentDTO = new StudentDTO("123456789V", "Pubudud", "Horana", "071-1234567");
        Student student = new Student("123456789V", "Pubudud", "Horana", "071-1234567");

        when(studentRepository.findById(studentDTO.getNic())).thenReturn(Optional.of(student));
        when(transformer.toStudentEntity(studentDTO)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(student);

        assertDoesNotThrow(() -> {
            studentServiceImpl.updateStudentDetails(studentDTO);
        });
    }

    @Test
    void deleteStudent() {
        String nic = "123456789V";
        when(studentRepository.existsById(nic)).thenReturn(true);
        studentRepository.deleteById(nic);

        assertDoesNotThrow(() -> {
            studentServiceImpl.deleteStudent(nic);
        });
    }
}