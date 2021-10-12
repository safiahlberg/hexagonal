package com.wixia.hexagonal.core.visit;

import com.wixia.hexagonal.core.owner.Pet;
import lombok.Data;

import java.time.LocalDate;

public @Data class Visit {
    private LocalDate date;
    private String description;
    private Pet pet;
}
