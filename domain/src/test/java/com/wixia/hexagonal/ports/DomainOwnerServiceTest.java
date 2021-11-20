package com.wixia.hexagonal.ports;

import com.wixia.hexagonal.core.owner.*;
import com.wixia.hexagonal.core.person.ImmutablePersonId;
import com.wixia.hexagonal.core.person.PersonId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DomainOwnerServiceTest {

    private OwnerRepository ownerRepository;
    private DomainOwnerService tested;
    private ArgumentCaptor<Owner> ownerArgumentCaptor;

    @BeforeEach
    void setUp() {
        ownerRepository = mock(OwnerRepository.class);
        tested = new DomainOwnerService(ownerRepository);
        ownerArgumentCaptor = ArgumentCaptor.forClass(Owner.class);
    }

    @Test
    void addPet() {

        final PersonId personId = ImmutablePersonId.builder().value("123456789").build();
        final Owner expectedOwner = ImmutableOwner.builder()
                .id(personId)
                .firstName("John")
                .lastName("Doe")
                .build();

        final ImmutablePet pet = ImmutablePet.builder()
                .owner(expectedOwner)
                .name("Fido")
                .type(ImmutablePetType.builder().name("Dog").build())
                .build();

        when(ownerRepository.findByPersonId(personId)).thenReturn(Optional.of(expectedOwner));

        assertThat(expectedOwner.pets()).extracting(Pet::name).doesNotContain("Fido");

        tested.addPet(personId, pet);

        verify(ownerRepository).findByPersonId(personId);
        verify(ownerRepository).save(ownerArgumentCaptor.capture());

        assertThat(ownerArgumentCaptor.getValue().pets()).extracting(Pet::name).contains("Fido");

        // A bit redundant, but this shows the point of immutability
        assertThat(expectedOwner.pets()).extracting(Pet::name).doesNotContain("Fido");
    }

    @Test
    void removePet() {

        final PersonId personId = ImmutablePersonId.builder().value("123456789").build();
        Owner expectedOwner = ImmutableOwner.builder()
                .id(personId)
                .firstName("John")
                .lastName("Doe")
                .build();

        final Pet pet = ImmutablePet.builder()
                .owner(expectedOwner)
                .name("Fido")
                .type(ImmutablePetType.builder().name("Dog").build())
                .build();
        final Set<Pet> pets = new HashSet<>();
        pets.add(pet);
        expectedOwner = ImmutableOwner.copyOf(expectedOwner).withPets(pets);

        when(ownerRepository.findByPersonId(personId)).thenReturn(Optional.of(expectedOwner));

        assertThat(expectedOwner.pets()).extracting(Pet::name).contains("Fido");

        tested.removePet(personId, pet);

        verify(ownerRepository).findByPersonId(personId);
        verify(ownerRepository).save(ownerArgumentCaptor.capture());

        assertThat(ownerArgumentCaptor.getValue().pets()).extracting(Pet::name).doesNotContain("Fido");

        // A bit redundant, but this shows the point of immutability
        assertThat(expectedOwner.pets()).extracting(Pet::name).contains("Fido");
    }
}