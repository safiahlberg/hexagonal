package com.wixia.hexagonal.ports;

import com.wixia.hexagonal.core.owner.ImmutableOwner;
import com.wixia.hexagonal.core.owner.Owner;
import com.wixia.hexagonal.core.owner.Pet;
import com.wixia.hexagonal.core.person.PersonId;

import java.util.HashSet;
import java.util.Set;

public class DomainOwnerService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public DomainOwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void addPet(PersonId ownerId, Pet pet) {
        Owner owner = getOwner(ownerId);
        owner = ImmutableOwner.copyOf(owner).withPets(pet); // ImmutableOwner.builder().from(owner).addPets(pet).build();

        ownerRepository.save(owner);
    }

    @Override
    public void removePet(PersonId ownerId, Pet pet) {
        Owner owner = getOwner(ownerId);

        // We need to copy the set to avoid UnsupportedOperationException.
        // This also illustrates the immutability of Owner and its attributes.
        Set<Pet> pets = new HashSet<>(owner.pets());
        pets.remove(pet);

        owner = ImmutableOwner.copyOf(owner).withPets(pets); // ImmutableOwner.builder().from(owner).pets(pets).build();

        ownerRepository.save(owner);
    }

    @Override
    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    private Owner getOwner(PersonId ownerId) {
        return ownerRepository.findByPersonId(ownerId).orElseThrow(
                () -> new IllegalStateException("Owner not found"));
    }
}
