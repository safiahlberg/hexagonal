package com.wixia.hexagonal.core.vet;

import com.wixia.hexagonal.core.person.Person;
import lombok.Data;

import java.util.Set;

public @Data class Vet extends Person {
    private Set<Specialty> specialties;

}
