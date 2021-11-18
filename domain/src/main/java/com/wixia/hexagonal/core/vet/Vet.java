package com.wixia.hexagonal.core.vet;

import com.wixia.hexagonal.core.person.Person;
import org.immutables.value.Value;

import java.util.Set;

@Value.Immutable
public interface Vet extends Person {
    Set<Specialty> specialties();

}
