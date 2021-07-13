package com.ledinhtuyenbkdn.springboottemplate.util;

import com.ledinhtuyenbkdn.springboottemplate.service.criteria.filter.LongFilter;
import com.ledinhtuyenbkdn.springboottemplate.service.criteria.filter.StringFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.metamodel.SingularAttribute;

public class SpecificationUtils {

    private SpecificationUtils() {

    }

    public static <E> Specification<E> buildLongSpecification(LongFilter filter, SingularAttribute<E, Long> attribute) {
        if (filter.getEquals() != null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(attribute), filter.getEquals());
        }

        if (filter.getNotEquals() != null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(attribute), filter.getNotEquals());
        }

        return Specification.where(null);
    }

    public static <E> Specification<E> buildStringSpecification(StringFilter filter, SingularAttribute<E, String> attribute) {
        if (filter.getEquals() != null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(attribute), filter.getEquals());
        }

        if (filter.getNotEquals() != null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(attribute), filter.getNotEquals());
        }

        if (filter.getContains() != null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(attribute), "%" + filter.getContains() + "%");
        }

        if (filter.getNotContains() != null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.notLike(root.get(attribute), "%" + filter.getContains() + "%");
        }

        return Specification.where(null);
    }
}
