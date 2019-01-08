package be.faros.springbootspc.repositories;

import be.faros.springbootspc.model.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VisitRepository extends CrudRepository<Visit,Long> {
    Set<Visit> findAll();
}
