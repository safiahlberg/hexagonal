package com.wixia.hexagonal.core.owner;

import com.wixia.hexagonal.core.visit.Visit;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

public @Data class Pet {
    private LocalDate birthDate;
    private PetType type;
    private Owner owner;

    private Set<Visit> visits;
}
