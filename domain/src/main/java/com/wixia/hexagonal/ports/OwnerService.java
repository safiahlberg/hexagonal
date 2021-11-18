package com.wixia.hexagonal.ports;

import com.wixia.hexagonal.core.owner.Owner;
import com.wixia.hexagonal.core.owner.Pet;
import com.wixia.hexagonal.core.person.PersonId;

public interface OwnerService {

    Owner addPet(PersonId ownerId, Pet pet);

    Owner removePet(PersonId ownerId, Pet pet);
}
