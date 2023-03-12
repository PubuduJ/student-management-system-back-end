package lk.ijse.dep9.app.api;

import lk.ijse.dep9.app.dto.StudentDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/students")
public class StudentController {

    public StudentDTO createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return studentDTO;
    }
}
