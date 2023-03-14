package co.com.ias.ejercicioCA.infrastructure.entrypoint;

import co.com.ias.ejercicioCA.domain.model.student.dto.StudentDTO;
import co.com.ias.ejercicioCA.domain.usecase.StudentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentEntryPoint {

   private final StudentUseCase studentUseCase;

   @PostMapping(value = "/saveStudent")
   public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDTO){
       return ResponseEntity.ok().body(studentUseCase.saveStudent(studentDTO));
   }

    @GetMapping(value = "/searchStudents")
    public ResponseEntity<?> searchStudents(){
        return ResponseEntity.ok().body(studentUseCase.searchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(studentUseCase.findById(id));
    }

    @GetMapping("/findStudentByCourse/{id}")
    public ResponseEntity<?> findStudentByCourse(@PathVariable Long id){
        return ResponseEntity.ok().body(studentUseCase.findStudentsByCourse(id));
    }
}
