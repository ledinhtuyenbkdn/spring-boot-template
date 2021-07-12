package com.ledinhtuyenbkdn.springboottemplate.service.criteria;

import com.ledinhtuyenbkdn.springboottemplate.service.criteria.filter.LongFilter;
import com.ledinhtuyenbkdn.springboottemplate.service.criteria.filter.StringFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetCriteria {

    private LongFilter id;

    private StringFilter name;

    private StringFilter type;
}
