package com.wixia.hexagonal.core.person;

public interface Person {
    String firstName();
    String lastName();

    PersonId id();
}
