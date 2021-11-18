package com.wixia.hexagonal.ports;

import com.wixia.hexagonal.core.owner.ImmutableOwner;
import com.wixia.hexagonal.core.owner.Owner;
import com.wixia.hexagonal.core.owner.Pet;
import com.wixia.hexagonal.core.person.PersonId;

import java.util.Set;

public class DomainOwnerService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public DomainOwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner addPet(PersonId ownerId, Pet pet) {
        Owner owner = getOwner(ownerId);
        owner = ImmutableOwner.builder().from(owner).addPets(pet).build();

        ownerRepository.save(owner);
        return owner;
    }

    @Override
    public Owner removePet(PersonId ownerId, Pet pet) {
        Owner owner = getOwner(ownerId);
        Set<Pet> pets = owner.pets();
        pets.remove(pet);
        owner = ImmutableOwner.builder().from(owner).pets(pets).build();

        ownerRepository.save(owner);
        return owner;
    }

    private Owner getOwner(PersonId ownerId) {
        return ownerRepository.findByPersonId(ownerId).orElseThrow(
                () -> new IllegalStateException("Owner not found"));
    }
}
