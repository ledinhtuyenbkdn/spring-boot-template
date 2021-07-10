package com.ledinhtuyenbkdn.springboottemplate.service.impl;

import com.ledinhtuyenbkdn.springboottemplate.constant.ExceptionConstants;
import com.ledinhtuyenbkdn.springboottemplate.dto.PetDTO;
import com.ledinhtuyenbkdn.springboottemplate.exception.BusinessException;
import com.ledinhtuyenbkdn.springboottemplate.mapper.PetMapper;
import com.ledinhtuyenbkdn.springboottemplate.model.Pet;
import com.ledinhtuyenbkdn.springboottemplate.repository.PetRepository;
import com.ledinhtuyenbkdn.springboottemplate.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    private final PetMapper petMapper;

    public PetDTO getPet(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ExceptionConstants.NOT_FOUND_PET));
        return petMapper.toDto(pet);
    }

}
