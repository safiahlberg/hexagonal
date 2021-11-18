package com.wixia.hexagonal.core.owner;

import org.immutables.value.Value;

@Value.Immutable
public interface PetType {
    String name();
}
