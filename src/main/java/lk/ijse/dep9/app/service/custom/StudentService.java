package lk.ijse.dep9.app.service.custom;

import lk.ijse.dep9.app.dto.StudentDTO;
import lk.ijse.dep9.app.service.SuperService;

public interface StudentService extends SuperService {

    void createNewStudent(StudentDTO studentDTO);

    StudentDTO getStudentInfo(String nic);

    void updateStudentDetails(StudentDTO studentDTO);

    void deleteStudent(String nic);
}
