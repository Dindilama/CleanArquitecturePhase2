package co.com.ias.ejercicioCA.infrastructure.adapters.jpa.student.entity;

import co.com.ias.ejercicioCA.domain.model.student.*;
import co.com.ias.ejercicioCA.domain.model.student.attributes.StudentId;
import co.com.ias.ejercicioCA.domain.model.student.attributes.StudentMail;
import co.com.ias.ejercicioCA.domain.model.student.attributes.StudentName;
import co.com.ias.ejercicioCA.domain.model.student.attributes.StudentPhone;
import co.com.ias.ejercicioCA.infrastructure.adapters.jpa.course.dbo.CourseDBO;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="student")
@Entity
public class StudentDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer phone;
    private String mail;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course", referencedColumnName = "id")
    private CourseDBO courseDBO;

    public StudentDBO(Long id, String name, Integer phone, String mail) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }

    public StudentDBO fromDomain (Student student) {
        return new StudentDBO(
                student.getId().getValue(),
                student.getName().getValue(),
                student.getPhone().getValue(),
                student.getMail().getValue()
        );
    }

    public Student toDomain (StudentDBO studentDBO) {
        return new Student(
                new StudentId(studentDBO.getId()),
                new StudentName(studentDBO.getName()),
                new StudentPhone(studentDBO.getPhone()),
                new StudentMail(studentDBO.getMail())
        );
    }
}
