package it.objectmethod.school.mappers;

import it.objectmethod.school.dtos.InscriptionDto;
import it.objectmethod.school.entities.Inscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InscriptionMapper extends BaseMappingMethod<InscriptionDto, Inscription> {
    @Override
    @Mapping(target = "studentId", source = "student.studentId")
    @Mapping(target = "courseId", source = "course.courseId")
    @Mapping(target = "courseDto", source = "course")
    InscriptionDto toDto(Inscription inscription);

    @Override
    @Mapping(target = "student.studentId", source = "studentId")
    @Mapping(target = "course.courseId", source = "courseId")
    @Mapping(target = "course", source = "courseDto")
    Inscription toEntity(InscriptionDto inscriptionDto);

    @Override
    List<InscriptionDto> toDtoList(List<Inscription> inscriptions);

    @Override
    List<Inscription> toEntityList(List<InscriptionDto> inscriptionDtos);

}
