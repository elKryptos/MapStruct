package it.objectmethod.school.controllers;

import it.objectmethod.school.dtos.StudentDto;
import it.objectmethod.school.filters.StudentParams;
import it.objectmethod.school.responses.ResponseWrapper;
import it.objectmethod.school.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    @PutMapping("/updateStudent")
    public ResponseEntity<ResponseWrapper<StudentDto>> updateStudent(@RequestParam Integer id, @RequestBody StudentDto studentDto) {
        ResponseWrapper<StudentDto> response = studentService.updateStudent(id, studentDto);
        if (response != null)
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper<StudentDto>> deleteStudent(@PathVariable Integer id) {
        ResponseWrapper<StudentDto> response = studentService.deleteStudent(id);
        if (response != null) return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name")
    public ResponseEntity<ResponseWrapper<List<StudentDto>>> findByName(@RequestParam String name) {
        ResponseWrapper<List<StudentDto>> response = studentService.findByName(name);
        if (response != null) return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name1")
    public ResponseEntity<ResponseWrapper<List<StudentDto>>> byName1(@RequestParam String name) {
        ResponseWrapper<List<StudentDto>> response = studentService.findByName(name);
        if (response != null) return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/surname")
    public ResponseEntity<ResponseWrapper<List<StudentDto>>> findBySurname(@RequestParam String surname) {
        ResponseWrapper<List<StudentDto>> response = studentService.findBySurname(surname);
        if (response != null) return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/filter")
    public ResponseEntity<ResponseWrapper<List<StudentDto>>> findByNameAndSurname(final StudentParams studentParams) {
        ResponseWrapper<List<StudentDto>> response = studentService.findStudentByNameAndSurname(studentParams);
        if (response != null) return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping("/query/{}")
//    public ResponseEntity<ResponseWrapper<List<StudentDto>>> findStudentById(@PathVariable int courseId) {
//        ResponseWrapper<List<StudentDto>> response = studentService.findStudentByCourseId(courseId);
//        if (response != null) {
//            return ResponseEntity
//                    .status(HttpStatus.OK)
//                    .body(response);
//        }
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(new ResponseWrapper<>("Utente non trovato"));
//    }

    @GetMapping("all/{studentId}")
    public ResponseEntity<ResponseWrapper<List<StudentDto>>> findStudentByInscriptionsAndCourse (@PathVariable int studentId){
        ResponseWrapper<List<StudentDto>> response = studentService.findStudentByInscriptionsAndCourse(studentId);
        if (response != null) return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
