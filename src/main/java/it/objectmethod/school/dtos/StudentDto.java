package it.objectmethod.school.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentDto {
    private String name;
    private String surname;
    private List<InscriptionDto> inscriptionsDto = new ArrayList<>();

}
