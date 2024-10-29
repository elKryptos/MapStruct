package it.objectmethod.school.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDto {
    private String name;

    public CourseDto(String name) {
        this.name = name;
    }

}
