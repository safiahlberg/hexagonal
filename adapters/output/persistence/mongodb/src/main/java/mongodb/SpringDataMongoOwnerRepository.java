package mongodb;

import com.wixia.hexagonal.core.owner.Owner;
import com.wixia.hexagonal.core.person.PersonId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SpringDataMongoOwnerRepository extends MongoRepository<Owner, PersonId> {
    Optional<Owner> findByPersonId(PersonId personId);
}
