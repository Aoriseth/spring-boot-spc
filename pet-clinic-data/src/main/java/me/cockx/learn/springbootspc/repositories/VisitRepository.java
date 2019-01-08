package me.cockx.learn.springbootspc.repositories;

import me.cockx.learn.springbootspc.model.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VisitRepository extends CrudRepository<Visit,Long> {
    Set<Visit> findAll();
}
