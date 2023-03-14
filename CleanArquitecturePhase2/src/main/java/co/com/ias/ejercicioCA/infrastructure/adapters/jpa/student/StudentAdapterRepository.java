package co.com.ias.ejercicioCA.infrastructure.adapters.jpa.student;

import co.com.ias.ejercicioCA.domain.model.course.Course;
import co.com.ias.ejercicioCA.domain.model.gateway.IStudentRepository;
import co.com.ias.ejercicioCA.domain.model.student.Student;
import co.com.ias.ejercicioCA.infrastructure.adapters.jpa.course.ICourseAdapterRepository;
import co.com.ias.ejercicioCA.infrastructure.adapters.jpa.course.dbo.CourseDBO;
import co.com.ias.ejercicioCA.infrastructure.adapters.jpa.student.entity.StudentDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class StudentAdapterRepository implements IStudentRepository {
    private final IStudentAdapterRepository iStudentAdapterRepository;
    private final ICourseAdapterRepository iCourseAdapterRepository;

    @Override
    public Student saveStudent(Student student, Course course) {
        StudentDBO studentDBO = new StudentDBO().fromDomain(student);
        CourseDBO courseDBO = new CourseDBO().fromDomain(course);
        studentDBO.setCourseDBO(courseDBO);
        return studentDBO.toDomain(iStudentAdapterRepository.save(studentDBO));
    }

    @Override
    public List<Student> searchStudents() {
        return iStudentAdapterRepository.findAll().stream().map(a -> a.toDomain(a)).collect(Collectors.toList());
    }

    @Override
    public Student findById(Long id) {
        Optional<StudentDBO> studentDBO = iStudentAdapterRepository.findById(id);
        if (studentDBO.isPresent()){
            return studentDBO.get().toDomain(studentDBO.get());
        }else {
            return null;
        }
    }

    @Override
    public List<Student> findStudentByCourse(Long id) {
        Optional<CourseDBO> courseDBO = iCourseAdapterRepository.findById(id);
        List<StudentDBO> studentDBOList = iStudentAdapterRepository.findByCourseDBO(courseDBO.get());
        return studentDBOList.stream().map(a->a.toDomain(a)).collect(Collectors.toList());

    }

}
