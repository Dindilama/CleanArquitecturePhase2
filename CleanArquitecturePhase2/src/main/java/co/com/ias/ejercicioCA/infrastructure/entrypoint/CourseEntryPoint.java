package co.com.ias.ejercicioCA.infrastructure.entrypoint;


import co.com.ias.ejercicioCA.domain.model.course.dto.CourseDTO;
import co.com.ias.ejercicioCA.domain.usecase.CourseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseEntryPoint {

    private final CourseUseCase courseUseCase;

    @PostMapping(value = "/saveCourse")
    public ResponseEntity<?> saveCourse(@RequestBody CourseDTO courseDTO){
        return ResponseEntity.ok().body(courseUseCase.saveCourse(courseDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        //Optional<CourseDTO>
        return ResponseEntity.ok().body(courseUseCase.findById(id));
    }

    @GetMapping("/findCourses")
    public ResponseEntity<?> findCourses(){
        return ResponseEntity.ok().body(courseUseCase.findCourses());
    }

}
