package com.wixia.hexagonal.application.rest;

import com.wixia.hexagonal.application.request.CreateOwnerRequest;
import com.wixia.hexagonal.core.owner.Owner;
import com.wixia.hexagonal.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/owners")
public class OwnerController {

    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createOwner(@RequestBody CreateOwnerRequest createOwnerRequest) {
        ownerService.saveOwner(createOwnerRequest.getOwner());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }
}
