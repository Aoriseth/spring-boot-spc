package be.faros.springbootspc.repositories;

import be.faros.springbootspc.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    
}
