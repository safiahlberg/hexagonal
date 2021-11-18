package com.wixia.hexagonal.ports;

import com.wixia.hexagonal.core.owner.*;
import com.wixia.hexagonal.core.person.ImmutablePersonId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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

        assert(actualOwner.pets()).contains(pet);
    }

    @Test
    void removePet() {
    }
}