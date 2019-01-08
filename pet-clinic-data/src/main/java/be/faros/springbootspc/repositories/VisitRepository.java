package be.faros.springbootspc.repositories;

import be.faros.springbootspc.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
