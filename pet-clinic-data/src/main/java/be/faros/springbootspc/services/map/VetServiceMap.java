package be.faros.springbootspc.services.map;

import be.faros.springbootspc.model.Specialty;
import be.faros.springbootspc.model.Vet;
import be.faros.springbootspc.services.SpecialtyService;
import be.faros.springbootspc.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet t) {
        super.delete(t);
    }

    @Override
    public Vet save(Vet vet) {

        if(vet.getSpecialties().size()>0){
            vet.getSpecialties().forEach(specialty -> {
                if(specialty.getId()==null){
                    Specialty specialtySaved = specialtyService.save(specialty);
                    specialty.setId(specialtySaved.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
