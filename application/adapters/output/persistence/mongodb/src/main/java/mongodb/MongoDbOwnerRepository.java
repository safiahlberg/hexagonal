package mongodb;

import com.wixia.hexagonal.core.owner.Owner;
import com.wixia.hexagonal.core.person.PersonId;
import com.wixia.hexagonal.ports.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoDbOwnerRepository implements OwnerRepository {

    private SpringDataMongoOwnerRepository ownerRepository;

    @Autowired
    public MongoDbOwnerRepository(SpringDataMongoOwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void save(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public Optional<Owner> findByPersonId(PersonId personId) {
        return ownerRepository.findByPersonId(personId);
    }
}
