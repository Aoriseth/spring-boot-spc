package me.cockx.learn.springbootspc.services.JPA;

import me.cockx.learn.springbootspc.model.Pet;
import me.cockx.learn.springbootspc.repositories.PetRepository;
import me.cockx.learn.springbootspc.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@Profile("springdatajpa")
public class PetServiceJPA implements PetService {

    private final PetRepository petRepository;

    public PetServiceJPA(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
