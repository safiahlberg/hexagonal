package com.wixia.hexagonal.core.person;

import org.immutables.value.Value;

@Value.Immutable
public interface PersonId {
    String value();
}
