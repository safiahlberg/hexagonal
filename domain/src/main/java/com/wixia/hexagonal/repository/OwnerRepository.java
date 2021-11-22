package com.wixia.hexagonal.repository;

import com.wixia.hexagonal.core.owner.Owner;
import com.wixia.hexagonal.core.person.PersonId;

import java.util.Optional;

public interface OwnerRepository {
    void save(Owner owner);

    Optional<Owner> findByPersonId(PersonId personId);

    Iterable<Owner> findAll();
}