package be.faros.springbootspc.repositories;

import be.faros.springbootspc.model.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PetRepository extends CrudRepository<Pet,Long> {

    Set<Pet> findAll();

}
