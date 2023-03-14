package co.com.ias.ejercicioCA.infrastructure.adapters.jpa.course;

import co.com.ias.ejercicioCA.domain.model.course.Course;
import co.com.ias.ejercicioCA.domain.model.gateway.ICourseRepository;
import co.com.ias.ejercicioCA.domain.model.student.Student;
import co.com.ias.ejercicioCA.infrastructure.adapters.jpa.course.dbo.CourseDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class CourseAdapterRepository implements ICourseRepository {

    private final ICourseAdapterRepository iCourseAdapterRepository;

    @Override
    public Course saveCourse(Course course) {
        CourseDBO courseDBO = new CourseDBO().fromDomain(course);
        return courseDBO.toDomain(iCourseAdapterRepository.save(courseDBO));
    }

    @Override
    public Course findById(Long id) {
        Optional<CourseDBO> courseDBO = iCourseAdapterRepository.findById(id);
        if (courseDBO.isPresent()) {
            return courseDBO.get().toDomain(courseDBO.get());
        } else {
            return null;
        }
    }

    @Override
    public List<Course> findCourses() {
        return iCourseAdapterRepository.findAll().stream().map(a -> a.toDomain(a)).collect(Collectors.toList());
    }
}
