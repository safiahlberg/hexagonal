package com.wixia.hexagonal.core.owner;

import com.wixia.hexagonal.core.person.Person;
import org.immutables.value.Value;

import java.util.Set;

@Value.Immutable
public interface Owner extends Person {
    String address();
    String city();
    String telephone();

    Set<Pet> pets();
}
