package be.faros.springbootspc.repositories;

import be.faros.springbootspc.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
