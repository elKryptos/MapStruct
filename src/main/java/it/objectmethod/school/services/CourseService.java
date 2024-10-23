package it.objectmethod.school.services;

import it.objectmethod.school.dtos.CourseDto;
import it.objectmethod.school.entities.Course;
import it.objectmethod.school.mappers.CourseMapper;
import it.objectmethod.school.repositories.CourseRepository;
import it.objectmethod.school.responses.ResponseWrapper;
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

    public ResponseWrapper<CourseDto> findById(int id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if(courseOptional.isPresent()) {
            Course course = courseOptional.get();
            CourseDto courseDto = courseMapper.toDto(course);
            return new ResponseWrapper<>("Course found!", courseDto);
        }
        return new ResponseWrapper<>("Course not found!", null);

//        return courseRepository.findById(id)
//                .map(course -> {
//                    CourseDto courseDto = courseMapper.toDto(course);
//                    return new CourseResponse("Course found", courseDto);
//                })
//                .orElseGet(() -> new CourseResponse("Course not found"));
    }

    public ResponseWrapper<CourseDto> createCourse(CourseDto courseDto) {
        if (courseDto.getName() == null || courseDto.getName().isEmpty()) {
            return new ResponseWrapper<>("Course name not found");
        }
        Course course = courseMapper.toEntity(courseDto);
        courseRepository.save(course);
        CourseDto savedCourseDto = courseMapper.toDto(course);
        return new ResponseWrapper<>("Course created", savedCourseDto);
    }

    public ResponseWrapper<CourseDto> updateCourse(int id, CourseDto courseDto) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if(courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setName(courseDto.getName());
            courseRepository.save(course);
            CourseDto savedCourseDto = courseMapper.toDto(course);
            return new ResponseWrapper<>("Course updated", savedCourseDto);
        }
        return new ResponseWrapper<>("Course not found!");
    }

    public ResponseWrapper<CourseDto> deleteCourse(int id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if(courseOptional.isPresent()) {
            Course course = courseOptional.get();
            courseRepository.delete(course);
            CourseDto savedCourseDto = courseMapper.toDto(course);
            return new ResponseWrapper<>("Course deleted", savedCourseDto);
        }
        return new ResponseWrapper<>("Course not found!");
    }

    public ResponseWrapper<CourseDto> findCourseByName(String name) {
        if (name == null || name.isEmpty()) {
            return new ResponseWrapper<>("Name not found");
        }
        Optional<Course> courseOptional = courseRepository.findCourseByName(name);
        if (courseOptional.isPresent()){
            Course course = courseOptional.get();
            return new ResponseWrapper<>("Course found!", courseMapper.toDto(course));
        }
        return new ResponseWrapper<>("Course not found!");

    }



}
