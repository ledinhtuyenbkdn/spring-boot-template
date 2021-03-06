package com.ledinhtuyenbkdn.springboottemplate.service;

import com.ledinhtuyenbkdn.springboottemplate.service.dto.PetDTO;
import com.ledinhtuyenbkdn.springboottemplate.service.criteria.PetCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PetService {

    PetDTO createPet(PetDTO petDTO);

    PetDTO updatePet(PetDTO petDTO);

    PetDTO getPet(Long id);

    Page<PetDTO> getAllPets(PetCriteria petCriteria, Pageable pageable);

    void deletePet(Long id);
}
