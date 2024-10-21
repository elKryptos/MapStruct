package it.objectmethod.school.mappers;

import it.objectmethod.school.dtos.InscriptionDto;
import it.objectmethod.school.dtos.StudentDto;
import it.objectmethod.school.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public StudentDto toDto(Student student) {
        return Optional.ofNullable(student).map(stud -> {
            StudentDto studentDto = new StudentDto();
            studentDto.setName(stud.getName());
            studentDto.setSurname(stud.getSurname());

            List<InscriptionDto> inscriptionDtos = Optional.ofNullable(stud.getInscriptions())
                    .map(inscriptions -> inscriptions.stream()
                            .map(inscription -> new InscriptionDto(
                                    inscription.getRegistrationDate()
                            ))
                            .collect(Collectors.toList()))
                    .orElse(new ArrayList<>());
            studentDto.setInscriptionsDto(inscriptionDtos);
            return studentDto;
        }).orElseThrow(() -> new IllegalArgumentException("Student cannot be null"));
    }

    public Student toEntity(StudentDto studentDto) {
        return Optional.ofNullable(studentDto).map(dto -> {
            Student student = new Student();
            student.setName(studentDto.getName());
            student.setSurname(studentDto.getSurname());
            return student;
        }).orElseThrow(() -> new IllegalArgumentException("Student cannot be null"));
    }
}