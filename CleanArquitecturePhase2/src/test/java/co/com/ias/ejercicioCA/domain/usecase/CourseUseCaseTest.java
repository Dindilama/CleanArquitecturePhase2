package co.com.ias.ejercicioCA.domain.usecase;

import co.com.ias.ejercicioCA.domain.model.course.Course;
import co.com.ias.ejercicioCA.domain.model.course.dto.CourseDTO;
import co.com.ias.ejercicioCA.domain.model.gateway.ICourseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
@SpringBootTest
class CourseUseCaseTest {


    @MockBean
    private ICourseRepository iCourseRepository;

    //Inyeccion de dependencias
    @InjectMocks
    private CourseUseCase courseUseCase;

    @Test
    void saveCourse() {
        CourseDTO courseDTO = new CourseDTO(1L, "seed");
        Course course = courseDTO.toDomain(courseDTO);
        when(iCourseRepository.saveCourse(any(Course.class))).thenReturn(course);

        CourseDTO answer = courseUseCase.saveCourse(courseDTO);

        assertNotNull(answer);
        assertEquals(answer.getName(), "seed");

    }


}