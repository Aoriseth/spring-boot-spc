package me.cockx.learn.springbootspc.services;

import me.cockx.learn.springbootspc.model.Vet;

public interface VetService extends CrudService<Vet,Long> {
    Vet findByLastName(String lastName);
}
