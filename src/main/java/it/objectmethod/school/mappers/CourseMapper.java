package it.objectmethod.school.mappers;

import it.objectmethod.school.dtos.CourseDto;
import it.objectmethod.school.models.Course;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseMapper {
    public CourseDto toDto(Course course) {
        if(course == null) return null;
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getCourseId());
        courseDto.setName(course.getName());
        return courseDto;
    }

    public Course toEntity(CourseDto courseDto) {
        Optional<CourseDto> optionalCourseDto = Optional.ofNullable(courseDto);
        if(optionalCourseDto.isPresent()) {
            Course course = new Course();
            course.setCourseId(optionalCourseDto.get().getId());
            course.setName(optionalCourseDto.get().getName());
            return course;
        }
        return null;
    }
}
