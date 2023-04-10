package lk.ijse.dep9.app.service.util;

import lk.ijse.dep9.app.dto.StudentDTO;
import lk.ijse.dep9.app.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransformerTest {

    @Mock
    private ModelMapper mapper;
    @InjectMocks
    private Transformer transformer;

    @Test
    void toStudentEntity() {
        StudentDTO studentDTO = new StudentDTO("123456789V", "Pubudu", "Horana", "071-1234567");
        Student student = new Student("123456789V", "Pubudu", "Horana", "071-1234567");

        when(mapper.map(studentDTO, Student.class)).thenReturn(student);

        assertEquals(student.toString(), transformer.toStudentEntity(studentDTO).toString());
    }

    @Test
    void toStudentDTO() {
        StudentDTO studentDTO = new StudentDTO("123456789V", "Pubudu", "Horana", "071-1234567");
        Student student = new Student("123456789V", "Pubudu", "Horana", "071-1234567");

        when(mapper.map(student, StudentDTO.class)).thenReturn(studentDTO);

        assertEquals(studentDTO.toString(), transformer.toStudentDTO(student).toString());
    }
}