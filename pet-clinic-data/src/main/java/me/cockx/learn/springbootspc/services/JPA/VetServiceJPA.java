package me.cockx.learn.springbootspc.services.JPA;

import me.cockx.learn.springbootspc.model.Vet;
import me.cockx.learn.springbootspc.repositories.VetRepository;
import me.cockx.learn.springbootspc.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetServiceJPA implements VetService {
    private final VetRepository vetRepository;

    public VetServiceJPA(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }


    @Override
    public Vet findByLastName(String lastName) {
        return vetRepository.findByLastName(lastName);
    }

    @Override
    public Set<Vet> findAll() {
        return vetRepository.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
