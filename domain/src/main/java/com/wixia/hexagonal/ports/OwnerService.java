package com.wixia.hexagonal.ports;

import com.wixia.hexagonal.core.owner.Owner;
import com.wixia.hexagonal.core.owner.Pet;
import com.wixia.hexagonal.core.person.PersonId;

public interface OwnerService {

    void addPet(PersonId ownerId, Pet pet);

    void removePet(PersonId ownerId, Pet pet);
}
