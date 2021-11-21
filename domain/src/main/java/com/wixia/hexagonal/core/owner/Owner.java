package com.wixia.hexagonal.core.owner;

import com.wixia.hexagonal.core.person.Person;
import com.wixia.hexagonal.core.person.PersonId;
import org.immutables.value.Value;

import java.util.Optional;
import java.util.Set;

@Value.Style(visibility = Value.Style.ImplementationVisibility.PACKAGE)
@Value.Immutable
public abstract class Owner implements Person {
    @Value.Parameter
    public abstract Optional<String> address();

    @Value.Parameter
    public abstract Optional<String> city();

    @Value.Parameter
    public abstract Optional<String> telephone();

    @Value.Parameter
    public abstract Set<Pet> pets();

    public static Owner of(String firstName,
                           String lastName,
                           PersonId id,
                           String name,
                           String address,
                           String city,
                           String telephone,
                           Set<Pet> pets) {
        return ImmutableOwner.of(firstName,
                lastName,
                id,
                name,
                address,
                city,
                telephone,
                pets);
    }

    public static Builder builder() {
        return ImmutableOwner.builder();
    }

    public interface Builder extends Person.Builder {
        Builder address(String address);

        Builder city(String city);

        Builder telephone(String telephone);

        Builder pets(Set<Pet> pets);

        Owner build();
    }
}
