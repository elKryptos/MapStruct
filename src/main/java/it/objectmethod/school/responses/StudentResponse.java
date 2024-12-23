package it.objectmethod.school.responses;

import it.objectmethod.school.models.dtos.StudentDto;
import lombok.Data;

@Data
public class StudentResponse {
    private String msg;
    private StudentDto studentDto;

    public StudentResponse(String msg) {
        this.msg = msg;
    }

    public StudentResponse(String msg, StudentDto studentDto) {
        this.msg = msg;
        this.studentDto = studentDto;
    }
    
}
