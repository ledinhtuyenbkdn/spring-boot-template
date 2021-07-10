package com.ledinhtuyenbkdn.springboottemplate.mapper;

import com.ledinhtuyenbkdn.springboottemplate.dto.PetDTO;
import com.ledinhtuyenbkdn.springboottemplate.model.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {

    Pet toEntity(PetDTO petDto);

    PetDTO toDto(Pet pet);
}
