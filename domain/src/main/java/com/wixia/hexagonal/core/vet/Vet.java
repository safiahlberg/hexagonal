package com.wixia.hexagonal.core.vet;

import com.wixia.hexagonal.core.person.Person;
import org.immutables.value.Value;

import java.util.Set;

@Value.Style(visibility = Value.Style.ImplementationVisibility.PACKAGE)
@Value.Immutable
public abstract class Vet extends Person {
    @Value.Parameter public abstract Set<Specialty> specialties();

    public static Vet of(Set<Specialty> specialties) {
        return ImmutableVet.of(specialties);
    }

    public static ImmutableVet.Builder builder() {
        return ImmutableVet.builder();
    }

    public interface Builder {
        Builder specialties(Set<Specialty> specialties);

        Vet build();
    }
}
