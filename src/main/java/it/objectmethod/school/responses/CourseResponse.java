package it.objectmethod.school.responses;

import it.objectmethod.school.models.dtos.CourseDto;
import lombok.Data;

@Data
public class CourseResponse {
    private String msg;
    private CourseDto courseDto;

    public CourseResponse(String msg) {
        this.msg = msg;
    }

    public CourseResponse(String msg, CourseDto courseDto) {
        this.msg = msg;
        this.courseDto = courseDto;
    }
}
