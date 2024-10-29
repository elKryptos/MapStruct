package it.objectmethod.school.models.dto;

import lombok.Data;

@Data
public class StudentDto {
    private String name;
    private String surname;

    public StudentDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
