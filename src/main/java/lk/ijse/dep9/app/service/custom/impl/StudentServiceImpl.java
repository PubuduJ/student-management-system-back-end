package lk.ijse.dep9.app.service.custom.impl;

import lk.ijse.dep9.app.dto.StudentDTO;
import lk.ijse.dep9.app.entity.Student;
import lk.ijse.dep9.app.repository.StudentRepository;
import lk.ijse.dep9.app.service.custom.StudentService;
import lk.ijse.dep9.app.service.exception.NotFoundException;
import lk.ijse.dep9.app.service.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final Transformer transformer;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, Transformer transformer) {
        this.studentRepository = studentRepository;
        this.transformer = transformer;
    }

    @Override
    @Transactional
    public void createNewStudent(StudentDTO studentDTO) {
        Optional<Student> student = studentRepository.findById(studentDTO.getNic());
        if (student.isEmpty()) studentRepository.save(transformer.toStudentEntity(studentDTO));
        else throw new DuplicateKeyException("A student is already exists with this nic number");
    }

    @Override
    @Transactional
    public StudentDTO getStudentInfo(String nic) {
        if (!studentRepository.existsById(nic)) throw new NotFoundException("Student doesn't exist");
        Optional<Student> student = studentRepository.findById(nic);
        return transformer.toStudentDTO(student.get());
    }

    @Override
    @Transactional
    public void updateStudentDetails(StudentDTO studentDTO) {
        Optional<Student> student = studentRepository.findById(studentDTO.getNic());
        if (student.isPresent()) studentRepository.save(transformer.toStudentEntity(studentDTO));
        else throw new NotFoundException("Student doesn't exist");
    }

    @Override
    @Transactional
    public void deleteStudent(String nic) {
        if (!studentRepository.existsById(nic)) throw new NotFoundException("Student doesn't exist");
        studentRepository.deleteById(nic);
    }
}
