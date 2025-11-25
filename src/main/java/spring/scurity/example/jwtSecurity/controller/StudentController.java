package spring.scurity.example.jwtSecurity.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.scurity.example.jwtSecurity.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController
{
    List<Student> students = new ArrayList<>(List.of(
            new Student("Somin","Ali",10,70),
            new Student("Vinay","Mali",12,50),
            new Student("Uday","Kiran",11,80)
    ));
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents()
    {
        return ResponseEntity.ok().body(students);
    }
    @PostMapping("/students")
    public ResponseEntity<Student> addStudents(@RequestBody Student student)
    {
        students.add(student);
        return ResponseEntity.ok(student);
    }
    @GetMapping("csrf-token")
    public ResponseEntity<Object> getCsrfToken(HttpServletRequest request)
    {

        return ResponseEntity.ok(request.getAttribute("_csrf"));
    }

}
