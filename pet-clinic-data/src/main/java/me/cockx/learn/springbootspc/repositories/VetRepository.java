package me.cockx.learn.springbootspc.repositories;

import me.cockx.learn.springbootspc.model.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VetRepository extends CrudRepository<Vet,Long> {
    Vet findByLastName(String lastName);
    Set<Vet> findAll();
}
