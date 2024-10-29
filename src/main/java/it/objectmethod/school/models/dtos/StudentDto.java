package it.objectmethod.school.models.dtos;

import lombok.Data;

@Data
public class StudentDto {
    private String name;
    private String surname;

    public StudentDto() {}

    public StudentDto (String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
