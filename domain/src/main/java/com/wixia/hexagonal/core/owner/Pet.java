package com.wixia.hexagonal.core.owner;

import com.wixia.hexagonal.core.visit.Visit;
import org.immutables.value.Value;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Value.Style(visibility = Value.Style.ImplementationVisibility.PACKAGE)
@Value.Immutable
public abstract class Pet {
    @Value.Parameter public abstract String name();
    @Value.Parameter public abstract Optional<LocalDate> birthDate();
    @Value.Parameter public abstract PetType type();
    @Value.Parameter public abstract Owner owner();

    @Value.Parameter public abstract Set<Visit> visits();

    public static Pet of(String name, LocalDate birthDate, PetType type, Owner owner, Set<Visit> visits) {
        return ImmutablePet.of(name, birthDate, type, owner, visits);
    }

    public interface Builder {
        Builder name(String name);
        Builder birthDate(LocalDate birthDate);
        Builder type(PetType type);
        Builder owner(Owner owner);
        Builder visits(Set<Visit> visits);

        Pet build();
    }
}
