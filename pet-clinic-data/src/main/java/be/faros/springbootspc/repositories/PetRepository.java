package be.faros.springbootspc.repositories;

import be.faros.springbootspc.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
