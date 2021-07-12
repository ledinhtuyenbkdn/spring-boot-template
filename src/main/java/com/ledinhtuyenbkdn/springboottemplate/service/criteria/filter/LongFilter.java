package com.ledinhtuyenbkdn.springboottemplate.service.criteria.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LongFilter {

    private Long equals;

    private Long notEquals;
}
