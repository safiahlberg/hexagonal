package com.wixia.hexagonal.infrastructure.repository.mongo;

import com.wixia.hexagonal.core.owner.Owner;
import com.wixia.hexagonal.core.person.PersonId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataMongoOwnerRepository extends MongoRepository<Owner, PersonId> {
    Optional<Owner> findById(PersonId personId);
}
