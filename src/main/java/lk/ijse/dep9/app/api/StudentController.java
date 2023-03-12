package lk.ijse.dep9.app.api;

import lk.ijse.dep9.app.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public StudentDTO createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return studentDTO;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{nic}", produces = "application/json")
    public StudentDTO getStudentDetails(@PathVariable String nic) {
        return null;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping(value = "/{nic}", consumes = "application/json", produces = "application/json")
    public StudentDTO updateStudent(String nic, StudentDTO studentDTO) {
        return studentDTO;
    }
}
