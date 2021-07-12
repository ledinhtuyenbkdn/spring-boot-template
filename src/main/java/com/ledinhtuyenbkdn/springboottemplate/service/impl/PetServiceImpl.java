package com.ledinhtuyenbkdn.springboottemplate.service.impl;

import com.ledinhtuyenbkdn.springboottemplate.constant.ExceptionConstants;
import com.ledinhtuyenbkdn.springboottemplate.dto.PetDTO;
import com.ledinhtuyenbkdn.springboottemplate.exception.BusinessException;
import com.ledinhtuyenbkdn.springboottemplate.model.Pet_;
import com.ledinhtuyenbkdn.springboottemplate.service.criteria.PetCriteria;
import com.ledinhtuyenbkdn.springboottemplate.service.mapper.PetMapper;
import com.ledinhtuyenbkdn.springboottemplate.model.Pet;
import com.ledinhtuyenbkdn.springboottemplate.repository.PetRepository;
import com.ledinhtuyenbkdn.springboottemplate.service.PetService;
import com.ledinhtuyenbkdn.springboottemplate.util.SpecificationUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    private final PetMapper petMapper;

    @Override
    @Transactional(readOnly = true)
    public PetDTO getPet(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ExceptionConstants.NOT_FOUND_PET));
        return petMapper.toDto(pet);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PetDTO> getAllPets(PetCriteria criteria, Pageable pageable) {
        Specification<Pet> specification = createSpecification(criteria);
        Page<Pet> pets = petRepository.findAll(specification, pageable);
        return pets.map(petMapper::toDto);
    }

    private Specification<Pet> createSpecification(PetCriteria criteria) {
        Specification<Pet> specification = Specification.where(null);

        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(SpecificationUtils.buildLongSpecification(criteria.getId(), Pet_.id));
            }

            if (criteria.getName() != null) {
                specification = specification.and(SpecificationUtils.buildStringSpecification(criteria.getName(), Pet_.name));
            }

            if (criteria.getType() != null) {
                specification = specification.and(SpecificationUtils.buildStringSpecification(criteria.getType(), Pet_.type));
            }
        }
        return specification;
    }
}
