package it.objectmethod.school.controllers;

import it.objectmethod.school.dtos.StudentDto;
import it.objectmethod.school.responses.ResponseWrapper;
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
    public List<StudentDto> getAll() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<StudentDto>> getStudentById(@PathVariable int id) {
        ResponseWrapper<StudentDto> response = studentService.findById(id);
        if (response != null) return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createStudent")
    public ResponseEntity<ResponseWrapper<StudentDto>> createStudent(@RequestBody StudentDto studentDto) {
        ResponseWrapper<StudentDto> response = studentService.createStudent(studentDto);
        if (response != null)
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(null);
    }
}
