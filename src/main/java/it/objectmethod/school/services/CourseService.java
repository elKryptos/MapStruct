package it.objectmethod.school.services;

import it.objectmethod.school.dtos.CourseDto;
import it.objectmethod.school.mappers.CourseMapper;
import it.objectmethod.school.models.Course;
import it.objectmethod.school.repositories.CourseRepository;
import it.objectmethod.school.responses.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(courseMapper::toDto).collect(Collectors.toList());
    }

    public CourseResponse getCourseById(int id) {
//        Optional<Course> courseOptional = courseRepository.findById(id);
//        CourseDto  courseDto = null;
//        if(courseOptional.isPresent()) {
//            Course course = courseOptional.get();
//            courseDto = new CourseDto(course.getName());
//            return new CourseResponse("Course found!", courseDto);
//        }
//        return new CourseResponse("Course not found!", courseDto);

        return courseRepository.findById(id)
                .map(course -> {
                    CourseDto courseDto = courseMapper.toDto(course);
                    return new CourseResponse("Course found", courseDto);
                })
                .orElseGet(() -> new CourseResponse("Course not found"));
    }

    public CourseResponse createCourse(CourseDto courseDto) {
        if (courseDto.getName() == null || courseDto.getName().isEmpty()) {
            return new CourseResponse("Course name not found");
        }
        Course course = courseMapper.toEntity(courseDto);
        courseRepository.save(course);
        CourseDto savedCourseDto = courseMapper.toDto(course);
        return new CourseResponse("Course created", savedCourseDto);
    }

}
