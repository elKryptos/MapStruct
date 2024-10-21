package it.objectmethod.school.mappers;

import java.util.List;

public interface BaseMappingMethod<DTO, ENTITY> {
    DTO toDto(ENTITY entity);

    ENTITY toEntity(DTO dto);

    List<DTO> toDtoList(List<ENTITY> entities);

    List<ENTITY> toEntityList(List<DTO> dtos);
}
