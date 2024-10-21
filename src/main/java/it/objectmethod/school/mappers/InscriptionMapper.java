package it.objectmethod.school.mappers;

import it.objectmethod.school.dtos.InscriptionDto;
import it.objectmethod.school.models.Inscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InscriptionMapper extends BaseMappingMethod<InscriptionDto, Inscription> {
    @Override
    @Mapping(source = "student.studentId", target = "studentId")
    @Mapping(source = "course.courseId", target = "courseId")
    InscriptionDto toDto(Inscription inscription);

    @Override
    @Mapping(source = "studentId", target = "student.studentId")
    @Mapping(source = "courseId", target = "course.courseId")
    Inscription toEntity(InscriptionDto inscriptionDto);

    @Override
    List<InscriptionDto> toDtoList(List<Inscription> inscriptions);

    @Override
    List<Inscription> toEntityList(List<InscriptionDto> inscriptionDtos);
}
