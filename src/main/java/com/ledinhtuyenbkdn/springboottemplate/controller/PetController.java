package com.ledinhtuyenbkdn.springboottemplate.controller;

import com.ledinhtuyenbkdn.springboottemplate.dto.PetDTO;
import com.ledinhtuyenbkdn.springboottemplate.model.Pet;
import com.ledinhtuyenbkdn.springboottemplate.service.PetService;
import com.ledinhtuyenbkdn.springboottemplate.service.criteria.PetCriteria;
import com.ledinhtuyenbkdn.springboottemplate.util.HttpHeaderUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class PetController {

    private final PetService petService;

    @GetMapping("/pets/{id}")
    public ResponseEntity<PetDTO> getPet(@PathVariable Long id) {
        log.info("Request to get Pet by Id: {}", id);
        PetDTO petDTO = petService.getPet(id);
        return ResponseEntity.ok(petDTO);
    }

    @GetMapping("/pets")
    public ResponseEntity<List<PetDTO>> getAllPets(PetCriteria criteria, Pageable pageable) {
        log.info("Request to get all Pet by criteria: {}", criteria);
        Page<PetDTO> pets = petService.getAllPets(criteria, pageable);
        return ResponseEntity.ok().headers(HttpHeaderUtils.generatePaginationHttpHeaders(pets)).body(pets.getContent());
    }
}
