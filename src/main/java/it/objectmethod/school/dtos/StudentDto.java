package it.objectmethod.school.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentDto {
    private String name;
    private String surname;
    private List<InscriptionDto> inscriptionsDto;

    public StudentDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }



}
