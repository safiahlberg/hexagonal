package com.wixia.hexagonal.core.owner;

import com.wixia.hexagonal.core.visit.Visit;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Builder
public @Data class Pet {
    private LocalDate birthDate;
    private PetType type;
    private Owner owner;

    private Set<Visit> visits;
}
