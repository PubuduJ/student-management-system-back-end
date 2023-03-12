package lk.ijse.dep9.app.service.util;

import lk.ijse.dep9.app.dto.StudentDTO;
import lk.ijse.dep9.app.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Transformer {

    private final ModelMapper mapper;


    @Autowired
    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Student toStudentEntity(StudentDTO studentDTO) {
        return mapper.map(studentDTO, Student.class);
    }

    public StudentDTO toStudentDTO(Student studentEntity) {
        return mapper.map(studentEntity, StudentDTO.class);
    }
}
