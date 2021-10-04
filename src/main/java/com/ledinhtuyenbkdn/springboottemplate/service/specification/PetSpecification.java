package com.ledinhtuyenbkdn.springboottemplate.service.specification;

import com.ledinhtuyenbkdn.springboottemplate.model.Pet;
import com.ledinhtuyenbkdn.springboottemplate.model.Pet_;
import com.ledinhtuyenbkdn.springboottemplate.service.criteria.PetCriteria;
import com.ledinhtuyenbkdn.springboottemplate.util.SpecificationUtils;
import org.springframework.data.jpa.domain.Specification;

public class PetSpecification {

    public static Specification<Pet> createSpecification(PetCriteria criteria) {
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
