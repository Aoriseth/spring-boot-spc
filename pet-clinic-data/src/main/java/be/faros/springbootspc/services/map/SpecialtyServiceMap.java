package be.faros.springbootspc.services.map;

import be.faros.springbootspc.model.Specialty;
import be.faros.springbootspc.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty,Long> implements SpecialtyService  {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty t) {
        super.delete(t);
    }

    @Override
    public Specialty save(Specialty t) {
        return super.save(t);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
