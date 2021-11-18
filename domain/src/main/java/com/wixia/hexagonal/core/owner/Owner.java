package com.wixia.hexagonal.core.owner;

import com.wixia.hexagonal.core.person.Person;
import org.immutables.value.Value;

import java.util.Optional;
import java.util.Set;

@Value.Immutable
public interface Owner extends Person {
    Optional<String> address();
    Optional<String> city();
    Optional<String> telephone();

    Set<Pet> pets();
}
