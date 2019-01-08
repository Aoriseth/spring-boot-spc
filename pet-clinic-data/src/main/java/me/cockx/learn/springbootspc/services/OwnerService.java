package me.cockx.learn.springbootspc.services;

import me.cockx.learn.springbootspc.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
}
