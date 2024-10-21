package it.objectmethod.school.controllers;

import it.objectmethod.school.dtos.CourseDto;
import it.objectmethod.school.models.Course;
import it.objectmethod.school.responses.CourseResponse;
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
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable int id) {
        CourseResponse response = courseService.getCourseById(id);
        if(response != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<CourseResponse> createCourse(@RequestBody CourseDto courseDto) {
        CourseResponse response = courseService.createCourse(courseDto);
        if (response != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}

