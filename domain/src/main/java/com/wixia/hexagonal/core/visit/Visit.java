package com.wixia.hexagonal.core.visit;

import com.wixia.hexagonal.core.owner.Pet;
import org.immutables.value.Value;

import java.time.LocalDate;

@Value.Immutable
public interface Visit {
    LocalDate date();
    String description();
    Pet pet();
}
