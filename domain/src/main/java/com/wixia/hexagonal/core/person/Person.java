package com.wixia.hexagonal.core.person;

import org.immutables.value.Value;

@Value.Style(visibility = Value.Style.ImplementationVisibility.PACKAGE)
@Value.Immutable
public abstract class Person {
    @Value.Parameter public abstract String firstName();
    @Value.Parameter public abstract String lastName();

    @Value.Parameter public abstract PersonId id();

    public static Person of(PersonId id, String firstName, String lastName) {
        return ImmutablePerson.of(id, firstName, lastName);
    }

    public static Builder builder() {
        return ImmutablePerson.builder();
    }

    public interface Builder {
        Builder id(PersonId id);
        Builder firstName(String firstName);
        Builder lastName(String lastName);

        Person build();
    }
}
