package it.objectmethod.school.models.dtos;

import lombok.Data;

@Data
public class InscriptionDto {
    private Long inscriptionId;
    private Long registrationDate;
    private CourseDto course;
    private int studentId;
    private int courseId;

    public InscriptionDto() {}

    public InscriptionDto(Long inscriptionId, Long registrationDate, CourseDto course) {
        this.inscriptionId = inscriptionId;
        this.registrationDate = registrationDate;
        this.course = course;
    }

}
