package it.objectmethod.school.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InscriptionDto {
    private Integer inscriptionId;
    private long registrationDate;
    private Integer studentId;
    private Integer courseId;
    private CourseDto courseDto;

}
