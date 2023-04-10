package lk.ijse.dep9.app.api;

import lk.ijse.dep9.app.dto.StudentDTO;
import lk.ijse.dep9.app.service.custom.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentService studentService;
    @InjectMocks
    private StudentController studentController;

    @Test
    void createStudent() {
        StudentDTO studentDTO = new StudentDTO("123456789V", "Pubudu Janith", "Horana", "077-1234567");

        studentService.createNewStudent(studentDTO);

        assertDoesNotThrow(() -> {
            studentController.createStudent(studentDTO);
        });
    }

    @Test
    void getStudentDetails() {
        String nic = "123456789V";
        StudentDTO studentDTO = new StudentDTO("123456789V", "Pubudu Janith", "Horana", "077-1234567");

        when(studentService.getStudentInfo(nic)).thenReturn(studentDTO);

        assertEquals(studentDTO.toString(), studentController.getStudentDetails(nic).toString());
    }

    @Test
    void updateStudent() {
        String nic = "123456789V";
        StudentDTO studentDTO = new StudentDTO("123456789V", "Pubudu Janith", "Horana", "077-1234567");

        studentService.updateStudentDetails(studentDTO);

        assertEquals(studentDTO.toString(), studentController.updateStudent(nic, studentDTO).toString());
    }

    @Test
    void deleteStudent() {
        String nic = "123456789V";

        studentService.deleteStudent(nic);

        assertDoesNotThrow(() -> {
            studentController.deleteStudent(nic);
        });
    }
}