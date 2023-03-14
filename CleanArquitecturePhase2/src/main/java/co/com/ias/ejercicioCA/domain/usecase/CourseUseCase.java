package co.com.ias.ejercicioCA.domain.usecase;

import co.com.ias.ejercicioCA.domain.model.course.Course;
import co.com.ias.ejercicioCA.domain.model.course.dto.CourseDTO;
import co.com.ias.ejercicioCA.domain.model.gateway.ICourseRepository;
import co.com.ias.ejercicioCA.domain.model.student.Student;

import java.util.List;


public class CourseUseCase {



    private final ICourseRepository iCourserepository;

    public CourseUseCase(ICourseRepository iCourserepository) {
        this.iCourserepository = iCourserepository;
    }

    public CourseDTO saveCourse(CourseDTO courseDTO){
        return courseDTO.fromDomain(iCourserepository.saveCourse(courseDTO.toDomain(courseDTO)));
    }

    public CourseDTO findById(Long id){
        try{
            CourseDTO courseDTO = new CourseDTO().fromDomain(iCourserepository.findById(id));
            return courseDTO;
        }catch (Exception e){
            return null;
        }
    }

    public List<Course> findCourses() {
       return iCourserepository.findCourses();
    }

}
