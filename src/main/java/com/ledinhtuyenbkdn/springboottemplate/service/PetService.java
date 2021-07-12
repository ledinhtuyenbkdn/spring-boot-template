package com.ledinhtuyenbkdn.springboottemplate.service;

import com.ledinhtuyenbkdn.springboottemplate.dto.PetDTO;
import com.ledinhtuyenbkdn.springboottemplate.service.criteria.PetCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PetService {

    PetDTO getPet(Long id);

    Page<PetDTO> getAllPets(PetCriteria petCriteria, Pageable pageable);
}
