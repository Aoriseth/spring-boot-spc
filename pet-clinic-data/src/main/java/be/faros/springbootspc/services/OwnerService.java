package be.faros.springbootspc.services;

import be.faros.springbootspc.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
}
