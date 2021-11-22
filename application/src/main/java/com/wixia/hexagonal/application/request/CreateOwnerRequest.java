package com.wixia.hexagonal.application.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wixia.hexagonal.core.owner.Owner;

import javax.validation.constraints.NotNull;

public class CreateOwnerRequest {

    @NotNull
    private Owner owner;

    @JsonCreator
    public CreateOwnerRequest(@JsonProperty("owner") @NotNull final Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }
}
