package it.objectmethod.school.mappers;

import it.objectmethod.school.dtos.InscriptionDto;
import it.objectmethod.school.dtos.StudentDto;
import it.objectmethod.school.entities.Inscription;
import it.objectmethod.school.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper extends BaseMappingMethod<StudentDto, Student> {

    @Override
    @Mapping(target = "inscriptionsDto", source = "inscriptions")
    StudentDto toDto(Student student);

    @Override
    Student toEntity(StudentDto studentDto);

    @Override
    List<StudentDto> toDtoList(List<Student> students);

    @Override
    List<Student> toEntityList(List<StudentDto> studentDtos);

    InscriptionDto toInscriptionDto(Inscription inscription);

    List<Inscription> toInscriptionEntity(List<InscriptionDto> inscriptionsDtos);

    List<InscriptionDto> toInscriptionDtoList(List<Inscription> inscriptions);

}
