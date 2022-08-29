package co.develhope.email1.services;

import co.develhope.email1.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    static List<Student> students = Arrays.asList(
            new Student("1", "Davide", "Allega", "davideallega@gmail.com"),
            new Student("2", "Stoccolma", "Sindrome", "sindrome@stoccolma.com"),
            new Student("3", "Il", "Professore", "professore@il.com"),
            new Student("4", "Monte", "Bianco", "non@sniffo.mexico")
    );

    public Student getStudentById(String studentId) {
        Optional<Student> studentFromList = students.stream().filter(student -> student.getId().equals(studentId)).findAny();
        if(studentFromList.isPresent())return studentFromList.get();
        return null;
    }
}
