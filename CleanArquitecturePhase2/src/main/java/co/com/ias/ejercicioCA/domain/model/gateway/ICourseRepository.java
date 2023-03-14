package co.com.ias.ejercicioCA.domain.model.gateway;

import co.com.ias.ejercicioCA.domain.model.course.Course;
import co.com.ias.ejercicioCA.domain.model.student.Student;

import javax.persistence.Id;
import java.util.List;

public interface ICourseRepository {


    Course saveCourse(Course course);

    Course findById(Long id);

    List<Course> findCourses();
}
