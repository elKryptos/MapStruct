package it.objectmethod.school.mappers;

import it.objectmethod.school.dtos.CourseDto;
import it.objectmethod.school.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper extends BaseMappingMethod <CourseDto, Course> {
    @Override
    CourseDto toDto(Course course);

    @Override
    Course toEntity(CourseDto dto);

    @Override
    List<CourseDto> toDtoList(List<Course> course);

    @Override
    List<Course> toEntityList(List<CourseDto> courseDto);

}
