package it.objectmethod.school.services;

import it.objectmethod.school.models.dtos.StudentDto;
import it.objectmethod.school.models.entities.Student;
import it.objectmethod.school.repositories.StudentRepository;
import it.objectmethod.school.responses.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public StudentResponse findById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        StudentDto studentDto = null;
        if (studentOptional.isPresent()) {
            Student student;
            student = studentOptional.get();
            studentDto = new StudentDto(student.getName(), student.getSurname());
            return new StudentResponse("Student found", studentDto);
        }
        return new StudentResponse("Student not found", studentDto);
    }

    public StudentResponse createStudent(StudentDto studentDto) {
        Student student = new Student();
        if (studentDto.getName() == null || studentDto.getName().isEmpty() ||
                studentDto.getSurname() == null || studentDto.getSurname().isEmpty()) {
            return new StudentResponse("The blanks cannot be empty");
        }
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            return new StudentResponse("DB error creating the student");
        }
        return new StudentResponse("Student created successfully", studentDto);
    }
}
