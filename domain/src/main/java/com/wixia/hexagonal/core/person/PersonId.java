package com.wixia.hexagonal.core.person;

import org.immutables.value.Value;

@Value.Style(visibility = Value.Style.ImplementationVisibility.PACKAGE)
@Value.Immutable
public abstract class PersonId {
    @Value.Parameter
    public abstract String value();

    public static PersonId of(String value) {
        return ImmutablePersonId.of(value);
    }

    public static Builder builder() {
        return ImmutablePersonId.builder();
    }

    public interface Builder {
        Builder value(String value);
        PersonId build();
    }
}
