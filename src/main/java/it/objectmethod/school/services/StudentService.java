package it.objectmethod.school.services;

import it.objectmethod.school.dtos.StudentDto;
import it.objectmethod.school.mappers.StudentMapper;
import it.objectmethod.school.entities.Student;
import it.objectmethod.school.repositories.StudentRepository;
import it.objectmethod.school.responses.ResponseWrapper;
import it.objectmethod.school.responses.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return studentMapper.toDtoList(students);
    }

    public ResponseWrapper<StudentDto> findById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            StudentDto studentDto = studentMapper.toDto(student);
            return new ResponseWrapper<>("Student found", studentDto);
        }
        return new ResponseWrapper<>("Student not found", null);
    }

    public ResponseWrapper<StudentDto> createStudent(StudentDto studentDto) {
        if (studentDto.getName() == null || studentDto.getName().isEmpty() ||
                studentDto.getSurname() == null || studentDto.getSurname().isEmpty()) {
            return new ResponseWrapper<>("The blanks cannot be empty");
        }
//        student.setName(studentDto.getName());
//        student.setSurname(studentDto.getSurname());
        Student student = studentMapper.toEntity(studentDto);
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            return new ResponseWrapper<>("DB error creating the student");
        }
        return new ResponseWrapper<>("Student created successfully", studentDto);
    }
}
