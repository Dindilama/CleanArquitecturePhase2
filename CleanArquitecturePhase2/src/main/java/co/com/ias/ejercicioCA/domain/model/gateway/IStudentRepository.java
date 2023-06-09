package co.com.ias.ejercicioCA.domain.model.gateway;

import co.com.ias.ejercicioCA.domain.model.course.Course;
import co.com.ias.ejercicioCA.domain.model.student.Student;

import java.util.List;

public interface IStudentRepository {
    Student saveStudent(Student student, Course course);

    List<Student> searchStudents();

    Student findById(Long id);
    List<Student> findStudentByCourse(Long id);
}
