package com.ledinhtuyenbkdn.springboottemplate.controller;

import com.ledinhtuyenbkdn.springboottemplate.service.dto.PetDTO;
import com.ledinhtuyenbkdn.springboottemplate.service.PetService;
import com.ledinhtuyenbkdn.springboottemplate.service.criteria.PetCriteria;
import com.ledinhtuyenbkdn.springboottemplate.util.HttpHeaderUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class PetController {

    private final PetService petService;

    @PostMapping("/pets")
    @Async
    public CompletableFuture<ResponseEntity<PetDTO>> createPet(@Valid @RequestBody PetDTO petDTO) {
        log.info("Request to create Pet: {}", petDTO);
        if (petDTO.getId() != null) {
            throw new RuntimeException("Id must be null");
        }
        petDTO = petService.createPet(petDTO);
        return CompletableFuture.completedFuture(
                ResponseEntity.ok(petDTO)
        );
    }

    @PutMapping("/pets/{id}")
    @Async
    public CompletableFuture<ResponseEntity<PetDTO>> updatePet(@Valid @RequestBody PetDTO petDTO, @PathVariable Long id) {
        log.info("Request to update Pet: {}", petDTO);
        if (petDTO.getId() == null) {
            throw new RuntimeException("Id must be not null");
        }
        if (!petDTO.getId().equals(id)) {
            throw new RuntimeException("Ids are not same");
        }
        petDTO = petService.updatePet(petDTO);
        return CompletableFuture.completedFuture(
                ResponseEntity.ok(petDTO)
        );
    }

    @GetMapping("/pets/{id}")
    @Async
    public CompletableFuture<ResponseEntity<PetDTO>> getPet(@PathVariable Long id) {
        log.info("Request to get Pet by Id: {}", id);
        PetDTO petDTO = petService.getPet(id);
        return CompletableFuture.completedFuture(
                ResponseEntity.ok(petDTO)
        );
    }

    @GetMapping("/pets")
    @Async
    public CompletableFuture<ResponseEntity<List<PetDTO>>> getAllPets(PetCriteria criteria, Pageable pageable) {
        log.info("Request to get all Pet by criteria: {}", criteria);
        Page<PetDTO> pets = petService.getAllPets(criteria, pageable);
        return CompletableFuture.completedFuture(
                ResponseEntity.ok()
                        .headers(HttpHeaderUtils.generatePaginationHttpHeaders(pets))
                        .body(pets.getContent())
        );
    }

    @DeleteMapping("/pets/{id}")
    @Async
    public CompletableFuture<ResponseEntity<Void>> deletePet(@PathVariable Long id) {
        log.info("Request to delete Pet with id: {}", id);
        if (id == null) {
            throw new RuntimeException("Id must be not null");
        }
        petService.deletePet(id);
        return CompletableFuture.completedFuture(
                ResponseEntity.noContent().build()
        );
    }
}
