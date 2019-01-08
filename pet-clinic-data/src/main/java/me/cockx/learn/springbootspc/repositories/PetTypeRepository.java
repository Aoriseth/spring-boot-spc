package me.cockx.learn.springbootspc.repositories;

import me.cockx.learn.springbootspc.model.PetType;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
    Set<PetType> findAll();
}
