package com.wixia.hexagonal.core.owner;

import com.wixia.hexagonal.core.visit.Visit;
import org.immutables.value.Value;

import java.time.LocalDate;
import java.util.Set;

@Value.Immutable
public interface Pet {
    LocalDate birthDate();
    PetType type();
    Owner owner();

    Set<Visit> visits();
}
