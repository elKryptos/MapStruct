package it.objectmethod.school.services;

import it.objectmethod.school.models.dtos.CourseDto;
import it.objectmethod.school.models.entities.Course;
import it.objectmethod.school.repositories.CourseRepository;
import it.objectmethod.school.responses.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseResponse getCourseById(int id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        CourseDto  courseDto = null;
        if(courseOptional.isPresent()) {
            Course course = courseOptional.get();
            courseDto = new CourseDto(course.getName());
            return new CourseResponse("Course found!", courseDto);
        }
        return new CourseResponse("Course not found!", courseDto);
    }

    public CourseResponse createCourse(CourseDto courseDto) {
        Course course = new Course();
        if (courseDto.getName() != null && courseDto.getName().isEmpty()) {
            return new CourseResponse("The blanks cannot be empty");
        }
        course.setName(courseDto.getName());
        courseRepository.save(course);
        return new CourseResponse("Course created", courseDto);
    }

}
