package isneverdead.farizspring3.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
//        return args -> {
//            Student fariz =  new Student(
//                    "Fariz",
//                    "fariz@local.com",
//                    LocalDate.of(2000, Month.FEBRUARY, 19)
//            );
//            Student akbar = new Student(
//                    "Akbar",
//                    "akbar@local.com",
//                    LocalDate.of(2001, Month.JANUARY, 20)
//            );
//            Student akbur = new Student(
//                    "Akbur",
//                    "akbur@local.com",
//                    LocalDate.of(2002, Month.MARCH, 18)
//            );
//            studentRepository.saveAll(List.of(fariz, akbar, akbur));
//        };
//    }
}
