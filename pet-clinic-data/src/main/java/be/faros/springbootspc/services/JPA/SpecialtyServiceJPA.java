package be.faros.springbootspc.services.JPA;

import be.faros.springbootspc.model.Specialty;
import be.faros.springbootspc.repositories.SpecialtyRepository;
import be.faros.springbootspc.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@Profile("springdatajpa")
public class SpecialtyServiceJPA implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceJPA(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
