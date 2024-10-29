package it.objectmethod.school.controllers;

import it.objectmethod.school.models.dtos.StudentDto;
import it.objectmethod.school.models.entities.Student;
import it.objectmethod.school.responses.StudentResponse;
import it.objectmethod.school.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAll(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable int id){
        StudentResponse response = studentService.findById(id);
        if (response != null) return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createStudent")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentDto studentDto){
        StudentResponse response = studentService.createStudent(studentDto);
        if (response != null)
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
