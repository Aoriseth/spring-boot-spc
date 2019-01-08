package be.faros.springbootspc.repositories;

import be.faros.springbootspc.model.Specialty;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
    Set<Specialty> findAll();
}
