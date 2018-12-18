package be.faros.springbootspc.services;

import be.faros.springbootspc.model.Vet;

public interface VetService extends CrudService<Vet,Long> {
    Vet findByLastName(String lastName);
}
