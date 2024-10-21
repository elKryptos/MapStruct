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

    public InscriptionDto(long registrationDate) {
        this.registrationDate = registrationDate;
    }

    public InscriptionDto(long registrationDate, Integer studentId, Integer courseId) {
        this.registrationDate = registrationDate;
        this.studentId = studentId;
        this.courseId = courseId;

    }

}
