package it.objectmethod.school.services;

import it.objectmethod.school.dtos.StudentDto;
import it.objectmethod.school.mappers.StudentMapper;
import it.objectmethod.school.models.Student;
import it.objectmethod.school.repositories.StudentRepository;
import it.objectmethod.school.responses.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    public StudentResponse findById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        StudentDto studentDto = null;
        if (studentOptional.isPresent()) {
            Student student = new Student();
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
