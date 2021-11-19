package com.wixia.hexagonal.ports;

import com.wixia.hexagonal.core.owner.*;
import com.wixia.hexagonal.core.person.ImmutablePersonId;
import com.wixia.hexagonal.core.person.PersonId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DomainOwnerServiceTest {

    private OwnerRepository ownerRepository;
    private DomainOwnerService tested;

    @BeforeEach
    void setUp() {
        ownerRepository = mock(OwnerRepository.class);
        tested = new DomainOwnerService(ownerRepository);
    }

    @Test
    void addPet() {

        final Owner expectedOwner = ImmutableOwner.builder()
                .id(ImmutablePersonId.builder().value("123456789").build())
                .firstName("John")
                .lastName("Doe")
                .build();
        final Pet pet = ImmutablePet.builder()
                .owner(expectedOwner)
                .name("Fido")
                .type(ImmutablePetType.builder().name("Dog").build())
                .build();

        when(ownerRepository.findByPersonId(expectedOwner.id())).thenReturn(Optional.of(expectedOwner));

        final Owner actualOwner = tested.addPet(expectedOwner.id(), pet);

        verify(ownerRepository).findByPersonId(expectedOwner.id());
        verify(ownerRepository).save(actualOwner);

        assertThat(actualOwner.pets()).extracting(Pet::name).contains("Fido");
    }

    @Test
    void removePet() {

        final PersonId personId = ImmutablePersonId.builder().value("123456789").build();
        final Owner expectedOwner = mock(Owner.class);
        final Pet pet = ImmutablePet.builder()
                .owner(expectedOwner)
                .name("Fido")
                .type(ImmutablePetType.builder().name("Dog").build())
                .build();
        final Set<Pet> pets = new HashSet<>();
        pets.add(pet);

        when(ownerRepository.findByPersonId(personId)).thenReturn(Optional.of(expectedOwner));
        when(expectedOwner.id()).thenReturn(personId);
        when(expectedOwner.firstName()).thenReturn("John");
        when(expectedOwner.lastName()).thenReturn("Doe");
        when(expectedOwner.pets()).thenReturn(pets);

        assertThat(expectedOwner.pets()).extracting(Pet::name).contains("Fido");

        final Owner actualOwner = tested.removePet(personId, pet);

        verify(ownerRepository).save(actualOwner);

        assertThat(actualOwner.pets()).extracting(Pet::name).doesNotContain("Fido");
    }
}