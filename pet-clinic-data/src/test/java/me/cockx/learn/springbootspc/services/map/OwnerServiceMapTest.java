package me.cockx.learn.springbootspc.services.map;

import me.cockx.learn.springbootspc.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {


    private OwnerServiceMap ownerServiceMap;
    private final String fn = "Milli";
    private final String ln = "Monco";
    private final Long id = 1L;



    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().firstName(fn).lastName(ln).build());
    }

    @Test
    void findAll() {
        Set<Owner> all = ownerServiceMap.findAll();
        assertEquals(1,all.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(id);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(id));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void saveWithoutId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().firstName(fn).build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());

    }

    @Test
    void findById() {
        Owner byId = ownerServiceMap.findById(1L);
        assertEquals(id,byId.getId());
    }

    @Test
    void findByLastName() {
        Owner byLastName = ownerServiceMap.findByLastName(ln);
        assertEquals(ln,byLastName.getLastName());

    }

    @Test
    void findByLastNameNotFound() {
        assertNull(ownerServiceMap.findByLastName("Random"));

    }
}