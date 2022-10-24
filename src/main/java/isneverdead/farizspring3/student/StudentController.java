package isneverdead.farizspring3.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
    @PostMapping(path = "add")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @PostMapping(path = "delete/{studentId}")
    public void deleteStudentById(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);

    }
    @PostMapping(
            path = "update/{studentId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public void updateStudentById(@PathVariable("studentId") Long id, @RequestBody(required = false) Student student) {
        studentService.updateStudent(id, student);

    }
}
