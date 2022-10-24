package isneverdead.farizspring3.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exist = studentRepository.existsById(id);
        if (!exist) {
            throw new IllegalStateException("Student with id "+ id +"does not exists");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, Student studentFromRequest) {
        Student updatedStudent = studentRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Student with id "+id+" does not exists")
        );

        if (
                studentFromRequest.getName() != null &&
                studentFromRequest.getName().length() > 0 &&
                !Objects.equals(updatedStudent.getName(), studentFromRequest.getName())
        ) {
            updatedStudent.setName(studentFromRequest.getName());
        }

        if (
                studentFromRequest.getEmail() != null &&
                studentFromRequest.getEmail().length() > 0 &&
                !Objects.equals(updatedStudent.getEmail(), studentFromRequest.getEmail())
        ) {
            boolean exist = studentRepository.findStudentByEmail(studentFromRequest.getEmail()).isPresent();
            if (exist) {
                throw new IllegalStateException("Email taken");
            }
            updatedStudent.setEmail(studentFromRequest.getEmail());
        }

        if (
                studentFromRequest.getDob() != null &&
                !Objects.equals(updatedStudent.getDob(), studentFromRequest.getDob())
        ) {
            updatedStudent.setDob(studentFromRequest.getDob());
        }
    }
}
