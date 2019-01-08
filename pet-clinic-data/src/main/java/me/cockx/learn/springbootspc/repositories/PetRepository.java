package me.cockx.learn.springbootspc.repositories;

import me.cockx.learn.springbootspc.model.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PetRepository extends CrudRepository<Pet,Long> {

    Set<Pet> findAll();

}
