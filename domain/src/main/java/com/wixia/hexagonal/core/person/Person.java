package com.wixia.hexagonal.core.person;

public interface Person {
    String firstName();
    String lastName();

    PersonId id();

     interface Builder {
        Builder id(PersonId id);
        Builder firstName(String firstName);
        Builder lastName(String lastName);

        Person build();
    }
}
