package be.faros.springbootspc.services.JPA;

import be.faros.springbootspc.model.Pet;
import be.faros.springbootspc.repositories.PetRepository;
import be.faros.springbootspc.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@Profile("springdatajpa")
public class PetJPAService implements PetService {

    private final PetRepository petRepository;

    public PetJPAService(PetRepository petRepository) {
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
