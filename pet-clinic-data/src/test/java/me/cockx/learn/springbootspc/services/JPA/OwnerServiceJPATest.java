package me.cockx.learn.springbootspc.services.JPA;

import me.cockx.learn.springbootspc.model.Owner;
import me.cockx.learn.springbootspc.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJPATest {

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    OwnerServiceJPA ownerServiceJPA;
    private String lastName = "Smith";
    private Owner owner;
    private Set<Owner> ownerSet = new HashSet<>();
    private Long id= 1L;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().lastName(lastName).build();
        owner.setId(id);
        ownerSet.add(owner);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner byLastName = ownerServiceJPA.findByLastName(lastName);
        assertEquals(lastName,byLastName.getLastName());

        verify(ownerRepository,times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> all = ownerServiceJPA.findAll();

        assertEquals(1,all.size());
        verify(ownerRepository,times(1)).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));
        Owner byId = ownerServiceJPA.findById(id);

        assertEquals(id,byId.getId());
        verify(ownerRepository,times(1)).findById(any());

    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        Owner byId = ownerServiceJPA.findById(id);

        assertNull(byId);
        verify(ownerRepository,times(1)).findById(any());

    }

    @Test
    void save() {
        Owner phonny = Owner.builder().firstName("Phonny").build();
        ownerSet.add(phonny);

        when(ownerRepository.findAll()).thenReturn(ownerSet);
        ownerServiceJPA.save(phonny);
        Set<Owner> all = ownerServiceJPA.findAll();

        assertEquals(2,all.size());
        //default is 1 time, see next test
        verify(ownerRepository,times(1)).findAll();
        verify(ownerRepository,times(1)).save(any());

        ownerSet.remove(phonny);

    }

    @Test
    void delete() {
        when(ownerRepository.findAll()).thenReturn(new HashSet<>());
        ownerServiceJPA.delete(owner);
        Set<Owner> all = ownerServiceJPA.findAll();

        assertEquals(0,all.size());
        verify(ownerRepository).findAll();
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        when(ownerRepository.findAll()).thenReturn(new HashSet<>());
        ownerServiceJPA.deleteById(id);
        Set<Owner> all = ownerServiceJPA.findAll();

        assertEquals(0,all.size());
        verify(ownerRepository,times(1)).findAll();
        verify(ownerRepository,times(1)).deleteById(id);

    }
}