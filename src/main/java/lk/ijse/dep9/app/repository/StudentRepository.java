package lk.ijse.dep9.app.repository;

import lk.ijse.dep9.app.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
}
