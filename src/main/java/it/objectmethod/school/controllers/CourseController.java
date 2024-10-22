package it.objectmethod.school.controllers;

import it.objectmethod.school.dtos.CourseDto;
import it.objectmethod.school.responses.ResponseWrapper;
import it.objectmethod.school.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@CrossOrigin
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/all")
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<CourseDto>> findById(@PathVariable int id) {
        ResponseWrapper<CourseDto> response = courseService.findById(id);
        if(response != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseWrapper<CourseDto>> createCourse(@RequestBody CourseDto courseDto) {
        ResponseWrapper<CourseDto> response = courseService.createCourse(courseDto);
        if (response != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    public ResponseEntity<ResponseWrapper<CourseDto>> findCourseByName(@RequestParam String name) {
        ResponseWrapper<CourseDto> response = courseService.findCourseByName(name);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}

