package com.wixia.hexagonal.core.person;

import org.immutables.value.Value;

@Value.Immutable
public interface Person {
    String firstName();
    String lastName();
}
