package it.objectmethod.school.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDto {
    private Integer courseId;
    private String name;
}
